package com.freedom.copy_wechat.common.utils.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.freedom.copy_wechat.R;

public class AdapterActivity extends Activity implements
		RefleshListView.IOnRefreshListener {

	private RefleshListView mList;
	private CommonAdapter adapter;
	private List<String> data;
	private RefreshDataAsynTask mRefreshAsynTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_adapter_list_container);
		mList = (RefleshListView) findViewById(R.id.folder_list);
		data = new ArrayList<String>(Arrays.asList("hello", "world", "sorry"));
		// adapter = new MyAdapter(this, data);
		// mList.setAdapter(adapter);
		// 简化过得CommonAdapter已经可以不需要单独写一个Adapter了，直接在Activity里写一个匿名内部类即可
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

	}

	@Override
	public void OnRefresh() {
		mRefreshAsynTask = new RefreshDataAsynTask();
		mRefreshAsynTask.execute();

	}

	class RefreshDataAsynTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int index = 0;
			index++;
			// data.addFirst("TestListviewRefreshAdd" + index);

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			adapter.refreshData(data);
			mList.onRefreshComplete();
		}

	}
}
