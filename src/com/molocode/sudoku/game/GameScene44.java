package com.molocode.sudoku.game;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import com.molocode.sudoku.game.domain.BaseBoard;
import com.molocode.sudoku.game.domain.Map;
import com.molocode.sudoku.game.sprite.ChessControlPanelSprite;
import com.molocode.sudoku.game.sprite.Chessboard44Sprite;
import com.molocode.sudoku.game.sprite.CountdownSprite;
import com.molocode.sudoku.game.sprite.ResultSprite;
import com.molocode.sudoku.game.sprite.SettingBtnSprite;
import com.molocode.sudoku.game.sprite.SettingSprite;

public class GameScene44 extends BaseSudokuScene {

	public GameScene44(int level, Activity activity) {
		super(level, activity);
	}

	private Chessboard44Sprite chessboard44Sprite;
	private ChessControlPanelSprite chessControlPanelSprite;
	private SettingBtnSprite settingBtnSprite;
	private SettingSprite settingSprite;
	private ResultSprite resultSprite;
	private CountdownSprite countdownSprite;
	

	private void initSprite() {
		chessboard44Sprite = new Chessboard44Sprite(null, 
				Chessboard44Sprite.X, Chessboard44Sprite.Y, 
				Chessboard44Sprite.WIDTH, Chessboard44Sprite.HEIGHT);
		chessboard44Sprite.initCells( BaseBoard.getCellMap(Map.getCellMaps(Map.MAP_TYPE_44, level)) );
		attachChild(chessboard44Sprite);
		
		countdownSprite = new CountdownSprite(null, 
				CountdownSprite.X, CountdownSprite.Y, 
				CountdownSprite.WIDTH, CountdownSprite.HEIGHT);
		attachChild(countdownSprite);
		
		chessControlPanelSprite = new ChessControlPanelSprite(null, 
				ChessControlPanelSprite.X, ChessControlPanelSprite.Y, 
				ChessControlPanelSprite.WIDTH, ChessControlPanelSprite.HEIGHT,
				true);
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
		registerTouch(chessboard44Sprite);
		registerTouch(chessControlPanelSprite);
		registerTouch(settingBtnSprite);
		
	}

	@Override
	public void onUnloadResources() {
		// TODO 需要手动释放的资源
		
	}
	
	@Override
	public void updateUiNumberChangeRequest(int number) {
		chessboard44Sprite.numberChangeRequest(number);
	}
	
	@Override
	public void updateUiSuccessGame() {
		Log.i("MOLO_DEBUG", "success game on scene44");
		resultSprite.setVisible(true);
	}
	
	@Override
	public void updateUiShowSetting() {
		settingSprite.setVisible(true);
	}

	@Override
	public void reStartGame() {
		chessboard44Sprite.initCells( BaseBoard.getCellMap(Map.getCellMaps(Map.MAP_TYPE_44, level)) );
		countdownSprite.cleanCountTime();
	}

	@Override
	public void onLoadResources(Resources res, AssetManager assertManager) {
		initSprite();
	}

	/**
	 * 下一局
	 */
	@Override
	public void next() {
		level++;
		reStartGame();
	}
}
