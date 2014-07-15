package com.molocode.sudoku.Journey.degree;

public class PostgraduateDegree extends Degree {
	public PostgraduateDegree() {
		super();
		this.id = Degree.POSTGRADUATE;
		this.name = Degree.getDegreeDesc(Degree.POSTGRADUATE);
	}
}
