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
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
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

public class BikesDataActivity extends Activity {

	private ProgressDialog m_ProgressDialog = null;
	private Runnable runnableBikes;
	private JSONObject bikesJson;
	private String bikesInfo;
	private LinearLayout contenedor;
	private JSONArray items;
	private DndZgzApplication dndzgzApp;
	private static final String TAG = "DndZgzAndroid";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dndzgzApp =  ((DndZgzApplication)this.getApplication());
		if (getIntent().hasExtra("object")) {
			bikesInfo = getIntent().getStringExtra("object");			
		}
		try {
			bikesJson = new JSONObject(bikesInfo);
			bikesJson.put("type", "bike");
			dndzgzApp.setLastObject(bikesJson);
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
			uri = "google.navigation:q=" + bikesJson.getString("lat") + "," + bikesJson.getString("lon");			
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		Intent RouteIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));		
		final Action routeAction = new IntentAction(this, RouteIntent, R.drawable.ic_action_bar_navigation);
		actionBar.addAction(routeAction);
		
		Intent FavIntent = new Intent(BikesDataActivity.this, FavoritesActivity.class);
		FavIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		FavIntent.putExtra("action", "add");
		final Action FavAction = new IntentAction(this, FavIntent, R.drawable.ic_action_bar_star);	
		actionBar.addAction(FavAction);			
		
		
		try {
			actionBar.setTitle(bikesJson.getString("title"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ////////////////
		contenedor = (LinearLayout) findViewById(R.id.contenedor);
		
		runnableBikes = new Runnable() {
			@Override
			public void run() {
				getInfoBike();
			}
		};

		Thread thread = new Thread(null, runnableBikes, "ObtenerInfoBike");
		thread.start();

		m_ProgressDialog = ProgressDialog.show(BikesDataActivity.this,
				getText(R.string.espere), getText(R.string.obteniendo_datos), true);

	}

	private void getInfoBike() {
		try {
			Log.i(TAG, "getInfoBike()");
			String jsonBike = retriveInfo(bikesJson.getString("id"));
			JSONObject bikeInfoJson = new JSONObject(jsonBike);
			items = new JSONArray(bikeInfoJson.getString("items"));
			Log.i(TAG, "Total items: " + items.length());

		} catch (Exception e) {
			Log.e(TAG, "getInfoBike() " + e.getMessage());
			Log.i(TAG, "getInfoBike() " + e.toString());
		}
		runOnUiThread(returnRes);
	}

	private Runnable returnRes = new Runnable() {

		@Override
		public void run() {
			m_ProgressDialog.dismiss();
			// Pintamos la info
			if (items.length() > 1) {
				int n = items.length();
				for (int i = 0; i < n; i++) {
					String title = "";
					String subtitle = "";
					try {
						String item = items.get(i).toString();
						// Elimino el primer y ultimo corchete
						item = item.substring(1, item.length() - 1);
						// Quito Comillas
						item = item.replaceAll("\"", "");
						String[] partes = item.split(" ");
						title = partes[0];
						subtitle = partes[1];
						subtitle = subtitle.substring(0, 1).toUpperCase() + subtitle.substring(1, subtitle.length());

					} catch (JSONException e) {
						e.printStackTrace();
					}					
					TextView txtTitle = new TextView(getApplicationContext());
					txtTitle.setText(title);
					txtTitle
							.setLayoutParams(new LinearLayout.LayoutParams(
									LayoutParams.FILL_PARENT,
									LayoutParams.FILL_PARENT));
					txtTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
					txtTitle.setPadding(0, 25, 0, 0);
					txtTitle.setGravity(Gravity.CENTER_HORIZONTAL);
					
					TextView txtSubtitle = new TextView(getApplicationContext());
					txtSubtitle.setText(subtitle);
					txtSubtitle
							.setLayoutParams(new LinearLayout.LayoutParams(
									LayoutParams.FILL_PARENT,
									LayoutParams.FILL_PARENT));
					txtSubtitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
					txtSubtitle.setGravity(Gravity.CENTER_HORIZONTAL);
					
					
					contenedor.addView(txtTitle);
					contenedor.addView(txtSubtitle);
				}
			} else {
				TextView titulo = new TextView(getApplicationContext());
				titulo.setText("Estacion sin informacion");
				titulo.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
				titulo.setTextSize(TypedValue.COMPLEX_UNIT_PX, 30);
				titulo.setPadding(0, 15, 0, 0);
				contenedor.addView(titulo);
			}

		}
	};

	public String retriveInfo(String id) {
		Log.i(TAG, "retriveInfo()");
		URL url;
		HttpURLConnection urlConnection = null;
		Writer writer = null;
		String result = null;
		try {
			url = new URL("http://www.dndzgz.com/point?service=bizi&id=" + id);
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

	public static final long TO_E6 = 1000000l;

	public static GeoPoint toGeoPoint(double latitud, double longitud) {
		return new GeoPoint((int) (latitud * TO_E6), (int) (longitud * TO_E6));
	}	
}
