package com.dndzgz.android;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dndzgz.android.bikes.BikesActivity;
import com.dndzgz.android.buses.BusesActivity;
import com.dndzgz.android.favorites.FavoritesActivity;
import com.dndzgz.android.gas.GasActivity;
import com.dndzgz.android.parking.ParkingActivity;
import com.dndzgz.android.pharmacy.PharmacyActivity;
import com.dndzgz.android.store.StoreActivity;
import com.dndzgz.android.taxi.TaxiActivity;
import com.dndzgz.android.tram.TramActivity;
import com.dndzgz.android.wifi.WifiActivity;
import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;

public class MenuActivity extends Activity implements OnClickListener {

	private ImageView btnAutobuses;
	private ImageView btnBizis;
	private ImageView btnTranvia;
	private ImageView btnRecarga;
	private ImageView btnFarmacia;
	private ImageView btnGasolinera;
	private ImageView btnTaxi;
	private ImageView btnParking;
	private ImageView btnWifis;
	private ImageView btnFavoritos;
	private ImageView btnBuscar;
	private EditText busStop;
	private JSONArray listFavs;
	private DndZgzApplication dndzgzApp;
	private static final String TAG = "DndZgzAndroid";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dndzgzApp = ((DndZgzApplication) this.getApplication());
		setContentView(R.layout.menu);
		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
		actionBar.setHomeAction(new NullAction());
		actionBar.setTitle(R.string.dndzgz);

		LinearLayout layoutSearch = (LinearLayout) findViewById(R.id.poste);
		layoutSearch.setBackgroundColor(Color.parseColor("#333333"));

		btnAutobuses = (ImageView) findViewById(R.id.bus);
		btnAutobuses.setOnClickListener(this);

		btnBizis = (ImageView) findViewById(R.id.bizi);
		btnBizis.setOnClickListener(this);

		btnTranvia = (ImageView) findViewById(R.id.tranvia);
		btnTranvia.setOnClickListener(this);

		btnRecarga = (ImageView) findViewById(R.id.recarga);
		btnRecarga.setOnClickListener(this);

		btnFarmacia = (ImageView) findViewById(R.id.farmacia);
		btnFarmacia.setOnClickListener(this);

		btnGasolinera = (ImageView) findViewById(R.id.gas);
		btnGasolinera.setOnClickListener(this);

		btnTaxi = (ImageView) findViewById(R.id.taxi);
		btnTaxi.setOnClickListener(this);

		btnParking = (ImageView) findViewById(R.id.parking);
		btnParking.setOnClickListener(this);

		btnWifis = (ImageView) findViewById(R.id.wifi);
		btnWifis.setOnClickListener(this);

		btnFavoritos = (ImageView) findViewById(R.id.fav);
		btnFavoritos.setOnClickListener(this);

		btnBuscar = (ImageView) findViewById(R.id.search);
		btnBuscar.setOnClickListener(this);

		busStop = (EditText) findViewById(R.id.txtParada);

		SharedPreferences favorites = getSharedPreferences("favorites",
				MODE_PRIVATE);
		String sListFavs = favorites.getString("listaFav", "");
		if (sListFavs != "") {
			try {
				listFavs = new JSONArray(sListFavs);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			dndzgzApp.setFavsList(listFavs);
		}
	}

	@Override
	public void onClick(View v) {
		if (v == btnAutobuses) {
			Log.w(TAG, "Boton Autobus"); // warning
			Intent autobusesIntent = new Intent(MenuActivity.this,
					BusesActivity.class);
			autobusesIntent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
			MenuActivity.this.startActivity(autobusesIntent);
		} else if (v == btnBizis) {
			Log.w(TAG, "Boton Bicis"); // warning
			Intent biziIntent = new Intent(MenuActivity.this,
					BikesActivity.class);
			biziIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(biziIntent);
		} else if (v == btnTranvia) {
			Log.w(TAG, "Boton Tranvia"); // warning
			Intent tramIntent = new Intent(MenuActivity.this,
					TramActivity.class);
			tramIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(tramIntent);
		} else if (v == btnRecarga) {
			Log.w(TAG, "Boton Recarga"); // warning
			Intent storeIntent = new Intent(MenuActivity.this,
					StoreActivity.class);
			storeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(storeIntent);
		} else if (v == btnFarmacia) {
			Log.w(TAG, "Boton Farmacia"); // warning
			Intent pharmacyIntent = new Intent(MenuActivity.this,
					PharmacyActivity.class);
			pharmacyIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(pharmacyIntent);
		} else if (v == btnGasolinera) {
			Log.w(TAG, "Boton Gasolinera"); // warning
			Intent gasIntent = new Intent(MenuActivity.this,
					GasActivity.class);
			gasIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(gasIntent);

		} else if (v == btnTaxi) {
			Log.w(TAG, "Boton Taxi"); // warning
			Intent taxiIntent = new Intent(MenuActivity.this,
					TaxiActivity.class);
			taxiIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(taxiIntent);

		} else if (v == btnParking) {
			Log.w(TAG, "Boton Parking"); // warning
			Intent parkingIntent = new Intent(MenuActivity.this,
					ParkingActivity.class);
			parkingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(parkingIntent);

		} else if (v == btnWifis) {
			Log.w(TAG, "Boton Wifi"); // warning
			Intent wifiIntent = new Intent(MenuActivity.this,
					WifiActivity.class);
			wifiIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MenuActivity.this.startActivity(wifiIntent);

		} else if (v == btnFavoritos) {
			Log.w(TAG, "Boton Favoritos"); // warning
			Intent FavIntent = new Intent(MenuActivity.this,
					FavoritesActivity.class);
			FavIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			FavIntent.putExtra("action", "view");
			MenuActivity.this.startActivity(FavIntent);
		} else if (v == btnBuscar) {
			Log.w(TAG, "Boton Buscar"); // warning
			String textoFiltro = busStop.getText().toString();
			if (textoFiltro.length() > 0) {
				Intent autobusesIntent = new Intent(MenuActivity.this,
						BusesActivity.class);
				autobusesIntent.putExtra("filtro", textoFiltro);
				autobusesIntent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
				MenuActivity.this.startActivity(autobusesIntent);
			}

		}
	}

	private class NullAction implements Action {

		@Override
		public int getDrawable() {
			return R.drawable.ic_logo_dndzgz;
		}

		@Override
		public void performAction(View view) {

		}

	}

}
