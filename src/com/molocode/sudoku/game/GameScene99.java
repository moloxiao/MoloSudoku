package com.molocode.sudoku.game;

import com.molocode.sudoku.game.domain.BaseBoard;
import com.molocode.sudoku.game.domain.Map;
import com.molocode.sudoku.game.sprite.ChessControlPanelSprite;
import com.molocode.sudoku.game.sprite.Chessboard99Sprite;
import com.molocode.sudoku.game.sprite.CountdownSprite;
import com.molocode.sudoku.game.sprite.ResultSprite;
import com.molocode.sudoku.game.sprite.SettingBtnSprite;
import com.molocode.sudoku.game.sprite.SettingSprite;
import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

public class GameScene99 extends BaseSudokuScene {

	private Chessboard99Sprite chessboard99Sprite;
	private ChessControlPanelSprite chessControlPanelSprite;
	private SettingBtnSprite settingBtnSprite;
	private SettingSprite settingSprite;
	private ResultSprite resultSprite;
	private CountdownSprite countdownSprite;
	
	public GameScene99(int level, Activity activity) {
		super(level, activity);
	}
	
	private void initSprite() {
		chessboard99Sprite = new Chessboard99Sprite(null, 
				Chessboard99Sprite.X, Chessboard99Sprite.Y, 
				Chessboard99Sprite.WIDTH, Chessboard99Sprite.HEIGHT);
		chessboard99Sprite.initCells( BaseBoard.getCellMap(Map.getCellMaps(Map.MAP_TYPE_99, level)) );
		attachChild(chessboard99Sprite);
		
		countdownSprite = new CountdownSprite(null, 
				CountdownSprite.X, CountdownSprite.Y, 
				CountdownSprite.WIDTH, CountdownSprite.HEIGHT);
		attachChild(countdownSprite);
		
		chessControlPanelSprite = new ChessControlPanelSprite(null, 
				ChessControlPanelSprite.X, ChessControlPanelSprite.Y, 
				ChessControlPanelSprite.WIDTH, ChessControlPanelSprite.HEIGHT_2,
				false);
		attachChild(chessControlPanelSprite);
		
		
		settingBtnSprite = new SettingBtnSprite(null, 
				SettingBtnSprite.X, SettingBtnSprite.Y, 
				SettingBtnSprite.WIDTH, SettingBtnSprite.HEIGHT);
		attachChild(settingBtnSprite);
		
		resultSprite = new ResultSprite(null, 
				ResultSprite.X, ResultSprite.Y, 
				ResultSprite.WIDTH, ResultSprite.HEIGHT);
		attachChild(resultSprite);
		
		settingSprite = new SettingSprite(null, 
				SettingSprite.X, SettingSprite.Y, 
				SettingSprite.WIDTH, SettingSprite.HEIGHT);
		attachChild(settingSprite);
		
		initTouch();
	}

	private void initTouch() {
		registerTouch(resultSprite);
		registerTouch(settingSprite);
		registerTouch(chessboard99Sprite);
		registerTouch(chessControlPanelSprite);
		registerTouch(settingBtnSprite);
		
	}

	@Override
	public void updateUiNumberChangeRequest(int number) {
		chessboard99Sprite.numberChangeRequest(number);
	}

	@Override
	public void updateUiSuccessGame() {
		Log.i("MOLO_DEBUG", "success game on scene99");
		resultSprite.setVisible(true);
	}

	@Override
	public void updateUiShowSetting() {
		settingSprite.setVisible(true);
	}

	@Override
	public void reStartGame() {
		chessboard99Sprite.initCells( BaseBoard.getCellMap(Map.getCellMaps(Map.MAP_TYPE_99, level)) );
		countdownSprite.cleanCountTime();
	}

	@Override
	public void next() {
		level++;
		reStartGame();
	}

	@Override
	public void onLoadResources(Resources res, AssetManager assertManager) {
		initSprite();

	}

	@Override
	public void onUnloadResources() {
	}

}
