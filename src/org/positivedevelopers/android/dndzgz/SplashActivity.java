package org.positivedevelopers.android.dndzgz;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	// El handler es necesario para que desde un Thread
	// fuera del loop de pintado se pueda actualizar la interfaz de usuario
	// o invocar nuevos Intents
	private Handler handler;
	private String listadoWifis;
	private String listadoBizis;
	private String listadoAutobus;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		handler = new Handler();
		setContentView(R.layout.splash);
		Thread cargaPuntosThread = new CargaPuntosThread();
		cargaPuntosThread.start();
		
	}

	class CargaPuntosThread extends Thread {

		@Override
		public void run() {
			listadoWifis = retriveList("wifi");
			listadoBizis = retriveList("bizi");
			listadoAutobus = retriveList("bus");
			//Thread.sleep(1000);
			handler.post(new Runnable() {
				@Override
				public void run() {
					Intent mainIntent = new Intent(SplashActivity.this, MenuActivity.class);
					mainIntent.putExtra("listadoWifis", listadoWifis);
					mainIntent.putExtra("listadoBizis", listadoBizis);
					mainIntent.putExtra("listadoAutobus", listadoAutobus);
					mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					SplashActivity.this.startActivity(mainIntent);
					SplashActivity.this.finish();
				}
			});
		}
	}

	public String retriveList(String service){
		// Obtenemos el listado
		URL url;
		HttpURLConnection urlConnection = null;
		Writer writer = null;
		String result = null;
		try {
			url = new URL("http://www.dndzgz.com/fetch?service=" + service);
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
