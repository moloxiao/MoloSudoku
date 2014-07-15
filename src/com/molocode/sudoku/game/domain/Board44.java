package com.molocode.sudoku.game.domain;

import java.util.HashSet;

import android.util.Log;

public class Board44 extends BaseBoard {

	public static final int CELLS_LENGTH = 16;
	public static final int SIZE = 4;
	private Cell[] cells;

	@Override
	public boolean initCells(Cell[] cells) {
		if (cells != null && cells.length == CELLS_LENGTH) {
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
		if (cells != null && cells.length > position) {
			return cells[position];
		}
		return null;
	}

	@Override
	public void updateCellInfo(int position, int number) {
		if (cells != null && cells.length > position) {
			cells[position].setNumber(number);
			if (success()) {
				Log.i("MOLO_DEBUG", "success");
				success.success();
			} else {
				Log.i("MOLO_DEBUG", "success not");
			}
		}
	}

	private boolean success() {
		// TODO 要检查 每个小宫格
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (cells[i * SIZE + j].getNumber() == Cell.NOTHING_IN_CELL) {
					Log.e("PX", "元素【i * SIZE + j】为空i=" + i + "j=" + j);
					return false;
				}
				set.add(cells[i * SIZE + j].getNumber());
			}
			if (set.size() != SIZE) {
				return false;
			}
			set.clear();
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				set.add(cells[i + j * SIZE].getNumber());
			}
			if (set.size() != SIZE) {
				return false;
			}
			set.clear();
		}

		return true;
	}
}
