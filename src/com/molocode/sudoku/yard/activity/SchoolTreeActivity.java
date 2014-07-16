package com.molocode.sudoku.yard.activity;

import java.util.List;

import com.molocode.sudoku.R;
import com.molocode.sudoku.Journey.LifeJourney;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.degree.DegreeManager;
import com.molocode.sudoku.Journey.examination.ExamScore;
import com.molocode.sudoku.Journey.examination.Examination;
import com.molocode.sudoku.Journey.school.ProgressManager;
import com.molocode.sudoku.Journey.school.School;
import com.molocode.sudoku.Journey.school.SchoolInfo;
import com.molocode.sudoku.Journey.school.SchoolManager;
import com.molocode.sudoku.domain.PlayerInfo;
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

public class SchoolTreeActivity extends Activity {

	private Button[] btns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置学校路线界面
		setContentView(R.layout.shooltree_activity);
		initData();
		setMapBySchools();
		// 是否初次登陆，是展示对话框
		if (SplashActivity.firstLogin) {
			showAdmission();
		} else {
			// Intent intent = new Intent(SchoolTreeActivity.this,
			// CourseTreeActivity.class);
			// intent.putExtra(CourseTreeActivity.SCHOOL_ID, currentSchoolId);
			// startActivity(intent);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (ProgressManager.getInstance().getEntranceExams()) {
			if (ExamScore.getInstance().getExamScore() > 0) {
				// TODO 显示学校选着界面
				// TODO 清除升学考状态
			} else {
				// 显示补考界面
			}
			showEnteranceDialog();// TODO 只显示一次
		}
	}

	// 首次登陆的用户弹出欢迎入学界面
	private void showAdmission() {
		AlertDialog.Builder builder = new Builder(SchoolTreeActivity.this);
		builder.setMessage("恭喜你已经被逗比小学录取，是否参加为期六年的逗比之旅");
		builder.setTitle("录取通知");
		builder.setPositiveButton("我要成为逗比", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Intent intent = new Intent(SchoolTreeActivity.this,
						CourseTreeActivity.class);
				startActivity(intent);
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

	private void initData() {
		btns = new Button[] { (Button) findViewById(R.id.Button1),
				(Button) findViewById(R.id.Button2),
				(Button) findViewById(R.id.Button3),
				(Button) findViewById(R.id.Button4),
				(Button) findViewById(R.id.Button5),
				(Button) findViewById(R.id.Button6),
				(Button) findViewById(R.id.Button7),
				(Button) findViewById(R.id.Button8),
				(Button) findViewById(R.id.Button9),
				(Button) findViewById(R.id.Button10),
				(Button) findViewById(R.id.Button11),
				(Button) findViewById(R.id.Button12),
				(Button) findViewById(R.id.Button13),
				(Button) findViewById(R.id.Button14),
				(Button) findViewById(R.id.Button15), };
	}

	// 拼装学校地图
	private void setMapBySchools() {
		for (int i = 0; i < Degree.getSchoolSequence().length; i++) {
			SchoolInfo info = Degree.getSchoolSequence()[i];
			School buffer = SchoolManager.getSchool(info);
			Log.i("com.poxiao.suduko", "i=" + i + ";name=" + buffer.getName());
			btns[i].setText(buffer.getName());
			btns[i].setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(SchoolTreeActivity.this,
							CourseTreeActivity.class);
					startActivity(intent);
				}
			});
		}

	}

	// 择校通知
	private void showHitDialog(final int schoolId) {
		AlertDialog.Builder builder = new Builder(SchoolTreeActivity.this);
		builder.setMessage("隔壁学校在招手");
		builder.setTitle("转学通知");
		builder.setPositiveButton("转学", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				// 保存用户的当前学校
				PlayerInfo player = PlayerInfo
						.getPlayerInfo(SchoolTreeActivity.this);
				PlayerInfo.setPlayerInfo(SchoolTreeActivity.this, player);
				Intent intent = new Intent(SchoolTreeActivity.this,
						CourseTreeActivity.class);
				startActivity(intent);
			}
		});
		builder.setNegativeButton("留校", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Intent intent = new Intent(SchoolTreeActivity.this,
						CourseTreeActivity.class);
				startActivity(intent);
			}
		});
		builder.create().show();

	}

	// 择校通知
	private void showEnteranceDialog() {
		AlertDialog.Builder builder = new Builder(SchoolTreeActivity.this);
		builder.setMessage("小哥，我看你骨骼清奇，去初中念书吧");
		builder.setTitle("升学");
		builder.setPositiveButton("参加升学考", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				List<Examination> exam = Examination
						.getEnterDegreeExaninationList(LifeJourney
								.getInstance().getDegreeId());
				Intent intent = new Intent(SchoolTreeActivity.this,
						GameActivity.class);
				intent.putExtra(GameActivity.EXTRA_MAPTYPE, exam.get(0)
						.getMapType());
				startActivity(intent);
				dialog.dismiss();
			}
		});
		builder.setNegativeButton("不读了", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.create().show();

	}
}