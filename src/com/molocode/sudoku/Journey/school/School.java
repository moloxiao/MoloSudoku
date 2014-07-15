package com.molocode.sudoku.Journey.school;

public abstract class School {

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
		// TODO Auto-generated method stub
		return false;
	}


	private int getProgressFromStore() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public boolean isGraduateHere() {
		return isGraduateHere;
	}

	public void setGraduateHere(boolean isGraduateHere) {
		this.isGraduateHere = isGraduateHere;
	}

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
