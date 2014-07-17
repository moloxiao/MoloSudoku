package com.molocode.sudoku.game;

import java.util.Timer;
import java.util.TimerTask;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import com.hifreshday.android.pge.engine.Engine;
import com.hifreshday.android.pge.engine.options.EngineOptions;
import com.hifreshday.android.pge.engine.options.ScaleModel;
import com.hifreshday.android.pge.entity.scene.Scene;
import com.hifreshday.android.pge.ui.activity.BaseGameActivity;
import com.molocode.sudoku.R;
import com.molocode.sudoku.Journey.examination.Examination;
import com.molocode.sudoku.game.domain.Map;

public class GameActivity extends BaseGameActivity {

	public static final String EXTRA_MAPTYPE = "mapType";
	private int mapType;

	@Override
	public boolean coming() {
		mapType = getIntent().getIntExtra(EXTRA_MAPTYPE, 0);
		return true;
	}

	@Override
	public int getGameViewResId() {
		return R.id.gameview;
	}

	@Override
	public int getLayoutResId() {
		return R.layout.game_layout;
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
		return new Engine(new EngineOptions(getScreenWidth(),
				getScreenHeight(), ScaleModel.CONSTRAIN, true,
				EngineOptions.ORIENTATION_PORTPRAIT));
	}

	@Override
	public Scene onLoadScene() {
		PaintManager.initPaintManager(this);

		BaseSudokuScene screen = null;
		if (mapType == Map.MAP_TYPE_99_1) {
			screen = new GameScene99(this);
		} else if (mapType == Map.MAP_TYPE_66) {
			screen = new GameScene66(this);
		} else {
			screen = new GameScene44(this);
		}

		screen.onLoadResources(getResources(), null);
		screen.setScreenSize(EngineOptions.getScreenWidth(),
				EngineOptions.getScreenHeight());
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
