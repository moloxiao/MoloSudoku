package com.molocode.sudoku.Journey.degree;

import com.molocode.sudoku.Journey.degree.allDegree.HighDegree;
import com.molocode.sudoku.Journey.degree.allDegree.MiddleDegree;
import com.molocode.sudoku.Journey.degree.allDegree.PostgraduateDegree;
import com.molocode.sudoku.Journey.degree.allDegree.PrimaryDegree;
import com.molocode.sudoku.Journey.degree.allDegree.UniversityDegree;

import android.util.Log;

public class DegreeManager {

	public static Degree getDegree(int degreeId) {
		switch (degreeId) {
		case Degree.PRIMARY:
			return new PrimaryDegree();
		case Degree.MIDDLE:
			return new MiddleDegree();
		case Degree.HIGH:
			return new HighDegree();
		case Degree.UNIVERSITY:
			return new UniversityDegree();
		case Degree.POSTGRADUATE:
			return new PostgraduateDegree();
		default:
			Log.e("com.poxiao.suduko", "无此学历,去火星看看");
			return null;
		}
	}
}
