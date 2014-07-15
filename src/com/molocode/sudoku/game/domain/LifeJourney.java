package com.molocode.sudoku.game.domain;

public class LifeJourney {

	private static LifeJourney journery = null;
	private int currentDegreeId;

	public int getCurrentDegreeId() {
		return currentDegreeId;
	}

	public void setCurrentDegreeId(int currentDegreeId) {
		this.currentDegreeId = currentDegreeId;
	}

	private LifeJourney() {
		//
	}

	public static LifeJourney getInstance() {
		if (null != journery) {
			return journery;
		} else {
			return new LifeJourney();
		}
	}

}
