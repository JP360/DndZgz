package com.dndzgz.android.pharmacy;

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

public class PharmacyActivity extends Activity {

	private ListView listViewPharmacy;
	private EditText txtSearch;

	private ProgressDialog progressDialog = null;
	private ArrayList<JSONObject> pharmacyArrayList = null;
	private PharmacyAdapter pharmacyListAdapter;
	private Runnable runnablePharmacy;
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
		actionBar.setTitle(R.string.listado_farmacias);

		Intent pharmacyMapIntent = new Intent(PharmacyActivity.this,
				PharmacyMapActivity.class);
		pharmacyMapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		final Action pharmacyMapAction = new IntentAction(this, pharmacyMapIntent,
				R.drawable.ic_action_bar_locate);
		actionBar.addAction(pharmacyMapAction);
		// ////////////////
		txtSearch = (EditText) findViewById(R.id.txtSearch);
		txtSearch.addTextChangedListener(filterTextWatcher);
		listViewPharmacy = (ListView) findViewById(R.id.ListView);
		pharmacyArrayList = new ArrayList<JSONObject>();
		this.pharmacyListAdapter = new PharmacyAdapter(this, R.layout.pharmacy_item,
				pharmacyArrayList);
		listViewPharmacy.setAdapter(this.pharmacyListAdapter);
		listViewPharmacy.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				JSONObject jo = pharmacyListAdapter.getItem(pos);
				Intent mainIntent = new Intent(PharmacyActivity.this,
						PharmacyDataActivity.class);
				mainIntent.putExtra("object", jo.toString());
				mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				PharmacyActivity.this.startActivity(mainIntent);
			}
		});
		Log.i(TAG, "General Application");
		// Obtengo el listado de Tiendas de la Aplicacion
		dndzgzApp = ((DndZgzApplication) this.getApplication());
		listJSON = dndzgzApp.getPharmacyList();
		for (int i = 0; i < listJSON.length(); i++) {
			try {
				pharmacyArrayList.add((JSONObject) listJSON.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.i(TAG, "pharmacyArrayList: " + pharmacyArrayList.size());

		progressDialog = ProgressDialog.show(PharmacyActivity.this,
				getText(R.string.espere), getText(R.string.actualizando_datos),
				true);
		updatePharmacyAdapter();

	}

	private class PharmacyAdapter extends ArrayAdapter<JSONObject> {
		private ArrayList<JSONObject> items;

		public PharmacyAdapter(Context context, int textViewResourceId,
				ArrayList<JSONObject> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.pharmacy_item, null);
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
			pharmacyListAdapter.clear();
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
					pharmacyListAdapter.add(jo);
				}
			}
			pharmacyListAdapter.notifyDataSetChanged();
		} else {
			for (int i = 0; i < listJSON.length(); i++) {
				try {
					pharmacyArrayList.add((JSONObject) listJSON.get(i));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			this.pharmacyListAdapter = new PharmacyAdapter(this,
					R.layout.autobus_item, this.pharmacyArrayList);
			this.listViewPharmacy.setAdapter(this.pharmacyListAdapter);
		}
	}

	private void updatePharmacyAdapter() {
		if (pharmacyArrayList != null && pharmacyArrayList.size() > 0) {
			this.pharmacyListAdapter = new PharmacyAdapter(this,
					R.layout.autobus_item, this.pharmacyArrayList);
			this.listViewPharmacy.setAdapter(this.pharmacyListAdapter);
		}
		progressDialog.dismiss();
		pharmacyListAdapter.notifyDataSetChanged();
		listViewPharmacy.requestFocus();
	}
}
