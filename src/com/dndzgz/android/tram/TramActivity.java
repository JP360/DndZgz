package com.dndzgz.android.tram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.dndzgz.android.DndZgzApplication;
import com.dndzgz.android.MenuActivity;
import com.dndzgz.android.R;
import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;

public class TramActivity extends Activity {

	private ListView listViewTram;
	private EditText txtSearch;

	private ProgressDialog progressDialog = null;
	private ArrayList<JSONObject> tramArrayList = null;
	private TramAdapter tramListAdapter;
	private Runnable runnableTram;
	private DndZgzApplication dndzgzApp;
	private JSONArray listJSON;

	private static final String TAG = "DndZgzAndroid";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ACTION BAR
		setContentView(R.layout.listview);
		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
		Intent homeIntent = new Intent(this, MenuActivity.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		actionBar.setHomeAction(new IntentAction(this, homeIntent,
				R.drawable.ic_title_home_default));
		actionBar.setTitle(R.string.listado_paradas);

		Intent tramMapIntent = new Intent(TramActivity.this,
				TramMapActivity.class);
		tramMapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		final Action tramMapAction = new IntentAction(this, tramMapIntent,
				R.drawable.ic_action_bar_locate);
		actionBar.addAction(tramMapAction);
		// ////////////////
		txtSearch = (EditText) findViewById(R.id.txtSearch);
		txtSearch.addTextChangedListener(filterTextWatcher);
		listViewTram = (ListView) findViewById(R.id.ListView);
		tramArrayList = new ArrayList<JSONObject>();
		this.tramListAdapter = new TramAdapter(this,
				R.layout.tram_item, tramArrayList);
		listViewTram.setAdapter(this.tramListAdapter);
		listViewTram.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				JSONObject jo = tramListAdapter.getItem(pos);
				Intent mainIntent = new Intent(TramActivity.this,
						TramDataActivity.class);
				mainIntent.putExtra("object", jo.toString());
				mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				TramActivity.this.startActivity(mainIntent);
			}
		});
		Log.i(TAG, "General Application");
		// Obtengo el listado de paradas de la Aplicacion
		dndzgzApp =  ((DndZgzApplication)this.getApplication());
		listJSON = dndzgzApp.getTramList();
		for(int i=0; i<listJSON.length(); i++){
			try {
				tramArrayList.add((JSONObject) listJSON.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.i(TAG, "tramArrayList: " + tramArrayList.size());
		Log.i(TAG, "listJSON.length()" + listJSON.length());
		//Si no tenemos el listado
		if (!(tramArrayList.size() > 0)) {
			runnableTram = new Runnable() {
				@Override
				public void run() {
					getTram();
				}
			};
			Thread thread = new Thread(null, runnableTram,
					"ObtenerListadoTranvia");
			thread.start();
			progressDialog = ProgressDialog.show(TramActivity.this,
					getText(R.string.espere), getText(R.string.obteniendo_datos), true);
		} else {
			progressDialog = ProgressDialog.show(TramActivity.this,
					getText(R.string.espere), getText(R.string.actualizando_datos), true);
			updateTramAdapter();
		}

	}

	private class TramAdapter extends ArrayAdapter<JSONObject> {
		private ArrayList<JSONObject> items;

		public TramAdapter(Context context, int textViewResourceId,
				ArrayList<JSONObject> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.tram_item, null);
			}
			JSONObject jo = items.get(position);
			if (jo != null) {
				try {
					TextView tt = (TextView) v.findViewById(R.id.txtTitulo);
					TextView bt = (TextView) v.findViewById(R.id.txtSubTitulo);
					if (tt != null) {
						tt.setText((String) jo.get("title"));
					}
					if (bt != null) {
						bt.setText((String) jo.get("subtitle"));
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return v;
		}
	}

	private void getTram() {
		try {
			Log.i(TAG, "getTram()");
			String jsonTram = retriveList();
			JSONArray tramJson = new JSONArray(jsonTram);
			int n = tramJson.length();
			tramArrayList = new ArrayList<JSONObject>();
			JSONArray tramArrayJson = new JSONArray();
			Log.i(TAG, "Total Objetos: " + n);
			for (int i = 0; i < n; i++) {
				try {
					JSONObject tram = tramJson.getJSONObject(i);
					tramArrayJson.put(tram);
					tramArrayList.add(tram);
				} catch (JSONException e) {
					Log.e(TAG, e.getMessage());
				}
			}
			
			dndzgzApp.setTramList(tramArrayJson);
			listJSON = tramArrayJson;
			Log.i(TAG, "Total tranvia: " + tramArrayList.size());
			Log.i(TAG, "tramArrayList " + this.tramArrayList.size());
			Log.i(TAG, "listJSON.length()" + listJSON.length());
		} catch (Exception e) {
			Log.i(TAG, "getTram() " + e.getMessage());
			Log.i(TAG, "getTram() " + e.toString());
		}

		runOnUiThread(returnRes);
	}

	private Runnable returnRes = new Runnable() {
		@Override
		public void run() {
			updateTramAdapter();
		}		
	};

	public String retriveList() {
		// Obtenemos el listado
		Log.i(TAG, "retriveList()");
		URL url;
		HttpURLConnection urlConnection = null;
		Writer writer = null;
		String result = null;
		try {
			url = new URL("http://www.dndzgz.com/fetch?service=tranvia");
			urlConnection = (HttpURLConnection) url.openConnection();
			InputStream in = urlConnection.getInputStream();
			if (in != null) {
				writer = new StringWriter();
				char[] buffer = new char[1024];
				try {
					Reader reader = new BufferedReader(new InputStreamReader(
							in, "UTF-8"));
					int n;
					while ((n = reader.read(buffer)) != -1) {
						writer.write(buffer, 0, n);
					}
				} finally {
					in.close();
				}
			}
			result = writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			urlConnection.disconnect();
		}
		Log.i(TAG, "listado obtenido (¡¡Gracias DndZgz!!)");
		return result;
	}

	private TextWatcher filterTextWatcher = new TextWatcher() {

		public void afterTextChanged(Editable s) {
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			filtrarAdapter(s);
		}

	};

	protected void filtrarAdapter(CharSequence s) {
		if(s.toString().length() > 0){
			Log.i(TAG, "listJSON.length()" + listJSON.length());
			this.tramListAdapter.clear();
			String search = s.toString();
			search = search.toLowerCase();
			Log.i(TAG, "listJSON.length()" + listJSON.length());
			for (int i = 0; i < this.listJSON.length(); i++) {
				JSONObject jo = new JSONObject();
				try {
					jo = (JSONObject) this.listJSON.get(i);
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				String titulo = "";
				String subtitulo = "";
				try {
					titulo = jo.getString("title").toLowerCase();
					subtitulo = jo.getString("subtitle").toLowerCase();
					Log.i(TAG, "titulo" + titulo);
					Log.i(TAG, "subtitulo" + subtitulo);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (titulo.contains(search) || subtitulo.contains(search)) {
					this.tramListAdapter.add(jo);
				}
			}
			this.tramListAdapter.notifyDataSetChanged();
		}else{
			for(int i=0; i<listJSON.length(); i++){
				try {
					tramArrayList.add((JSONObject) listJSON.get(i));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			this.tramListAdapter = new TramAdapter(this,
					R.layout.autobus_item, this.tramArrayList);
			this.listViewTram.setAdapter(this.tramListAdapter);
		}
	}

	private void updateTramAdapter() {
		if (tramArrayList != null && tramArrayList.size() > 0) {
			this.tramListAdapter = new TramAdapter(this,
					R.layout.autobus_item, this.tramArrayList);
			this.listViewTram.setAdapter(this.tramListAdapter);
		}
		progressDialog.dismiss();
		tramListAdapter.notifyDataSetChanged();
		listViewTram.requestFocus();
	}
}
