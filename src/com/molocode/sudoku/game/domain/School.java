package com.molocode.sudoku.game.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {

	public static final int SCHOOL_TYPE_ABLE = 0;
	public static final int SCHOOL_TYPE_DEGREEUNABLE = 1;
	public static final int SCHOOL_TYPE_AGEUNABLE = 2;

	private int id;
	private String name;
	private String location;
	private int schoolType;// 0普通学校，1重点学校 ，2私立学校
	private int playerUsed;// 0玩家没来过，1玩家来过
	private int playProperty;// 1可读学校,1学历不可读，2年龄不可读
	List<Examination> examinations;// 当前学校考试的列表

	public School() {
		getExaminationsByMap(getDefaultMap());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public int getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(int schoolType) {
		this.schoolType = schoolType;
	}

	public int getPlayerUsed() {
		return playerUsed;
	}

	public void setPlayerUsed(int playerUsed) {
		this.playerUsed = playerUsed;
	}

	public int getPlayProperty() {
		return playProperty;
	}

	public void setPlayProperty(int playProperty) {
		this.playProperty = playProperty;
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

	public Map<Integer, String> getDefaultMap() {
		// examinationName-passTime-type-level
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "1年级期末考#180#0#1");
		map.put(1, "2年级期末考#150#0#2");
		map.put(2, "3年级期末考#120#0#3");
		map.put(3, "4年级期末考#90#0#4");
		map.put(4, "5年级期末考#60#0#5");
		map.put(5, "6年级期末考#30#0#6");
		return map;
	}
}
