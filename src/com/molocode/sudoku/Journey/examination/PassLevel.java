package com.molocode.sudoku.Journey.examination;

/**
 * 考试成绩的评分等级，单位是秒
 * @author molo
 *
 */
public class PassLevel {
	public int pass;
	public int good;
	public int perfect;
	
	public PassLevel(int pass, int good, int perfect) {
		super();
		this.pass = pass;
		this.good = good;
		this.perfect = perfect;
	}
	
}
