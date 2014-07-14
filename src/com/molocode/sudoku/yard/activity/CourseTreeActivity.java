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
import android.widget.Button;

public class CourseTreeActivity extends Activity {
	private static boolean isFirstLogin = true;
	public static String DEGREE_ID = "DEGREE_ID";
	private Button[] btns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置课程树
		setContentView(R.layout.coursetree_activity);
		if (isFirstLogin) {
			showExamination();
		}
		// 根据degreeId来获取当前学校下的所有考试科目
		getIntent().getExtras().get(DEGREE_ID);
	}

	private void initData() {
		btns = new Button[] { (Button) findViewById(R.id.course_btn_1),
				(Button) findViewById(R.id.course_btn_2),
				(Button) findViewById(R.id.course_btn_3),
				(Button) findViewById(R.id.course_btn_4),
				(Button) findViewById(R.id.course_btn_5),
				(Button) findViewById(R.id.course_btn_6), };

	}

	// 首次登陆的用户弹考试界面
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
}
