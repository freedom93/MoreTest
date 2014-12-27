package com.freedom.copy_wechat.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.freedom.copy_wechat.R;
import com.freedom.copy_wechat.WeChatStart;
import com.freedom.copy_wechat.common.utils.adapter.AdapterActivity;
import com.freedom.copy_wechat.common.utils.adapter.CommonAdapter;
import com.freedom.copy_wechat.common.utils.adapter.RefleshListView;
import com.freedom.copy_wechat.common.utils.adapter.ViewHolder;
import com.freedom.copy_wechat.main.WeChatMain;
import com.freedom.copy_wechat.main2.WeChatMain2;
import com.jauker.widget.BadgeView;

public class TestFunctionListActivity extends Activity implements
		RefleshListView.IOnRefreshListener {

	private RefleshListView mList;
	private CommonAdapter adapter;
	private List<String> data;
	private RefreshDataAsynTask mRefreshAsynTask;
	private BadgeView mBadgeView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_adapter_list_container);
		mList = (RefleshListView) findViewById(R.id.folder_list);
		//test badgeView
		TextView top_middle = (TextView)findViewById(R.id.top_middle);
		mBadgeView = new BadgeView(TestFunctionListActivity.this,top_middle);
		mBadgeView.setText("99+");
		mBadgeView.setTextColor(Color.WHITE);
//		mBadgeView.setTextSize(30);
		mBadgeView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT); //默认值
		mBadgeView.show();
		
		top_middle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 mBadgeView.toggle();
				
			}
		});
		data = new ArrayList<String>(Arrays.asList("main0","main1", "main2"));//, "adapter"
		adapter = new CommonAdapter<String>(this, data,
				R.layout.c_adapter_list_item) {
			
			@Override
			public void convert(ViewHolder holder, String item) {
				TextView view = holder.getView(R.id.folder_name);
				view.setText(item);

			}

		};
		mList.setAdapter(adapter);
		mList.setOnRefreshListener(this);
		mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 1:
					startActivity(new Intent(TestFunctionListActivity.this,
							WeChatStart.class));
					break;
				case 2:
					startActivity(new Intent(TestFunctionListActivity.this,
							WeChatMain.class));
					break;
				case 3:
					startActivity(new Intent(TestFunctionListActivity.this,
							WeChatMain2.class));
					break;
				default:
					startActivity(new Intent(TestFunctionListActivity.this,
							AdapterActivity.class));
					break;
			
				}

			}
		});

	}

	@Override
	public void OnRefresh() {
		mRefreshAsynTask = new RefreshDataAsynTask();
		mRefreshAsynTask.execute();

	}

	int index = 2;
	class RefreshDataAsynTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			index++;
			if(index<4){
				data.add("main"+index);
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			adapter.refreshData(data);
			mList.onRefreshComplete();
		}

	}
}
