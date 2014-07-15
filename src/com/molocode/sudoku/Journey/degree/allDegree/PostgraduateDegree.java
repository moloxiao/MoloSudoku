package com.molocode.sudoku.Journey.degree.allDegree;

import com.molocode.sudoku.Journey.degree.Degree;

public class PostgraduateDegree extends Degree {
	public PostgraduateDegree() {
		super();
		this.id = Degree.POSTGRADUATE;
		this.name = Degree.getDegreeDesc(Degree.POSTGRADUATE);
	}
}
