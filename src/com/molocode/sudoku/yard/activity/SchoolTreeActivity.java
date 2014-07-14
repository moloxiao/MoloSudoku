package com.molocode.sudoku.yard.activity;

import java.util.List;

import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;
import com.molocode.sudoku.game.domain.Degree;
import com.molocode.sudoku.game.domain.LifeJourney;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置学校路线界面
		setContentView(R.layout.shooltree_activity);
		initData();
		// 是否初次登陆，是展示对话框
		PlayerInfo info = PlayerInfo.getPlayerInfo(this);
		if (info.isIsfirstlogin()) {
			showAdmission();
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
				Intent intent =new Intent(SchoolTreeActivity.this,CourseTreeActivity.class);
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
		// 获取学校点位和整个学校树的配置
		life = LifeJourney.getInstance();
		List<Degree> degrees = life.getDegrees();
		if (null != degrees) {
			int mysize = (degrees.size() > imgbtns.length) ? (imgbtns.length)
					: (degrees.size());
			for (int i = 0; i < mysize; i++) {
				// TODO 设置每个按钮所代表的关卡信息
				final int id=degrees.get(i).getDegreeId();
				imgbtns[i].setText(degrees.get(i).getDegreeName());
				imgbtns[i].setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent =new Intent(SchoolTreeActivity.this,CourseTreeActivity.class);
						intent.putExtra(CourseTreeActivity.DEGREE_ID, id);
						startActivity(intent);
					}
				});
			}
		}
	}
}