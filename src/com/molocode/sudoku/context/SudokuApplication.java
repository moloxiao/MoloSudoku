package com.molocode.sudoku.context;

import android.app.Application;

public class SudokuApplication extends Application {

	private static SudokuApplication instance;
	
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}
	
	public static SudokuApplication getInstance() {
		return instance;
	}
}
