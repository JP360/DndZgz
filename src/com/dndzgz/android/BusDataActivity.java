package com.dndzgz.android;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;
import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;

public class BusDataActivity extends Activity {

	private ProgressDialog m_ProgressDialog = null;
	private Runnable runnableAutobus;
	private JSONObject autobusJson;
	private String autobusInfo;
	private LinearLayout contenedor;
	private JSONArray items;
	private static final String TAG = "DndZgzAndroid";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getIntent().hasExtra("autobus")) {
			autobusInfo = getIntent().getStringExtra("autobus");
		}
		try {
			autobusJson = new JSONObject(autobusInfo);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// ACTION BAR
		setContentView(R.layout.bus_info);
		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
		Intent homeIntent = new Intent(this, MenuActivity.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		actionBar.setHomeAction(new IntentAction(this, homeIntent,
				R.drawable.ic_title_home_default));
		
		String uri = "";
		try {
			uri = "google.navigation:q=" + autobusJson.getString("lat") + "," + autobusJson.getString("lon");			
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		Intent RouteIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));		
		final Action routeAction = new IntentAction(this, RouteIntent, R.drawable.ic_action_bar_navigation);
		actionBar.addAction(routeAction);
		
		final Action FavAction = new IntentAction(this, createShareIntent(), R.drawable.ic_action_bar_star);	
		actionBar.addAction(FavAction);		
		
		
		try {
			actionBar.setTitle(autobusJson.getString("title"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ////////////////
		contenedor = (LinearLayout) findViewById(R.id.contenedor);
		
		runnableAutobus = new Runnable() {
			@Override
			public void run() {
				getInfoAutobus();
			}
		};

		Thread thread = new Thread(null, runnableAutobus, "ObtenerInfoAutobus");
		thread.start();

		m_ProgressDialog = ProgressDialog.show(BusDataActivity.this,
				"Por favor, espere...", "Obteniendo Datos...", true);

	}

	private void getInfoAutobus() {
		try {
			Log.i(TAG, "getInfoAutobus()");
			String jsonAutobus = retriveInfo(autobusJson.getString("id"));
			JSONObject busInfoJson = new JSONObject(jsonAutobus);
			items = new JSONArray(busInfoJson.getString("items"));
			Log.i(TAG, "Total items: " + items.length());

		} catch (Exception e) {
			Log.e(TAG, "getInfoAutobus() " + e.getMessage());
			Log.i(TAG, "getInfoAutobus() " + e.toString());
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
					String SnumLinea = "";
					try {
						String item = items.get(i).toString();
						// Elimino el primer y ultimo corchete
						item = item.substring(1, item.length() - 1);
						// Obtengo el numero de la linea de autobus entre
						// corchetes
						SnumLinea = item.substring(item.indexOf("[") + 1, item
								.indexOf("]"));
						// Elmino el numero de linea
						item = item.substring(item.indexOf("]") + 1, item
								.length());
						// Quito Comillas
						item = item.replaceAll("\"", "");
						String[] partes = item.split(",");
						title = partes[0].trim();
						subtitle = partes[1].trim();
					} catch (JSONException e) {
						e.printStackTrace();
					}
					LinearLayout contentGeneral = new LinearLayout(
							getApplicationContext());
					contentGeneral
							.setLayoutParams(new LinearLayout.LayoutParams(
									LayoutParams.FILL_PARENT,
									LayoutParams.WRAP_CONTENT));
					contentGeneral.setPadding(0, 10, 0, 10);
					TextView numLinea = new TextView(getApplicationContext());
					numLinea.setText(SnumLinea);
					numLinea
							.setLayoutParams(new LinearLayout.LayoutParams(
									LayoutParams.WRAP_CONTENT,
									LayoutParams.FILL_PARENT));
					numLinea.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
					numLinea.setPadding(10, 0, 15, 0);
					LinearLayout contentData = new LinearLayout(
							getApplicationContext());
					contentData.setOrientation(LinearLayout.VERTICAL);
					contentData
							.setLayoutParams(new LinearLayout.LayoutParams(
									LayoutParams.FILL_PARENT,
									LayoutParams.WRAP_CONTENT));
					TextView titulo = new TextView(getApplicationContext());
					titulo.setText(title);
					titulo
							.setLayoutParams(new LinearLayout.LayoutParams(
									LayoutParams.FILL_PARENT,
									LayoutParams.WRAP_CONTENT));
					titulo.setTextSize(TypedValue.COMPLEX_UNIT_PX, 18);
					TextView subtitulo = new TextView(getApplicationContext());
					subtitulo.setText(subtitle);
					subtitulo
							.setLayoutParams(new LinearLayout.LayoutParams(
									LayoutParams.FILL_PARENT,
									LayoutParams.WRAP_CONTENT));
					subtitulo.setTextSize(TypedValue.COMPLEX_UNIT_PX, 18);
					contentData.addView(titulo);
					contentData.addView(subtitulo);
					contentGeneral.addView(numLinea);
					contentGeneral.addView(contentData);
					contenedor.addView(contentGeneral);
				}
			} else {
				TextView titulo = new TextView(getApplicationContext());
				titulo.setText("Parada sin informacion");
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
			url = new URL("http://www.dndzgz.com/point?service=bus&id=" + id);
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
	
	private Intent createShareIntent() {
        return null;
    }
}
