package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class SchoolTreeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置学校路线界面
		setContentView(R.layout.shooltree_activity);
		showAdmission();
	}

	// TODO 首次登陆的用户弹出欢迎入学界面
	private void showAdmission() {
		AlertDialog.Builder builder = new Builder(SchoolTreeActivity.this);
		builder.setMessage("恭喜你已经被逗比小学录取，是否参加为期六年的逗比之旅");
		builder.setTitle("录取通知");
		builder.setPositiveButton("我要成为逗比", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				startActivity(new Intent(SchoolTreeActivity.this,
						CourseTreeActivity.class));
			}
		});
		builder.setNegativeButton("辍学", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.create().show();
	}
}