package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;
import com.molocode.sudoku.game.GameActivity44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CopyListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.copy_list_activity);
	}
	
	public void btnLevel1(View view) {
		startActivity(new Intent(this, LevelActivity.class));
	}
}
