package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlayerInfoActivity extends Activity {

	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playerinfo_activity);
		
		initView();
	}
	
	private void initView() {
		tv = (TextView)findViewById(R.id.text_playerinfo);
		tv.setText(PlayerInfo.getPlayerInfo(this).getNickname());
	}

	public void btnStart(View view) {
		startActivity(new Intent(this, CopyListActivity.class));
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		// TODO : 处理游戏退出与信息存储
	}
}
