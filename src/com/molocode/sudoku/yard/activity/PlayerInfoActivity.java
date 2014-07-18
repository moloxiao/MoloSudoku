package com.molocode.sudoku.yard.activity;

import java.util.Timer;
import java.util.TimerTask;

import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerInfoActivity extends Activity {
	private ImageButton boy_select;
	private ImageButton girl_select;
	private ImageView boy_selected;
	private ImageView boy_unselected;
	private ImageView girl_selected;
	private ImageView girl_unselected;
	private TextView playerName;
	private ImageButton nameRandom;
	private ImageView clock;
	private TextView time;
	private ImageButton startGame;
	private PlayerInfo playerInfo;
	private static int counttime = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playerinfo_activity);
		playerInfo = PlayerInfo.getPlayerInfo(this);
		initView();
	}

	private void initView() {
		boy_select = (ImageButton) findViewById(R.id.boy);
		girl_select = (ImageButton) findViewById(R.id.girl);
		nameRandom = (ImageButton) findViewById(R.id.random);
		playerName = (TextView) findViewById(R.id.name_text);
		boy_selected = (ImageView) findViewById(R.id.boy_selected);
		boy_unselected = (ImageView) findViewById(R.id.boy_unselected);
		girl_selected = (ImageView) findViewById(R.id.girl_selected);
		girl_unselected = (ImageView) findViewById(R.id.girl_unselected);
		clock = (ImageView) findViewById(R.id.playerinfo_time);
		time = (TextView) findViewById(R.id.countdown);
		startGame = (ImageButton) findViewById(R.id.game_start);
		// 设置内容
		playerName.setText(playerInfo.getNickname());
		// 设置点击事件
		boy_select.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boy_selected.setVisibility(View.VISIBLE);
				boy_unselected.setVisibility(View.INVISIBLE);
				girl_selected.setVisibility(View.INVISIBLE);
				girl_unselected.setVisibility(View.VISIBLE);
				playerInfo.setGender(PlayerInfo.MALE);
				PlayerInfo.setPlayerInfo(PlayerInfoActivity.this, playerInfo);
			}
		});
		girl_select.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				girl_selected.setVisibility(View.VISIBLE);
				girl_unselected.setVisibility(View.INVISIBLE);
				boy_selected.setVisibility(View.INVISIBLE);
				boy_unselected.setVisibility(View.VISIBLE);
				playerInfo.setGender(PlayerInfo.FEMALE);
				PlayerInfo.setPlayerInfo(PlayerInfoActivity.this, playerInfo);
			}
		});
		nameRandom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				playerName.setText(PlayerInfo.randomPlayerName());
				playerInfo.setNickname(PlayerInfo.randomPlayerName());
				PlayerInfo.setPlayerInfo(PlayerInfoActivity.this, playerInfo);
			}
		});
		startGame.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(PlayerInfoActivity.this,
						SchoolTreeActivity.class));
			}
		});
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				PlayerInfoActivity.this.runOnUiThread(new Runnable() {
					public void run() {
						if (counttime == 0) {
							startActivity(new Intent(PlayerInfoActivity.this,
									SchoolTreeActivity.class));
						}
						time.setText(String.valueOf(counttime--));
					}
				});
			}
		};
		timer.schedule(task, 0, 1000);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}
