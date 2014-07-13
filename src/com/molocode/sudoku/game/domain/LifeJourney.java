package com.molocode.sudoku.game.domain;

import java.util.List;

public class LifeJourney {

	private static LifeJourney journery;
	private List<Degree> degrees;
	private int highestEducation;// 当前角色的最高学历(例如:初中)

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

}
