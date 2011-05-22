package com.dndzgz.android.buses;

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

public class BusesActivity extends Activity {

	private ListView listViewBuses;
	private EditText txtSearch;

	private ProgressDialog progressDialog = null;
	private ArrayList<JSONObject> busesArrayList = null;
	private AutobusesAdapter busesListAdapter;
	private Runnable runnableBuses;
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

		Intent busesMapIntent = new Intent(BusesActivity.this,
				BusesMapActivity.class);
		busesMapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		final Action busesMapAction = new IntentAction(this, busesMapIntent,
				R.drawable.ic_action_bar_locate);
		actionBar.addAction(busesMapAction);
		// ////////////////
		txtSearch = (EditText) findViewById(R.id.txtSearch);
		txtSearch.addTextChangedListener(filterTextWatcher);
		listViewBuses = (ListView) findViewById(R.id.ListView);
		busesArrayList = new ArrayList<JSONObject>();
		this.busesListAdapter = new AutobusesAdapter(this,
				R.layout.autobus_item, busesArrayList);
		listViewBuses.setAdapter(this.busesListAdapter);
		listViewBuses.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				JSONObject jo = busesListAdapter.getItem(pos);
				Intent mainIntent = new Intent(BusesActivity.this,
						BusDataActivity.class);
				mainIntent.putExtra("object", jo.toString());
				mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				BusesActivity.this.startActivity(mainIntent);
			}
		});
		Log.i(TAG, "General Application");
		// Obtengo el listado de Autobuses de la Aplicacion
		dndzgzApp = ((DndZgzApplication) this.getApplication());
		listJSON = dndzgzApp.getBusesList();
		for (int i = 0; i < listJSON.length(); i++) {
			try {
				busesArrayList.add((JSONObject) listJSON.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.i(TAG, "busesArrayList: " + busesArrayList.size());
		// Si no tenemos el listado
		if (!(busesArrayList.size() > 0)) {
			runnableBuses = new Runnable() {
				@Override
				public void run() {
					getAutobuses();
				}
			};
			Thread thread = new Thread(null, runnableBuses,
					"ObtenerListadoAutobuses");
			thread.start();
			progressDialog = ProgressDialog.show(BusesActivity.this,
					getText(R.string.espere),
					getText(R.string.obteniendo_datos), true);
		} else {
			Log.i(TAG, "else");
			progressDialog = ProgressDialog.show(BusesActivity.this,
					getText(R.string.espere),
					getText(R.string.actualizando_datos), true);
			updateBusesAdapter();
		}

	}

	private class AutobusesAdapter extends ArrayAdapter<JSONObject> {
		private ArrayList<JSONObject> items;

		public AutobusesAdapter(Context context, int textViewResourceId,
				ArrayList<JSONObject> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.autobus_item, null);
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

	private void getAutobuses() {
		try {
			Log.i(TAG, "getAutobuses()");
			String jsonAutobuses = retriveList();
			JSONArray busesJson = new JSONArray(jsonAutobuses);
			int n = busesJson.length();
			busesArrayList = new ArrayList<JSONObject>();
			JSONArray busesArrayJson = new JSONArray();
			Log.i(TAG, "Total Objetos: " + n);
			for (int i = 0; i < n; i++) {
				try {
					JSONObject bus = busesJson.getJSONObject(i);
					busesArrayJson.put(bus);
					busesArrayList.add(bus);
				} catch (JSONException e) {
					Log.e(TAG, e.getMessage());
				}
			}
			dndzgzApp.setBusesList(busesArrayJson);
			listJSON = busesArrayJson;
			Log.i(TAG, "Total Buses: " + busesArrayList.size());
		} catch (Exception e) {
			Log.i(TAG, "getAutobuses() " + e.getMessage());
			Log.i(TAG, "getAutobuses() " + e.toString());
		}

		runOnUiThread(returnRes);
	}

	private Runnable returnRes = new Runnable() {
		@Override
		public void run() {
			updateBusesAdapter();
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
			url = new URL("http://www.dndzgz.com/fetch?service=bus");
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
		Log.i(TAG, "listado obtenido (Gracias DndZgz!!)");
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
		if (s.toString().length() > 0) {
			busesListAdapter.clear();
			String search = s.toString();
			search = search.toLowerCase();
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
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (titulo.contains(search) || subtitulo.contains(search)) {
					busesListAdapter.add(jo);
				}
			}
			busesListAdapter.notifyDataSetChanged();
		} else {
			for (int i = 0; i < listJSON.length(); i++) {
				try {
					busesArrayList.add((JSONObject) listJSON.get(i));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			this.busesListAdapter = new AutobusesAdapter(this,
					R.layout.autobus_item, this.busesArrayList);
			this.listViewBuses.setAdapter(this.busesListAdapter);
		}
	}

	private void updateBusesAdapter() {
		if (busesArrayList != null && busesArrayList.size() > 0) {
			this.busesListAdapter = new AutobusesAdapter(this,
					R.layout.autobus_item, this.busesArrayList);
			this.listViewBuses.setAdapter(this.busesListAdapter);
		}
		progressDialog.dismiss();
		busesListAdapter.notifyDataSetChanged();
		listViewBuses.requestFocus();
		filterBusesList();
	}

	private void filterBusesList() {
		if (getIntent().hasExtra("filtro")) {
			Log.i(TAG, "filtro");
			String filtro = getIntent().getStringExtra("filtro");
			filtro = "Poste " + filtro;
			filtrarAdapter(filtro);
			txtSearch.setText(filtro);
		}
	}
}
