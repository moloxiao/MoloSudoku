package com.molocode.sudoku.domain;

public class Level {
	/**
	 * 星级评级 ： 0~3
	 */
	public static final int SCORE_STAR_NONE = 0;
	public static final int SCORE_STAR_1 = 1;
	public static final int SCORE_STAR_2 = 2;
	public static final int SCORE_STAR_3 = 3;

	private boolean isLock;
	private boolean isPass;
	private int passCondition;
	private int bestScore;
	
	public Level(boolean isLock, boolean isPass, int passCondition,
			int bestScore) {
		super();
		this.isLock = isLock;
		this.isPass = isPass;
		this.passCondition = passCondition;
		this.bestScore = bestScore;
	}

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}

	public boolean isPass() {
		return isPass;
	}

	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}

	public int getPassCondition() {
		return passCondition;
	}

	public void setPassCondition(int passCondition) {
		this.passCondition = passCondition;
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	/**
	 * 获得得分的星级评定
	 * @return [0, 3]
	 */
	public static int getScoreLevel() {
		return 0;
	}
	
	/**
	 * 获取过关条件描述(数字描述转为时间格式)
	 * @param passCondition
	 * @return
	 */
	public static String getPassConditionDesc(int passCondition) {
		return "";
	}
}
