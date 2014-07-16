package com.molocode.sudoku.Journey.school;

import java.util.List;

import android.content.SharedPreferences;
import android.util.Log;

import com.molocode.sudoku.Journey.LifeJourney;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.degree.DegreeManager;
import com.molocode.sudoku.Journey.examination.Examination;
import com.molocode.sudoku.context.SudokuApplication;

public class ProgressManager {

	private static final String PROGRESS_MANAGER_KEY_ENTRANCEEXAMS = "PROGRESS_MANAGER_KEY_ENTRANCEEXAMS";
	private static final String PREFS_KEY_ENTRANCEEXAMS = "PREFS_KEY_ENTRANCEEXAMS";
	private boolean entranceExams = false;

	private ProgressManager() {

	}

	private static ProgressManager instance;

	public static ProgressManager getInstance() {
		if (null != instance) {
			return instance;
		} else {
			return new ProgressManager();
		}
	}

	public boolean getEntranceExams() {
		return getProgressFromStore();
	}

	public void setEntranceExams(boolean entranceExams) {
		this.entranceExams = entranceExams;
		setProgressToStore(this.entranceExams);
	}

	private boolean getProgressFromStore() {
		SharedPreferences settings = SudokuApplication.getInstance()
				.getSharedPreferences(PROGRESS_MANAGER_KEY_ENTRANCEEXAMS, 0);
		return settings.getBoolean(PREFS_KEY_ENTRANCEEXAMS, false);
	}

	private void setProgressToStore(boolean result) {
		SharedPreferences settings = SudokuApplication.getInstance()
				.getSharedPreferences(PROGRESS_MANAGER_KEY_ENTRANCEEXAMS, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(PREFS_KEY_ENTRANCEEXAMS, result);
		editor.commit();
	}

	public boolean studyProgress(int degreeId, int progress) {
		boolean theEnd = false;
		for (int i = 0; i < Degree.getSchoolSequence().length; i++) {
			if (Degree.getSchoolSequence()[i].degreeId == degreeId
					&& Degree.getSchoolSequence()[i].schoolLevel == DegreeManager
							.getDegree(LifeJourney.getInstance().getDegreeId())
							.getSchoolInfo().schoolLevel) {
				// 获取School实例
				School school = SchoolManager.getSchool(Degree
						.getSchoolSequence()[i]);
				// 当前学校的学习进程
				List<Examination> exams = Examination.getExaminationList(Degree
						.getSchoolSequence()[i].degreeId);
				Log.i("com.poxiao.suduko", "exam.size" + exams.size());
				if (progress < (exams.size() - 1)) {
					school.setProgress(progress);
					theEnd = false;
				} else if (progress == (exams.size() - 1)) {
					school.setProgress(0);
					LifeJourney.getInstance().setDegreeId(degreeId + 1);
					Log.i("com.poxiao.suduko", "一个阶段的考试结束，弹出升学考");
					theEnd = true;
				}

			}
		}
		return theEnd;
	}
}
