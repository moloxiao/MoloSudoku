package com.molocode.sudoku.game;

import com.hifreshday.android.pge.engine.Engine;
import com.hifreshday.android.pge.engine.options.EngineOptions;
import com.hifreshday.android.pge.engine.options.ScaleModel;
import com.hifreshday.android.pge.entity.scene.Scene;
import com.hifreshday.android.pge.ui.activity.BaseGameActivity;
import com.molocode.sudoku.R;

public class GameActivity44 extends BaseGameActivity {
	
	public static final String EXTRA_LEVEL = "level";
	private int level;
	
	
	
	@Override
	public boolean coming() {
		level = getIntent().getIntExtra(EXTRA_LEVEL, 0);
		return true;
	}

	@Override
	public int getGameViewResId() {
		return R.id.gameview;
	}

	@Override
	public int getLayoutResId() {
		return R.layout.game_44;
	}

	@Override
	public int getSceneBgResId() {
		return R.drawable.bg;
	}

	@Override
	public void onLoadComplete() {
	}
	
	@Override
	public Engine onEngineLoaded() {
		return new Engine(
			new EngineOptions(
					getScreenWidth(), 
					getScreenHeight(), 
					ScaleModel.CONSTRAIN, 
					true, 
					EngineOptions.ORIENTATION_PORTPRAIT));
	}

	@Override
	public Scene onLoadScene() {
		PaintManager.initPaintManager(this);
		GameScene44 screen = new GameScene44(level, this);	// TODO : change magic number。 0代表第0关
        screen.onLoadResources(getResources(), null);	// TODO : change null object 
        screen.setScreenSize(
        		EngineOptions.getScreenWidth(), EngineOptions.getScreenHeight());
        screen.setBgResId(getResources(), getSceneBgResId());
		return screen;
	}

	@Override
	public void onPauseGame() {
	}

	@Override
	public void onResumeGame() {
	}
}
