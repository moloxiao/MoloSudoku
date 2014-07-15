package com.molocode.sudoku.Journey.examination;

import java.util.ArrayList;
import java.util.List;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.game.domain.Map;

public class Examination {

	private String examinationName;// 考试名称
	private String examinationNumber;// 准考证号，随机生成
	private int passTime;// 过关时间
	private String examinationLocation;// 考试地点
	private int[] questions;// 考试试题
	private int mapType;// 地图类型

	public Examination() {
	}
	
	public Examination(String examinationName, String examinationNumber,
			int passTime, String examinationLocation, int[] questions, int mapType) {
		this.examinationName = examinationName;
		this.examinationNumber = examinationNumber;
		this.passTime = passTime;
		this.examinationLocation = examinationLocation;
		this.questions = questions;
		this.mapType = mapType;
	}

	public String getExaminationName() {
		return examinationName;
	}

	public String getExaminationNumber() {
		return examinationNumber;
	}

	public int getPassTime() {
		return passTime;
	}

	public String getExaminationLocation() {
		return examinationLocation;
	}

	public int[] getQuestions() {
		return questions;
	}

	public int getMapType() {
		return mapType;
	}

	/**
	 * TODO 获取学校日常考试题目
	 * @param degreeId
	 * @return
	 */
	public static List<Examination> getExaminationList(int degreeId) {
		List<Examination> result = new ArrayList<Examination>() ;
		switch(degreeId) {
		case Degree.PRIMARY:
			return result;
		case Degree.MIDDLE:
			return result;
		case Degree.HIGH:
			return result;
		case Degree.UNIVERSITY:
			return result;
		case Degree.POSTGRADUATE:
			return result;
		default:
			return result;
		}
	}
	
	/**
	 * TODO 获取入学考试试题，如果Degree的是否包含入学考试为true，则可以在此获取考试题目
	 * @param degreeId
	 * @return
	 */
	public static List<Examination> getEnterDegreeExaninationList(int degreeId) {
		List<Examination> result = new ArrayList<Examination>() ;
		switch(degreeId) {
		case Degree.PRIMARY:
			return result;
		case Degree.MIDDLE:
			result.add(new Examination(
					"初中入学考试", 
					Examination.getRandomExaminationNumber(), 
					30, 
					"12教学楼1教室34桌", 
					Map.formatMaps("2030430000000002"), // TODO : 地图从统一配置的地方获取 
					Map.MAP_TYPE_44));
			return result;
		case Degree.HIGH:
			return result;
		case Degree.UNIVERSITY:
			return result;
		case Degree.POSTGRADUATE:
			return result;
		default:
			return result;
		}
	}
	
	/**
	 * 获取随机的准考证号
	 * @return 随机的准考证号
	 */
	public static String getRandomExaminationNumber() {
		return System.currentTimeMillis()+"";
	}
}
