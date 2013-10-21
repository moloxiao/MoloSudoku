package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;
import com.molocode.sudoku.game.GameActivity44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LevelActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_activity);
		// TODO : 用列表显示十个关卡
		initView();
	}

	private void initView() {	
	}
	
	public void btnLevel1(View view) {
		// TODO : 传入关卡参数
		startActivity(new Intent(this, GameActivity44.class));
	}
	
}
