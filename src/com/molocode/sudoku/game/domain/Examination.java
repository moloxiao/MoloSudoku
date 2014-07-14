package com.molocode.sudoku.game.domain;

import java.util.List;

import com.molocode.sudoku.domain.Level;

public class Examination {
	private String examinationName;// 考试名称
	private String examinationNumber;// 准考证号，随机生成
	private int passTime;// 过关时间
	private String examinationLocation;// 考试地点
	private Level level;// 地图关卡ID
	private int type;// 地图类型
	private int score;// 考试成绩

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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// TODO 根据String获取Examination
	public List<Examination> getExaminationByString(String str) {
		return null;
	}

	// TODO 把list<Examination>的信息转化成一个String数组
	public String getStringByExaminations(List<Examination> examinations) {
		return null;
	}
}
