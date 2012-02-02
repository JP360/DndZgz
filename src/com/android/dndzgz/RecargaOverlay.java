//  RecargaOverlay.java
//  DNDzgz
//
//  Created by gimenete on 02/10/10.
//  Modified by Malicious-mind on 19/03/11
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//
package com.android.dndzgz;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class RecargaOverlay extends ItemizedOverlay<OverlayItem> {
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private OverlayItem itemOverlay;
	private GeoPoint point;
	private static final long TO_E6 = 1000000l;
	
	public RecargaOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		

		 //COMANDANTE REPOLLES , 18, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6498664,-0.8768782);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Comandante Repollés, 18, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COSO , 98, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6510102,-0.8772596);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 17",
			"Calle del Coso, 98, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JOSE LUIS POMARÓN , 5, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6470671,-0.8766925);
		itemOverlay = new OverlayItem(point, "QUIOSCO FUNDACION DFA",
			"Calle de José Luis Pomarón Herranz, 5, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo LA MINA, de , 21, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6489221,-0.8769054);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de la Mina, 21, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIANO CARDEDERA , 4, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6520979,-0.8764514);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza PILAR, del , 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6558758,-0.8788017);
		itemOverlay = new OverlayItem(point, "AYUNTAMIENTO",
			"Plaza del Pilar, Catedral-Basílica de Nuestra Señora del Pilar de Zaragoza, Plaza de Nuestra Señora del Pilar, 19, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JORGE , 3, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6530106,-0.878113);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de San Jorge, 3, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JORGE , 8, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6527976,-0.877645);
		itemOverlay = new OverlayItem(point, "IBERCAJA, OF. SAN JORGE",
			"Calle de San Jorge, 8, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JORGE , 3, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6530106,-0.878113);
		itemOverlay = new OverlayItem(point, "QUIOSCO - EL ARBOL",
			"Calle de San Jorge, 3, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JORGE , 3, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6530106,-0.878113);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EL ARBOL",
			"Calle de San Jorge, 3, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JORGE , 22, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6522424,-0.8765589);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de San Jorge, 22, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN MIGUEL , 42, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6499744,-0.8776751);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de San Miguel, 42, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza SAN PEDRO NOLASCO , 7, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6530411,-0.8771493);
		itemOverlay = new OverlayItem(point, "D.G.A. S. PEDRO NOLASCO",
			"Plaza de San Pedro Nolasco, 7, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN VICENTE DE PAUL , 1, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6510277,-0.8769449);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de San Vicente Paul, 1, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ZURITA , 14, 50001  Zaragoza, Aragón, España
		point = toGeoPoint(41.6499595,-0.8803936);
		itemOverlay = new OverlayItem(point, "Tiendas de conveniencia",
			"Calle de Jerónimo Zurita, 14, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ASALTO , 54, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6490946,-0.8728015);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Asalto, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ASALTO , 65, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6497099,-0.8706617);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle del Asalto, 65, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BATALLA DE LEPANTO , 59, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6443002,-0.8597695);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Batalla de Lepanto, 59, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BATALLA DE LEPANTO , 15, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6449654,-0.8657986);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Batalla de Lepanto, 15, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		/* //BATALLA DE LEPANTO , 29, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.64482,-0.864639);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Batalla de Lepanto, 29, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMPROMISO DE CASPE , 95, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6453839,-0.8620577);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 8",
			"Av del Compromiso de Caspe, 95, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMPROMISO DE CASPE , 68, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6452173,-0.8624674);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 43",
			"Av del Compromiso de Caspe, 68, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMPROMISO DE CASPE , 34, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6456904,-0.8668348);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av del Compromiso de Caspe, 34, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMPROMISO DE CASPE , 82, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6449478,-0.8602057);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av del Compromiso de Caspe, 82, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMPROMISO DE CASPE , 107, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6449201,-0.859063);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av del Compromiso de Caspe, 107, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMPROMISO DE CASPE , 77, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6455753,-0.8646895);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Av del Compromiso de Caspe, 77, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMUNEROS DE CASTILLA , 5, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.650495,-0.859696);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Comuneros de Castilla, 5, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COSO , 120, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6507632,-0.8757553);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Coso, 120, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COSO , 182, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6525411,-0.8725009);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Coso, 182, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DOCTOR IRANZO , 68, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6476056,-0.8637741);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Doctor Iranzo, 68, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DOCTOR IRANZO , 84, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6493826,-0.8634989);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Doctor Iranzo, 84, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DON ALONSO DE ARAGON , 18, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6545841,-0.9032282);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Don Alonso de Aragón, 18, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //EUGENIA BUESO , 3, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6493304,-0.8608665);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Eugenia Bueso, 3, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FLORIAN REY , 1, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6492848,-0.8615702);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de Florián Rey, 1, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FRAY LUIS URBANO , 27, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6466069,-0.858854);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Fray Luis Urbano, 27, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JOAQUIN SANZ GADEA , 1, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6465143,-0.871268);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Joaquín Sanz Gadea, 1, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JORGE COCCI , 3, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6503138,-0.8651303);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MANUEL VIOLA , 2, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6591662,-0.8580812);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Manuel Viola, 2, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONASTERIO DE SIRESA , 15, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6474585,-0.8637959);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 3",
			"Calle del Monasterio de Siresa, 15, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONASTERIO DE SIRESA , 20, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6475456,-0.86336);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle del Monasterio de Siresa, 20, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONASTERIO DE SIRESA , 24, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6475254,-0.8641866);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle del Monasterio de Siresa, 24, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONASTERIO DE SIRESA , 33, 50002  (SOLO VENTA) Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONASTERIO DE SIRESA , 33, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.647563,-0.8664654);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Monasterio de Siresa, 33, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONASTERIO DE SIRESA , 34, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6477624,-0.8659751);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Monasterio de Siresa, 34, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza NUESTRA DEL PORTAL , 3, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6488684,-0.8628871);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza de Nuestra Señora del Portal, 3, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //REBOLERIA , 14, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6521596,-0.8701327);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Rebolería, 14, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //REINA ESTHER , 4, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6509535,-0.8682014);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Reina Esther, 4, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //REINA FABIOLA , 22, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6451574,-0.8747898);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Reina Fabiola, 22, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RODRIGO REBOLLEDO , 7, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6462375,-0.8650527);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Rodrigo Rebolledo, 7, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RODRIGO REBOLLEDO , 38, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.645767,-0.8605632);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Rodrigo Rebolledo, 38, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RODRIGO REBOLLEDO , 7, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6462375,-0.8650527);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Rodrigo Rebolledo, 7, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RUIZ LASALA , 20, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6675483,-0.827906);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Ruiz Lasala, 20, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR MINGUIJON , 33, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6482409,-0.8616153);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 51",
			"Calle de Salvador Minguijón, 33, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR MINGUIJON , 14, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6459051,-0.8619175);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 15",
			"Calle de Salvador Minguijón, 14, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR MINGUIJON , 10, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6454736,-0.8619755);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Salvador Minguijón, 10, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SILVESTRE PEREZ , 28, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6482167,-0.8635491);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Silvestre Pérez, 28, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza TAUSTE , 1, 50002  Zaragoza, Aragón, España
		point = toGeoPoint(41.6518413,-0.8679471);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 83",
			"Plaza de Tauste, 1, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ALMOZARA , 7, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6616345,-0.896448);
		itemOverlay = new OverlayItem(point, "SUPERBIEN",
			"Av de la Almozara, 7, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ALTAIR , 29, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6392213,-0.9361408);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Altair, 29, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BATALLA DE ALMANSA , 12, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6622056,-0.8992109);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Batalla de Almansa, 12, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BOGGIERO , 182, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6565794,-0.8923406);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Basilio Boggiero, 182, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BONN , 1, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6616961,-0.9023648);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Bonn, 1, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BRUSELAS , 2, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6606624,-0.9030739);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de Bruselas, 2, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BRUSELAS , 7, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6609919,-0.9027744);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Bruselas, 7, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CEREROS , 22, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6573083,-0.8911263);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Cereros, 22, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAR AUGUSTO , 48, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6545151,-0.8842093);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 31",
			"Av de César Augusto, 48, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONDE DE ARANDA , 114, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.65579,-0.8908951);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 15",
			"Calle Conde de Aranda, 114, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONDE DE ARANDA , 2, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6546597,-0.8859726);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Conde de Aranda, 2, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COSO , 29, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6527399,-0.8815071);
		itemOverlay = new OverlayItem(point, "CAJALON, OFICINA PRINCIPAL",
			"Calle del Coso, 29, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DON JAIME I , 33, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6539407,-0.8779184);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 4",
			"Calle de Don Jaime I, 33, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DON JAIME I , 37, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6543232,-0.8774777);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Don Jaime I, 37, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza ESPAÑA, de , 3, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6519942,-0.8812422);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza de España, 3, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FRAGA , 14, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6593743,-0.9002456);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Fraga, 14, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo INDEPENDENCIA, de la , 11, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6504171,-0.8826701);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de la Independencia, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo MARIA AGUSTIN, de , 97, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.657327,-0.8934555);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Paseo de María Agustín, 97, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONACO , 11, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6606352,-0.9053373);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Mónaco, 11, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONSEÑOR ROMERO , 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6556775,-0.8929931);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Monseñor Óscar Romero, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 69, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6607592,-0.8994555);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 26",
			"Av de Pablo Gargallo, 69, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 19, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6599133,-0.8961482);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 4",
			"Av de Pablo Gargallo, 19, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 75, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6608327,-0.9002907);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 66",
			"Av de Pablo Gargallo, 75, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 65, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6605928,-0.8990728);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Av de Pablo Gargallo, 65, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 93, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6611349,-0.9021537);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 49",
			"Av de Pablo Gargallo, 93, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 55, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6605756,-0.8984506);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Pablo Gargallo, 55, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida PABLO GARGALLO , 105, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6616358,-0.9033762);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Pablo Gargallo, 105, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 7, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.659432,-0.8942542);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Pablo Gargallo, 7, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 103, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6614957,-0.903203);
		itemOverlay = new OverlayItem(point, "QUIOSCO (PANADERÍA)",
			"Av de Pablo Gargallo, 103, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 36, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6598147,-0.8949955);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Av de Pablo Gargallo, 36, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 107, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6617064,-0.9035905);
		itemOverlay = new OverlayItem(point, "QUIOSCO Vídeoclub",
			"Av de Pablo Gargallo, 107, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PADRE CONSOLACION , 16, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6615588,-0.8974101);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Padre Consolación, 16, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza PILAR, del "Pasaje de la Industria" , 11, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6725129,-0.8348499);
		itemOverlay = new OverlayItem(point, "QUIOSCO Expendid. nº 54",
			"Av de la Industria, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PREDICADORES , 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6575617,-0.8856419);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de los Predicadores, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //REINA FELICIA , 35, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6591608,-0.8994181);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Reina Felicia, 35, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN PABLO , 14, 50003  (SOLO VENTA) Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza SAN PEDRO NOLASCO , 1, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6527579,-0.8772732);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza de San Pedro Nolasco, 1, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN VOTO , 6, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6540295,-0.8786339);
		itemOverlay = new OverlayItem(point, "MULTICAJA, OFICINA PRINCIPAL",
			"Calle de San Voto, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SANTA INES , 12, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6572329,-0.890714);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Santa Inés, 12, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SANTA LUCIA , 8, 50003  Zaragoza, Aragón, España
		point = toGeoPoint(41.6583128,-0.8909779);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Santa Lucía, 8, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ALBAREDA , 19, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6495196,-0.8852879);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de José Luis Albareda, 19, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANSELMO CLAVE , 49, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6491317,-0.8936708);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de José Anselmo Clavé, 49, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida ANSELMO CLAVE , 37, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6499158,-0.8937337);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de José Anselmo Clavé, 37, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANSELMO CLAVE , 37, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6499158,-0.8937337);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de José Anselmo Clavé, 37, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza ARAGON, de , 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6482701,-0.8850658);
		itemOverlay = new OverlayItem(point, "CABINA TUZSA PZA DE ARAGON",
			"Plaza de Aragón, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //AZOQUE , 37, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6516912,-0.8842833);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Azoque, 37, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BENITO PEREZ GALDOS , 2, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6482798,-0.8906283);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Benito Pérez Galdós, 2, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BILBAO , 7, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6491868,-0.8857851);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Bilbao, 7, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CANFRANC , 22, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6492337,-0.886359);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 100",
			"Calle de Canfranc, 22, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAR AUGUSTO , 18, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6509576,-0.8860006);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 9",
			"Av de César Augusto, 18, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAR AUGUSTO , 4, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6501122,-0.8870766);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de César Augusto, 4, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CINCO DE MARZO , 12, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.651719,-0.8826911);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle Cinco de Marzo, 12, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONDE DE ARANDA , 101, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6553298,-0.8893005);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 1",
			"Calle Conde de Aranda, 101, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONDE DE ARANDA , 45, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6551017,-0.8885401);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Conde de Aranda, 45, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DOCTOR HORNO , 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6497684,-0.8905532);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Doctor Horno Alcorta, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //HERNAN CORTES , 12, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6487863,-0.8892853);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 1",
			"Calle de Hernán Cortés, 12, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //HERNAN CORTES , 1, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6493928,-0.8881771);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Hernán Cortés, 1, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo INDEPENDENCIA, de la , 10, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6502502,-0.8828415);
		itemOverlay = new OverlayItem(point, "CAI. OFICINA PRINCIPAL",
			"Paseo de la Independencia, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo INDEPENDENCIA, de la , 24, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6502502,-0.8828415);
		itemOverlay = new OverlayItem(point, "CENTRO COMERCIAL INDEPENDENCIA (CARACOL)",
			"Paseo de la Independencia, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo INDEPENDENCIA, de la , 24, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6502502,-0.8828415);
		itemOverlay = new OverlayItem(point, "CENTRO COMERCIAL INDEPENDENCIA (CARACOL 2)",
			"Paseo de la Independencia, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo INDEPENDENCIA, de la , 8, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6502502,-0.8828415);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de la Independencia, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo INDEPENDENCIA, de la , 33, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6502502,-0.8828415);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de la Independencia, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MADRE SACRAMENTO , 28, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6497305,-0.8911269);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Madre Sacramento, 28, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MADRE SACRAMENTO , 20, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.64944,-0.8906864);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Madre Sacramento, 20, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MADRID, de , 17, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6556705,-0.8950363);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Madrid, 17, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo MARIA AGUSTIN, de , 67, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.653409,-0.8927501);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de María Agustín, 67, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo PAMPLONA, de , 25, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6494331,-0.8877093);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de Pamplona, 25, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza PARAÍSO, de Basilio (QUIOSCO) , 0, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6513698,-0.89016);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo TERUEL, de -Local derecho- , 29, 50004  Zaragoza, Aragón, España
		point = toGeoPoint(41.6513698,-0.89016);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BRETON , 22, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6443222,-0.8953411);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de Tomás Bretón, 22, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BRETON , 27, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6448949,-0.8966572);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Tomás Bretón, 27, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BRETON , 31, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6453947,-0.8976139);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Tomás Bretón, 31, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BURGOS , 14, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6476247,-0.8956714);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Burgos, 14, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMANDANTE SANTA PAU , 17, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6418684,-0.8848412);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Comandante Santa Pau, 17, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CORTES DE ARAGON , 4, 50005  (SOLO VENTA) Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CORTES DE ARAGON , 4, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6469065,-0.8913539);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de las Cortes de Aragón, 4, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CORTES DE ARAGON , 19, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6461913,-0.8918149);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de las Cortes de Aragón, 19, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DESIDERIO ESCOSURA , 65, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.648951,-0.8991079);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 62",
			"Calle de Desiderio Escosura, 65, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DOCTOR CERRADA , 14, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6476179,-0.8885339);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle del Doctor Cerrada, 14, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ESCOSURA , 44, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6484813,-0.8987358);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Desiderio Escosura, 44, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GARCIA SANCHEZ , 16, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6469011,-0.8989532);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de José García Sánchez, 16, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida GOYA , 90, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6468879,-0.893522);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Goya, 90, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GRAN VIA , 52, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6448843,-0.8914513);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 11",
			"Paseo Gran Vía, 52, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GRAN VIA , 40, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6452875,-0.8907961);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 20",
			"Paseo Gran Vía, 40, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GRAN VIA , 52, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6448843,-0.8914513);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Paseo Gran Vía, 52, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //HERNAN CORTES , 22, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6479682,-0.8903083);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 64",
			"Calle de Hernán Cortés, 22, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JUAN JOSE LORENTE , 26, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6455934,-0.8963219);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Juan José Lorente, 26, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MAESTRO SERRANO , 1, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6453722,-0.8980636);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 10",
			"Calle del Maestro José Serrano, 1, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARCIAL , 1, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6450496,-0.8914713);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Poeta Marco Marcial, 1, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TARRAGONA , 32, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6485482,-0.8978239);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Tarragona, 32, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TOLEDO , 32, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6477676,-0.8979663);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Toledo, 32, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TOMAS BRETON , 2, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.643696,-0.8940588);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Tomás Bretón, 2, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida VALENCIA , 24, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6469064,-0.8958613);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 64",
			"Av de Valencia, 24, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VALENCIA , 11, 50005  Zaragoza, Aragón, España
		point = toGeoPoint(41.6471084,-0.8949616);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Valencia, 11, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANDRES PIQUER , 14, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6389147,-0.8957426);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de Don Andrés Piquer, 14, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ARZOBISPO DOMENECH , 12, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6448852,-0.8879773);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Arzobispo Domènech, 12, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ARZOBISPO DOMENECH , 21, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6439556,-0.8881157);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Arzobispo Domènech, 21, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BRUNO SOLANO , 3, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6396844,-0.8951531);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Bruno Solano, 3, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CERVANTES (CASETAS) , 4, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.722284,-1.0293464);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Cervantes, 4, 50620 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza DIEGO VELAZQUEZ , 2, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6387332,-0.8865675);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Glorieta de Diego Velázquez, 2, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FELIX LATASSA , 25, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6418446,-0.8926411);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Félix Latassa, 25, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FERNANDO EL CATOLICO , 35, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6413557,-0.8941933);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 10",
			"Paseo de Don Fernando El Católico, 35, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GASCON DE GOTOR , 19, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6389027,-0.8882333);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de Gascón de Gotor, 19, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GASCON DE GOTOR , 26, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.638513,-0.8890956);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Gascón de Gotor, 26, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GASCON DE GOTOR , 12, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6392433,-0.887856);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Gascón de Gotor, 12, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JUAN PABLO BONET , 16, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6405686,-0.8882472);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Juan Pablo Bonet, 16, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JUAN PABLO BONET , 20, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6407452,-0.8888353);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Juan Pablo Bonet, 20, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle MARIANO ROYO , 14, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6456747,-0.8871442);
		itemOverlay = new OverlayItem(point, "QUIOSCO Expendeduría",
			"Calle de Mariano Royo Urieta, 14, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RODRIGO DÍAZ DE VIVAR -ED. OPALO- , 4, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6401602,-0.8889678);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAGASTA , 80, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6390142,-0.8863837);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 3",
			"Paseo de Sagasta, 80, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JUAN DE LA CRUZ , 7, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.6414833,-0.8931142);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de San Juan de la Cruz, 7, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SUPERVIA , 37, 50006  Zaragoza, Aragón, España
		point = toGeoPoint(41.637986,-0.8948716);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Don Mariano Supervía, 37, 50006 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //AGUAS , 6, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.632514,-0.8870789);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Juan Aguas, 6, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida AMERICA , 14, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6321285,-0.8852953);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 5",
			"Av de América, 14, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida AMERICA , 67, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6297153,-0.8859061);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 6",
			"Av de América, 67, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida AMERICA , 4, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6326144,-0.8852754);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 7",
			"Av de América, 4, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida AMERICA , 53, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6302986,-0.8857368);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 44",
			"Av de América, 53, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avda AMERICA , 34, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6308558,-0.885625);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de América, 34, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida AMERICA , 71, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6293943,-0.8860005);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de América, 71, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida AMERICA , 4, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6326144,-0.8852754);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Av de América, 4, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ARCIPRESTE DE HITA , 1, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.632572,-0.8760273);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle del Arcipreste de Hita, 1, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ATECA , 36, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6282555,-0.8883695);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Ateca, 36, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ATECA , 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6283875,-0.8888698);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Ateca, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CAPITAN OROQUIETA , 4, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6325536,-0.8791561);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Capitán Oroquieta, 4, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CEUTA , 2, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6328399,-0.8744771);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Ciudad de Ceuta, 2, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONSEJO DE CIENTO , 19, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6271244,-0.8738582);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Consejo de Ciento, 19, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CORUÑA , 80, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6273015,-0.8813831);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de La Coruña, 80, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CUARTA AVENIDA , 70, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6245762,-0.8765131);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Cuarta Avenida, 70, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CUARTE , 1, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6313376,-0.8873773);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Cuarte, 1, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo CUELLAR, de , 39, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.636945,-0.8844497);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de Cuéllar, 39, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo CUELLAR, de , 45, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.636215,-0.8844009);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de Cuéllar, 45, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DOCE DE OCTUBRE , 1, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6358769,-0.8787238);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Doce de Octubre, 1, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DOCE DE OCTUBRE , 5, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6359241,-0.8788488);
		itemOverlay = new OverlayItem(point, "SUPERBIEN",
			"Calle del Doce de Octubre, 5, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DOCE DE OCTUBRE , 10, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6355992,-0.8784944);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle del Doce de Octubre, 10, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Doce de octubre , 1, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6358769,-0.8787238);
		itemOverlay = new OverlayItem(point, "Tiendas de conveniencia",
			"Calle del Doce de Octubre, 1, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DR. MARTINEZ VARGAS , 2, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6292736,-0.8861947);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Doctor Martínez Vargas, 2, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ESCULTOR LOBATO , 41, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6339471,-0.8776292);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 30",
			"Calle del Escultor Lobato, 41, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FRAY JULIAN GARCES , 2, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6318758,-0.8856202);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Fray Julián Garcés, 2, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GARCIA LORCA , 1, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6354218,-0.879429);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Federico García Lorca, 1, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GARCIA SANCHEZ , 20, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6470905,-0.8990759);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de José García Sánchez, 20, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GARCIA SANCHEZ , 38, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6487065,-0.9002573);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de José García Sánchez, 38, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GIMENO VIZARRA , 34, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6283764,-0.8843452);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de los Hermanos Gimeno Vizarra, 34, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //J. PELLICER , 17, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6376665,-0.8787034);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Don José Pellicer, 17, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LASIERRA PURROY , 53, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6282756,-0.883952);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 23",
			"Calle de Lasierra Purroy, 53, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LASIERRA PURROY , 82, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6280379,-0.883894);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Lasierra Purroy, 82, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARGARITA XIRGU , 12, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6781697,-0.892449);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Margarita Xirgú, 12, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIA MOLINER , 12, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6392728,-0.8849562);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de María Moliner, 12, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONZON , 26, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6295562,-0.8824071);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Monzón, 26, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //OVIEDO , 177, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6256548,-0.877799);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 62",
			"Calle de Oviedo, 177, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino PUENTE VIRREY , 72, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6358836,-0.8749706);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Camino de Puente del Virrey, 72, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN EUGENIO , 24, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6254781,-0.8790302);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 45",
			"Calle de San Eugenio, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida SAN JOSE , 15, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6448633,-0.8724959);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Av de San José, 15, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle SANCHO RAMIREZ , 16, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6321783,-0.8832772);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Sancho Ramírez, 16, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SOLEIMAN , 2, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6235082,-0.875937);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de Soleimán, 2, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TENOR FLETA , 18, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6410802,-0.8842357);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 47",
			"Av del Tenor Fleta, 18, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TENOR FLETA , 67, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6387234,-0.8791626);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av del Tenor Fleta, 67, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TENOR FLETA , 122, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.636593,-0.8753251);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av del Tenor Fleta, 122, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TENOR FLETA -MERCADILLO- , 56, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino TORRES, de las , 106, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6408666,-0.8845092);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Camino de las Torres, 106, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino TORRES, de las , 109, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6399377,-0.8859228);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Camino de las Torres, 109, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ZAFIRO , 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6231137,-0.8759838);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Zafiro, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ZARAGOZA LA VIEJA , 4, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6345218,-0.8752803);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Zaragoza La Vieja, 4, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ZARAGOZA LA VIEJA , 25, 50007  Zaragoza, Aragón, España
		point = toGeoPoint(41.6337551,-0.8752927);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Zaragoza La Vieja, 25, 50007 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza ALBERT SCHWEITZER , 2, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6427743,-0.882481);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza Albert Schweitzer, 2, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BOLONIA , 8, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6430962,-0.8848765);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Bolonia, 8, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAREO ALIERTA , 19, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6443657,-0.8769405);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 47",
			"Av de Cesáreo Alierta, 19, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAREO ALIERTA , 113, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6379016,-0.8681072);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 67",
			"Av de Cesáreo Alierta, 113, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAREO ALIERTA , 17, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6443657,-0.8769405);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Cesáreo Alierta, 17, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAREO ALIERTA , 17, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6443657,-0.8769405);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Cesáreo Alierta, 17, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAREO ALIERTA , 15, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6446062,-0.8771253);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Cesáreo Alierta, 15, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COMANDANTE SANTA PAU , 17, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6418684,-0.8848412);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Comandante Santa Pau, 17, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Cmno DE LAS TORRES , 47, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6432533,-0.8805524);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Camino de las Torres, 47, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ESCULTOR FÉLIX BURRIEL , 1, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6423414,-0.8732846);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Escultor Félix Burriel, 1, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FLORIDA , 19, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6435719,-0.8757387);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Florida, 19, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FRANCISCO VITORIA , 26, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6452543,-0.8792941);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Francisco de Vitoria, 26, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GLORIETA SASERA , 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.641489,-0.8782392);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GONZALO DE BERCEO , 2, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6455893,-0.8742934);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Gonzalo de Berceo, 2, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ILLUECA , 1, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6401232,-0.8745949);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Illueca, 1, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo LAS DAMAS, de , 3, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6460174,-0.8850591);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 18",
			"Paseo de las Damas, 3, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo LAS DAMAS, de , 33, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6435614,-0.8827817);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Paseo de las Damas, 33, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LUIS AULA , 8, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6372372,-0.8721593);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Luis Aula, 8, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Andador LUIS PUNTES , 8, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6402095,-0.8808197);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Andador de Luis Puntes, 8, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIANA PINEDA , 18, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6651182,-0.8893188);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Mariana Pineda, 18, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MIGUEL SERVET , 50, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6465068,-0.8726309);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 24",
			"Calle de Miguel Servet, 50, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MIGUEL SERVET , 26, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6475498,-0.8744748);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Miguel Servet, 26, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza PARAISO, de Basilio , 2, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.641489,-0.8782392);
		itemOverlay = new OverlayItem(point, "IBERCAJA, OFICINA PRINCIPAL",
			"50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino PUENTE DEL VIRREY , 49, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6368415,-0.8745965);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Camino de Puente del Virrey, 49, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //REINA FABIOLA , 28, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6450448,-0.8752788);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de Reina Fabiola, 28, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo ROSALES , 26, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6398895,-0.8783608);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de los Rosales, 26, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JOSE , 115, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6388014,-0.8752741);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 16",
			"Av de San José, 115, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida SAN JOSE , 70, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6398092,-0.8741093);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de San José, 70, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN VICENTE MARTIR , 26, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6451584,-0.8802735);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de San Vicente Mártir, 26, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SERVET , 52, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6463922,-0.8726467);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Miguel Servet, 52, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TENOR FLETA , 95, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6376972,-0.877069);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 7",
			"Av del Tenor Fleta, 95, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TENOR FLETA , 57, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6389564,-0.879577);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av del Tenor Fleta, 57, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TENOR FLETA , 89, 50008  Zaragoza, Aragón, España
		point = toGeoPoint(41.6378234,-0.8774294);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av del Tenor Fleta, 89, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ASIN Y PALACIOS , 15, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6361415,-0.9055344);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 12",
			"Calle de Miguel Asín y Palacios, 15, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ASIN Y PALACIOS , 13, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6370838,-0.904652);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 37",
			"Calle de Miguel Asín y Palacios, 13, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ASIN Y PALACIOS , 15, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6361415,-0.9055344);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Miguel Asín y Palacios, 15, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ASIN Y PALACIOS , 15, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6361415,-0.9055344);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Miguel Asín y Palacios, 15, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ASIN Y PALACIOS , 11, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6376757,-0.9040915);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Miguel Asín y Palacios, 11, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CASTILLA , 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6428539,-0.9108568);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 41",
			"Calle de Castilla, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CENTRO , 13, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6317779,-0.9096271);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Centro, 13, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONDES DE ARAGON , 18, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6385768,-0.9062453);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de los Condes de Aragón, 18, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONDES DE ARAGÓN , 12, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6396514,-0.905436);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de los Condes de Aragón, 12, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DUQUESA VILLAHERMOSA , 143, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6442762,-0.9131921);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 82",
			"Calle de la Duquesa de Villahermosa, 143, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //EMBARCADERO , 4, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.629688,-0.9076842);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 53",
			"Calle del Embarcadero, 4, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FERNANDO EL CATOLICO , 52, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6393853,-0.8965711);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Paseo de Don Fernando El Católico, 52, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FERNANDO EL CATOLICO , 52, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6393853,-0.8965711);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Paseo de Don Fernando El Católico, 52, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FERNANDO EL CATOLICO , 38, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6404265,-0.8956974);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 50",
			"Paseo de Don Fernando El Católico, 38, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FERNANDO EL CATOLICO , 56, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6392155,-0.8967958);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de Don Fernando El Católico, 56, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FERNANDO EL CATÓLICO , 42, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6399581,-0.896192);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 2",
			"Paseo de Don Fernando El Católico, 42, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avda. HISPANIDAD , 15, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6312097,-0.9029254);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Ronda Hispanidad, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Vía HISPANIDAD , 6, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6332529,-0.9067969);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Vía Hispanidad, 6, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //HOSPITAL CLINICO "LOZANO BLESA" , 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6432048,-0.9033219);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Lozano Blesa, Av SAN JUAN BOSCO, 15, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JUAN CARLOS I , 6, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6443404,-0.9108426);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Av de Juan Carlos I, 6, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Juan Pablo II , 34, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6403566,-0.9103693);
		itemOverlay = new OverlayItem(point, "Tiendas de conveniencia",
			"Av de Juan Pablo II, 34, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LA VIA , 3, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6300926,-0.9080933);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 14",
			"Calle de la Vía, 3, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LA VIA , 17, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6309939,-0.9081332);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de la Vía, 17, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LA VIA , 4, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6299732,-0.9079833);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de la Vía, 4, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LA VIA , 7, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6304715,-0.9081339);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Vía, 7, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LUCAS GALLEGO , 58, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6461811,-0.9033104);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Pedro Lucas Gallego, 58, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LUIS BERMEJO -local- , 13, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.640049,-0.9032769);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIA GUERRERO , 39, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6438827,-0.9115138);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de María Guerrero, 39, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Campus PLAZA S. FRANCISCO Edif. Información , 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.640049,-0.9032769);
		itemOverlay = new OverlayItem(point, "UNIVERSIDAD DE ZARAGOZA",
			"50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RESIDENCIA MIGUEL SERVET , 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.640049,-0.9032769);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN FRANCISCO DE BORJA , 5, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.64002,-0.9018494);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de San Francisco de Borja, 5, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Vía UNIVERSITAS , 42, 50009  Zaragoza, Aragón, España
		point = toGeoPoint(41.6479944,-0.9083964);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Vía Universitas, 42, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANDRES VICENTE , 9, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6502926,-0.9143659);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Andrés Vicente, 9, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANTONIO MOMPEON MOTOS , 6, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6509319,-0.9123877);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Antonio Mompeón Motos, 6, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ARIAS , 20, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6538094,-0.9085139);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Arias, 20, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BIARRITZ , 10, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6563606,-0.9197893);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 46",
			"Calle de Biarritz, 10, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CALANDA , 21, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6523968,-0.9037669);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Paseo de Calanda, 21, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo CALANDA , 21, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6523968,-0.9037669);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 45",
			"Paseo de Calanda, 21, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo CALANDA , 39, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6509157,-0.9029465);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de Calanda, 39, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo CALANDA, de , 11, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6536905,-0.9043649);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de Calanda, 11, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo CALANDA, esquina Avda..MADRID , 11, 50010  (SOLO VENTA) Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CELSO EMILIO FERREIRO , 12, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6534565,-0.915462);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Poeta Celso Emilio Ferreiro, 12, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //COSO , 54, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.651811,-0.8796958);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Coso, 54, 50001 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DAROCA , 9, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6494439,-0.9051494);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Daroca, 9, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DELICIAS , 5, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6523582,-0.905728);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de las Delicias, 5, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DR. PEREZ SERRANO , 3, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6533893,-0.9011702);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Luis Pérez Serrano, 3, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DUQUESA VILLAHERMOSA , 2, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6493735,-0.899508);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 31",
			"Calle de la Duquesa de Villahermosa, 2, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ESCORIAZA Y FABRO , 107, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6543516,-0.8988436);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Escoriaza y Fabro, 107, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ESCULTOR PALAO , 15, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6488963,-0.9144369);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Escultor Palao, 15, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GARCILASO DE LA VEGA , 5, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6522555,-0.9129723);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Garcilaso de la Vega, 5, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GENERAL DON MANUEL LON-LAGA , 1, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.655145,-0.9011943);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del General Don Manuel Lon Laga, 1, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //HERMANOS PINZON , 5, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6496267,-0.9000359);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de los Hermanos Pinzón, 5, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //INGLATERRA , 1, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6524956,-0.9013169);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Inglaterra, 1, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ITALIA , 3, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.652332,-0.9006657);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 49",
			"Calle Italia, 3, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JORDANA , 5, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6526358,-0.905526);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Jorge Jordana, 5, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JUAN CARLOS I , 9, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6444865,-0.9110303);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Juan Carlos I, 9, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JUAN II DE ARAGON , 5, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6347597,-0.9042807);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Juan II de Aragón, 5, 50009 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JULIAN SANZ IBAÑEZ , 5, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6526729,-0.9112283);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Julián Sanz Ibáñez, 5, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MADRES PLAZA DE MAYO , 5, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6530016,-0.913952);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle Madres de la Plaza de Mayo, 5, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MADRID , 227, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6518388,-0.9112816);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 13",
			"Av de Madrid, 227, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MADRID , 169, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6529728,-0.9061403);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 4",
			"Av de Madrid, 169, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avda. MADRID , 175, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6527935,-0.9068802);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Av de Madrid, 175, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MADRID , 224, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6507337,-0.9181669);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Madrid, 224, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MADRID , 273, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6509005,-0.9152784);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Madrid, 273, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MADRID , 135, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6538861,-0.9026346);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Av de Madrid, 135, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MANUEL DE FALLA , 27, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6553213,-0.9192329);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Manuel de Falla, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle MARCOS ZAPATA , 11, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6536357,-0.9061028);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Marcos Zapata, 11, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida NAVARRA , 27, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6547647,-0.9033911);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 42",
			"Av de Navarra, 27, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //NAVARRA , 33, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6548167,-0.9043632);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 14",
			"Av de Navarra, 33, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida NAVARRA , 2, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6548145,-0.9008522);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Navarra, 2, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PARQUE ROMA F-5 , 50010  Zaragoza, Aragón, España
		point = toGeoPoint(20.5890457,-100.3898547);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Ignacio Zaragoza 5, Centro, Santiago de Querétaro, Qt, México");
		addOverlay(itemOverlay);
	
		 //PASAJE CIAL. PARQUE ROMA BL: F-8 , 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6537699,-0.9020843);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PEDRO DE LUNA , 91, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6488238,-0.9034603);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Don Pedro de Luna, 91, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PEDRO EL CATOLICO , 20, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.654168,-0.907748);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Pedro II El Católico, 20, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RAMIRO I , 14, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6534645,-0.916047);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Ramiro I de Aragón, 14, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RAMON J. SENDER , 3, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6563317,-0.9193104);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Ramón José Sender, 3, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR MINGUIJÓN , 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6479379,-0.8615425);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Salvador Minguijón, 50002 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN ANTONIO MARIA CLARET , 55, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6434004,-0.8963057);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de San Antonio María Claret, 55, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle SANGENIS , 33, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6512916,-0.9038637);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Antonio Sangenis, 33, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SANGENIS , 10, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6529579,-0.9046766);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Antonio Sangenis, 10, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SANTANDER , 1, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6489002,-0.8945301);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Santander, 1, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TARRAGONA , 32, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6485482,-0.8978239);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Tarragona, 32, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TARRAGONA , 32, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6485482,-0.8978239);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Tarragona, 32, 50005 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //UNCETA , 44, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6511385,-0.9014952);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Unceta, 44, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Vía UNIVERSITAS , 55, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6495168,-0.9094146);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Vía Universitas, 55, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VICENTE BERDUSAN , 46, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6497938,-0.8991005);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 19",
			"Calle de Vicente Berdusán, 46, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VICENTE BERDUSAN , 12, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6528537,-0.897838);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Vicente Berdusán, 12, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VICENTE BERDUSAN , 30, 50010  Zaragoza, Aragón, España
		point = toGeoPoint(41.6508356,-0.8986859);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Vicente Berdusán, 30, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ALEJANDRO OLIVAN , 16, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6487967,-0.9223093);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Alejandro Oliván, 16, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANTONIO LEYVA , 65, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6516021,-0.926163);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 20",
			"Calle de Antonio de Leyva, 65, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANTONIO LEYVA , 49, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6515201,-0.9252346);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 11",
			"Calle de Antonio de Leyva, 49, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANTONIO LEYVA , 83, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6515139,-0.9287191);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Antonio de Leyva, 83, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ESTACION INTERMODAL , 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.658661,-0.9112);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 95",
			"Estación de Zaragoza-Delicias, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //HUESA DEL COMUN , 2, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6515597,-0.9259179);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Huesa del Común, 2, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //J. VALDES , 2, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.651379,-0.9284674);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Valdés Guzmán, 2, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MADRE BARAT , 1, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6515866,-0.9206481);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Madre Barat, 1, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MOSEN JOSE BOSQUED , 5, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6489356,-0.9211396);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 16",
			"Calle del Mosén José Bosqued, 5, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida NAVARRA , 80, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6559384,-0.9094057);
		itemOverlay = new OverlayItem(point, "ESTACIÓN INTERMODAL DELICIAS",
			"Av de Navarra, 80, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino PILON, del , 120, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6587144,-0.9411556);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 8",
			"Camino del Pilón, 120, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino PILON, del , 131, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6587017,-0.9403599);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 89",
			"Camino del Pilón, 131, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //TORRES SAN LAMBERTO , 7, 50011  Zaragoza, Aragón, España
		point = toGeoPoint(41.6647403,-0.9274689);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Urbanización Torres de San Lamberto, 7, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza AMAZONAS , 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6463896,-0.9181277);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza del Amazonas, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BEETHOVEN , 42, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6335991,-0.9443766);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Beethoven, 42, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BEETHOVEN, 38. LOCAL 11 , 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida ILUSTRACIÓN , 14, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6272198,-0.9294978);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de la Ilustración, 14, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ILUSTRACION (LOCAL-19) , 14, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LA ILUSTRACIÓN , 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.629338,-0.9325008);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de la Ilustración, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Carretera MADRID KM.315 , 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6530184,-0.9063134);
		itemOverlay = new OverlayItem(point, "QUIOSCO C.C.Alcampo",
			"Av de Madrid, Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARTE , 54, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6386014,-0.9323772);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Marte, 54, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MAURICE RAVEL , 25, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.637387,-0.944502);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 99",
			"Calle de Maurice Ravel, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //OBISPO PERALTA , 11, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6392993,-0.9300018);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 60",
			"Calle de Obispo Peralta, 11, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RIGEL , 1, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6399291,-0.9305411);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 42",
			"Calle de Rigel, 1, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RIGLOS , 12, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6274533,-0.912089);
		itemOverlay = new OverlayItem(point, "PANADERIA Las Nieves",
			"Calle Riglos, 12, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida VALDEFIERRO , 47, 50012  Zaragoza, Aragón, España
		point = toGeoPoint(41.6404449,-0.929118);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Valdefierro, 47, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino CABALDOS , 76, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6393559,-0.8690253);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Camino de Cabaldos, 76, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino CABALDOS , 78, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6390831,-0.8690217);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Camino de Cabaldos, 78, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Camino CABALDOS , 88, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6373706,-0.8693691);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Camino de Cabaldos, 88, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CASTELAR , 50, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6394162,-0.8703002);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Emilio Castelar, 50, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Carretera CASTELLON , 44, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6220096,-0.8489843);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Carretera Castellón, 44, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAREO ALIERTA , 96, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6383892,-0.870133);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Cesáreo Alierta, 96, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CESAREO ALIERTA , 33, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6428178,-0.8755255);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Cesáreo Alierta, 33, 50008 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FLORENTINO BALLESTEROS , 19, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6435461,-0.8666397);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Florentino Ballesteros, 19, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JUANA DE IBARBOUROU , 6, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6424481,-0.8695319);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 21",
			"Calle de Juana Ibarbourou, 6, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JUANA DE IBARBURU , 20, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6417421,-0.8701492);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de Juana Ibarbourou, 20, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MIGUEL SERVET , 118, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6427056,-0.8688606);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 30",
			"Calle de Miguel Servet, 118, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MIGUEL SERVET , 67, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.642923,-0.8689137);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Miguel Servet, 67, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONASTERIO DE SAMOS , 40, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6451437,-0.871006);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Monasterio de Samos, 40, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza REINA SOFÍA , 3, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6429754,-0.8723123);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza de la Reina Sofía, 3, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida SAN JOSÉ , 77, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6411147,-0.8734245);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de San José, 77, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN LUIS DE FRANCIA , 13, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6412172,-0.8711829);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de San Luis de Francia, 13, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SANTUARIO CABAÑAS , 1, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6433269,-0.8718758);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 46",
			"Calle del Santuario de Cabañas, 1, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza UTRILLAS , 6, 50013  Zaragoza, Aragón, España
		point = toGeoPoint(41.6410795,-0.8673947);
		itemOverlay = new OverlayItem(point, "CENTRO COMERCIAL UTRILLAS PLAZA",
			"Plaza de Utrillas, 6, 50013 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //AGUARON , 22, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6586438,-0.8640499);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Aguarón, 22, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ALFONSO SOLANS , 3, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.656828,-0.8685594);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 91",
			"Calle de Alfonso Solans Serrano, 3, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BALBINO ORENSANZ , 1, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6581431,-0.8590542);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 81",
			"Calle de Balbino Orensanz, 1, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BALBINO ORENSANZ , 3, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6581431,-0.8590542);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Balbino Orensanz, 3, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //BLAS DE OTERO , 14, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6706516,-0.8839897);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Poeta Blas de Otero, 14, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CAMINIO DEL VADO , 4, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6574308,-0.868724);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Camino del Vado, 4, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida CATALUÑA , 289, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.670112,-0.8464699);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 80",
			"Av Cataluña, 289, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida CATALUÑA , 25, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6601303,-0.869735);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Av Cataluña, 25, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida CATALUÑA , 92, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6624462,-0.8640029);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 32",
			"Av Cataluña, 92, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida CATALUÑA , 132, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.663893,-0.8605856);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 55",
			"Av Cataluña, 132, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida CATALUÑA , 134, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6638908,-0.8604562);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av Cataluña, 134, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida CATALUÑA , 298, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6693846,-0.8476561);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av Cataluña, 298, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida CATALUÑA , 293, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6703054,-0.8455302);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Av Cataluña, 293, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Polígono COGULLADA - MERCAZARAGOZA , 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.7314623,-1.4628042);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FEDERICO OZANAN , 4, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6396821,-0.9308259);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Federico Ozanam, 4, 50012 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FELISA GALE , 2, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6635042,-0.8615319);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Felisa Gale, 2, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle FUENDEJALON , 4, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6590507,-0.865607);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Fuendejalón, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JESUS , 28, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6580095,-0.8709118);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Jesús, 28, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JOSE OTO , 44, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6609113,-0.8658698);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de José Oto, 44, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JOSE OTO , 26, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6621066,-0.8631057);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de José Oto, 26, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JOSE OTO , 63, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.660624,-0.8662682);
		itemOverlay = new OverlayItem(point, "Tiendas de conveniencia",
			"Calle de José Oto, 63, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LA JOTA , 50, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6616456,-0.8574299);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de la Jota, 50, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARQUES DE LA CADENA , 40, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6607558,-0.8637212);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 54",
			"Calle del Marqués de la Cadena, 40, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARQUES DE LA CADENA , 44, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6611228,-0.8640849);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle del Marqués de la Cadena, 44, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MATIAS MALUENDA , 1, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6561254,-0.8569285);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Matías Maluenda, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //NOBLEZA BATURRA , 17, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6538274,-0.8576146);
		itemOverlay = new OverlayItem(point, "QUIOSKO SUPERBIEN",
			"Calle Nobleza Baturra, 17, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //NOBLEZA BATURRA , 17, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6538274,-0.8576146);
		itemOverlay = new OverlayItem(point, "SUPERBIEN",
			"Calle Nobleza Baturra, 17, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO GARGALLO , 23, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6593007,-0.8962719);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Pablo Gargallo, 23, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PASCUALA PERIE , 1, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6622765,-0.8633384);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Pascuala Perie, 1, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PASCUALA PERIE , 10, 50014  Zaragoza, Aragón, España
		point = toGeoPoint(41.6616836,-0.8630351);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de Pascuala Perie, 10, 50014 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida ACADEMIA GENERAL MILITAR, 17. LOCAL 2 , 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6852028,-0.8651303);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CINEASTA CARLOS SAURA , 16, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.675219,-0.8872581);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Cineasta Carlos Saura, 16, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONCEPCION SAINZ DE OTERO , 8, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6702165,-0.8917252);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Concepción Sáiz de Otero, 8, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //EL GLOBO , 1, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6836668,-0.8711608);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 89",
			"Calle del Globo, 1, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //EL GLOBO , 8, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6837277,-0.8724619);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Globo, 8, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GARCIA ARISTA , 14, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.65926,-0.8768036);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de García Arista, 14, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GRAN CANARIA , 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6692548,-0.8775437);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Isla de Gran Canaria, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Ctra  HUESCA, KM 7,200 , 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.7016241,-0.8665015);
		itemOverlay = new OverlayItem(point, "QUIOSCO BRIGADA CABALLERIA U",
			"Carretera de Huesca, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ILDEFONSO MANUEL GIL , 28, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6715492,-0.8846656);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Ildefonso Manuel Gil, 28, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo INDEPENDENCIA, de la , 24, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6504171,-0.8826701);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Paseo de la Independencia, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JORGE GUILLÉN , 14, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6682052,-0.885198);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Jorge Guillén, 14, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LA ALMUNIA DE DOÑA GODINA , 13, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6612808,-0.8989162);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Almunia de Doña Godina, 13, 50003 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MAJAS DE GOYA , 17, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6866619,-0.8751655);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de las Majas de Goya, 17, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIA DE ECHARRI , 2, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6686205,-0.8920274);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de María de Echarri, 2, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIA ZAMBRANO , 10, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6649254,-0.8844626);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Poetisa María Zambrano, 10, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIANA PINEDA , 18, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6651182,-0.8893188);
		itemOverlay = new OverlayItem(point, "QUIOSCO Estanco",
			"Calle de Mariana Pineda, 18, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MONTEPERDIDO , 22, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6722347,-0.8726912);
		itemOverlay = new OverlayItem(point, "SUPERBIEN",
			"Calle de Monte Perdido, 22, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MOSEN DOMINGO AGUDO , 21, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6608591,-0.8780169);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Mosén Domingo Agudo, 21, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO IGLESIAS , 25, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6773987,-0.8856119);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Pablo Iglesias, 25, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PANO Y RUATA , 15, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6610937,-0.8744413);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de Mariano Pano y Ruata, 15, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PANTANO DE BUBAL , 4, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6684831,-0.8756732);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Pantano de Bubal, 4, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //POETA LEON FELIPE , 31, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6852028,-0.8651303);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAINZ DE OTERO , 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6697007,-0.8926579);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle Concepción Sáiz de Otero, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR ALLENDE , 14, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6692507,-0.8766358);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 72",
			"Av Salvador Allende, 14, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR ALLENDE , 75, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6758255,-0.8766739);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 79",
			"Av Salvador Allende, 75, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR ALLENDE , 20, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6694305,-0.876649);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Av Salvador Allende, 20, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR ALLENDE , 20, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6694305,-0.876649);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Av Salvador Allende, 20, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR ALLENDE , 17, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6689534,-0.8769161);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Av Salvador Allende, 17, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR ALLENDE , 57, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6745639,-0.8771896);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av Salvador Allende, 57, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR ALLENDE , 41, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6714608,-0.8770338);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av Salvador Allende, 41, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SALVADOR ALLENDE , 98, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6734389,-0.877448);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av Salvador Allende, 98, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza SAN GREGORIO , 3, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6607327,-0.8765613);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza de San Gregorio, 3, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JUAN DE LA PEÑA , 190, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6766205,-0.8710709);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 39",
			"Av San Juan de la Peña, 190, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JUAN DE LA PEÑA , 194, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6771258,-0.8710441);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av San Juan de la Peña, 194, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN JUAN DE LA PEÑA , 129, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6710708,-0.8715208);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av San Juan de la Peña, 129, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SOBRARBE , 36, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6605131,-0.8734891);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 23",
			"Calle de Sobrarbe, 36, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SOBRARBE , 55, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6604382,-0.8738396);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Sobrarbe, 55, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VALLE DE ARAN , 1, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6719152,-0.8716746);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 36",
			"Calle del Valle de Arán, 1, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VALLE DE GISTAIN , 2, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6638625,-0.8728117);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Valle de Gistaín, 2, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VALLE DE ZURIZA , 19, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6614914,-0.8728628);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 75",
			"Calle del Valle de Zuriza, 19, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VALLE DE ZURIZA , 20, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.661433,-0.8733216);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Valle de Zuriza, 20, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VILLACAMPA , 50, 50015  Zaragoza, Aragón, España
		point = toGeoPoint(41.6607294,-0.8760397);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 51",
			"Calle de Pedro Villacampa, 50, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //J.I.SERRANO OSTARIZ , 78, 50016  Zaragoza, Aragón, España
		point = toGeoPoint(41.6687309,-0.8250745);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Serrano Ostariz, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida SANTA ISABEL , 137, 50016  Zaragoza, Aragón, España
		point = toGeoPoint(41.6669486,-0.8294658);
		itemOverlay = new OverlayItem(point, "CAJALON, URBANA 11",
			"Av de Santa Isabel, 137, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida SANTA ISABEL , 76, 50016  Zaragoza, Aragón, España
		point = toGeoPoint(41.6670167,-0.8323858);
		itemOverlay = new OverlayItem(point, "IBERCAJA, OF. PPAL. SANTA ISABEL",
			"Av de Santa Isabel, 76, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza SERRANO BERGES , 50016  Zaragoza, Aragón, España
		point = toGeoPoint(41.6673263,-0.8309359);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 29",
			"Plaza de Serrano Berges, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ANDRES VICENTE , 25, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6488035,-0.9137734);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de Andrés Vicente, 25, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CAÑIZAR DEL OLIVAR , 1, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6461583,-0.9140119);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Cañizar del Olivar, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CENTRO COMERC. CARREFOUR "S.G.E.L." , 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.1656609,-1.4966619);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle DAROCA , 55, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6495953,-0.9075792);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Daroca, 55, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DAROCA , 69, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.64966,-0.9082609);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Daroca, 69, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //DELICIAS , 93, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.648671,-0.9040523);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 16",
			"Calle de las Delicias, 93, 50010 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FRAY JUAN REGLA , 37, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6500572,-0.9155868);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Fray Juan Regla, 37, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle FUENTES DE EBRO , 1, 50017  (SOLO VENTA) Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //FUENTES DE EBRO , 1, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6476082,-0.9050867);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Fuentes de Ebro, 1, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GALAN BERGUA , 24, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6478034,-0.9155537);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Demetrio Galán Bergua, 24, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Vía HISPANIDAD , 110, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6567233,-0.9210494);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Vía Hispanidad, 110, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MADRID , 283, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6507662,-0.9160745);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 86",
			"Av de Madrid, 283, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MADRID , 204, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6509385,-0.9157918);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 18",
			"Av de Madrid, 204, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avda. MADRID , 251, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6513966,-0.9133577);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Av de Madrid, 251, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MOMPEON MOTOS , 8, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6506938,-0.9122895);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Antonio Mompeón Motos, 8, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MOMPEON MOTOS , 6, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6509319,-0.9123877);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de Antonio Mompeón Motos, 6, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MOSEN ANDRES VICENTE , 30, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.1656609,-1.4966619);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 28",
			"50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //POETA MIGUEL LABORDETA , 45, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6549471,-0.9180074);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 54",
			"Calle del Poeta Miguel Labordeta, 45, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //RIOJA , 6, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.652759,-0.9103386);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Rioja, 6, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Vía UNIVERSITAS , 58, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.6502468,-0.9092922);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Vía Universitas, 58, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Vía UNIVERSITAS , 64, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.650867,-0.9096148);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Vía Universitas, 64, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Vía UNIVERSITAS , 81, 50017  Zaragoza, Aragón, España
		point = toGeoPoint(41.651687,-0.9104017);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Vía Universitas, 81, 50017 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ADOLFO AZNAR , 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6759893,-0.8852739);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle Cineasta Adolfo Aznar, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ADOLFO AZNAR , 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6759893,-0.8852739);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle Cineasta Adolfo Aznar, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //ALEJANDRO CASONA , 9, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6771568,-0.8917352);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Alejandro Casona, 9, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle ALEJANDRO CASONA LOCAL 7B , 9, 50018  (SOLO VENTA) Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //AVERROES , 16, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6715396,-0.8861802);
		itemOverlay = new OverlayItem(point, "MULTICAJA, URBANA 42",
			"Calle de Averroes, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CARLOS SAURA , 3, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6753976,-0.8885477);
		itemOverlay = new OverlayItem(point, "QUIOSCO Estanco",
			"Calle Cineasta Carlos Saura, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CENTRO COMERC. GRANCASA , 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6690395,-0.8900373);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 70",
			"Centro Comercial Grancasa, Calle de Gertrudis Gómez de Avellaneda, 35, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CENTRO COMERC. GRANCASA , 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6690395,-0.8900373);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 70 (2)",
			"Centro Comercial Grancasa, Calle de Gertrudis Gómez de Avellaneda, 35, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //EMILIA PARDO BAZAN , 21, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6704793,-0.8939778);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Emilia Pardo Bazán, 21, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //EUGENIO LUCAS , 1, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6881773,-0.8751031);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Eugenio Lucas, 1, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GERTRUDIS GOMEZ DE AVELLANEDA , 77, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6704374,-0.8907553);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 80",
			"Calle de Gertrudis Gómez de Avellaneda, 77, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GOMEZ DE AVELLANEDA , 83, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6704374,-0.8907553);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 68",
			"Calle de Gertrudis Gómez de Avellaneda, 83, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //HOSPITAL ROYO VILLANOVA , 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.692467,-0.8611487);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Royo Villanova, Av SAN GREGORIO, 30, 50015 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JORGE GUILLEN , 15, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6682166,-0.8869843);
		itemOverlay = new OverlayItem(point, "SUPERMERCADO EROSKI",
			"Calle de Jorge Guillén, 15, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle JORGE MANRIQUE , 4, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6689592,-0.8863604);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Poeta Jorge Manrique, 4, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JOSE LUIS BORAU , 5, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6753517,-0.8844409);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Cineasta José Luis Borau, 5, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //JULIO GARCIA CONDOY , 20, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6746357,-0.8866827);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Julio García Condoy, 20, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza LAGOS AZULES , 7, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6602309,-0.9331971);
		itemOverlay = new OverlayItem(point, "QUIOSCO  Cinebank",
			"Plaza Lagos Azules, 7, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MAJAS DE GOYA , 13, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6866619,-0.8751655);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 96",
			"Av de las Majas de Goya, 13, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MAJAS DE GOYA , 25, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6866619,-0.8751655);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 90",
			"Av de las Majas de Goya, 25, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARGARITA XIRGU , 14, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6781697,-0.892449);
		itemOverlay = new OverlayItem(point, "SUPERBIEN",
			"Calle de Margarita Xirgú, 14, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIA ZAMBRANO , 2, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6643376,-0.8838921);
		itemOverlay = new OverlayItem(point, "CAI, URBANA 34",
			"Calle de la Poetisa María Zambrano, 2, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIA ZAMBRANO , 42, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6720983,-0.8893894);
		itemOverlay = new OverlayItem(point, "Martín Martín",
			"Calle de la Poetisa María Zambrano, 42, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARÍA ZAMBRANO , 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6692564,-0.8899488);
		itemOverlay = new OverlayItem(point, "DECATHLON EN C.COMERCIAL GRANCASA",
			"C/ MARÍA ZAMBRANO, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIA ZAYAS , 9, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.66695,-0.8917589);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de María Zayas y Sotomayor, 9, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MARIA ZAYAS , 9, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.66695,-0.8917589);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de María Zayas y Sotomayor, 9, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO NERUDA , 20, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6701237,-0.8847577);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Pablo Neruda, 20, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //POETA VICENTE ALEIXANDRE , 15, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.8163055,-0.9629523);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //POETISA MARIA ZAMBRANO , 58, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.6737639,-0.8893583);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA 64",
			"Calle de la Poetisa María Zambrano, 58, 50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Campus RÍO EBRO  Edif. Bethencourt , 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.8163055,-0.9629523);
		itemOverlay = new OverlayItem(point, "UNIVERSIDAD DE ZARAGOZA",
			"50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Campus RÍO EBRO Edif. Torres Quevedo , 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.8163055,-0.9629523);
		itemOverlay = new OverlayItem(point, "UNIVERSIDAD DE ZARAGOZA",
			"50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VICTORIA OCAMPO -ROSAS- , 11, 50018  Zaragoza, Aragón, España
		point = toGeoPoint(41.8163055,-0.9629523);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50018 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle LA VENTANA INDISCRETA (LOCAL 2) , 6, 50019  Zaragoza, Aragón, España
		point = toGeoPoint(41.6199478,-0.9223636);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50019 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CONCORDIA (SANTA ISABEL) , 16, 50058  Zaragoza, Aragón, España
		point = toGeoPoint(41.6658893,-0.8226907);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Concordia, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GASPAR TORRENTE (SANTA ISABEL) , 62, 50058  Zaragoza, Aragón, España
		point = toGeoPoint(41.6678504,-0.825462);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Gaspar Torrente, 62, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo INDEPENDENCIA, de la (SANTA ISABEL) , 33, 50058  Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida SANTA ISABEL (SANTA ISABEL) , 66, 50058  Zaragoza, Aragón, España
		point = toGeoPoint(41.6671118,-0.833321);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Santa Isabel, 66, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SANTA NUNILA (SANTA ISABEL) , 9, 50058  Zaragoza, Aragón, España
		point = toGeoPoint(41.6705817,-0.8276063);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Santa Nunila, 9, 50016 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MONTAÑANA (MONTAÑANA) , 254, 50059  Zaragoza, Aragón, España
		point = toGeoPoint(41.684651,-0.8288066);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de la Montañana, 254, 50059 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo MARIA AGUSTIN, de , 36, 50071  Zaragoza, Aragón, España
		point = toGeoPoint(41.6528026,-0.891992);
		itemOverlay = new OverlayItem(point, "D.G.A. EDIFICIO PIGNATELLI",
			"Paseo de María Agustín, 36, 50004 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Vía VIA HISPANIDAD , 20, 50071  Zaragoza, Aragón, España
		point = toGeoPoint(41.7677673,-0.8262746);
		itemOverlay = new OverlayItem(point, "AYUNTAMIENTO (EDIF. SEMINARIO)",
			"Calle de la Ronda de la Hispanidad, 20, 50830 Villanueva de Gállego, España");
		addOverlay(itemOverlay);
	
		 //LA SAGRADO/PERFUMERIA (MONZALBARBA) , 20, 50120  Zaragoza, Aragón, España
		point = toGeoPoint(41.7043343,-0.9653412);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50120 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN MIGUEL (MONZALBARBA) , 2, 50120  Zaragoza, Aragón, España
		point = toGeoPoint(41.7009795,-0.9700959);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de San Miguel, 2, 50120 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //MAYOR (MEDIANA DE ARAGON) , 18, 50135  Zaragoza, Aragón, España
		point = toGeoPoint(41.4953897,-0.6537675);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Mayor, 18, 50741 Fuentes de Ebro, España");
		addOverlay(itemOverlay);
	
		 //LA IGLESIA (LECIÑENA) , 4, 50160  Zaragoza, Aragón, España
		point = toGeoPoint(41.7988405,-0.6108729);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Iglesia, 50160 Leciñena, España");
		addOverlay(itemOverlay);
	
		 //IGLESIA BAJA (VILLAMAYOR DE GALLEGO) , 50162  Zaragoza, Aragón, España
		point = toGeoPoint(41.6853284,-0.7734904);
		itemOverlay = new OverlayItem(point, "QUIOSCO Pastelería",
			"Calle de la Iglesia Baja, 50162 Villamayor, España");
		addOverlay(itemOverlay);
	
		 //ERAS ALTAS, S/N. GRÁFICAS (LA PUEBLA DE ALFINDÉN) , 9, 50171  Zaragoza, Aragón, España
		point = toGeoPoint(41.6336763,-0.7485282);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50171 La Puebla de Alfindén, España");
		addOverlay(itemOverlay);
	
		 //ESPAÑA (ALFAJARÍN) , 7, 50171  Zaragoza, Aragón, España
		point = toGeoPoint(41.5917856,-0.6832896);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza de España, 7, 50173 Nuez de Ebro, España");
		addOverlay(itemOverlay);
	
		 //VIRGEN DE LA PEÑA (ALFAJARIN) , 1, 50172  Zaragoza, Aragón, España
		point = toGeoPoint(41.6156495,-0.7022804);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Nuestra Señora de la Peña, 50172 Alfajarín, España");
		addOverlay(itemOverlay);
	
		 //MAYOR (VILLAFRANCA DE EBRO) , 27, 50174  Zaragoza, Aragón, España
		point = toGeoPoint(41.569807,-0.5730713);
		itemOverlay = new OverlayItem(point, "QUIOSCO - ESTANCO",
			"50174 Villafranca de Ebro, España");
		addOverlay(itemOverlay);
	
		 //CANDANCHU (UTEBO) , 4, 50180  Zaragoza, Aragón, España
		point = toGeoPoint(41.7161735,-1.0247129);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Candanchú, 4, 50180 Utebo, España");
		addOverlay(itemOverlay);
	
		 //CENTRO COMERCIAL ALCAMPO (UTEBO) , 50180  Zaragoza, Aragón, España
		point = toGeoPoint(41.7150315,-0.9947444);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50180 Utebo, España");
		addOverlay(itemOverlay);
	
		 //Plaza CONSTITUCION (UTEBO) , 4, 50180  Zaragoza, Aragón, España
		point = toGeoPoint(41.7204194,-1.0252887);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Av de la Constitución, 4, 50620 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Plaza CONSTITUCION (UTEBO) , 4, 50180  Zaragoza, Aragón, España
		point = toGeoPoint(41.7204194,-1.0252887);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de la Constitución, 4, 50620 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PABLO RUIZ PICASSO (UTEBO) , 16, 50180  Zaragoza, Aragón, España
		point = toGeoPoint(41.7043842,-0.9959304);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Pablo Ruiz Picasso, 50180 Utebo, España");
		addOverlay(itemOverlay);
	
		 //Avenida ZARAGOZA (UTEBO) , 24, 50180  Zaragoza, Aragón, España
		point = toGeoPoint(41.707081,-0.9985522);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Zaragoza, 24, 50180 Utebo, España");
		addOverlay(itemOverlay);
	
		 //Avenida ZARAGOZA (UTEBO) , 32, 50180  Zaragoza, Aragón, España
		point = toGeoPoint(41.7073661,-0.9985848);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Zaragoza, 32, 50180 Utebo, España");
		addOverlay(itemOverlay);
	
		 //MAYOR (GARRAPINILLOS) , 13, 50190  Zaragoza, Aragón, España
		point = toGeoPoint(41.6831916,-1.0262321);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Mayor, 13, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Calle MAYOR (GARRAPINILLOS) , 13, 50190  Zaragoza, Aragón, España
		point = toGeoPoint(41.6831916,-1.0262321);
		itemOverlay = new OverlayItem(point, "QUIOSCO (Fotoesfera)",
			"Calle Mayor, 13, 50011 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //PAS DE QUINT, AEROPUERTO DE ZARAGOZA , 50190  Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida MOVERA , 378, 50194  Zaragoza, Aragón, España
		point = toGeoPoint(41.6524521,-0.8294548);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Movera, 50194 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Avenida PALAFOX,  (PASTRIZ) , 19, 50195  Zaragoza, Aragón, España
		point = toGeoPoint(41.6176187,-0.7809548);
		itemOverlay = new OverlayItem(point, "QUIOSCO Bazar",
			"Av de Palafox, 50195 Pastriz, España");
		addOverlay(itemOverlay);
	
		 //Avenida SANTA ANA, (PASTRIZ) , 2, 50195  Zaragoza, Aragón, España
		point = toGeoPoint(41.620766,-0.781354);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Santa Ana, 50195 Pastriz, España");
		addOverlay(itemOverlay);
	
		 //Autovía A-2, KM.299-EST.SERVICIO SHELL , 299, 50196  (SOLO VENTA) Zaragoza, Aragón, España
		point = toGeoPoint(41.6562873,-0.8765379);
		itemOverlay = new OverlayItem(point, "GASOLINERA",
			"Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //LA JUSTICIA DE ARAGÓN (LA MUELA) , 4, 50196  Zaragoza, Aragón, España
		point = toGeoPoint(41.5815824,-1.1135564);
		itemOverlay = new OverlayItem(point, "QUIOSCO  EL ARBOL",
			"Av de la Justicia de Aragón, 50196 La Muela, España");
		addOverlay(itemOverlay);
	
		 //Calle MAYOR (LA MUELA) , 2, 50196  Zaragoza, Aragón, España
		point = toGeoPoint(41.5781149,-1.1209864);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Mayor, 50196 La Muela, España");
		addOverlay(itemOverlay);
	
		 //MAYOR (LA MUELA) , 7, 50196  Zaragoza, Aragón, España
		point = toGeoPoint(41.5758184,-1.1161166);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50196 La Muela, España");
		addOverlay(itemOverlay);
	
		 //CONSUELO (PINSEQUE) , 1, 50298  Zaragoza, Aragón, España
		point = toGeoPoint(41.7367741,-1.1010045);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Consuelo, 50298 Pinseque, España");
		addOverlay(itemOverlay);
	
		 //PORTALADA, (PINSEQUE) , 10, 50298  Zaragoza, Aragón, España
		point = toGeoPoint(41.7369935,-1.1026995);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Portalada, 50298 Pinseque, España");
		addOverlay(itemOverlay);
	
		 //ROGER DE TUR (CALATAYUD) , 13, 50300  Zaragoza, Aragón, España
		point = toGeoPoint(41.3698274,-1.6178011);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50300 Calatayud, España");
		addOverlay(itemOverlay);
	
		 //MARIANO BARBASÁN (CADRETE) , 8, 50410  Zaragoza, Aragón, España
		point = toGeoPoint(41.592447,-0.9295234);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50410 Cuarte de Huerva, España");
		addOverlay(itemOverlay);
	
		 //RAMON Y CAJAL (CUARTE DE HUERVA) , 26, 50410  Zaragoza, Aragón, España
		point = toGeoPoint(41.5903911,-0.9289619);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Ramón y Cajal, 50410 Cuarte de Huerva, España");
		addOverlay(itemOverlay);
	
		 //Plaza ARAGON, de (CADRETE) , 4, 50420  Zaragoza, Aragón, España
		point = toGeoPoint(41.5552683,-0.9600153);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza de Aragón, 50420 Cadrete, España");
		addOverlay(itemOverlay);
	
		 //CONSTITUCION, (CADRETE) , 4, 50420  Zaragoza, Aragón, España
		point = toGeoPoint(41.5551738,-0.9592718);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Constitución, 50420 Cadrete, España");
		addOverlay(itemOverlay);
	
		 //Carretera VALENCIA KM. 380 (MARIA DE HUERVA) , 50430  Zaragoza, Aragón, España
		point = toGeoPoint(41.5397327,-0.9967589);
		itemOverlay = new OverlayItem(point, "QUIOSCO Estación Servicio",
			"Carretera de Valencia, 50430 María de Huerva, España");
		addOverlay(itemOverlay);
	
		 //Calle VALENZUELA SOLER (MARÍA DE HUERVA) , 3, 50430  Zaragoza, Aragón, España
		point = toGeoPoint(41.537968,-0.9960222);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Valenzuela Soler, 50430 María de Huerva, España");
		addOverlay(itemOverlay);
	
		 //Calle MAYOR (BOTORRITA) , 5, 50441  Zaragoza, Aragón, España
		point = toGeoPoint(41.507792,-1.0310711);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Mayor, 50441 Botorrita, España");
		addOverlay(itemOverlay);
	
		 //ESPAÑA (MUEL) , 3, 50450  Zaragoza, Aragón, España
		point = toGeoPoint(41.4613122,-1.074339);
		itemOverlay = new OverlayItem(point, "ESTANCO",
			"Calle 3, 50450 Muel, España");
		addOverlay(itemOverlay);
	
		 //Calle GARCIA JIMENEZ (MUEL) , 34, 50450  Zaragoza, Aragón, España
		point = toGeoPoint(41.4715918,-1.0823155);
		itemOverlay = new OverlayItem(point, "PANADERIA",
			"Av de García Giménez, 50450 Muel, España");
		addOverlay(itemOverlay);
	
		 //Calle LA ALAMEDA, B-0 local-3 (CASETAS) , 50620  Zaragoza, Aragón, España
		point = toGeoPoint(41.7186947,-1.0322845);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50620 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Autovía LOGROÑO (CASETAS) , 57, 50620  Zaragoza, Aragón, España
		point = toGeoPoint(41.7226646,-1.0362961);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Autovía de Logroño, 50620 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Autovía LOGROÑO (CASETAS) , 57, 50620  Zaragoza, Aragón, España
		point = toGeoPoint(41.7226646,-1.0362961);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Autovía de Logroño, 50620 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //VIRGEN DE LA ROSA S/N (CASETAS) , 50620  Zaragoza, Aragón, España
		point = toGeoPoint(41.717375,-1.0278329);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de la Virgen de la Rosa, 50620 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //SAN ANTONIO (SOBRADIEL) , 15, 50629  Zaragoza, Aragón, España
		point = toGeoPoint(41.7389107,-1.0385742);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de San Antonio, 50629 Sobradiel, España");
		addOverlay(itemOverlay);
	
		 //Calle ARCOS DEL MARQUES (ALAGON) , 1, 50630  Zaragoza, Aragón, España
		point = toGeoPoint(41.7651038,-1.1257082);
		itemOverlay = new OverlayItem(point, "QUIOSCO Librería",
			"50630 Alagón, España");
		addOverlay(itemOverlay);
	
		 //Calle MAYOR (ALAGON) , 12, 50630  Zaragoza, Aragón, España
		point = toGeoPoint(41.7699393,-1.120316);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Mayor, 12, 50630 Alagón, España");
		addOverlay(itemOverlay);
	
		 //Avenida ZARAGOZA (ALAGÓN) , 22, 50630  Zaragoza, Aragón, España
		point = toGeoPoint(41.7677904,-1.1175246);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Av de Zaragoza, 22, 50630 Alagón, España");
		addOverlay(itemOverlay);
	
		 //Calle MAYOR (FIGUERUELAS) , 50639  Zaragoza, Aragón, España
		point = toGeoPoint(41.7668378,-1.1741576);
		itemOverlay = new OverlayItem(point, "QUIOSCO (Estanco)",
			"Calle Mayor, 50639 Figueruelas, España");
		addOverlay(itemOverlay);
	
		 //Plaza AYUNTAMIENTO, del (LUCENI) , 50640  Zaragoza, Aragón, España
		point = toGeoPoint(41.828867,-1.238925);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza del Ayuntamiento, 50640 Luceni, España");
		addOverlay(itemOverlay);
	
		 //Calle ZARAGOZA (PEDROLA) , 25, 50690  Zaragoza, Aragón, España
		point = toGeoPoint(41.7869829,-1.2166856);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Calle de Zaragoza, 50690 Pedrola, España");
		addOverlay(itemOverlay);
	
		 //Plaza BONET (TORRES DE BERRELLEN) , 13, 50693  Zaragoza, Aragón, España
		point = toGeoPoint(41.7585307,-1.0648122);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza Juan Pablo Bonet, 50693 Torres de Berrellén, España");
		addOverlay(itemOverlay);
	
		 //Calle TENOR FLETA, (TORRES DE BERRELLEN) , 25, 50693  Zaragoza, Aragón, España
		point = toGeoPoint(41.7578739,-1.0675264);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle Tenor Fleta, 50693 Torres de Berrellén, España");
		addOverlay(itemOverlay);
	
		 //JUAN DE LAS VIÑAS (CARTUJA BAJA) , 3, 50720  Zaragoza, Aragón, España
		point = toGeoPoint(41.6066442,-0.8238677);
		itemOverlay = new OverlayItem(point, "SUPERBIEN",
			"Calle de Juan de las Viñas, 50720 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //Paseo LOS PLATANOS (LA CARTUJA) , 50720  Zaragoza, Aragón, España
		point = toGeoPoint(41.6045195,-0.82356);
		itemOverlay = new OverlayItem(point, "IBERCAJA, URBANA L.C.",
			"Paseo de los Plátanos, 50720 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //CORTES DE ARAGON (EL BURGO DE EBRO) , 32, 50730  Zaragoza, Aragón, España
		point = toGeoPoint(41.5705252,-0.7424857);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Cortés de Aragón, 50730 El Burgo de Ebro, España");
		addOverlay(itemOverlay);
	
		 //RAMON J. SENDER (BURGO DE EBRO, EL) , 9, 50730  Zaragoza, Aragón, España
		point = toGeoPoint(41.5726844,-0.7413571);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Ramón José Sender, 50730 El Burgo de Ebro, España");
		addOverlay(itemOverlay);
	
		 //FERNANDO DE BORBÓN (FUENTES DE EBRO) , 18, 50740  Zaragoza, Aragón, España
		point = toGeoPoint(41.5095643,-0.6334924);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Fernando Borbón, 50740 Fuentes de Ebro, España");
		addOverlay(itemOverlay);
	
		 //FERNANDO EL CATÓLICO (FUENTES DE EBRO) , 6, 50740  Zaragoza, Aragón, España
		point = toGeoPoint(41.5122886,-0.6308973);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Fernando 'El Católico', 6, 50740 Fuentes de Ebro, España");
		addOverlay(itemOverlay);
	
		 //Paseo JUSTICIA, del  (FUENTES DE EBRO) , 3, 50740  Zaragoza, Aragón, España
		point = toGeoPoint(41.5139969,-0.6354685);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Paseo de la Justicia, 3, 50740 Fuentes de Ebro, España");
		addOverlay(itemOverlay);
	
		 //Calle DEL SOL, (PINA DE EBRO) , 30, 50750  Zaragoza, Aragón, España
		point = toGeoPoint(41.4892275,-0.5295995);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Sol, 50750 Pina de Ebro, España");
		addOverlay(itemOverlay);
	
		 //MAYOR (QUINTO DE EBRO) , 23, 50770  Zaragoza, Aragón, España
		point = toGeoPoint(41.4199427,-0.5446912);
		itemOverlay = new OverlayItem(point, "QUIOSCO Estanco",
			"50770 Quinto, España");
		addOverlay(itemOverlay);
	
		 //Avenida ZARAGOZA (ZUERA) , 27, 50800  Zaragoza, Aragón, España
		point = toGeoPoint(41.8654698,-0.7912878);
		itemOverlay = new OverlayItem(point, "EL ARBOL",
			"Av de Zaragoza, 27, 50800 Zuera, España");
		addOverlay(itemOverlay);
	
		 //ZUFARIA (ZUERA) , 4, 50800  Zaragoza, Aragón, España
		point = toGeoPoint(41.8686013,-0.7879527);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Zufaria, 4, 50800 Zuera, España");
		addOverlay(itemOverlay);
	
		 //Plaza ESPAÑA, de, S/N (SAN JUAN DE MOZARRIFAR) , 50820  Zaragoza, Aragón, España
		point = toGeoPoint(41.7175793,-0.8411086);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Plaza de España, 50820 Zaragoza, España");
		addOverlay(itemOverlay);
	
		 //GOMEZ ACEBO - P.ANA (VILLANUEVA DE GÁLLEGO) , 25, 50830  Zaragoza, Aragón, España
		point = toGeoPoint(41.7873032,-0.8579818);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"50830 Villanueva de Gállego, España");
		addOverlay(itemOverlay);
	
		 //GOMEZ ACEBO (VILLANUEVA DE GALLEGO) , 82, 50830  Zaragoza, Aragón, España
		point = toGeoPoint(41.7684527,-0.8240568);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle del Gómez Acebo, 82, 50830 Villanueva de Gállego, España");
		addOverlay(itemOverlay);
	
		 //STA. CATALINA (VILLANUEVA DE GALLEGO) , 14, 50830  Zaragoza, Aragón, España
		point = toGeoPoint(41.7692308,-0.8240527);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Calle de Santa Catalina, 14, 50830 Villanueva de Gállego, España");
		addOverlay(itemOverlay);
	
		 //Avenida GALO PONTE (SAN MATEO DE GÁLLEGO) , 23, 50840  Zaragoza, Aragón, España
		point = toGeoPoint(41.8327297,-0.765731);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av de Galo Ponte, 50840 San Mateo de Gállego, España");
		addOverlay(itemOverlay);
	
		 //GENERAL FRANCO (SAN MATEO DE GÁLLEGO) , 12, 50840  Zaragoza, Aragón, España
		point = toGeoPoint(41.830155,-0.7686655);
		itemOverlay = new OverlayItem(point, "QUIOSCO",
			"Av del General Franco, 50840 San Mateo de Gállego, España");
		addOverlay(itemOverlay);*/
	
	}

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

	// Dado una imagen la ajusta para que el punto 0,0 de éste esté en el
	// centro de la parte inferior
	public Drawable boundCenterBottomAux(Drawable marker) {
		return boundCenterBottom(marker);
	}

	// Cuando se hace tap en un punto muestro un Alert
	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(null);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}
	
	public static GeoPoint toGeoPoint(double latitud, double longitud) {
		return new GeoPoint((int) (latitud * TO_E6), (int) (longitud * TO_E6));
	}

}
