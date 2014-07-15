package com.molocode.sudoku.yard.activity;

import java.util.ArrayList;
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

	private Button[] btns;
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
			intent.putExtra(CourseTreeActivity.SCHOOL_ID, currentSchoolId);
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
				intent.putExtra(CourseTreeActivity.SCHOOL_ID, 0);
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

	// 初始化学校地图
	private void initMap() {
		List<Degree> degrees = LifeJourney.getInstance().getDegrees();
		List<School> schools = new ArrayList<School>();
		if (null != degrees) {
			schools = getSchoolLsitDegree(degrees);
			Log.e("com.poxiao.suduko", "schools.size=" + schools.size());
		}
		setViewBtnsBySchools(schools, btns);
	}

	// 根据学历列表拼接学校列表
	private List<School> getSchoolLsitDegree(List<Degree> degrees) {
		List<School> schoolall = new ArrayList<School>();
		int currentDegree = Degree.getDegreeIdBySchoolId(currentSchoolId);
		Log.e("com.poxiao.suduko", "currentSchoolId0=" + currentSchoolId);
		for (int i = 0; i < degrees.size(); i++) {
			List<School> schools = new ArrayList<School>();
			schools = degrees.get(i).getSchools();
			int playProperty = getSchoolProperty(degrees.get(i), currentDegree);
			for (int j = 0; j < schools.size(); j++) {
				School schoolItem = schools.get(j);
				schoolItem.setPlayProperty(playProperty);
				schoolall.add(schoolItem);
			}
		}
		return schoolall;
	}

	// 根据当前学历的等级来判断学校的属性
	private int getSchoolProperty(Degree degrees, int currentdegree) {
		if (degrees.getDegreeId() > currentdegree) {
			return School.SCHOOL_TYPE_DEGREEUNABLE;
		} else if (degrees.getDegreeId() == currentdegree) {
			return School.SCHOOL_TYPE_ABLE;
		} else {
			return School.SCHOOL_TYPE_AGEUNABLE;
		}
	}

	// 根据所有学校的列表设置地图上所有的按钮
	private void setViewBtnsBySchools(List<School> schools, Button[] btns) {
		if (schools.size() > btns.length) {
			Log.e("com.poxiao.suduko", "学校地图配置有无");
		}
		for (int i = 0; i < schools.size(); i++) {
			School schoolItem = schools.get(i);
			btns[i].setText(schoolItem.getName());
			Log.e("com.poxiao.suduko", "schoolItem_ID=" + schoolItem.getId());
			setBtnByProperty(schoolItem.getPlayProperty(), btns[i],
					schoolItem.getId());
		}
	}

	// 根据学校的类型来决定按钮的背景及点击事件
	private void setBtnByProperty(int property, Button btn, final int schoolId) {
		Log.e("com.poxiao.suduko", "schoolId=" + schoolId);
		switch (property) {
		case 0:
			if (schoolId == currentSchoolId) {
				Log.e("com.poxiao.suduko", "currentSchoolId1="
						+ currentSchoolId);
				btn.setBackgroundResource(R.drawable.btn_highlight);// 当前学校高亮
				btn.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// 直接进入考试列表
						Intent intent = new Intent(SchoolTreeActivity.this,
								CourseTreeActivity.class);
						intent.putExtra(CourseTreeActivity.SCHOOL_ID, schoolId);
						startActivity(intent);
					}
				});

			} else {
				btn.setBackgroundResource(R.drawable.test_button_bg);// 可读学校
				btn.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						showHitDialog(schoolId);
					}
				});
			}
			break;
		case 1:
			btn.setBackgroundResource(R.drawable.btn_disable);// 学历不够
			break;
		case 2:
			btn.setBackgroundResource(R.drawable.btn_disable);// 年龄超过
			break;
		default:
			break;
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
				initMap();// 再次刷新界面
				Intent intent = new Intent(SchoolTreeActivity.this,
						CourseTreeActivity.class);
				intent.putExtra(CourseTreeActivity.SCHOOL_ID, schoolId);
				startActivity(intent);
			}
		});
		builder.setNegativeButton("留校", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Intent intent = new Intent(SchoolTreeActivity.this,
						CourseTreeActivity.class);
				intent.putExtra(CourseTreeActivity.SCHOOL_ID, currentSchoolId);
				startActivity(intent);
			}
		});
		builder.create().show();

	}
}