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
	private int highestEducation;// 当前角色的最高学历(例如:初中)
	private int degreeId;// 学历的ID
	// 下面这个属性最好写在文件里，做成可配置，现在先这样吧.
	private Map<Integer, String> degreesMap;

	private LifeJourney() {
		// TODO 构造的时候可以从文件里读出degreesMap,方便测试，先填几个(ID-NAME-TYPE-HIGHESTLEVEL)
		degreesMap = new HashMap<Integer, String>();
		degreesMap.put(0, "0-胜利小学-0-4");
		degreesMap.put(1, "1-胜利小学-0-4");
		degreesMap.put(2, "2-胜利小学-0-4");
		degreesMap.put(3, "3-胜利小学-0-4");
		degreesMap.put(4, "4-胜利小学-0-4");
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

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
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

	// 第一次登陆获取一个默认列表，以后直接读本地信息,可以把信息都配置成一个String保存起来，简单粗暴
	private static final String PREFS_NAME = "DIZZY_PLAYERINFO";
	private static final String SCHOOL_INFO_HIGHESTDEGREE = "SCHOOL_INFO_HIGHESTDEGREE";

	public LifeJourney getLifeJourney(Context context) {
		SharedPreferences settings = context
				.getSharedPreferences(PREFS_NAME, 0);
		LifeJourney info = new LifeJourney();
		info.setHighestEducation(settings.getInt(SCHOOL_INFO_HIGHESTDEGREE, 0));
		return info;
	}

	public void setLifeJourney(Context context, LifeJourney info) {
		if (info == null) {
			return;
		}
		SharedPreferences settings = context
				.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(SCHOOL_INFO_HIGHESTDEGREE, info.getHighestEducation());
		editor.commit();
	}
}
