package com.android.dndzgz;

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
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {
	
	private TextView txtDetail;
	private String sid;
	private String service;
	private JSONObject detailJson;
	private String title;
	private String detailedText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Cargo el layout del menú de la aplicación
		setContentView(R.layout.detail);

		// Registro los listeners para los tres botones
		// El primer paso es obtenerlos por su id
		txtDetail = (TextView) findViewById(R.id.lbldetail);
		
		//Recojo los extras
		if (getIntent().hasExtra("id")) {
			sid = getIntent().getStringExtra("id");
		}
		
		if (getIntent().hasExtra("service")) {
			service = getIntent().getStringExtra("service");
		}
		
		if (getIntent().hasExtra("title")) {
			title = getIntent().getStringExtra("title");
		}
		detailedText = title + "\n";
		
		String detail = retriveInfo(service, Integer.parseInt(sid));
		try {
			detailJson = new JSONObject(detail);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		String nombre = null;
		JSONArray items = null;
		try {
			nombre = (String) detailJson.get("title");
			detailedText += nombre + "\n"; 
			items = (JSONArray) detailJson.get("items");
			if(service.compareTo("bizi") == 0){
				JSONArray ocupadas = (JSONArray) items.get(0);
				JSONArray libres = (JSONArray) items.get(1);
				detailedText += ocupadas.getString(0) + "\n" + libres.getString(0);				
			}
						
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		txtDetail.setText(detailedText);	
	}
	
	public String retriveInfo(String service, int id){
		// Obtenemos el listado
		URL url;
		HttpURLConnection urlConnection = null;
		Writer writer = null;
		String result = null;
		try {
			url = new URL("http://www.dndzgz.com/point?service=" + service + "&id=" + id);
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
		return result;
	}
}
