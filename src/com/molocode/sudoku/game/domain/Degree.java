package com.molocode.sudoku.game.domain;

import java.util.List;

public class Degree {

	private int type;
	private int highestLevel;// 当前学校级别的考试级别（例如:5年级）

	public int getHighestLevel() {
		return highestLevel;
	}

	public void setHighestLevel(int highestLevel) {
		this.highestLevel = highestLevel;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	List<Examination> examinations;

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

}
