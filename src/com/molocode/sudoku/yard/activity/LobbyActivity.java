package com.molocode.sudoku.yard.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.drawable;
import android.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.Chapter;

public class LobbyActivity extends Activity {
	private List<Chapter> chapters = null;
	private static boolean firstLogin = false;
	private GridView levelGridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lobby_activity);
		initData();
	}

	// 获取屏幕上的控件
	private void initData() {
		levelGridView = (GridView) findViewById(R.id.game_chapter);
	}

	// 获取章节列表
	private void initChapter(Map<String, String> record) {
		chapters = Chapter.getChapterInfo();
		// 获取每一章节的level
		for (int i = 0; i < chapters.size(); i++) {
			chapters.get(i).getLevels();
		}
	}

	// 返回最近一次玩的关卡
	private Map<String, String> getPlayerRecord() {
		Map<String, String> map = new HashMap<String, String>();
		// 如果是首次登陆，返回第一章第一级
		if (firstLogin) {
			map.clear();
			map.put("1", "1");
			return map;
		} else {
			map.clear();
			// TODO 从本地存储中获取上次玩的关卡
			map.put("1", "1");
			return map;
		}
	}
}