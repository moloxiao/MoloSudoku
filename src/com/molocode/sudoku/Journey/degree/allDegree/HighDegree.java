package com.molocode.sudoku.Journey.degree.allDegree;

import com.molocode.sudoku.Journey.degree.Degree;

public class HighDegree extends Degree {
	public HighDegree() {
		super();
		this.id = Degree.HIGH;
		this.name = Degree.getDegreeDesc(Degree.HIGH);
		this.isRequireExamination = true;
	}
}
