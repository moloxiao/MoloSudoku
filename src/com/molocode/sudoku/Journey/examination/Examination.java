package com.molocode.sudoku.Journey.examination;

import java.util.ArrayList;
import java.util.List;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.game.domain.Map;

public class Examination {

	private String examinationName;// 考试名称
	private String examinationNumber;// 准考证号，随机生成
	private String examinationLocation;// 考试地点
	private int[] questions;// 考试试题
	private int mapType;// 地图类型
	private PassLevel passLevel;

	public Examination() {
	}

	public Examination(String examinationName, String examinationNumber,
			String examinationLocation, int[] questions, int mapType,
			PassLevel passLevel) {
		this.examinationName = examinationName;
		this.examinationNumber = examinationNumber;
		this.examinationLocation = examinationLocation;
		this.questions = questions;
		this.mapType = mapType;
		this.passLevel = passLevel;
	}

	public PassLevel getPassLevel() {
		return passLevel;
	}

	public String getExaminationName() {
		return examinationName;
	}

	public String getExaminationNumber() {
		return examinationNumber;
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
	 * 
	 * @param degreeId
	 * @return
	 */
	public static List<Examination> getExaminationList(int degreeId) {
		List<Examination> result = new ArrayList<Examination>();
		switch (degreeId) {
		case Degree.PRIMARY:
			result.addAll(getPrimaryExam());
			return result;
		case Degree.MIDDLE:
			result.addAll(getMiddleExam());
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
	 * 
	 * @param degreeId
	 * @return
	 */
	public static List<Examination> getEnterDegreeExaninationList(int degreeId) {
		List<Examination> result = new ArrayList<Examination>();
		switch (degreeId) {
		case Degree.PRIMARY:
			return result;
		case Degree.MIDDLE:
			result.add(new Examination("初中入学考试", Examination
					.getRandomExaminationNumber(), "12教学楼1教室34桌", Map
					.formatMaps("2030430000000002"), // TODO : 地图从统一配置的地方获取
					Map.MAP_TYPE_44, new PassLevel(30, 25, 20)));
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
	 * 
	 * @return 随机的准考证号
	 */
	public static String getRandomExaminationNumber() {
		return System.currentTimeMillis() + "";
	}

	/**
	 * 随机获取地图类型下的考试题目
	 * 
	 * @param type
	 * @return
	 */
	private static int[] getQuestionsFromMap(int type) {
		int level = (int) Math.round(Math.random() * 5);
		return Map.getCellMaps(type, level);
	}

	/**
	 * 小学考题
	 * 
	 * @param result
	 * @return
	 */
	private static List<Examination> getPrimaryExam() {
		List<Examination> result = new ArrayList<Examination>();
		result.add(new Examination("一年级考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(60, 25, 20)));
		result.add(new Examination("二年级考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(60, 25, 20)));
		result.add(new Examination("三年级考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(60, 25, 20)));
		// result.add(new Examination("四年级考试", Examination
		// .getRandomExaminationNumber(), "12教学楼1教室34桌",
		// getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
		// new PassLevel(60, 25, 20)));
		// result.add(new Examination("五年级考试", Examination
		// .getRandomExaminationNumber(), "12教学楼1教室34桌",
		// getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
		// new PassLevel(60, 25, 20)));
		// result.add(new Examination("六年级考试", Examination
		// .getRandomExaminationNumber(), "12教学楼1教室34桌",
		// getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
		// new PassLevel(60, 25, 20)));
		return result;
	}

	/**
	 * 初中考题
	 * 
	 * @param result
	 * @return
	 */
	private static List<Examination> getMiddleExam() {
		List<Examination> result = new ArrayList<Examination>();
		result.add(new Examination("七年级上考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(30, 25, 20)));
		result.add(new Examination("七年级下考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(30, 25, 20)));
		result.add(new Examination("八年级上考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(30, 25, 20)));
		result.add(new Examination("八年级下考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(30, 25, 20)));
		result.add(new Examination("九年级上考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(30, 25, 20)));
		result.add(new Examination("九年级下考试", Examination
				.getRandomExaminationNumber(), "12教学楼1教室34桌",
				getQuestionsFromMap(Map.MAP_TYPE_44), Map.MAP_TYPE_44,
				new PassLevel(30, 25, 20)));
		return result;
	}

}
