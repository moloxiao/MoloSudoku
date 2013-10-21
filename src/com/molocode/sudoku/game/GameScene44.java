package com.molocode.sudoku.game;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import com.hifreshday.android.pge.entity.scene.BitmapBgScreen;
import com.molocode.sudoku.game.domain.BaseBoard;
import com.molocode.sudoku.game.domain.Map;
import com.molocode.sudoku.game.sprite.ChessControlPanelSprite;
import com.molocode.sudoku.game.sprite.Chessboard44Sprite;
import com.molocode.sudoku.game.sprite.CountdownSprite;
import com.molocode.sudoku.game.sprite.SettingBtnSprite;
import com.molocode.sudoku.game.sprite.SettingSprite;

public class GameScene44 extends BitmapBgScreen {

	private Chessboard44Sprite chessboard44Sprite;
	private ChessControlPanelSprite chessControlPanelSprite;
	private SettingBtnSprite settingBtnSprite;
	private SettingSprite settingSprite;
	private CountdownSprite countdownSprite;
	
	private Activity activity;
	
	private int level;
	
	public GameScene44(int level, Activity activity) {
		super();
		this.level = level;
		this.activity = activity;
	}

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
				ChessControlPanelSprite.WIDTH, ChessControlPanelSprite.HEIGHT);
		attachChild(chessControlPanelSprite);
		
		
		settingBtnSprite = new SettingBtnSprite(null, 
				SettingBtnSprite.X, SettingBtnSprite.Y, 
				SettingBtnSprite.WIDTH, SettingBtnSprite.HEIGHT);
		attachChild(settingBtnSprite);
		
		
		settingSprite = new SettingSprite(null, 
				SettingSprite.X, SettingSprite.Y, 
				SettingSprite.WIDTH, SettingSprite.HEIGHT);
		attachChild(settingSprite);
		
		initTouch();
	}

	private void initTouch() {
		registerTouch(settingSprite);
		registerTouch(chessboard44Sprite);
		registerTouch(chessControlPanelSprite);
		registerTouch(settingBtnSprite);
		
	}

	@Override
	public void onUnloadResources() {
		// TODO 需要手动释放的资源
		
	}
	
	
	public void updateUiNumberChangeRequest(int number) {
		chessboard44Sprite.numberChangeRequest(number);
	}
	
	public void updateUiSuccessGame() {
		// TODO : 成功完成一局游戏
		// 弹出结算信息
		// 停止计时器
		Log.i("MOLO_DEBUG", "success game");
	}
	
	public void updateUiShowSetting() {
		settingSprite.setVisible(true);
	}
	
	public void quitGame() {
		activity.finish();
	}

	public void reStartGame() {
		chessboard44Sprite.initCells( BaseBoard.getCellMap(Map.getCellMaps(Map.MAP_TYPE_44, level)) );
	}

	@Override
	public void onLoadResources(Resources res, AssetManager assertManager) {
		initSprite();
	}
}
