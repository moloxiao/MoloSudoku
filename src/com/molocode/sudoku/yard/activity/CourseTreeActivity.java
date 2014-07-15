package com.molocode.sudoku.yard.activity;

import java.util.ArrayList;
import java.util.List;

import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;
import com.molocode.sudoku.game.GameActivity;
import com.molocode.sudoku.game.domain.Examination;
import com.molocode.sudoku.game.domain.School;

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
	public static String SCHOOL_ID = "SCHOOL_ID";
	private Button[] btns;
	private int schoolId;
	private int grade;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置课程树
		setContentView(R.layout.coursetree_activity);
		// 根据degreeId来获取当前学校下的所有考试科目
		schoolId = (Integer) getIntent().getExtras().get(SCHOOL_ID);
		initData();
		if (SplashActivity.firstLogin) {
			showExamination();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		grade = PlayerInfo.getPlayerInfo(CourseTreeActivity.this).getGrade();
		initMap(schoolId);
	}

	// 根据学校ID初始化考试信息
	private void initMap(int schoolId) {
		List<Examination> exams = new ArrayList<Examination>();
		exams = School.getExaminationlistById(schoolId);// 考试列表
		setMapView(exams);
	}

	private void setMapView(List<Examination> exams) {
		if (exams.size() > btns.length) {
			Log.e("com.poxiao.suduko", "考试地图配置出问题了，请检查");
			return;
		}
		for (int i = 0; i < exams.size(); i++) {
			setBtnPorperty(btns[i], exams.get(i), grade);
		}
	}

	private void setBtnPorperty(Button btn, final Examination exam, int examId) {
		btn.setText(exam.getExaminationName());
		if (exam.getExamLevel() == examId) {
			// 当前级别的考试,按钮高亮
			exam.setExamType(Examination.EXAMTYPE_CURRENT);
			btn.setBackgroundResource(R.drawable.btn_highlight);
			btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(CourseTreeActivity.this,
							GameActivity.class);
					intent.putExtra(GameActivity.EXTRA_LEVEL, exam.getMapId());
					intent.putExtra(GameActivity.EXTRA_DIFICUTY,
							exam.getMapType());
					startActivity(intent);
				}
			});
		} else if (exam.getExamLevel() > examId) {
			exam.setExamType(Examination.EXAMTYPE_ERRORLEVEL);
			btn.setBackgroundResource(R.drawable.btn_disable);
			btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					showHintDialog(Examination.EXAMTYPE_ERRORLEVEL);
				}
			});
		} else {
			exam.setExamType(Examination.EXAMTYPE_PASSED);
			btn.setBackgroundResource(R.drawable.btn_disable);
			btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					showHintDialog(Examination.EXAMTYPE_PASSED);
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
