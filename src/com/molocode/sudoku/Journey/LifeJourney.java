package com.molocode.sudoku.Journey;

/**
 * 游戏进程
 * @author molo
 *
 */
public class LifeJourney {

	private static LifeJourney journery = null;
	private int degreeId;

	public static LifeJourney getInstance() {
		if (null != journery) {
			return journery;
		} else {
			return new LifeJourney();
		}
	}
	
	private LifeJourney() {
		initByStore();
	}
	
	private void initByStore() {
		// TODO : 从本地读取基本信息
		this.degreeId = 1;
	}

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

}
