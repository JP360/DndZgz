package com.dndzgz.android.data;

import java.util.ArrayList;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.dndzgz.android.buses.BusDataActivity;
import com.google.android.maps.MapView;
import com.readystatesoftware.mapviewballoons.BalloonItemizedOverlay;

public class ObjectsItemizedOverlay extends
		BalloonItemizedOverlay<JsonOverlayItem> {
	private ArrayList<JsonOverlayItem> mOverlays = new ArrayList<JsonOverlayItem>();
	private Context mContext;
	private Class destino;	

	public ObjectsItemizedOverlay(Drawable defaultMarker, MapView mapView) {
		super(boundCenterBottom(defaultMarker), mapView);
		mContext = mapView.getContext();
	}

	public void addOverlay(JsonOverlayItem overlay) {
		mOverlays.add(overlay);
		populate();
	}

	@Override
	protected JsonOverlayItem createItem(int i) {
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}
	
	
	public void setDestino(Class destino) {
		this.destino = destino;
	}

	@Override
	protected boolean onBalloonTap(int index, JsonOverlayItem item) {
		JSONObject jo = item.getJo();
		Intent mainIntent = new Intent(mContext,
				destino);
		mainIntent.putExtra("object", jo.toString());
		mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mContext.startActivity(mainIntent);
		return true;
	}

}
