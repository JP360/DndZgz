package com.android.dndzgz;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
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

public class BiziActivity extends MapActivity {

	private MapView mapView;
	private List<Overlay> mapOverlays;
	private Drawable iconoUsuario;
	private Drawable iconoBizi;
	private MyItemizedOverlay itemizedOverlay;
	private LocationManager locationManager;
	private GestureDetector detector;
	private JSONArray bizisJson;
	private String listadoBizis;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		// Recupero el mapa de la jerarquía de vistas
		mapView = (MapView) findViewById(R.id.mapview);

		// Creo una clase para detectar gestos. Básicamente para hacer zoom con
		// el double tap
		detector = new GestureDetector(this, new MySimpleGestureListener());

		// Digo al componente que incluya los componentes de zoom que tiene por
		// defecto
		mapView.setBuiltInZoomControls(true);

		// El detector necesita que le pasemos los eventos de touch para que los
		// detecte
		mapView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return detector.onTouchEvent(event);
			}
		});

		// Obtenemos la posicion actual del usuario
		// y centramos el mapa en esa posicion
		String serviceString = Context.LOCATION_SERVICE;
		locationManager = (LocationManager) getSystemService(serviceString);

		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		String bestProvider = locationManager.getBestProvider(criteria, true);

		Location location = locationManager.getLastKnownLocation(bestProvider);
		mapView.getController().setCenter(
				toGeoPoint(location.getLatitude(), location.getLongitude()));

		// Obtenemos la referencia al objeto overlays del mapa que nos permitirá
		// añadir capas encima
		mapOverlays = mapView.getOverlays();

		// Recuperamos las dos imágenes que vamos a utilizar
		iconoUsuario = this.getResources().getDrawable(R.drawable.usermarker);
		iconoBizi = this.getResources().getDrawable(R.drawable.marker);

		// Me creo mi propia capa donde añadiré todos las puntos
		itemizedOverlay = new MyItemizedOverlay(iconoBizi);

		// Creamos un marker para mostrar la posicion actual del usuario
		GeoPoint point = toGeoPoint(location.getLatitude(),
				location.getLongitude());
		OverlayItem posicionUsuario = new OverlayItem(point, "Posicion Actual",
				"Posicion de Usuario");
		posicionUsuario.setMarker(itemizedOverlay
				.boundCenterBottomAux(iconoUsuario));
		itemizedOverlay.addOverlay(posicionUsuario);

		// Indico que el mapa puede ser clicable
		mapView.setClickable(true);
		if (getIntent().hasExtra("listadoBizis")) {
			listadoBizis = getIntent().getStringExtra("listadoBizis");
			try {
				bizisJson = new JSONArray(listadoBizis);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		int n = bizisJson.length();
		for (int i = 0; i < n; i++) {
			try {
				JSONObject bizi = bizisJson.getJSONObject(i);
				String name = (String) bizi.get("name");
				Double latitud = (Double) bizi.getDouble("lat");
				Double longitud = (Double) bizi.getDouble("lon");
				String sid = (String) bizi.get("id");
				GeoPoint puntoBizi = toGeoPoint(latitud, longitud);
				OverlayItem itemBizi = new OverlayItem(puntoBizi,
						sid, name);
				itemizedOverlay.addOverlay(itemBizi);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		// Y por último añado la capa con todos los puntos
		mapOverlays.add(itemizedOverlay);
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
			item.getTitle();
			Intent detailIntent = new Intent(BiziActivity.this, DetailActivity.class);
			detailIntent.putExtra("id", item.getTitle());
			detailIntent.putExtra("service", "bizi");
			detailIntent.putExtra("title", item.getSnippet());
			detailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			BiziActivity.this.startActivity(detailIntent);
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
