package com.molocode.sudoku.Journey.school;

import java.util.List;

import android.util.Log;

import com.molocode.sudoku.Journey.LifeJourney;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.examination.Examination;

public class ProgressManager {

	public static void setScoolProgress(int degreeId, int schoolLevel,
			int progress) {
		for (int i = 0; i < Degree.getSchoolSequence().length; i++) {

			if (Degree.getSchoolSequence()[i].degreeId == degreeId
					&& Degree.getSchoolSequence()[i].schoolLevel == schoolLevel) {
				// 获取School实例
				School school = SchoolManager.getSchool(Degree
						.getSchoolSequence()[i]);
				// 当前学校的学习进程
				List<Examination> exams = Examination.getExaminationList(Degree
						.getSchoolSequence()[i].degreeId);
				Log.i("com.poxiao.suduko", "exam.size" + exams.size());
				if (progress < exams.size()) {
					school.setProgress(progress + 1);
				} else if (progress == exams.size()) {
					school.setProgress(0);
					LifeJourney.getInstance().setDegreeId(degreeId + 1);
				}

			}
		}
	}
}
