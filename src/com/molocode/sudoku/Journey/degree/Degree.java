package com.molocode.sudoku.Journey.degree;

import com.molocode.sudoku.context.SudokuApplication;

import android.content.SharedPreferences;

public abstract class Degree {

	private static final String DEGREE_MAP_KEY_CURRENTSCHOOL = "DEGREE_MAP_KEY_CURRENTSCHOOL";
	
	public static final String PREFS_KEY_SCHOOLID = "PREFS_KEY_SCHOOLID";
	
	public static final int PRIMARY = 0;
	public static final int MIDDLE = 1;
	public static final int HIGH = 2;
	public static final int UNIVERSITY = 3;
	public static final int POSTGRADUATE = 4;
	
	public static final String PRIMARY_DESC = "小学";
	public static final String MIDDLE_DESC = "初中";
	public static final String HIGH_DESC = "高中";
	public static final String UNIVERSITY_DESC = "大学";
	public static final String POSTGRADUATE_DESC = "研究生";
	
	public static String getDegreeDesc(int id) {
		switch(id) {
		case PRIMARY:
			return PRIMARY_DESC;
		case MIDDLE:
			return MIDDLE_DESC;
		case HIGH:
			return HIGH_DESC;
		case UNIVERSITY:
			return UNIVERSITY_DESC;
		case POSTGRADUATE:
			return POSTGRADUATE_DESC;
		default:
			return "不知道";	
		}
	}
	
	protected int id;
	protected String name;
	
	protected boolean isRequireExamination;
	// TODO : 入学考试题目List<> 等到考试出来以后实现
	
	protected int schoolId;
	
	public Degree(){
		schoolId = getSchoolIdFromStore();
	}
	
	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
		storeDegreeInfo(this.schoolId);
	}

	

	public int getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isRequireExamination(){
		return isRequireExamination;
	}
	
	private void storeDegreeInfo(int schoolId) {
		SharedPreferences settings = SudokuApplication.getInstance().getSharedPreferences(
				DEGREE_MAP_KEY_CURRENTSCHOOL, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(PREFS_KEY_SCHOOLID, schoolId);
		editor.commit();
	}
	
	protected int getSchoolIdFromStore() {
		SharedPreferences settings = SudokuApplication.getInstance().getSharedPreferences(
				DEGREE_MAP_KEY_CURRENTSCHOOL, 0);
		return settings.getInt(PREFS_KEY_SCHOOLID, 0); // TODO : 0改成默认schoolid
		
	}
}
