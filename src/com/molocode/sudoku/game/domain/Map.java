package com.molocode.sudoku.game.domain;

public class Map {
	
	public static final int MAP_TYPE_44 = 1;

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
		}
		return null;
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
		"4301004301300402" };
}
