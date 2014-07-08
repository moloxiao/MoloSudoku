package com.molocode.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

import com.molocode.sudoku.game.domain.Map;

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
	 * 获得得分的星级评定。
	 * 大于过关条件的为0星；
	 * 小于过关条件但是大于过关条件减去1/4的为1星
	 * 小于过关条件减去1/4但是大于过关条件减去1/2的为2星
	 * 小于等于过关条件减去1/2的为3星
	 * @return [0, 3]
	 */
	public static int getScoreLevel(int seccond, int passCondition) {
		if(seccond > passCondition) {
			return 0;
		}else if(seccond >passCondition - passCondition/4) {
			return 1;
		}else if(seccond >passCondition - passCondition/2) {
			return 2;
		}
		return 3;
	}
	
	/**
	 * TODO : 获取过关条件描述(数字描述转为时间格式)
	 * @param passCondition
	 * @return
	 */
	public static String getPassConditionDesc(int passCondition) {
		return passCondition+"s";
	}
	
	/**
	 * topLevelId 1->4*4 2->6*6 3->9*9_1
	 * 目前topLevelId只有1，2，3三个值有数据配置，如果不是返回长度为0的List
	 * @param topLevelId
	 * @return
	 */
	public static List<Level> getDefaultLevel(int topLevelId) {
		List<Level> levels = new ArrayList<Level>();
		if(topLevelId == 1) {
			levels.add(new Level(false, false, 40, 0));
			for(int i=1;i<Map.getChapterLevels(Map.MAP_TYPE_44);i++) {
				levels.add(new Level(true, false, 30-i, 0));
			}
		}else if(topLevelId == 2) {
			levels.add(new Level(false, false, 40, 0));
			for(int i=1;i<Map.getChapterLevels(Map.MAP_TYPE_66);i++) {
				levels.add(new Level(true, false, 50-i, 0));
			}
		}else if(topLevelId == 3) {
			levels.add(new Level(false, false, 40, 0));
			for(int i=1;i<Map.getChapterLevels(Map.MAP_TYPE_99_1);i++) {
				levels.add(new Level(true, false,120-i*2, 0));
			}
		}
		return levels;
	}
	
	
}
