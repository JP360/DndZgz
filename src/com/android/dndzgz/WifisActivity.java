package com.android.dndzgz;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class WifisActivity extends MapActivity {
		
	private MapView mapView;
	private List<Overlay> mapOverlays;
	private Drawable iconoUsuario;
	private Drawable iconoWifi;
	private RecargaOverlay itemizedOverlay;
	private LocationManager locationManager;
	private GestureDetector detector;
	private String listadoWifis;
	private JSONArray wifisJson;
	
	private static final String TAG = "com.android.dndzgz.WifisActivity";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		// Recupero el mapa de la jerarquía de vistas
		mapView = (MapView) findViewById(R.id.mapview);
		Log.e(TAG, "1");

		// Creo una clase para detectar gestos. Básicamente para hacer zoom con
		// el double tap
		detector = new GestureDetector(this, new MySimpleGestureListener());
		Log.e(TAG, "2");

		// Digo al componente que incluya los componentes de zoom que tiene por
		// defecto
		mapView.setBuiltInZoomControls(true);
		Log.e(TAG, "3");

		// El detector necesita que le pasemos los eventos de touch para que los
		// detecte
		mapView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return detector.onTouchEvent(event);
			}
		});
		Log.e(TAG, "4");
		
		if (getIntent().hasExtra("listadoWifis")) {
			listadoWifis = getIntent().getStringExtra("listadoWifis");
			try {
				wifisJson = new JSONArray(listadoWifis);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.e(TAG, "5");

		// Obtenemos la posicion actual del usuario
		// y centramos el mapa en esa posicion
		String serviceString = Context.LOCATION_SERVICE;
		locationManager = (LocationManager) getSystemService(serviceString);
		Log.e(TAG, "6");
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		String bestProvider = locationManager.getBestProvider(criteria, true);
		Log.e(TAG, "7");
		/*Location location = locationManager.getLastKnownLocation(bestProvider);
		mapView.getController().setCenter(
				toGeoPoint(location.getLatitude(), location.getLongitude()));*/
		Log.e(TAG, "8");

		// Obtenemos la referencia al objeto overlays del mapa que nos permitirá
		// añadir capas encima
		mapOverlays = mapView.getOverlays();
		Log.e(TAG, "9");
		// Recuperamos las dos imágenes que vamos a utilizar
		iconoUsuario = this.getResources().getDrawable(R.drawable.usermarker);
		iconoWifi = this.getResources().getDrawable(R.drawable.marker);
		Log.e(TAG, "10");
		// Me creo mi propia capa donde añadiré todos las puntos
		//itemizedOverlay = new MyItemizedOverlay(iconoWifi);
		Log.e(TAG, "Antes de crear el Overlay");
		itemizedOverlay = new RecargaOverlay(iconoWifi);
		Log.e(TAG, "Despues de crearlo");

		/*// Creamos un marker para mostrar la posicion actual del usuario
		GeoPoint point = toGeoPoint(location.getLatitude(),
				location.getLongitude());
		OverlayItem posicionUsuario = new OverlayItem(point, "Posicion Actual",
				"Posicion de Usuario");
		posicionUsuario.setMarker(itemizedOverlay
				.boundCenterBottomAux(iconoUsuario));
		itemizedOverlay.addOverlay(posicionUsuario);
		*/
		// Indico que el mapa puede ser clicable
		mapView.setClickable(true);
		
		/*
			JSONObject wifi;
			int n = wifisJson.length();
			for (int i = 0; i < n; i++) {
				try {
					wifi = wifisJson.getJSONObject(i);
					String nombre = (String) wifi.get("title");
					Double latitud = (Double) wifi.getDouble("lat");
					Double longitud = (Double) wifi.getDouble("lon");
					GeoPoint puntoWifi = toGeoPoint(latitud, longitud);
					OverlayItem itemWifi = new OverlayItem(puntoWifi, "Punto Wifi",
							nombre);
					itemizedOverlay.addOverlay(itemWifi);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}*/
		
		// Y por último añado la capa con todos los puntos
		Log.e(TAG, "Antes de pintarlo en el mapa");
		mapOverlays.add(itemizedOverlay);
		Log.e(TAG, "Despues de pintarlo");
	}

	public static final long TO_E6 = 1000000l;

	public static GeoPoint toGeoPoint(double latitud, double longitud) {
		return new GeoPoint((int) (latitud * TO_E6), (int) (longitud * TO_E6));
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	// La implementación de mi capa
	public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {

		public MyItemizedOverlay(Drawable defaultMarker) {
			super(boundCenterBottom(defaultMarker));
		}

		private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();

		@Override
		protected OverlayItem createItem(int i) {
			return mOverlays.get(i);
		}

		@Override
		public int size() {
			return mOverlays.size();
		}

		public void addOverlay(OverlayItem overlay) {
			mOverlays.add(overlay);
			populate();
		}

		// De nuevo paso los eventos al detector
		@Override
		public boolean onTouchEvent(MotionEvent event, MapView mapView) {
			return detector.onTouchEvent(event);
		}

		// Dado una imagen la ajusta para que el punto 0,0 de éste esté en el
		// centro de la parte inferior
		public Drawable boundCenterBottomAux(Drawable marker) {
			return boundCenterBottom(marker);
		}

		// Cuando se hace tap en un punto muestro un Alert
		@Override
		protected boolean onTap(int index) {
			OverlayItem item = mOverlays.get(index);
			AlertDialog.Builder dialog = new AlertDialog.Builder(
					WifisActivity.this);
			dialog.setTitle(item.getTitle());
			dialog.setMessage(item.getSnippet());
			dialog.show();
			return true;
		}

	}

	// Mi GestureListener desciende de SimpleOnGestureListener y sólo
	// sobreescribo el método onTap
	// Hago un zoom de la misma forma que lo hace la aplicación de Google Maps
	// nativa
	class MySimpleGestureListener extends SimpleOnGestureListener {

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			mapView.getController()
					.zoomInFixing((int) e.getX(), (int) e.getY());
			return true;
		}
	}

}
