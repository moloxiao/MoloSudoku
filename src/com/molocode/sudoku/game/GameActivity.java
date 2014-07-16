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
	public static final String EXTRA_EXAMINFO = "examinfo";
	private int mapType;
	private String[] examinfo;

	@Override
	public boolean coming() {
		mapType = getIntent().getIntExtra(EXTRA_MAPTYPE, 0);
		examinfo = getIntent().getStringArrayExtra(EXTRA_EXAMINFO);
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
			screen = new GameScene99(examinfo, this);
		} else if (mapType == Map.MAP_TYPE_66) {
			screen = new GameScene66(examinfo, this);
		} else {
			screen = new GameScene44(examinfo, this);
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

	public void showExamInfo(Examination examination) {
		this.runOnUiThread(new Runnable() {
			public void run() {
				AlertDialog.Builder builder = new Builder(GameActivity.this);
				// TODO 考试信息
				builder.setMessage("逗比小学1年级期末考试");
				builder.setTitle("考试信息");
				final Dialog dialog = builder.create();
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
