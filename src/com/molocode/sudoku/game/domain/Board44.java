package com.molocode.sudoku.game.domain;

import java.util.HashSet;

import android.util.Log;

public class Board44 extends BaseBoard {

	public static final int CELLS_LENGTH = 16;
	
	private Cell[] cells;
	
	@Override
	public boolean initCells(Cell[] cells) {
		if(cells != null && 
				cells.length == CELLS_LENGTH) {
			this.cells = cells;
			return true;
		}
		return false;
	}

	@Override
	public int getCellsCount() {
		return CELLS_LENGTH;
	}

	@Override
	public Cell getCells(int position) {
		if(cells != null && cells.length > position) {
			return cells[position];
		}
		return null;
	}

	@Override
	public void updateCellInfo(int position, int number) {
		if(cells != null && cells.length > position) {
			cells[position].setNumber(number);
			if(success()) {
				Log.i("MOLO_DEBUG", "success");
				success.success();
			}else {
				Log.i("MOLO_DEBUG", "success not");
			}
		}
	}

	private boolean success() {
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(cells[i*4 + j].getNumber() == Cell.NOTHING_IN_CELL) {
					return false;
				}
				set.add(cells[i*4 + j].getNumber());
			}
			if(set.size() != 4) {
				return false;
			}
			set.clear();
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				set.add(cells[i + j*4].getNumber());
			}
			if(set.size() != 4) {
				return false;
			}
			set.clear();
		}
		
		return true;
	}
}
