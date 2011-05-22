package com.dndzgz.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Application;
import android.util.Log;

public class DndZgzApplication extends Application {
	private JSONArray busesList = new JSONArray();
	private JSONArray bikesList = new JSONArray();
	private JSONArray favsList = new JSONArray();
	private JSONArray tramList = new JSONArray();
	private JSONArray storeList = new JSONArray();
	private JSONArray pharmacyList = new JSONArray();
	private JSONArray gasList = new JSONArray();
	private JSONArray taxiList = new JSONArray();
	private JSONArray parkingList = new JSONArray();
	private JSONArray wifiList = new JSONArray();
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

	public JSONArray getTramList() {
		return tramList;
	}

	public void setTramList(JSONArray tramList) {
		this.tramList = tramList;
	}

	public JSONArray getStoreList() {
		if (storeList.length() > 0) {
			return storeList;
		} else {
			JSONArray resultado = new JSONArray();
			InputStream ins = getResources().openRawResource(
					R.raw.puntos_recarga);
			try {
				if (ins != null) {
					Writer writer = new StringWriter();
					char[] buffer = new char[1024];
					try {
						Reader reader = new BufferedReader(
								new InputStreamReader(ins, "UTF-8"));
						int n;
						while ((n = reader.read(buffer)) != -1) {
							writer.write(buffer, 0, n);
						}
					} finally {
						ins.close();
					}
					Log.i("DndZgzAndroid", "writer\n" + writer.toString());
					resultado = new JSONArray(writer.toString());
					storeList = resultado;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
		}
	}

	public JSONArray getPharmacyList() {
		if (pharmacyList.length() > 0) {
			return pharmacyList;
		} else {
			JSONArray resultado = new JSONArray();
			InputStream ins = getResources().openRawResource(
					R.raw.puntos_farmacia);
			try {
				if (ins != null) {
					Writer writer = new StringWriter();
					char[] buffer = new char[1024];
					try {
						Reader reader = new BufferedReader(
								new InputStreamReader(ins, "UTF-8"));
						int n;
						while ((n = reader.read(buffer)) != -1) {
							writer.write(buffer, 0, n);
						}
					} finally {
						ins.close();
					}
					Log.i("DndZgzAndroid", "writer\n" + writer.toString());
					resultado = new JSONArray(writer.toString());
					pharmacyList = resultado;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
		}
	}
	public JSONArray getGasList() {
		if (gasList.length() > 0) {
			return gasList;
		} else {
			JSONArray resultado = new JSONArray();
			InputStream ins = getResources().openRawResource(
					R.raw.puntos_gas);
			try {
				if (ins != null) {
					Writer writer = new StringWriter();
					char[] buffer = new char[1024];
					try {
						Reader reader = new BufferedReader(
								new InputStreamReader(ins, "UTF-8"));
						int n;
						while ((n = reader.read(buffer)) != -1) {
							writer.write(buffer, 0, n);
						}
					} finally {
						ins.close();
					}
					Log.i("DndZgzAndroid", "writer\n" + writer.toString());
					resultado = new JSONArray(writer.toString());
					gasList = resultado;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
		}
	}
	
	public JSONArray getTaxiList() {
		if (taxiList.length() > 0) {
			return taxiList;
		} else {
			JSONArray resultado = new JSONArray();
			InputStream ins = getResources().openRawResource(
					R.raw.puntos_taxis);
			try {
				if (ins != null) {
					Writer writer = new StringWriter();
					char[] buffer = new char[1024];
					try {
						Reader reader = new BufferedReader(
								new InputStreamReader(ins, "UTF-8"));
						int n;
						while ((n = reader.read(buffer)) != -1) {
							writer.write(buffer, 0, n);
						}
					} finally {
						ins.close();
					}
					Log.i("DndZgzAndroid", "writer\n" + writer.toString());
					resultado = new JSONArray(writer.toString());
					taxiList = resultado;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
		}
	}
	
	public JSONArray getParkingList() {
		if (parkingList.length() > 0) {
			return parkingList;
		} else {
			JSONArray resultado = new JSONArray();
			InputStream ins = getResources().openRawResource(
					R.raw.puntos_parking);
			try {
				if (ins != null) {
					Writer writer = new StringWriter();
					char[] buffer = new char[1024];
					try {
						Reader reader = new BufferedReader(
								new InputStreamReader(ins, "UTF-8"));
						int n;
						while ((n = reader.read(buffer)) != -1) {
							writer.write(buffer, 0, n);
						}
					} finally {
						ins.close();
					}
					Log.i("DndZgzAndroid", "writer\n" + writer.toString());
					resultado = new JSONArray(writer.toString());
					parkingList = resultado;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;
		}
	}

	public JSONArray getWifiList() {
		return wifiList;
	}

	public void setWifiList(JSONArray wifiList) {
		this.wifiList = wifiList;
	}
	
	
	
}
