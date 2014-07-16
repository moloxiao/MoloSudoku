package com.molocode.sudoku.game;

import android.app.Activity;

import com.hifreshday.android.pge.entity.scene.BitmapBgScreen;

public abstract class BaseSudokuScene extends BitmapBgScreen {

	protected Activity activity;

	public BaseSudokuScene(String[] examinfo, Activity activity) {
		super();
		this.activity = activity;
	}

	public void quitGame() {
		activity.finish();
	}

	public abstract void updateUiNumberChangeRequest(int number);

	public abstract void updateUiSuccessGame();

	public abstract void updateUiShowSetting();

	public abstract void reStartGame();

	public abstract void next();
}
