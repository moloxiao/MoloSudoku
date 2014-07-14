package com.molocode.sudoku.game.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class LifeJourney {

	private static LifeJourney journery = null;
	private List<Degree> degrees;

	private LifeJourney() {
		getDegreeByMap(getDefaultMap());
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

	// 设置地图上所有学历的信息
	public void getDegreeByMap(Map<Integer, String> map) {
		degrees = new ArrayList<Degree>();
		for (int i = 0; i < map.size(); i++) {
			String degreeinfo = map.get(i);
			String[] infos = degreeinfo.split("-");
			Degree degree = new Degree(Integer.valueOf(infos[0]));
			degree.setDegreeName(infos[1]);
			degrees.add(degree);
		}
	}

	// 获取默认的关卡配置
	private Map<Integer, String> getDefaultMap() {
		// 构造的时候可以从文件里读出degreesMap:degreeId-degreeName-degreeType
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "0-小学");
		map.put(1, "1-中学");
		map.put(2, "2-高中");
		map.put(3, "3-大学");
		map.put(4, "4-硕士");
		return map;
	}
}
