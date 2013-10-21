package com.molocode.sudoku.game.domain;

public class Cell {

	public static final int NOTHING_IN_CELL = 0;
	
	private int number;
	private boolean inputCell;
	
	public Cell(int number, boolean inputCell) {
		super();
		this.number = number;
		this.inputCell = inputCell;
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean isInputCell() {
		return inputCell;
	}
	
	public void setInputCell(boolean inputCell) {
		this.inputCell = inputCell;
	}
}
