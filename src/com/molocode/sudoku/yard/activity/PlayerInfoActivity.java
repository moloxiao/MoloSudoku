package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayerInfoActivity extends Activity {

	private TextView tv;
	private ImageButton nameEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playerinfo_activity);
		initView();
	}

	private void initView() {
		tv = (TextView) findViewById(R.id.text_playerinfo);
		nameEdit = (ImageButton) findViewById(R.id.playerName_edit_btn);
		tv.setText(randomName());
	}

	private void savePlayerInfo() {
		// TODO 保存用户的信息，需要修改类PlayerInfo
	}

	private String randomName() {
		// TOOD 为首次登陆用户产生一个随机的名字
		String name = "逗比";
		return name;
	}

	public void btnStart(View view) {
		savePlayerInfo();
		startActivity(new Intent(this, CopyListActivity.class));
	}

	public void nameChange(View view) {
		// TODO 把光标移到文字输入框里
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		// TODO : 处理游戏退出与信息存储
	}
}
