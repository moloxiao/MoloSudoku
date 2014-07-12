package com.molocode.sudoku.game;

import com.molocode.sudoku.game.domain.BaseBoard;
import com.molocode.sudoku.game.domain.Map;
import com.molocode.sudoku.game.sprite.ChessControlPanelSprite;
import com.molocode.sudoku.game.sprite.Chessboard66Sprite;
import com.molocode.sudoku.game.sprite.CountdownSprite;
import com.molocode.sudoku.game.sprite.ExamFailSprite;
import com.molocode.sudoku.game.sprite.ExamSuccessSprite;
import com.molocode.sudoku.game.sprite.SettingBtnSprite;
import com.molocode.sudoku.game.sprite.SettingSprite;
import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

public class GameScene66 extends BaseSudokuScene {

	private Chessboard66Sprite chessboard66Sprite;
	private ChessControlPanelSprite chessControlPanelSprite;
	private SettingBtnSprite settingBtnSprite;
	private SettingSprite settingSprite;
	private ExamSuccessSprite successSprite;
	private ExamFailSprite failSprite;
	private CountdownSprite countdownSprite;
	 private float passTime=180;//过关时间
	
	public GameScene66(int level, Activity activity) {
		super(level, activity);
	}
	
	private void initSprite() {
		chessboard66Sprite = new Chessboard66Sprite(null, 
				Chessboard66Sprite.X, Chessboard66Sprite.Y, 
				Chessboard66Sprite.WIDTH, Chessboard66Sprite.HEIGHT);
		chessboard66Sprite.initCells( BaseBoard.getCellMap(Map.getCellMaps(Map.MAP_TYPE_66, level)) );
		attachChild(chessboard66Sprite);
		
		countdownSprite = new CountdownSprite(null, 
				CountdownSprite.X, CountdownSprite.Y, 
				CountdownSprite.WIDTH, CountdownSprite.HEIGHT,passTime);
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
		
		successSprite = new ExamSuccessSprite(null, 
				ExamSuccessSprite.X, ExamSuccessSprite.Y, 
				ExamSuccessSprite.WIDTH, ExamSuccessSprite.HEIGHT);
		attachChild(successSprite);
		
		failSprite= new ExamFailSprite(null, ExamFailSprite.X, ExamFailSprite.Y,
				ExamFailSprite.WIDTH, ExamFailSprite.HEIGHT);
		attachChild(failSprite);
		
		settingSprite = new SettingSprite(null, 
				SettingSprite.X, SettingSprite.Y, 
				SettingSprite.WIDTH, SettingSprite.HEIGHT);
		attachChild(settingSprite);
		
		initTouch();
	}

	private void initTouch() {
		registerTouch(successSprite);
		registerTouch(settingSprite);
		registerTouch(chessboard66Sprite);
		registerTouch(chessControlPanelSprite);
		registerTouch(settingBtnSprite);
		registerTouch(failSprite);
		
	}

	@Override
	public void updateUiNumberChangeRequest(int number) {
		chessboard66Sprite.numberChangeRequest(number);
	}

	@Override
	public void updateUiSuccessGame() {
		Log.i("MOLO_DEBUG", "success game on scene66");
		successSprite.setVisible(true);
	}

	@Override
	public void updateUiShowSetting() {
		settingSprite.setVisible(true);
	}

	@Override
	public void reStartGame() {
		chessboard66Sprite.initCells( BaseBoard.getCellMap(Map.getCellMaps(Map.MAP_TYPE_66, level)) );
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
