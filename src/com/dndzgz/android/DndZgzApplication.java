package com.dndzgz.android;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Application;

public class DndZgzApplication extends Application {
	private ArrayList<JSONObject> busesList = new ArrayList<JSONObject>();
	private JSONObject lastBus = new JSONObject();
	
	private ArrayList<JSONObject> bikesList = new ArrayList<JSONObject>();
	private JSONObject lastBike = new JSONObject();
	
	public ArrayList<JSONObject> getBusesList() {
		return busesList;
	}
	public void setBusesList(ArrayList<JSONObject> busesList) {
		this.busesList = busesList;
	}
	public JSONObject getLastBus() {
		return lastBus;
	}
	public void setLastBus(JSONObject lastBus) {
		this.lastBus = lastBus;
	}
	public ArrayList<JSONObject> getBikesList() {
		return bikesList;
	}
	public void setBikesList(ArrayList<JSONObject> bikesList) {
		this.bikesList = bikesList;
	}
	public JSONObject getLastBike() {
		return lastBike;
	}
	public void setLastBike(JSONObject lastBike) {
		this.lastBike = lastBike;
	}	
	
}
