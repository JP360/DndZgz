package com.dndzgz.android.wifi;

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

public class WifiActivity extends Activity {

	private ListView listViewWifi;
	private EditText txtSearch;

	private ProgressDialog progressDialog = null;
	private ArrayList<JSONObject> wifiArrayList = null;
	private WifiAdapter wifiListAdapter;
	private Runnable runnableWifi;
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
		actionBar.setTitle(R.string.listado_wifis);

		Intent wifiMapIntent = new Intent(WifiActivity.this,
				WifiMapActivity.class);
		wifiMapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		final Action wifiMapAction = new IntentAction(this, wifiMapIntent,
				R.drawable.ic_action_bar_locate);
		actionBar.addAction(wifiMapAction);
		// ////////////////
		txtSearch = (EditText) findViewById(R.id.txtSearch);
		txtSearch.addTextChangedListener(filterTextWatcher);
		listViewWifi = (ListView) findViewById(R.id.ListView);
		wifiArrayList = new ArrayList<JSONObject>();
		this.wifiListAdapter = new WifiAdapter(this,
				R.layout.wifi_item, wifiArrayList);
		listViewWifi.setAdapter(this.wifiListAdapter);
		listViewWifi.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				JSONObject jo = wifiListAdapter.getItem(pos);
				Intent mainIntent = new Intent(WifiActivity.this,
						WifiDataActivity.class);
				mainIntent.putExtra("object", jo.toString());
				mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				WifiActivity.this.startActivity(mainIntent);
			}
		});
		Log.i(TAG, "General Application");
		// Obtengo el listado de paradas de la Aplicacion
		dndzgzApp =  ((DndZgzApplication)this.getApplication());
		listJSON = dndzgzApp.getWifiList();
		for(int i=0; i<listJSON.length(); i++){
			try {
				wifiArrayList.add((JSONObject) listJSON.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.i(TAG, "wifiArrayList: " + wifiArrayList.size());
		Log.i(TAG, "listJSON.length()" + listJSON.length());
		//Si no tenemos el listado
		if (!(wifiArrayList.size() > 0)) {
			runnableWifi = new Runnable() {
				@Override
				public void run() {
					getWifi();
				}
			};
			Thread thread = new Thread(null, runnableWifi,
					"ObtenerListadoWifi");
			thread.start();
			progressDialog = ProgressDialog.show(WifiActivity.this,
					getText(R.string.espere), getText(R.string.obteniendo_datos), true);
		} else {
			progressDialog = ProgressDialog.show(WifiActivity.this,
					getText(R.string.espere), getText(R.string.actualizando_datos), true);
			updateWifiAdapter();
		}

	}

	private class WifiAdapter extends ArrayAdapter<JSONObject> {
		private ArrayList<JSONObject> items;

		public WifiAdapter(Context context, int textViewResourceId,
				ArrayList<JSONObject> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.wifi_item, null);
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

	private void getWifi() {
		try {
			Log.i(TAG, "getWifi()");
			String jsonTram = retriveList();
			JSONArray wifiJson = new JSONArray(jsonTram);
			int n = wifiJson.length();
			wifiArrayList = new ArrayList<JSONObject>();
			JSONArray wifiArrayJson = new JSONArray();
			Log.i(TAG, "Total Objetos: " + n);
			for (int i = 0; i < n; i++) {
				try {
					JSONObject tram = wifiJson.getJSONObject(i);
					wifiArrayJson.put(tram);
					wifiArrayList.add(tram);					
				} catch (JSONException e) {
					Log.e(TAG, e.getMessage());
				}
			}
			
			dndzgzApp.setWifiList(wifiArrayJson);
			listJSON = wifiArrayJson;
			Log.i(TAG, "Total wifi: " + wifiArrayList.size());
			Log.i(TAG, "wifiArrayList " + this.wifiArrayList.size());
			Log.i(TAG, "listJSON.length()" + listJSON.length());
		} catch (Exception e) {
			Log.i(TAG, "getWifi() " + e.getMessage());
			Log.i(TAG, "getWifi() " + e.toString());
		}

		runOnUiThread(returnRes);
	}

	private Runnable returnRes = new Runnable() {
		@Override
		public void run() {
			updateWifiAdapter();
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
			url = new URL("http://www.dndzgz.com/fetch?service=wifi");
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
			this.wifiListAdapter.clear();
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
					this.wifiListAdapter.add(jo);
				}
			}
			this.wifiListAdapter.notifyDataSetChanged();
		}else{
			for(int i=0; i<listJSON.length(); i++){
				try {
					wifiArrayList.add((JSONObject) listJSON.get(i));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			this.wifiListAdapter = new WifiAdapter(this,
					R.layout.autobus_item, this.wifiArrayList);
			this.listViewWifi.setAdapter(this.wifiListAdapter);
		}
	}

	private void updateWifiAdapter() {
		if (wifiArrayList != null && wifiArrayList.size() > 0) {
			this.wifiListAdapter = new WifiAdapter(this,
					R.layout.autobus_item, this.wifiArrayList);
			this.listViewWifi.setAdapter(this.wifiListAdapter);
		}
		progressDialog.dismiss();
		wifiListAdapter.notifyDataSetChanged();
		listViewWifi.requestFocus();
	}
}
