package com.molocode.sudoku.domain;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;

public class PlayerInfo {

	public static final int MALE = 0;
	public static final int FEMALE = 1;

	private String nickname;
	private int score;
	private int gender;
	private boolean isfirstlogin;

	private int levelsCompleted;

	public boolean isIsfirstlogin() {
		return isfirstlogin;
	}

	public void setIsfirstlogin(boolean isfirstlogin) {
		this.isfirstlogin = isfirstlogin;
	}

	private PlayerInfo() {
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public int getLevelsCompleted() {
		return levelsCompleted;
	}

	public void setLevelsCompleted(int levelsCompleted) {
		this.levelsCompleted = levelsCompleted;
	}

	private static final String PREFS_NAME = "DIZZY_PLAYERINFO";
	private static final String PREFS_KEY_NICKNAME = "DIZZY_PLAYERINFO_NICKNAME";
	private static final String PREFS_KEY_SCORE = "DIZZY_PLAYERINFO_SCORE";
	private static final String PREFS_KEY_GENDER = "DIZZY_PLAYERINFO_GENDER";
	private static final String PREFS_KEY_FIRSTLOGIN = "PREFS_KEY_FIRSTLOGIN";
	private static final String PREFS_KEY_LEVELSCOMPLETED = "PREFS_KEY_LEVELSCOMPLETED";

	public static PlayerInfo getPlayerInfo(Context context) {
		SharedPreferences settings = context
				.getSharedPreferences(PREFS_NAME, 0);
		PlayerInfo info = new PlayerInfo();
		info.setNickname(settings.getString(PREFS_KEY_NICKNAME,
				randomPlayerName()));
		info.setScore(settings.getInt(PREFS_KEY_SCORE, 0));
		info.setGender(settings.getInt(PREFS_KEY_GENDER, PlayerInfo.MALE));
		info.setIsfirstlogin(settings.getBoolean(PREFS_KEY_FIRSTLOGIN, true));
		info.setLevelsCompleted(settings.getInt(PREFS_KEY_LEVELSCOMPLETED, 0));
		return info;
	}

	public static void setPlayerInfo(Context context, PlayerInfo info) {
		if (info == null) {
			return;
		}
		SharedPreferences settings = context
				.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(PREFS_KEY_NICKNAME, info.getNickname());
		editor.putInt(PREFS_KEY_SCORE, info.getScore());
		editor.putInt(PREFS_KEY_GENDER, info.getGender());
		editor.putBoolean(PREFS_KEY_FIRSTLOGIN, info.isIsfirstlogin());
		editor.putInt(PREFS_KEY_LEVELSCOMPLETED, info.getLevelsCompleted());
		editor.commit();
	}

	private static String randomPlayerName() {
		// TOOD 为首次登陆用户产生一个随机的名字
		String name = "快乐的逗比";
		return name;
	}
}
