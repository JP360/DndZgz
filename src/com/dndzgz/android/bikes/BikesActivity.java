package com.dndzgz.android.bikes;

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

public class BikesActivity extends Activity {

	private ListView listViewBikes;
	private EditText txtSearch;

	private ProgressDialog progressDialog = null;
	private ArrayList<JSONObject> bikesArrayList = null;
	private BikesAdapter bikesListAdapter;
	private Runnable runnableBikes;
	private DndZgzApplication dndzgzApp;

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
		actionBar.setTitle(R.string.listado_bicis);

		Intent bikesMapIntent = new Intent(BikesActivity.this,
				BikesMapActivity.class);
		bikesMapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		final Action bikesMapAction = new IntentAction(this, bikesMapIntent,
				R.drawable.ic_action_bar_locate);
		actionBar.addAction(bikesMapAction);
		// ////////////////
		txtSearch = (EditText) findViewById(R.id.txtSearch);
		txtSearch.addTextChangedListener(filterTextWatcher);
		listViewBikes = (ListView) findViewById(R.id.ListView);
		bikesArrayList = new ArrayList<JSONObject>();
		this.bikesListAdapter = new BikesAdapter(this,
				R.layout.bikes_item, bikesArrayList);
		listViewBikes.setAdapter(this.bikesListAdapter);
		listViewBikes.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				JSONObject jo = bikesListAdapter.getItem(pos);
				Intent mainIntent = new Intent(BikesActivity.this,
						BikesDataActivity.class);
				mainIntent.putExtra("object", jo.toString());
				mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				BikesActivity.this.startActivity(mainIntent);
			}
		});
		Log.i(TAG, "General Application");
		// Obtengo el listado de Bicis de la Aplicacion
		dndzgzApp =  ((DndZgzApplication)this.getApplication());
		JSONArray listJSON = dndzgzApp.getBikesList();
		for(int i=0; i<listJSON.length(); i++){
			try {
				bikesArrayList.add((JSONObject) listJSON.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.i(TAG, "bikesArrayList: " + bikesArrayList.size());
		//Si no tenemos el listado
		if (!(bikesArrayList.size() > 0)) {
			runnableBikes = new Runnable() {
				@Override
				public void run() {
					getBikes();
				}
			};
			Thread thread = new Thread(null, runnableBikes,
					"ObtenerListadoBicis");
			thread.start();
			progressDialog = ProgressDialog.show(BikesActivity.this,
					getText(R.string.espere), getText(R.string.obteniendo_datos), true);
		} else {
			progressDialog = ProgressDialog.show(BikesActivity.this,
					getText(R.string.espere), getText(R.string.actualizando_datos), true);
			updateBikesAdapter();
		}

	}

	private class BikesAdapter extends ArrayAdapter<JSONObject> {
		private ArrayList<JSONObject> items;

		public BikesAdapter(Context context, int textViewResourceId,
				ArrayList<JSONObject> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.bikes_item, null);
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

	private void getBikes() {
		try {
			Log.i(TAG, "getBikes()");
			String jsonBikes = retriveList();
			JSONArray bikesJson = new JSONArray(jsonBikes);
			int n = bikesJson.length();
			bikesArrayList = new ArrayList<JSONObject>();
			JSONArray bikesArrayJson = new JSONArray();
			Log.i(TAG, "Total Objetos: " + n);
			for (int i = 0; i < n; i++) {
				try {
					JSONObject bike = bikesJson.getJSONObject(i);
					bikesArrayJson.put(bike);
					bikesArrayList.add(bike);
				} catch (JSONException e) {
					Log.e(TAG, e.getMessage());
				}
			}
			
			dndzgzApp.setBikesList(bikesArrayJson);
			Log.i(TAG, "Total Bicis: " + bikesArrayList.size());
		} catch (Exception e) {
			Log.i(TAG, "getBikes() " + e.getMessage());
			Log.i(TAG, "getBikes() " + e.toString());
		}

		runOnUiThread(returnRes);
	}

	private Runnable returnRes = new Runnable() {
		@Override
		public void run() {
			updateBikesAdapter();
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
			url = new URL("http://www.dndzgz.com/fetch?service=bizi");
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
		bikesListAdapter.clear();
		String search = s.toString();
		search = search.toLowerCase();
		for (int i = 0; i < bikesArrayList.size(); i++) {
			JSONObject jo = bikesArrayList.get(i);
			String titulo = "";
			String subtitulo = "";
			try {
				titulo = jo.getString("title").toLowerCase();
				subtitulo = jo.getString("subtitle").toLowerCase();				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (titulo.contains(search) || subtitulo.contains(search)) {
				bikesListAdapter.add(jo);
			}
		}
		bikesListAdapter.notifyDataSetChanged();
	}

	private void updateBikesAdapter() {
		if (bikesArrayList != null && bikesArrayList.size() > 0) {
			bikesListAdapter.notifyDataSetChanged();
			for (int i = 0; i < bikesArrayList.size(); i++)
				bikesListAdapter.add(bikesArrayList.get(i));
		}
		progressDialog.dismiss();
		bikesListAdapter.notifyDataSetChanged();
		listViewBikes.requestFocus();
		filterBikesList();
	}
	
	private void filterBikesList() {
		if (getIntent().hasExtra("filtro")) {
			String filtro = getIntent().getStringExtra("filtro");
			filtro = "Poste " + filtro;
			filtrarAdapter(filtro);
			txtSearch.setText(filtro);
		}
	}
}
