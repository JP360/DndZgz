package com.dndzgz.android.store;

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

public class StoreActivity extends Activity {

	private ListView listViewStore;
	private EditText txtSearch;

	private ProgressDialog progressDialog = null;
	private ArrayList<JSONObject> storeArrayList = null;
	private StoreAdapter storeListAdapter;
	private Runnable runnableStore;
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
		actionBar.setTitle(R.string.listado_establecimientos);

		Intent storeMapIntent = new Intent(StoreActivity.this,
				StoreMapActivity.class);
		storeMapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		final Action storeMapAction = new IntentAction(this, storeMapIntent,
				R.drawable.ic_action_bar_locate);
		actionBar.addAction(storeMapAction);
		// ////////////////
		txtSearch = (EditText) findViewById(R.id.txtSearch);
		txtSearch.addTextChangedListener(filterTextWatcher);
		listViewStore = (ListView) findViewById(R.id.ListView);
		storeArrayList = new ArrayList<JSONObject>();
		this.storeListAdapter = new StoreAdapter(this, R.layout.store_item,
				storeArrayList);
		listViewStore.setAdapter(this.storeListAdapter);
		listViewStore.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				JSONObject jo = storeListAdapter.getItem(pos);
				Intent mainIntent = new Intent(StoreActivity.this,
						StoreDataActivity.class);
				mainIntent.putExtra("object", jo.toString());
				mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				StoreActivity.this.startActivity(mainIntent);
			}
		});
		Log.i(TAG, "General Application");
		// Obtengo el listado de Tiendas de la Aplicacion
		dndzgzApp = ((DndZgzApplication) this.getApplication());
		listJSON = dndzgzApp.getStoreList();
		for (int i = 0; i < listJSON.length(); i++) {
			try {
				storeArrayList.add((JSONObject) listJSON.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.i(TAG, "storeArrayList: " + storeArrayList.size());

		progressDialog = ProgressDialog.show(StoreActivity.this,
				getText(R.string.espere), getText(R.string.actualizando_datos),
				true);
		updateStoreAdapter();

	}

	private class StoreAdapter extends ArrayAdapter<JSONObject> {
		private ArrayList<JSONObject> items;

		public StoreAdapter(Context context, int textViewResourceId,
				ArrayList<JSONObject> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.store_item, null);
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
			storeListAdapter.clear();
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
					storeListAdapter.add(jo);
				}
			}
			storeListAdapter.notifyDataSetChanged();
		} else {
			for (int i = 0; i < listJSON.length(); i++) {
				try {
					storeArrayList.add((JSONObject) listJSON.get(i));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			this.storeListAdapter = new StoreAdapter(this,
					R.layout.autobus_item, this.storeArrayList);
			this.listViewStore.setAdapter(this.storeListAdapter);
		}
	}

	private void updateStoreAdapter() {
		if (storeArrayList != null && storeArrayList.size() > 0) {
			this.storeListAdapter = new StoreAdapter(this,
					R.layout.autobus_item, this.storeArrayList);
			this.listViewStore.setAdapter(this.storeListAdapter);
		}
		progressDialog.dismiss();
		storeListAdapter.notifyDataSetChanged();
		listViewStore.requestFocus();
	}
}
