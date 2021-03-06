package com.molocode.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

import com.molocode.sudoku.game.domain.Map;

public class TopLevel {
	
	private int id;
	private String desc;
	private boolean allowPlay;
	private int amountPromblem;
	private int slovePromblem;
	private int slovingPromblem;
	
	public TopLevel(int id, String desc, boolean allowPlay, 
			int amountPromblem, int slovePromblem, int slovingPromblem) {
		super();
		this.id = id;
		this.desc = desc;
		this.allowPlay = allowPlay;
		this.amountPromblem = amountPromblem;
		this.slovePromblem = slovePromblem;
		this.slovingPromblem = slovingPromblem;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isAllowPlay() {
		return allowPlay;
	}

	public void setAllowPlay(boolean allowPlay) {
		this.allowPlay = allowPlay;
	}

	public int getAmountPromblem() {
		return amountPromblem;
	}

	public void setAmountPromblem(int amountPromblem) {
		this.amountPromblem = amountPromblem;
	}

	public int getSlovePromblem() {
		return slovePromblem;
	}

	public void setSlovePromblem(int slovePromblem) {
		this.slovePromblem = slovePromblem;
	}

	public int getSlovingPromblem() {
		return slovingPromblem;
	}

	public void setSlovingPromblem(int slovingPromblem) {
		this.slovingPromblem = slovingPromblem;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static List<TopLevel> levels = new ArrayList<TopLevel>();
	public static  List<TopLevel> getLevelList() {
		if(levels.size() == 0) {
			levels.add(new TopLevel(Map.MAP_TYPE_44, "菜鸟", true, Map.getChapterLevels(Map.MAP_TYPE_44), 0, 0));
			levels.add(new TopLevel(Map.MAP_TYPE_66, "牛人", true, Map.getChapterLevels(Map.MAP_TYPE_66), 0, 0));
			levels.add(new TopLevel(Map.MAP_TYPE_99_1, "怪咖", true, Map.getChapterLevels(Map.MAP_TYPE_99_1), 0, 0));
		}
		return levels;
	}
}
