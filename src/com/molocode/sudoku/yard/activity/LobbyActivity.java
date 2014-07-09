package com.molocode.sudoku.yard.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.drawable;
import android.R.layout;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.Chapter;
import com.molocode.sudoku.domain.Level;

public class LobbyActivity extends Activity {
	private List<Chapter> chapters = null;
	private static boolean firstLogin = false;
	private GridView levelGridView;
	private LobbyActivity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity = this;
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

	class levelGridViwAdapter extends BaseAdapter {
		private List<Level> chapterLevelInfo = new ArrayList<Level>();

		@Override
		public int getCount() {
			if (chapterLevelInfo.size() > 0) {
				return chapterLevelInfo.size();
			}
			return 0;
		}

		@Override
		public Object getItem(int position) {
			return chapterLevelInfo.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				LayoutInflater inflater = (LayoutInflater) activity
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.game_level_view_item,
						null);
				holder.game_level = (ImageView) convertView
						.findViewById(R.id.game_level);
				holder.passtime = (TextView) convertView
						.findViewById(R.id.passtime);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Level levelInfo = chapterLevelInfo.get(position);

			if (levelInfo != null) {
				// TODO 设置具体界面
			}
			return convertView;
		}

	}

	class ViewHolder {
		ImageView game_level;
		TextView passtime;
		// 设置GridView的每一个Item的样式
	}

}