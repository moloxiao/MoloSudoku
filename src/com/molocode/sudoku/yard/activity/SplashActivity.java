package com.molocode.sudoku.yard.activity;

import java.util.Timer;
import java.util.TimerTask;
import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;
import com.molocode.sudoku.game.GameActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
	// 简单粗暴的全局变量，记录用户是否首次登陆
	public static boolean firstLogin = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		Timer timer = new Timer();
		timer.schedule(task, 2000);
		firstLogin = PlayerInfo.getPlayerInfo(this).isIsfirstlogin();
	}

	private TimerTask task = new TimerTask() {
		@Override
		public void run() {
			// TODO 第一次登陆逻辑
			if (firstLogin) {
				startActivity(new Intent(SplashActivity.this,
						PlayerInfoActivity.class));
				PlayerInfo info = PlayerInfo.getPlayerInfo(SplashActivity.this);
				info.setIsfirstlogin(false);
				PlayerInfo.setPlayerInfo(SplashActivity.this, info);
				finish();
			} else {
				startActivity(new Intent(SplashActivity.this,
						SchoolTreeActivity.class));
				finish();
			}
		}
	};
}
