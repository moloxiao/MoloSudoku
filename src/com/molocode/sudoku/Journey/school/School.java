package com.molocode.sudoku.Journey.school;

import android.content.SharedPreferences;

import com.molocode.sudoku.context.SudokuApplication;

public abstract class School {
	
	private static final String SCHOOL_MAP_KEY_CURRENTSCHOOL = "SCHOOL_MAP_KEY_CURRENTSCHOOL";
	private static final String PREFS_KEY_PROGRESS = "PREFS_KEY_PROGRESS";
	private static final String PREFS_KEY_GRADUATE = "PREFS_KEY_GRADUATE";

	public static final int LEVEL1 = 0;
	public static final int LEVEL2 = 1;
	public static final int LEVEL3 = 2;
	
	/**
	 * 学校分为3个Level，不同的Level，升学考试的时候额外增加的时间不同
	 */
	private int level;
	
	/**
	 * 学校名称
	 */
	private String name;
	
	/**
	 * 学习进度
	 */
	private int progress;
	
	/**
	 * 是否从此毕业
	 */
	private boolean isGraduateHere;
	
	
	public School() {
		this.progress = getProgressFromStore();
		this.isGraduateHere = getIsGraduateHereFromStore();
	}
	
	private boolean getIsGraduateHereFromStore() {
		SharedPreferences settings = SudokuApplication.getInstance().getSharedPreferences(
				SCHOOL_MAP_KEY_CURRENTSCHOOL, 0);
		return settings.getBoolean(PREFS_KEY_GRADUATE, false);
	}
	

	private void setIsGraduateHereToStore(boolean result) {
		SharedPreferences settings = SudokuApplication.getInstance().getSharedPreferences(
				SCHOOL_MAP_KEY_CURRENTSCHOOL, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(PREFS_KEY_GRADUATE, result);
		editor.commit();
	}


	private int getProgressFromStore() {
		SharedPreferences settings = SudokuApplication.getInstance().getSharedPreferences(
				SCHOOL_MAP_KEY_CURRENTSCHOOL, 0);
		return settings.getInt(PREFS_KEY_PROGRESS, 0);
	}
	
	private void setProgressToStore(int result) {
		SharedPreferences settings = SudokuApplication.getInstance().getSharedPreferences(
				SCHOOL_MAP_KEY_CURRENTSCHOOL, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(PREFS_KEY_PROGRESS, result);
		editor.commit();
	}


	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
		setProgressToStore(this.progress);
	}

	public boolean isGraduateHere() {
		return isGraduateHere;
	}

	public void setGraduateHere(boolean isGraduateHere) {
		this.isGraduateHere = isGraduateHere;
		setIsGraduateHereToStore(this.isGraduateHere);
	}

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}
	
}
