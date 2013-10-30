package com.molocode.sudoku.game.domain;

public class Map {
	
	public static final int MAP_TYPE_44 = 0;
	public static final int MAP_TYPE_66 = 1;
	public static final int MAP_TYPE_99 = 2;
	
	public static int getMapLevels(int dificuty) {
		switch(dificuty) {
		case MAP_TYPE_44:
			return MAPS44.length;
		case MAP_TYPE_66:
			return MAPS66.length;
		case MAP_TYPE_99:
			return MAPS99.length;
		}
		return 0;
	}

	public static int[] getCellMaps(int type, int level) {
		switch(type) {
		case MAP_TYPE_44:
			return getcells(level, MAPS44);
		case MAP_TYPE_66:
			return getcells(level, MAPS66);
		case MAP_TYPE_99:
			return getcells(level, MAPS99);
		}
		return null;
	}
	
	private static int[] getcells(int level, String[] maps) {
		if( maps.length > level) {
			return formatMaps(maps[level]);
		}else {
			return formatMaps(maps[level%maps.length]);
		}
	}
	
	private static int[] formatMaps(String map) {
		if(map == null) {
			return null;
		}
		int[] results = new int[map.length()];
		for(int i=0;i<map.length();i++) {
			results[i] = map.charAt(i) - '0';
		}
		return results;
	}
	
	private static String[] MAPS44 = {
		"3041010003141003",
		"4301004301300402",
		"1020030440010142",
		"0204402020311300",
		"2104002012030410",
		"2040040210300301",
		"3400003403100103",
		"3001140003044030",
		"4200002414000041"};	
	
	private static String[] MAPS66 = {
		"412030053142320014541326164203030460",
		"540263306510213056050130465321130605"};
	
	private static String[] MAPS99 = {
		"030800000905600700001093200806500000040030000000000000472306950019487060368259010" };
}
