package com.molocode.sudoku.Journey.examination;

import android.content.SharedPreferences;

import com.molocode.sudoku.context.SudokuApplication;

public class ExamScore {
	private int score;
	public static int FAILED = 0;
	public static int PASS = 1;
	public static int GOOD = 2;
	public static int PERFECT = 3;

	private static final String SCORE_MANAGER_KEY_ENTRANCEEXAMS = "SCORE_MANAGER_KEY_ENTRANCEEXAMS";
	private static final String PREFS_KEY_SCORE = "PREFS_KEY_SCORE";

	private static ExamScore instance = null;

	private ExamScore() {

	}

	public static ExamScore getInstance() {
		if (null != instance) {
			return instance;
		} else {
			return new ExamScore();
		}
	}

	public int getScorebyTime(int passTime, Examination examination) {
		if (passTime >= examination.getPassLevel().pass
				- examination.getPassLevel().perfect) {
			return PERFECT;

		} else if (passTime >= examination.getPassLevel().pass
				- examination.getPassLevel().good) {
			return GOOD;
		}
		return PASS;
	}

	public void saveExamScore(int score) {
		this.score = score;
		setScoreToStore(this.score);
	}

	public int getExamScore() {
		return getScoreFromStore();
	}

	private int getScoreFromStore() {
		SharedPreferences settings = SudokuApplication.getInstance()
				.getSharedPreferences(SCORE_MANAGER_KEY_ENTRANCEEXAMS, 0);
		return settings.getInt(PREFS_KEY_SCORE, 0);
	}

	private void setScoreToStore(int result) {
		SharedPreferences settings = SudokuApplication.getInstance()
				.getSharedPreferences(SCORE_MANAGER_KEY_ENTRANCEEXAMS, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(PREFS_KEY_SCORE, result);
		editor.commit();
	}
}
