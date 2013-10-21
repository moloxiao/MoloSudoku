package com.molocode.sudoku.game.domain;

public interface Board {

	boolean initCells(Cell[] cells);
	int getCellsCount();
	Cell getCells(int position);
	void updateCellInfo(int position, int number);
}
