package com.molocode.sudoku.yard.activity;

import java.util.List;
import com.molocode.sudoku.R;
import com.molocode.sudoku.Journey.LifeJourney;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.degree.DegreeManager;
import com.molocode.sudoku.Journey.examination.Examination;
import com.molocode.sudoku.Journey.examination.PassLevel;
import com.molocode.sudoku.Journey.school.SchoolInfo;
import com.molocode.sudoku.Journey.school.SchoolManager;
import com.molocode.sudoku.game.GameActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CourseTreeActivity extends Activity {

	private Button[] btns;
	private int degreeId;
	private int schoolLevel;
	private int schoolprogress;
	private int mapType;
	private String[] examinfo;

	public static String SCHOOLLEVEL = "SCHOOLLEVEL";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置课程树
		setContentView(R.layout.coursetree_activity);
		// 根据degreeId来获取当前学校下的所有考试科目
		initData();
		if (SplashActivity.firstLogin) {
			showExamination();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("com.poxiao.suduko", "onResume");
		initMap();
	}

	// 根据学校ID初始化考试信息
	private void initMap() {
		degreeId = LifeJourney.getInstance().getDegreeId();
		for (int i = 0; i < Degree.getSchoolSequence().length; i++) {
			SchoolInfo info = Degree.getSchoolSequence()[i];
			if (degreeId == info.degreeId && schoolLevel == info.schoolLevel) {
				schoolprogress = SchoolManager.getSchool(info).getProgress();
			}
		}
		Log.i("com.poxiao.suduko", "CourseTreeActivity degreeId=" + degreeId);
		List<Examination> exams = Examination.getExaminationList(degreeId);
		for (int i = 0; i < exams.size(); i++) {
			mapType = exams.get(i).getMapType();
			examinfo = new String[] { String.valueOf(degreeId),
					String.valueOf(schoolLevel),
					String.valueOf(schoolprogress), };
			btns[i].setText(exams.get(i).getExaminationName());
			if (i == schoolprogress) {
				btns[i].setBackgroundResource(R.drawable.btn_highlight);
			} else {
				btns[i].setBackgroundResource(R.drawable.btn_disable);
			}
			btns[i].setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(CourseTreeActivity.this,
							GameActivity.class);
					intent.putExtra(GameActivity.EXTRA_MAPTYPE, mapType);
					intent.putExtra(GameActivity.EXTRA_EXAMINFO, examinfo);
					startActivity(intent);
				}
			});
		}
	}

	private void showHintDialog(int type) {
		AlertDialog.Builder builder = new Builder(CourseTreeActivity.this);
		builder.setTitle("提醒");
		switch (type) {
		case 1:
			builder.setMessage("你必须先通过当前的考试才可以解锁");
			builder.setPositiveButton("继续努力", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			break;
		case 2:
			builder.setMessage("作为学长的你不允许回去欺负学弟");
			builder.setPositiveButton("好吧", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			break;

		default:
			break;
		}
		builder.create().show();
	}

	private void initData() {
		schoolLevel = (Integer) getIntent().getExtras().get(SCHOOLLEVEL);
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
				intent.putExtra(GameActivity.EXTRA_MAPTYPE, mapType);
				intent.putExtra(GameActivity.EXTRA_EXAMINFO, examinfo);
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
