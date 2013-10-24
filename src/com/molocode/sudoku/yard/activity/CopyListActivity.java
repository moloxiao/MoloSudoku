package com.molocode.sudoku.yard.activity;

import java.util.List;
import com.molocode.sudoku.R;
import com.molocode.sudoku.domain.Level;
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

public class CopyListActivity extends Activity {

	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.copy_list_activity);
		initView();
	}
	
	private void initView() {
		listView = (ListView)findViewById(R.id.list_difficulty);
		listView.setAdapter(new LevelAdapter(Level.getLevelList()));
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent = new Intent(CopyListActivity.this, LevelActivity.class);
				int levelId = ((Level)parent.getItemAtPosition(position)).getId();
				intent.putExtra("levelId", 
						levelId );
				startActivity(intent);
			}
			
		});
	}

	public void btnLevel1(View view) {
		startActivity(new Intent(this, LevelActivity.class));
	}
	
	
	public class LevelAdapter extends BaseAdapter {

		private List<Level> levels;
		
		public LevelAdapter(List<Level> levels) {
			this.levels = levels;
		}
		
		@Override
		public int getCount() {
			if(levels == null) {
				return 0;
			}
			return levels.size();
		}

		@Override
		public Object getItem(int position) {
			if(levels == null) {
				return null;
			}
			return levels.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater mInflater = (LayoutInflater) CopyListActivity.this.getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				convertView = mInflater.inflate(R.layout.difucuty_item, parent, false);
			}
			((TextView) convertView.findViewById(R.id.difucuty_desc)).setText(
					levels.get(position).getDesc());
			return convertView;
		}
	}
	
}
