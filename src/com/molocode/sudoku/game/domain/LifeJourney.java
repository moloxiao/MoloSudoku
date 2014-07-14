package com.molocode.sudoku.game.domain;

import java.util.Map;
import java.util.List;
import android.content.Context;
import android.content.SharedPreferences;

public class LifeJourney {

	private static LifeJourney journery;
	private List<Degree> degrees;
	private int highestEducation;// 当前角色的最高学历(例如:初中)
	private int degreeId;// 学历的ID
	private String degreeString;// 学历列表转化的字符字符串
	// 下面这个属性最好写在文件里，做成可配置，现在先这样吧.
	private final String defaultDegreeString = "0-1-2-3-4-5-6-7-8-9-10-11-12-13-14";// 默认学校配置
	private Map<String, String> degreesMap;

	private LifeJourney() {
		// TODO 构造的时候可以从文件里读出degreesMap
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

	public void setDegreeString(String string) {
		degreeString = string;
	}

	public String getDegreeString() {
		return degreeString;
	}

	// 第一次登陆获取一个默认列表，以后直接读本地信息,可以把信息都配置成一个String保存起来，简单粗暴
	private static final String PREFS_NAME = "DIZZY_PLAYERINFO";
	private static final String SCHOOL_INFO_DEGREE = "SCHOOL_INFO_DEGREE";
	private static final String SCHOOL_INFO_HIGHESTDEGREE = "SCHOOL_INFO_HIGHESTDEGREE";

	public LifeJourney getLifeJourney(Context context) {
		SharedPreferences settings = context
				.getSharedPreferences(PREFS_NAME, 0);
		LifeJourney info = new LifeJourney();
		info.setDegreeString(settings.getString(SCHOOL_INFO_DEGREE,
				defaultDegreeString));
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
		editor.putString(SCHOOL_INFO_DEGREE, info.getDegreeString());
		editor.putInt(SCHOOL_INFO_HIGHESTDEGREE, info.getHighestEducation());
		editor.commit();
	}

	// TODO 根据学校的ID来获取当前学校的所有信息
	public Degree getDegreeByID(int id) {
		return null;
	}

	// TODO 根据String获取Degree
	public List<Degree> getDegreesByString(String str) {
		String[] strs = str.split("-");
		// 根据学校ID获取Degree

		return null;
	}
}
