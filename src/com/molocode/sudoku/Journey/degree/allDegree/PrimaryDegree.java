package com.molocode.sudoku.Journey.degree.allDegree;

import com.molocode.sudoku.Journey.degree.Degree;

public class PrimaryDegree extends Degree {

	public PrimaryDegree() {
		super();
		this.id = Degree.PRIMARY;
		this.name = Degree.getDegreeDesc(Degree.PRIMARY);
		this.isRequireExamination = false;
	}
}
