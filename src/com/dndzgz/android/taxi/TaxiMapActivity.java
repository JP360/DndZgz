package com.dndzgz.android.taxi;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.dndzgz.android.DndZgzApplication;
import com.dndzgz.android.R;
import com.dndzgz.android.data.JsonOverlayItem;
import com.dndzgz.android.data.ObjectsItemizedOverlay;
import com.dndzgz.android.data.userItemizedOverlay;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class TaxiMapActivity extends MapActivity {

	private ProgressDialog progressDialog = null;
	private MapView mapView;
	private ArrayList<JSONObject> taxiArrayList = new ArrayList<JSONObject>();
	private DndZgzApplication dndzgzApp;
	private ObjectsItemizedOverlay itemizedoverlay;
	private Runnable runnableTaxi;
	private List<Overlay> mapOverlays;
	private Drawable pushPinMarker;
	private Drawable userLocationMarker;
	private userItemizedOverlay userOverlay;
	private LocationManager locationManager;
	private LocationListener locationListener;
	private boolean isRequest;
	private Location lastLocation;

	private static final String TAG = "DndZgzAndroid";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate()");
		setContentView(R.layout.map);
		mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		mapOverlays = mapView.getOverlays();
		pushPinMarker = this.getResources().getDrawable(R.drawable.ic_icon_map_marker);
		itemizedoverlay = new ObjectsItemizedOverlay(pushPinMarker, mapView);
		itemizedoverlay.setDestino(TaxiDataActivity.class);
		userLocationMarker = this.getResources().getDrawable(
				R.drawable.ic_icon_user_location);
		userOverlay = new userItemizedOverlay(userLocationMarker);
		dndzgzApp = ((DndZgzApplication) this.getApplication());
		JSONArray listJSON = dndzgzApp.getTaxiList();
		for(int i=0; i<listJSON.length(); i++){
			try {
				taxiArrayList.add((JSONObject) listJSON.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.i(TAG, "taxiArrayList: " + taxiArrayList.size());

		runnableTaxi = new Runnable() {
			@Override
			public void run() {
				paintObjects();
			}
		};

		Thread thread = new Thread(null, runnableTaxi, "PintarPuntosMapa");
		thread.start();
		progressDialog = ProgressDialog.show(TaxiMapActivity.this,
				getText(R.string.espere), getText(R.string.pintando_puntos), true);
		locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);

		// Define a listener that responds to location updates
		locationListener = new LocationListener() {
			public void onLocationChanged(Location location) {
				showUserMarker(location);
				// Log.i(TAG, "LocationChanged");
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {

			}

			public void onProviderEnabled(String provider) {
				requestLocations();
			}

			public void onProviderDisabled(String provider) {
				removeRequestLocation();
			}
		};
		trackUserLocation();
	}

	private void paintObjects() {
		Log.i(TAG, "paintObjects()");
		for (int i = 1; i < taxiArrayList.size(); i++) {
			JSONObject jo = taxiArrayList.get(i - 1);
			try {
				String title = jo.getString("title");
				String subtitle = jo.getString("subtitle");
				String lat = jo.getString("lat");
				String lon = jo.getString("lon");
				GeoPoint point = toGeoPoint(Double.parseDouble(lat), Double
						.parseDouble(lon));
				JsonOverlayItem overlayitem = new JsonOverlayItem(point, title,
						subtitle);
				overlayitem.setJo(jo);
				itemizedoverlay.addOverlay(overlayitem);
				if ((i % 100) == 0) {
					mapOverlays.add(itemizedoverlay);
					itemizedoverlay = new ObjectsItemizedOverlay(pushPinMarker,
							mapView);
					itemizedoverlay.setDestino(TaxiDataActivity.class);
					// Log.e(TAG, "Nueva Capa");
				}
				// Log.i(TAG, (i+1)+"");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		Log.i(TAG, "Fin paintObjects()");
		Log.e(TAG, "Numero de Capas: " + mapView.getOverlays().size());
		runOnUiThread(returnRes);
	}

	public static final long TO_E6 = 1000000l;

	public static GeoPoint toGeoPoint(double latitud, double longitud) {
		return new GeoPoint((int) (latitud * TO_E6), (int) (longitud * TO_E6));
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	private Runnable returnRes = new Runnable() {
		@Override
		public void run() {
			mapOverlays.add(itemizedoverlay);
			mapView.postInvalidate();
			progressDialog.dismiss();
		}
	};

	protected void trackUserLocation() {
		// Acquire a reference to the system Location Manager
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		String bestProvider = locationManager.getBestProvider(criteria, true);
		Log.i(TAG, "Best Provider: " + bestProvider);
		Location lastKnownLocation = locationManager
				.getLastKnownLocation(bestProvider);
		requestLocations();
		mapView.getController().setZoom(16);
		Log.i(TAG, "lastLocation");
		lastLocation = lastKnownLocation;
		Log.i(TAG, "showUserMarker");
		showUserMarker(lastKnownLocation);
		GeoPoint point = toGeoPoint(lastKnownLocation.getLatitude(),
				lastKnownLocation.getLongitude());
		mapView.getController().animateTo(point);

	}

	protected void showUserMarker(Location location) {
		mapView.getOverlays().remove(userOverlay);
		userOverlay = (userItemizedOverlay) new userItemizedOverlay(
				userLocationMarker);
		GeoPoint point = toGeoPoint(location.getLatitude(), location
				.getLongitude());
		OverlayItem overlayitem = new OverlayItem(point, "", "");
		userOverlay.addOverlay(overlayitem);
		mapView.getOverlays().add(userOverlay);
		// double newLatitude = (double)Math.round(location.getLatitude() *
		// 10000000) / 10000000;
		// double newLongitude = (double)Math.round(location.getLongitude() *
		// 10000000) / 10000000;
		// double oldLatitude = (double)Math.round(lastLocation.getLatitude() *
		// 10000000) / 10000000;
		// double oldLongitude = (double)Math.round(lastLocation.getLongitude()
		// * 10000000) / 10000000;
		//		
		// if(!(newLatitude == oldLatitude) || !(newLongitude == oldLongitude)){
		// lastLocation.setLongitude(newLongitude);
		// lastLocation.setLatitude(newLatitude);
		// mapView.getController().animateTo(point);
		// }
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart()");
		requestLocations();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume()");
		requestLocations();
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause()");
		removeRequestLocation();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop()");
		removeRequestLocation();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy()");
		removeRequestLocation();
	}

	private void requestLocations() {
		// Log.i(TAG, "requestLocations()");
		// Log.i(TAG, "isRequest: " + isRequest);
		if (!isRequest) {
			locationManager.requestLocationUpdates(
					LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
			locationManager.requestLocationUpdates(
					LocationManager.GPS_PROVIDER, 0, 0, locationListener);
			isRequest = true;
		}
	}

	private void removeRequestLocation() {
		if (isRequest) {
			locationManager.removeUpdates(locationListener);
			isRequest = false;
		}
	}
}
