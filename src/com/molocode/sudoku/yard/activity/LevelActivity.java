package com.molocode.sudoku.yard.activity;

import com.molocode.sudoku.R;
import com.molocode.sudoku.game.GameActivity44;
import com.molocode.sudoku.game.domain.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LevelActivity extends Activity {

	private int currentLevel;
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_activity);
		
		currentLevel = getIntent().getIntExtra("levelId", 0);
		
		initView();
	}

	private void initView() {
		listView = (ListView)findViewById(R.id.list_level);
		listView.setAdapter(new LevelListAdapter(Map.getMapLevels(currentLevel)));
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent = new Intent(LevelActivity.this, GameActivity44.class);
				intent.putExtra(GameActivity44.EXTRA_LEVEL, position);
				startActivity(intent);
			}
			
		});
	}
	
	public class LevelListAdapter extends BaseAdapter {

		private int levels;
		
		public LevelListAdapter(int levels) {
			this.levels = levels;
		}
		
		@Override
		public int getCount() {
			return levels;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater mInflater = (LayoutInflater) LevelActivity.this.getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				convertView = mInflater.inflate(R.layout.level_item, parent, false);
			}
			int level = position + 1;
			((TextView) convertView.findViewById(R.id.level_desc)).setText(
					"关卡" + level);
			return convertView;
		}
	}
	
}
