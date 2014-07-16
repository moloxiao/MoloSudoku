package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;
import com.molocode.sudoku.Journey.degree.Degree;
import com.molocode.sudoku.Journey.school.School;
import com.molocode.sudoku.Journey.school.SchoolInfo;
import com.molocode.sudoku.Journey.school.SchoolManager;
import com.molocode.sudoku.domain.PlayerInfo;
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
	private int currentSchoolId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置学校路线界面
		setContentView(R.layout.shooltree_activity);
		PlayerInfo info = PlayerInfo.getPlayerInfo(this);
		Log.e("com.poxiao.suduko", "player_currentSchoolId=" + currentSchoolId);
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
		// for(int i=0;i<LifeJourney.getDegreeSequence().length;i++){
		// for(int j=0;j<School.LEVEL_MAX;j++){
		// }
		// }
		for (int i = 0; i < Degree.getSchoolSequence().length; i++) {
			final SchoolInfo info = Degree.getSchoolSequence()[i];
			final School buffer = SchoolManager.getSchool(info);
			Log.i("com.poxiao.suduko", "i=" + i + ";name=" + buffer.getName());
			btns[i].setText(buffer.getName());
			btns[i].setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(SchoolTreeActivity.this,
							CourseTreeActivity.class);
					intent.putExtra(CourseTreeActivity.DEGREE_ID, info.degreeId);
					intent.putExtra(CourseTreeActivity.SCHOOLLEVEL,
							info.schoolLevel);
					intent.putExtra(CourseTreeActivity.SCHOOLPROGRESS,
							buffer.getProgress());
					startActivity(intent);
				}
			});
		}

	}

	// 择校通知
	private void showHitDialog(final int schoolId) {
		AlertDialog.Builder builder = new Builder(SchoolTreeActivity.this);
		builder.setMessage("恭喜你已经被逗比小学录取，是否参加为期六年的逗比之旅");
		builder.setTitle("转学通知");
		builder.setPositiveButton("转学", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				currentSchoolId = schoolId;
				Log.e("com.poxiao.suduko", "currentSchoolId2="
						+ currentSchoolId);
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
}