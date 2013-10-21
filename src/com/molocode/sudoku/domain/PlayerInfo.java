package com.molocode.sudoku.domain;

import android.content.Context;
import android.content.SharedPreferences;

public class PlayerInfo {

	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	private String nickname;
	private int grade;	
	private int score;
	private int gender;
	
	private PlayerInfo(){
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	private static final String PREFS_NAME = "DIZZY_PLAYERINFO";
	private static final String PREFS_KEY_NICKNAME = "DIZZY_PLAYERINFO_NICKNAME";
	private static final String PREFS_KEY_GRADE = "DIZZY_PLAYERINFO_GRADE";
	private static final String PREFS_KEY_SCORE = "DIZZY_PLAYERINFO_SCORE";
	private static final String PREFS_KEY_GENDER = "DIZZY_PLAYERINFO_GENDER";
	
	public static PlayerInfo getPlayerInfo(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		PlayerInfo info = new PlayerInfo();
		info.setNickname(settings.getString(PREFS_KEY_NICKNAME, "傻蛋蛋"));
		info.setGrade(settings.getInt(PREFS_KEY_GRADE, 1));
		info.setScore(settings.getInt(PREFS_KEY_SCORE, 0));
		info.setGender(settings.getInt(PREFS_KEY_GENDER, PlayerInfo.MALE));
		return info;
	}
	
	public static void setPlayerInfo(Context context, PlayerInfo info) {
		if(info == null) {
			return ;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(PREFS_KEY_NICKNAME, info.getNickname());
		editor.putInt(PREFS_KEY_GRADE, info.getGrade());
		editor.putInt(PREFS_KEY_SCORE, info.getScore());
		editor.putInt(PREFS_KEY_GENDER, info.getGender());
		editor.commit();
	}
}
