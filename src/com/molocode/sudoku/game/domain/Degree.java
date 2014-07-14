package com.molocode.sudoku.game.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Degree {

	private int degreeId;// 学历ID
	private String degreeName;// 学历名称
	private int type;// 学历类型(小,中,高,本,硕)可以决定数独地图的难度
	private int highestLevel;// 当前学历级别的考试级别(例如:5年级)
	List<Examination> examinations;// 当前学历考试的列表

	public Degree() {
		// examinationName-passTime-type-level
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "1年级期末考#180#0#1");
		map.put(1, "2年级期末考#150#0#2");
		map.put(2, "3年级期末考#120#0#3");
		map.put(3, "4年级期末考#90#0#4");
		map.put(4, "5年级期末考#60#0#5");
		map.put(5, "6年级期末考#30#0#6");
		getExaminationsByMap(map);
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

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	// 根据degreeId获取当前学校里的所有考试
	public List<Examination> getExaminationsByMap(Map<Integer, String> map) {
		for (int i = 0; i < map.size(); i++) {
			String examInfo = map.get(i);
			String[] examinfos = examInfo.split("#");
			Examination exam = new Examination();
			exam.setExaminationName(examinfos[0]);
			exam.setPassTime(Integer.valueOf(examinfos[1]));
			exam.setType(Integer.valueOf(examinfos[1]));
			exam.setLevel(Integer.valueOf(examinfos[1]));
		}
		return null;
	}

}
