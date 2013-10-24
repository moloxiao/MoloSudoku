package com.molocode.sudoku.game.domain;

public class Map {
	
	public static final int MAP_TYPE_44 = 0;
	public static final int MAP_TYPE_66 = 1;
	public static final int MAP_TYPE_99 = 2;
	
	public static int getMapLevels(int dificuty) {
		switch(dificuty) {
		case MAP_TYPE_44:
			return MAPS44.length;
		}
		return 0;
	}

	public static int[] getCellMaps(int type, int level) {
		switch(type) {
		case MAP_TYPE_44:
			return get44cells(level);
		}
		return null;
	}
	
	private static int[] get44cells(int level) {
		if( MAPS44.length > level) {
			return formatMaps(MAPS44[level]);
		}else {
			return formatMaps(MAPS44[level%MAPS44.length]);
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
		"2104002012030410",		// 1~5
		"2040040210300301",
		"3400003403100103",
		"3001140003044030",
		"4200002414000041"};		// 6~10
}
