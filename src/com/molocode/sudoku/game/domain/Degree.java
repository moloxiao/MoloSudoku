package com.molocode.sudoku.game.domain;

import java.util.List;

public class Degree {
	private String degreeName;// 学历名称(例如:xx学校)
	private int degreeId;// 学校ID
	private int type;// 难度类型，决定数独地图的难度
	private int highestLevel;// 当前学校级别的考试级别(例如:5年级)
	private int examinationId;// 当前点亮的考试的ID
	List<Examination> examinations;// 学校所有考试的列表

	private Degree() {
	}

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

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public int getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(int examinationId) {
		this.examinationId = examinationId;
	}

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	// 根据获得的String转出学校包含的所有考试
}
