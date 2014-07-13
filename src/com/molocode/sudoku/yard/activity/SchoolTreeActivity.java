package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;
import com.molocode.sudoku.game.domain.LifeJourney;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.ImageButton;

public class SchoolTreeActivity extends Activity {

	private ImageButton[] imgbtns;
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

	private void initData() {
		//获取学校点位和整个学校树的配置
		life=LifeJourney.getInstance();
		
		imgbtns = new ImageButton[] {
				(ImageButton) findViewById(R.id.ImageButton1),
				(ImageButton) findViewById(R.id.ImageButton2),
				(ImageButton) findViewById(R.id.ImageButton3),
				(ImageButton) findViewById(R.id.ImageButton4),
				(ImageButton) findViewById(R.id.ImageButton5),
				(ImageButton) findViewById(R.id.ImageButton6),
				(ImageButton) findViewById(R.id.ImageButton7),
				(ImageButton) findViewById(R.id.ImageButton8),
				(ImageButton) findViewById(R.id.ImageButton9),
				(ImageButton) findViewById(R.id.ImageButton10),
				(ImageButton) findViewById(R.id.ImageButton11),
				(ImageButton) findViewById(R.id.ImageButton12),
				(ImageButton) findViewById(R.id.ImageButton13),
				(ImageButton) findViewById(R.id.ImageButton14),
				(ImageButton) findViewById(R.id.ImageButton15), };
		for (int i = 0; i < imgbtns.length; i++) {
			// 设置每个按钮所代表的关卡信息
			
		}
	}
}