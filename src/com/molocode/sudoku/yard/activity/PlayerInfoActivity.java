package com.molocode.sudoku.yard.activity;

import java.util.Timer;
import java.util.TimerTask;
import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.PlayerInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;

public class PlayerInfoActivity extends Activity {

	private EditText tv;
	private RadioGroup group;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playerinfo_activity);
		initView();
	}

	private void initView() {
		tv = (EditText) findViewById(R.id.text_playerinfo);
		tv.setText(PlayerInfo.getPlayerInfo(this).getNickname());
		group = (RadioGroup) findViewById(R.id.gender);
	}

	private void savePlayerInfo() {
		PlayerInfo info = PlayerInfo.getPlayerInfo(PlayerInfoActivity.this);
		info.setGender(group.getCheckedRadioButtonId());
		info.setNickname(tv.getText().toString());
	}

	public void btnStart(View view) {
		savePlayerInfo();
		startActivity(new Intent(this, SchoolTreeActivity.class));
	}

	public void nameChange(View view) {
		tv.requestFocus();
		Timer timer = new Timer();  
	     timer.schedule(new TimerTask()  
	     {  
	           
	         public void run()  
	         {  
	             InputMethodManager inputManager =  
                 (InputMethodManager) tv.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);  
	             inputManager.showSoftInput(tv, 0);  
	         }  
	           
	     },  
	         998);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}
