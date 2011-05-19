package com.dndzgz.android;

import org.json.JSONObject;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class JsonOverlayItem extends OverlayItem {
	private JSONObject jo;
	
	public JsonOverlayItem(GeoPoint point, String title, String snippet) {
		super(point, title, snippet);
	}

	public JSONObject getJo() {
		return jo;
	}

	public void setJo(JSONObject jo) {
		this.jo = jo;
	}

}
