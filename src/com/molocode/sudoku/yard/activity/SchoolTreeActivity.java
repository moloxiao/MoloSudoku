package com.molocode.sudoku.yard.activity;

import java.util.List;

import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;
import com.molocode.sudoku.game.domain.Degree;
import com.molocode.sudoku.game.domain.LifeJourney;
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

public class SchoolTreeActivity extends Activity {

	private Button[] imgbtns;
	private LifeJourney life;
	private int currentSchoolId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置学校路线界面
		setContentView(R.layout.shooltree_activity);
		initData();
		initMap();
		// 是否初次登陆，是展示对话框
		PlayerInfo info = PlayerInfo.getPlayerInfo(this);
		currentSchoolId = info.getSchoolId();
		Log.i("suduko", "currentSchoolId" + currentSchoolId);
		if (SplashActivity.firstLogin) {
			showAdmission();
		} else {
			Intent intent = new Intent(SchoolTreeActivity.this,
					CourseTreeActivity.class);
			intent.putExtra(CourseTreeActivity.DEGREE_ID, currentSchoolId);
			startActivity(intent);
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
				intent.putExtra(CourseTreeActivity.DEGREE_ID, 0);
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
		imgbtns = new Button[] { (Button) findViewById(R.id.Button1),
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

	// 获取学校点位和整个学校树的配置
	private void initMap() {
		int currentDegree = Degree.getDegreeIdBySchoolId(currentSchoolId);
		life = LifeJourney.getInstance();
		List<Degree> degrees = life.getDegrees();
		if (null != degrees) {
			for (int i = 0; i < degrees.size(); i++) {
				List<School> schools = degrees.get(i).getSchools();
				if (degrees.get(i).getDegreeId() < currentDegree) {
					for (int k = 0; k < schools.size(); k++) {
						schools.get(k).setPlayProperty(
								School.SCHOOL_TYPE_AGEUNABLE);
					}
				} else if (degrees.get(i).getDegreeId() == currentDegree) {
					for (int k = 0; k < schools.size(); k++) {
						schools.get(k).setPlayProperty(School.SCHOOL_TYPE_ABLE);
					}
				} else {
					for (int k = 0; k < schools.size(); k++) {
						schools.get(k).setPlayProperty(
								School.SCHOOL_TYPE_DEGREEUNABLE);
					}
				}
				for (int j = 0; j < schools.size(); j++) {
					// 设置每个按钮所代表的关卡信息
					final int id = schools.get(j).getId();
					if (id == currentSchoolId) {
						imgbtns[schools.size() * i + j]
								.setBackgroundResource(R.drawable.btn_highlight);
					} else {
						switch (schools.get(j).getPlayProperty()) {
						case 0:

							break;
						case 1:
							imgbtns[schools.size() * i + j]
									.setBackgroundResource(R.drawable.btn_disable);
							imgbtns[schools.size() * i + j].setClickable(false);
							break;
						case 2:
							imgbtns[schools.size() * i + j]
									.setBackgroundResource(R.drawable.btn_disable);
							imgbtns[schools.size() * i + j].setClickable(false);
							break;
						}
					}
					imgbtns[schools.size() * i + j].setText(schools.get(j)
							.getName());
					imgbtns[schools.size() * i + j]
							.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View v) {
									Intent intent = new Intent(
											SchoolTreeActivity.this,
											CourseTreeActivity.class);
									intent.putExtra(
											CourseTreeActivity.DEGREE_ID, id);
									startActivity(intent);
								}
							});
				}
			}
		}
	}
}