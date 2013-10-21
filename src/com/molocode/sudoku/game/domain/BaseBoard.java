package com.molocode.sudoku.game.domain;

public abstract class BaseBoard implements Board {

	protected SuccessSudoku success;
	
	public void registerSuccess(SuccessSudoku success) {
		this.success = success;
	}
	
	public static Cell[] getCellMap(int[] numbers) {
		if( !(numbers != null && numbers.length > 0) ) {
			return null;
		}
		Cell[] cells = new Cell[numbers.length];
		for(int i=0;i<numbers.length;i++) {
			cells[i] = new Cell(numbers[i], numbers[i]==Cell.NOTHING_IN_CELL?true:false);
		}
		return cells;
	}
	
}
