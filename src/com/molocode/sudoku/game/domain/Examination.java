package com.molocode.sudoku.game.domain;

public class Examination {
	private String examinationName;// 考试名称
	private String examinationNumber;// 准考证号，随机生成
	private int passTime;// 过关时间
	private String examinationLocation;// 考试地点
	private int mapId;// 地图关卡ID
	private int mapType;// 地图类型
	private int score;// 考试成绩
	private int examType;// 0当前可考,1能力不够,2考过了
	private int examLevel;// 考试级别

	public static final int EXAMTYPE_CURRENT = 0;
	public static final int EXAMTYPE_ERRORLEVEL = 1;
	public static final int EXAMTYPE_PASSED = 2;

	public String getExaminationNumber() {
		return examinationNumber;
	}

	public void setExaminationNumber(String examinationNumber) {
		this.examinationNumber = examinationNumber;
	}

	public int getPassTime() {
		return passTime;
	}

	public void setPassTime(int passTime) {
		this.passTime = passTime;
	}

	public String getExaminationLocation() {
		return examinationLocation;
	}

	public void setExaminationLocation(String examinationLocation) {
		this.examinationLocation = examinationLocation;
	}

	public String getExaminationName() {
		return examinationName;
	}

	public void setExaminationName(String examinationName) {
		this.examinationName = examinationName;
	}

	public int getMapType() {
		return mapType;
	}

	public void setMapType(int mapType) {
		this.mapType = mapType;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getExamType() {
		return examType;
	}

	public void setExamType(int examType) {
		this.examType = examType;
	}

	public int getExamLevel() {
		return examLevel;
	}

	public void setExamLevel(int examLevel) {
		this.examLevel = examLevel;
	}

}
