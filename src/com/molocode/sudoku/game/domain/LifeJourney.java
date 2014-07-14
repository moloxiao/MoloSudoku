package com.molocode.sudoku.game.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import android.content.Context;
import android.content.SharedPreferences;

public class LifeJourney {

	private static LifeJourney journery = null;
	private List<Degree> degrees;
	private int highestEducation;// 当前角色的就读学历(例如:初中)
	// 下面这个属性最好写在文件里，做成可配置，现在先这样吧.
	private Map<Integer, String> degreesMap;

	private LifeJourney() {
		degreesMap = getDefaultMap();
		getDegreeByMap(degreesMap);
	}

	public static LifeJourney getInstance() {
		if (null != journery) {
			return journery;
		} else {
			return new LifeJourney();
		}
	}

	public List<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}

	public int getHighestEducation() {
		return highestEducation;
	}

	public void setHighestEducation(int highestEducation) {
		this.highestEducation = highestEducation;
	}

	public Map<Integer, String> getDegreesMap() {
		return degreesMap;
	}

	public void setDegreesMap(Map<Integer, String> degreesMap) {
		this.degreesMap = degreesMap;
	}

	// 设置地图上所有学校的信息
	public List<Degree> getDegreeByMap(Map<Integer, String> map) {
		degrees = new ArrayList<Degree>();
		for (int i = 0; i < map.size(); i++) {
			String degreeinfo = degreesMap.get(i);
			String[] infos = degreeinfo.split("-");
			Degree degree = new Degree();
			degree.setDegreeId(Integer.valueOf(infos[0]));// 设置ID
			degree.setDegreeName(infos[1]);
			degree.setType(Integer.valueOf(infos[2]));
			degree.setHighestLevel(Integer.valueOf(infos[3]));
			degrees.add(degree);
		}
		return degrees;
	}

	// 获取默认的关卡配置
	private Map<Integer, String> getDefaultMap() {
		// 构造的时候可以从文件里读出degreesMap:id-name-type-highestLevel-privateSchool
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "0-胜利小学-0-4");
		map.put(1, "1-呆比小学-0-4");
		map.put(2, "2-二货小学-0-4");
		map.put(3, "3-吃货中学-0-4");
		map.put(4, "4-贝爷中学-0-4");
		map.put(5, "5-逗比中学-0-4");
		map.put(6, "6-PT高中-0-4");
		map.put(7, "7-英雄高中-0-4");
		map.put(8, "8-大熊高中-0-4");
		map.put(9, "9-大学1-0-4");
		map.put(10, "10-大学2-0-4");
		map.put(11, "11-大学3-0-4");
		map.put(12, "12-研究生1-0-4");
		map.put(13, "13-研究生2-0-4");
		map.put(14, "14-研究生3-0-4");
		return map;
	}
}
