package com.molocode.sudoku.game.domain;

import java.util.List;
import android.content.Context;
import android.content.SharedPreferences;

public class LifeJourney {

	private static LifeJourney journery;
	private List<Degree> degrees;
	private int highestEducation;// 当前角色的最高学历(例如:初中)
	private int degreeId;// 学历的ID

	private LifeJourney() {

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

	// TODO 第一次登陆获取一个默认列表，以后直接读本地信息,可以把信息都配置成一个String保存起来，简单粗暴
	private static final String PREFS_NAME = "DIZZY_PLAYERINFO";
	private static final String SCHOOL_INFO_DEGREE = "SCHOOL_INFO_DEGREE";
	private static final String SCHOOL_INFO_HIGHESTDEGREE = "SCHOOL_INFO_HIGHESTDEGREE";

	public LifeJourney LifeJourney(Context context) {
		SharedPreferences settings = context
				.getSharedPreferences(PREFS_NAME, 0);
		LifeJourney info = new LifeJourney();
		return info;
	}

	// TODO 根据String获取Degree
	public List<Degree> getDegreesByString(String str) {
		return null;
	}

	// TODO 把list<Degree>的信息转化成一个String数组
	public String getStringByDegrees(List<Degree> degrees) {
		return null;
	}
}
