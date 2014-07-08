package com.molocode.sudoku.domain.ai;

public class NotifyCell {
	public int position;
	public int number;
	public boolean isRight;
	
	public NotifyCell(int position, int number, boolean isRight) {
		super();
		this.position = position;
		this.number = number;
		this.isRight = isRight;
	}
	
	
}
