package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;
import com.molocode.sudoku.game.GameActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class CourseTreeActivity extends Activity {
	private static boolean isFirstLogin = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置课程树
		setContentView(R.layout.coursetree_activity);
		if (isFirstLogin) {
			showExamination();
		}
	}

	// TODO 首次登陆的用户弹考试界面
	private void showExamination() {
		AlertDialog.Builder builder = new Builder(CourseTreeActivity.this);
		builder.setMessage("经过一个学年的学习，接下来要检测一下你的逗比程度");
		builder.setTitle("考试");
		builder.setPositiveButton("参加期末考", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Intent intent = new Intent(CourseTreeActivity.this,
						GameActivity.class);
				intent.putExtra(GameActivity.EXTRA_LEVEL, 0);
				intent.putExtra(GameActivity.EXTRA_DIFICUTY, 0);
				startActivity(intent);
			}
		});
		builder.setNegativeButton("回家放羊", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.create().show();

	}

	// TODO 点击参加考试按钮，进入游戏界面
	private void enterExamination() {

	}
}
