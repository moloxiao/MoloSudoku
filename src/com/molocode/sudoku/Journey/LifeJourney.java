package com.molocode.sudoku.Journey;

import android.content.SharedPreferences;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.school.StudyState;
import com.molocode.sudoku.context.SudokuApplication;

/**
 * 游戏进程
 * 
 * @author molo
 * 
 */
public class LifeJourney {

	private static LifeJourney journery = null;
	private int degreeId;
	private StudyState studyState;

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
		this.degreeId = getSchoolIdFromStore();
	}

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
		storeDegreeId(this.degreeId);
	}
	
	

	public StudyState getStudyState() {
		return studyState;
	}

	public void setStudyState(StudyState studyState) {
		this.studyState = studyState;
	}

	private void storeDegreeId(int degreeId) { // TODO : 字符串改为静态变量
		SharedPreferences settings = SudokuApplication.getInstance()
				.getSharedPreferences("journey", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt("degreeId", degreeId);
		editor.commit();
	}

	protected int getSchoolIdFromStore() {
		SharedPreferences settings = SudokuApplication.getInstance()
				.getSharedPreferences("journey", 0);
		return settings.getInt("degreeId", Degree.PRIMARY);

	}

	/**
	 * 获取人生的求学顺序。
	 * 
	 * @return
	 */
	public static int[] getDegreeSequence() {
		return DEGREESEQUENCE;
	}

	private final static int[] DEGREESEQUENCE = { Degree.PRIMARY,
			Degree.MIDDLE, Degree.HIGH, Degree.UNIVERSITY, Degree.POSTGRADUATE };

}
