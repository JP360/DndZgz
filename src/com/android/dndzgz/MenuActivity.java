package com.android.dndzgz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MenuActivity extends Activity implements OnClickListener {
	
	private ImageView btnAutobuses;
	private ImageView btnBizis;
	private ImageView btnWifis;
	private String listadoWifis;
	private String listadoBizis;
	private String listadoAutobus;
	private static final String TAG = "com.android.dndzgz.MenuActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Cargo el layout del menú de la aplicación
		setContentView(R.layout.menu);

		// Registro los listeners para los tres botones
		// El primer paso es obtenerlos por su id
		btnAutobuses = (ImageView) findViewById(R.id.autobuses);
		btnBizis = (ImageView) findViewById(R.id.bizi);
		btnWifis = (ImageView) findViewById(R.id.wifi);

		btnAutobuses.setOnClickListener(this);
		btnBizis.setOnClickListener(this);
		btnWifis.setOnClickListener(this);
		
		if (getIntent().hasExtra("listadoWifis")) {
			listadoWifis = getIntent().getStringExtra("listadoWifis");			
		}
		if (getIntent().hasExtra("listadoBizis")) {
			listadoBizis = getIntent().getStringExtra("listadoBizis");			
		}
		if (getIntent().hasExtra("listadoAutobus")) {
			listadoAutobus = getIntent().getStringExtra("listadoAutobus");			
		}
		
		Log.w(TAG, "Fin de la creacion del menu"); // warning
	}

	@Override
	public void onClick(View v) {
		if (v == btnAutobuses) {
			Intent autobusesIntent = new Intent(MenuActivity.this,
					AutobusesActivity.class);
			autobusesIntent.putExtra("listadoAutobus", listadoAutobus);
			autobusesIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(autobusesIntent);
		} else if (v == btnBizis) {
			Intent biziIntent = new Intent(MenuActivity.this,
					BiziActivity.class);
			biziIntent.putExtra("listadoBizis", listadoBizis);
			biziIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(biziIntent);
		} else if (v == btnWifis) {
			Intent wifisIntent = new Intent(MenuActivity.this,
					WifisActivity.class);
			wifisIntent.putExtra("listadoWifis", listadoWifis);
			wifisIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(wifisIntent);
		}
	}
}
