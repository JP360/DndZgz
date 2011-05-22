package com.dndzgz.android.favorites;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.dndzgz.android.DndZgzApplication;
import com.dndzgz.android.MenuActivity;
import com.dndzgz.android.buses.BusDataActivity;
import com.dndzgz.android.gas.GasDataActivity;
import com.dndzgz.android.parking.ParkingDataActivity;
import com.dndzgz.android.pharmacy.PharmacyDataActivity;
import com.dndzgz.android.store.StoreDataActivity;
import com.dndzgz.android.taxi.TaxiDataActivity;
import com.dndzgz.android.tram.TramDataActivity;
import com.dndzgz.android.wifi.WifiDataActivity;
import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.IntentAction;
import com.markupartist.android.widget.actionbar.R;

public class FavoritesActivity extends Activity {

	private ListView listViewFav;
	private DndZgzApplication dndzgzApp;
	private String action = "";
	private JSONArray listFinal;
	private ArrayList<JSONObject> favArrayList;
	private FavAdapter FavAdapter;
	private static final String TAG = "DndZgzAndroid";
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dndzgzApp = ((DndZgzApplication) this.getApplication());
		// ACTION BAR
		setContentView(R.layout.listview_fav);
		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
		Intent homeIntent = new Intent(this, MenuActivity.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		actionBar.setHomeAction(new IntentAction(this, homeIntent,
				R.drawable.ic_title_home_default));
		actionBar.setTitle(R.string.favoritos);
		// ////////////////
		listFinal = new JSONArray();
		listFinal = dndzgzApp.getFavsList();
		if (getIntent().hasExtra("action")) {
			action = getIntent().getStringExtra("action");
		}
		if (action.equals("add")) {
			JSONObject lastObject = dndzgzApp.getLastObject();
			listFinal.put(lastObject);
			dndzgzApp.setFavsList(listFinal);

			SharedPreferences favorites = getSharedPreferences("favorites",
					MODE_PRIVATE);
			SharedPreferences.Editor editor = favorites.edit();
			editor.putString("listaFav", listFinal.toString());
			editor.commit();
		}
		listViewFav = (ListView) findViewById(R.id.ListView);
		favArrayList = new ArrayList<JSONObject>();
		for (int i = 0; i < listFinal.length(); i++) {
			try {
				favArrayList.add(listFinal.getJSONObject(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		this.FavAdapter = new FavAdapter(this, R.layout.fav_item, favArrayList);
		listViewFav.setAdapter(this.FavAdapter);
		listViewFav.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				JSONObject jo = FavAdapter.getItem(pos);
				try {
					String type = jo.getString("type");
					Intent action = new Intent();
					if (type.equals("bus")) {
						action = new Intent(FavoritesActivity.this,
								BusDataActivity.class);
					} else if (type.equals("bike")) {
						action = new Intent(FavoritesActivity.this,
								StoreDataActivity.class);
					} else if (type.equals("tram")) {
						action = new Intent(FavoritesActivity.this,
								TramDataActivity.class);
					} else if (type.equals("store")) {
						action = new Intent(FavoritesActivity.this,
								StoreDataActivity.class);
					} else if (type.equals("pharmacy")) {
						action = new Intent(FavoritesActivity.this,
								PharmacyDataActivity.class);
					} else if (type.equals("gas")) {
						action = new Intent(FavoritesActivity.this,
								GasDataActivity.class);
					} else if (type.equals("taxi")) {
						action = new Intent(FavoritesActivity.this,
								TaxiDataActivity.class);
					}  else if (type.equals("parking")) {
						action = new Intent(FavoritesActivity.this,
								ParkingDataActivity.class);
					}  else if (type.equals("wifi")) {
						action = new Intent(FavoritesActivity.this,
								WifiDataActivity.class);
					}

					action.putExtra("object", jo.toString());
					action.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					FavoritesActivity.this.startActivity(action);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
		registerForContextMenu(listViewFav);				
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
	    ContextMenuInfo menuInfo) {
	  if (v.getId()==R.id.ListView) {
	    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
	    menu.setHeaderTitle("Menu Opciones");	    
	    menu.add(Menu.NONE, 0, 0, "Eliminar Favorito");	    
	  }
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	  AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
	  borrarFav(info.position);
	  return true;
	}

	private class FavAdapter extends ArrayAdapter<JSONObject> {
		private ArrayList<JSONObject> items;

		public FavAdapter(Context context, int textViewResourceId,
				ArrayList<JSONObject> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.fav_item, null);
			}
			JSONObject jo = items.get(position);
			if (jo != null) {
				try {
					TextView tt = (TextView) v.findViewById(R.id.txtTitulo);
					TextView bt = (TextView) v.findViewById(R.id.txtSubTitulo);
					ImageView icon = (ImageView) v.findViewById(R.id.icono);
					if (tt != null) {
						String title = "";
						if (jo.getString("type").equals("bike")) {
							title = getString(R.string.estacion_bici);
							icon.setImageDrawable(getResources().getDrawable(
									R.drawable.bizi));
						} else if (jo.getString("type").equals("bus")) {
							title = getString(R.string.parada_bus);
							icon.setImageResource(R.drawable.bus);
						} else if (jo.getString("type").equals("tram")) {
							title = getString(R.string.parada_tram);
							icon.setImageResource(R.drawable.tranvia);
						} else if (jo.getString("type").equals("store")) {
							title = getString(R.string.establecimiento);
							icon.setImageResource(R.drawable.recarga);
						} else if (jo.getString("type").equals("pharmacy")) {
							title = getString(R.string.farmacia);
							icon.setImageResource(R.drawable.farmacia);
						} else if (jo.getString("type").equals("gas")) {
							title = getString(R.string.gasolinera);
							icon.setImageResource(R.drawable.gas);
						} else if (jo.getString("type").equals("taxi")) {
							title = getString(R.string.taxi);
							icon.setImageResource(R.drawable.taxi);
						} else if (jo.getString("type").equals("parking")) {
							title = getString(R.string.parking);
							icon.setImageResource(R.drawable.parking);
						} else if (jo.getString("type").equals("wifi")) {
							title = getString(R.string.wifi);
							icon.setImageResource(R.drawable.wifi);
						}
						tt.setText(title);
					}
					if (bt != null) {
						bt.setText((String) jo.get("title"));
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return v;
		}
	}

	private void borrarFav(int position) {
		JSONObject jo = favArrayList.get(position);
		favArrayList.remove(position);
		FavAdapter.remove(jo);
		FavAdapter.notifyDataSetChanged();
		
		listFinal = new JSONArray();
		for (int i=0; i<favArrayList.size(); i++){
			JSONObject joelement = favArrayList.get(i);
			listFinal.put(joelement);			
		}		
		dndzgzApp.setFavsList(listFinal);
		
		SharedPreferences favorites = getSharedPreferences("favorites",
				MODE_PRIVATE);
		SharedPreferences.Editor editor = favorites.edit();
		editor.putString("listaFav", listFinal.toString());
		editor.commit();		
	}

}
