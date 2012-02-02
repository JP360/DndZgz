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
import android.os.Handler;
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

public class AutobusesActivity extends MapActivity {
	private MapView mapView;
	private List<Overlay> mapOverlays;
	private Drawable iconoUsuario;
	private Drawable iconoAutobus;
	private MyItemizedOverlay itemizedOverlay;
	private LocationManager locationManager;
	private JSONArray autobusesJson;
	private String listadoAutobus;
	private boolean puntosCargados = false;
	private GestureDetector detector;
	private static final String TAG = "com.android.dndzgz.AutobusesActivity";
	
	// Need handler for callbacks to the UI thread
    final Handler mHandler = new Handler();

    // Create runnable for posting
    final Runnable mUpdateResults = new Runnable() {
        public void run() {
            updateResultsInUi();
        }
    };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		Log.e(TAG, "onCreate()...."); // warning

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
		iconoAutobus = this.getResources().getDrawable(R.drawable.marker);

		// Me creo mi propia capa donde añadiré todos los puntos
		itemizedOverlay = new MyItemizedOverlay(iconoAutobus);

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

		if (getIntent().hasExtra("listadoAutobus")) {
			listadoAutobus = getIntent().getStringExtra("listadoAutobus");
			try {
				autobusesJson = new JSONArray(listadoAutobus);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		startLongRunningOperation();
		Log.e(TAG, "Fin onCreate()");
	}
	
	protected void startLongRunningOperation() {
		Log.e(TAG, "startLongRunningOperation()");
        // Fire off a thread to do some work that we shouldn't do directly in the UI thread
        Thread t = new Thread() {
            public void run() {
                cargaPuntosMapa();
                while(!puntosCargados){
                	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                }
                mHandler.post(mUpdateResults);
            }
        };
        t.start();
    }
	
	private void updateResultsInUi() {
		Log.e(TAG, "updateResultsInUi()");
		Log.e(TAG, "añado el overlay");
		mapOverlays.add(itemizedOverlay);
		mapView.postInvalidate();
		
		
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
			// return detector.onTouchEvent(event);
			return false;
		}

		// Dado una imagen la ajusta para que el punto 0,0 de éste esté en el
		// centro de la parte inferior
		public Drawable boundCenterBottomAux(Drawable marker) {
			return boundCenterBottom(marker);
		}

		public Drawable boundCenterCenter(Drawable marker) {
			return boundCenter(marker);
		}

		// Cuando se hace tap en un punto muestro un Alert
		@Override
		protected boolean onTap(int index) {
			OverlayItem item = mOverlays.get(index);
			AlertDialog.Builder dialog = new AlertDialog.Builder(
					AutobusesActivity.this);
			dialog.setTitle(item.getTitle());
			dialog.setMessage(item.getSnippet());
			dialog.show();
			return true;
		}

	}

	// Mi GestureListener desciende de SimpleOnGestureListener y sólo
	// sobreescribo el método onDoubleTap
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

	public void cargaPuntosMapa() {
		MyItemizedOverlay capaDatos = new MyItemizedOverlay(iconoAutobus);
		Log.e(TAG, "cargaPuntosMapa()");		
		int n = autobusesJson.length();
		Log.e(TAG, "Total De Puntos: " + n);		
		int limite = n/20;
		for (int i = 0; i < n; i++) {
			try {				
				JSONObject autobus = autobusesJson.getJSONObject(i);
				String nombre = (String) autobus.get("title");				
				String descripcion = (String) autobus.get("subtitle");
				Log.e(TAG, i + "->" + descripcion);
				Double latitud = (Double) autobus.getDouble("lat");
				Double longitud = (Double) autobus.getDouble("lon");
				// String sid = (String) autobus.get("id");
				GeoPoint puntoAutobus = toGeoPoint(latitud, longitud);
				OverlayItem itemAutobus = new OverlayItem(puntoAutobus, nombre,
						descripcion);
//				capaDatos.addOverlay(itemAutobus);
//				if(i==limite){
//					Log.e(TAG, "Nueva Capa!");
//					limite+=limite;
//					mapOverlays.add(capaDatos);
//					mapView.postInvalidate();
//					capaDatos = new MyItemizedOverlay(iconoAutobus);
//				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		puntosCargados = true;
		Log.e(TAG, "Puntos Cargados!!!");
	}

}
