package com.dndzgz.android;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Application;

public class DndZgzApplication extends Application {
	private JSONArray busesList = new JSONArray();	
	private JSONArray bikesList = new JSONArray();
	private JSONArray favsList = new JSONArray();
	private JSONObject lastObject = new JSONObject();
	
	
	public JSONArray getBusesList() {
		return busesList;
	}
	public void setBusesList(JSONArray busesList) {
		this.busesList = busesList;
	}
	
	public JSONArray getBikesList() {
		return bikesList;
	}
	public void setBikesList(JSONArray bikesList) {
		this.bikesList = bikesList;
	}
	public JSONObject getLastObject() {
		return lastObject;
	}
	public void setLastObject(JSONObject lastObject) {
		this.lastObject = lastObject;
	}
	public JSONArray getFavsList() {
		return favsList;
	}
	public void setFavsList(JSONArray favsList) {
		this.favsList = favsList;
	}	
}
