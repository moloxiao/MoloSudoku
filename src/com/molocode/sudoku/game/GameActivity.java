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
import com.molocode.sudoku.game.domain.Map;

public class GameActivity extends BaseGameActivity {

	public static final String EXTRA_LEVEL = "level";
	public static final String EXTRA_DIFICUTY = "dificuty";
	private int dificuty;
	private int level;

	@Override
	public boolean coming() {
		level = getIntent().getIntExtra(EXTRA_LEVEL, 0);
		dificuty = getIntent().getIntExtra(EXTRA_DIFICUTY, 0);
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
		if (dificuty == Map.MAP_TYPE_99_1) {
			screen = new GameScene99(level, this);
		} else if (dificuty == Map.MAP_TYPE_66) {
			screen = new GameScene66(level, this);
		} else {
			screen = new GameScene44(level, this);
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

	public void showExamInfo() {
		this.runOnUiThread(new Runnable() {
			public void run() {
			  AlertDialog.Builder builder = new Builder(
						GameActivity.this);
				// TODO 考试信息
				builder.setMessage("逗比小学1年级期末考试");
				builder.setTitle("考试信息");
				final Dialog dialog=builder.create();
				dialog.show();
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						dialog.dismiss();
					}

				};
				timer.schedule(task, 3000);
			}
		});
	}
}
