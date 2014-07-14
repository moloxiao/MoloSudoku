package com.molocode.sudoku.game.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

public class Degree {
	private int degreeId;// 学历ID,分别代表学历类型(小,中,高,本,硕)可以决定数独地图的难度
	private String degreeName;// 学历名称
	private int highestLevel;// 当前学历级别的考试级别(例如:5年级)
	private List<School> schools;

	public Degree(int id) {
		this.degreeId = id;
		getSchoolsByType(degreeId);
	}

	public int getHighestLevel() {
		return highestLevel;
	}

	public void setHighestLevel(int highestLevel) {
		this.highestLevel = highestLevel;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public List<School> getSchools() {
		return schools;
	}

	// 获取当前学历级别下的说有学校
	private void getSchoolsByType(int degreeID) {
		schools = new ArrayList<School>();
		Map<Integer, String> map = getDefaultSchoolList(degreeID);
		for (int i = 0; i < map.size(); i++) {
			String info = map.get(i);
			String[] infos = info.split("#");
			School school = new School();
			school.setId(Integer.valueOf(infos[0]));
			school.setName(infos[1]);
			school.setLocation(infos[2]);
			school.setPrivateSchool(Boolean.valueOf(infos[0]));
			schools.add(school);
		}
	}

	// 返回前学历级别的所有可用学校
	private Map<Integer, String> getDefaultSchoolList(int degreeID) {
		// id-name-location-privateSchool
		Map<Integer, String> map = new HashMap<Integer, String>();
		switch (degreeID) {
		case 0: {
			map.clear();
			map.put(0, "0#龙湖小学#A街道101号#false");
			map.put(1, "1#胜利小学#B街道102号#false");
			map.put(2, "1#乌龙小学#C街道103号#true");
			break;
		}
		case 1: {
			map.clear();
			map.put(0, "3#龙湖中学学#A街道101号#false");
			map.put(1, "4#胜利中学#B街道102号#false");
			map.put(2, "5#乌龙中学#C街道103号#true");
			break;
		}
		case 2: {
			map.clear();
			map.put(0, "6#龙湖高中#A街道101号#false");
			map.put(1, "7#胜利高中#B街道102号#false");
			map.put(2, "8#乌龙高中#C街道103号#true");
			break;
		}
		case 3: {
			map.clear();
			map.put(0, "9#龙湖大学#A街道101号#false");
			map.put(1, "10#胜利大学#B街道102号#false");
			map.put(2, "11#乌龙大学#C街道103号#true");
			break;
		}
		case 4: {
			map.clear();
			map.put(0, "12#龙湖硕士#A街道101号#false");
			map.put(1, "13#胜利硕士#B街道102号#false");
			map.put(2, "14#乌龙硕士#C街道103号#true");
			break;
		}
		default:
			break;
		}
		return map;
	}
}
