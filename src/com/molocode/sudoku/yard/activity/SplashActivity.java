package com.molocode.sudoku.yard.activity;

import java.util.Timer;
import java.util.TimerTask;
import com.molocode.sudoku.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);

		Timer timer = new Timer();
		timer.schedule(task, 2000);
	}

	private TimerTask task = new TimerTask() {
		@Override
		public void run() {
			// 程序原先的流程
			startActivity(new Intent(SplashActivity.this,
					PlayerInfoActivity.class));
			finish();
		}
	};
}
