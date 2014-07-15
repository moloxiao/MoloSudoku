package com.molocode.sudoku.Journey.degree.allDegree;

import com.molocode.sudoku.Journey.degree.Degree;

public class UniversityDegree extends Degree {
	public UniversityDegree() {
		super();
		this.id = Degree.UNIVERSITY;
		this.name = Degree.getDegreeDesc(Degree.UNIVERSITY);
	}
}
