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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dndzgz.android.DndZgzApplication;
import com.dndzgz.android.MenuActivity;
import com.dndzgz.android.R;
import com.dndzgz.android.favorites.FavoritesActivity;
import com.google.android.maps.GeoPoint;
import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;

public class WifiDataActivity extends Activity {

	private ProgressDialog m_ProgressDialog = null;
	private Runnable runnableWifi;
	private JSONObject wifiJson;
	private String wifiInfo;
	private LinearLayout contenedor;
//	private JSONArray items;
	private DndZgzApplication dndzgzApp;
	private static final String TAG = "DndZgzAndroid";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dndzgzApp =  ((DndZgzApplication)this.getApplication());
		if (getIntent().hasExtra("object")) {
			wifiInfo = getIntent().getStringExtra("object");			
		}
		try {
			wifiJson = new JSONObject(wifiInfo);
			wifiJson.put("type", "wifi");
			dndzgzApp.setLastObject(wifiJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		// ACTION BAR
		setContentView(R.layout.data_info);
		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
		Intent homeIntent = new Intent(this, MenuActivity.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		actionBar.setHomeAction(new IntentAction(this, homeIntent,
				R.drawable.ic_title_home_default));
		///////////////////////
		String uri = "";
		try {
			uri = "google.navigation:q=" + wifiJson.getString("lat") + "," + wifiJson.getString("lon");			
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		Intent RouteIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));		
		final Action routeAction = new IntentAction(this, RouteIntent, R.drawable.ic_action_bar_navigation);
		actionBar.addAction(routeAction);
		
		Intent FavIntent = new Intent(WifiDataActivity.this, FavoritesActivity.class);
		FavIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		FavIntent.putExtra("action", "add");
		final Action FavAction = new IntentAction(this, FavIntent, R.drawable.ic_action_bar_star);	
		actionBar.addAction(FavAction);			
		
		
		try {
			actionBar.setTitle(wifiJson.getString("title"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ////////////////
		contenedor = (LinearLayout) findViewById(R.id.contenedor);
		
		runnableWifi = new Runnable() {
			@Override
			public void run() {
				getInfoWifi();
			}
		};

		Thread thread = new Thread(null, runnableWifi, "ObtenerInfoWifi");
		thread.start();

		m_ProgressDialog = ProgressDialog.show(WifiDataActivity.this,
				getText(R.string.espere), getText(R.string.obteniendo_datos), true);

	}

	private void getInfoWifi() {
		try {
		} catch (Exception e) {
			Log.e(TAG, "getInfoWifi() " + e.getMessage());
			Log.i(TAG, "getInfoWifi() " + e.toString());
		}
		runOnUiThread(returnRes);
	}

	private Runnable returnRes = new Runnable() {

		@Override
		public void run() {
			m_ProgressDialog.dismiss();
			
			LinearLayout contentGeneral = new LinearLayout(
					getApplicationContext());
			contentGeneral
					.setLayoutParams(new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT,
							LayoutParams.WRAP_CONTENT));
			contentGeneral.setPadding(0, 10, 0, 10);
			ImageView icono = new ImageView(getApplicationContext());
			icono.setImageDrawable(getResources().getDrawable(
					R.drawable.wifi));
			icono
					.setLayoutParams(new LinearLayout.LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.FILL_PARENT));
			icono.setPadding(10, 0, 15, 0);
			LinearLayout contentData = new LinearLayout(
					getApplicationContext());
			contentData.setOrientation(LinearLayout.VERTICAL);
			contentData
					.setLayoutParams(new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT,
							LayoutParams.WRAP_CONTENT));
			TextView titulo = new TextView(getApplicationContext());
			try {
				titulo.setText(wifiJson.getString("title"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			titulo
					.setLayoutParams(new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT,
							LayoutParams.WRAP_CONTENT));
			titulo.setTextSize(TypedValue.COMPLEX_UNIT_PX, 18);
			TextView subtitulo = new TextView(getApplicationContext());
			try {
				subtitulo.setText(wifiJson.getString("subtitle"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			subtitulo
					.setLayoutParams(new LinearLayout.LayoutParams(
							LayoutParams.FILL_PARENT,
							LayoutParams.WRAP_CONTENT));
			subtitulo.setTextSize(TypedValue.COMPLEX_UNIT_PX, 18);
			contentData.addView(titulo);
			contentData.addView(subtitulo);
			contentGeneral.addView(icono);
			contentGeneral.addView(contentData);
			contenedor.addView(contentGeneral);
		}
	};

	public String retriveInfo(String id) {
		Log.i(TAG, "retriveInfo()");
		URL url;
		HttpURLConnection urlConnection = null;
		Writer writer = null;
		String result = null;
		try {
			url = new URL("http://www.dndzgz.com/point?service=wifi&id=" + id);
			Log.i(TAG, url.toString());
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
		Log.i(TAG, "Info Obtenida (¡¡Gracias DndZgz!!)");
		return result;
	}	
}
