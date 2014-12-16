package com.freedom.copy_wechat.main2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.freedom.copy_wechat.R;
import com.freedom.copy_wechat.main.ShakeActivity;
import com.freedom.copy_wechat.virtualdata2.VirtualData2;

public class WeChatMain2 extends Activity implements OnViewChangeListener,
		OnClickListener {
	private MyScrollLayout mScrollLayout;
	private LinearLayout[] mImageViews;
	private int mViewCount;
	private int mCurSel;
	private ImageView add;

	private TextView chat;
	private TextView find;
	private TextView contacts;
	private TextView wo;

	private boolean isOpen = false;

	private ListView listview1;
	private ListView listview2;

	// 自定义的弹出框类
	SelectAddPopupWindow menuWindow; // 弹出框

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wechat_main2);
		init();
	}

	private void init() {
		chat = (TextView) findViewById(R.id.chat);
		find = (TextView) findViewById(R.id.find);
		contacts = (TextView) findViewById(R.id.contacts);
		wo = (TextView) findViewById(R.id.wo);

		listview1 = (ListView) findViewById(R.id.listView1);
		listview2 = (ListView) findViewById(R.id.listView2);

		ChattingAdapter ha = new ChattingAdapter(this, VirtualData2.getHuahui());
		listview1.setAdapter(ha);
		listview1.setCacheColorHint(0);

		ContactAdapter hc = new ContactAdapter(this, VirtualData2.getContact());
		listview2.setAdapter(hc);
		listview2.setCacheColorHint(0);

		mScrollLayout = (MyScrollLayout) findViewById(R.id.ScrollLayout);
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lllayout);
		mViewCount = mScrollLayout.getChildCount();
		mImageViews = new LinearLayout[mViewCount];
		for (int i = 0; i < mViewCount; i++) {
			mImageViews[i] = (LinearLayout) linearLayout.getChildAt(i);
			mImageViews[i].setEnabled(true);
			mImageViews[i].setOnClickListener(this);
			mImageViews[i].setTag(i);
		}
		mCurSel = 0;
		mImageViews[mCurSel].setEnabled(false);
		mScrollLayout.SetOnViewChangeListener(this);

		add = (ImageView) findViewById(R.id.add);

		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				uploadImage(WeChatMain2.this);
			}
		});
	}

	public void uploadImage(final Activity context) {
		menuWindow = new SelectAddPopupWindow(WeChatMain2.this, itemsOnClick);
		// 显示窗口
		menuWindow.showAtLocation(WeChatMain2.this.findViewById(R.id.add),
				Gravity.TOP | Gravity.RIGHT, 1, 76); // 设置layout在PopupWindow中显示的位置
	}

	// 为弹出窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
		}
	};

	private void setCurPoint(int index) {
		if (index < 0 || index > mViewCount - 1 || mCurSel == index) {
			return;
		}
		mImageViews[mCurSel].setEnabled(true);
		mImageViews[index].setEnabled(false);
		mCurSel = index;

		if (index == 0) {
			chat.setTextColor(0xff228B22);
			find.setTextColor(Color.BLACK);
			contacts.setTextColor(Color.BLACK);
			wo.setTextColor(Color.BLACK);
		} else if (index == 1) {
			chat.setTextColor(Color.BLACK);
			find.setTextColor(Color.BLACK);
			contacts.setTextColor(0xff228B22);
			wo.setTextColor(Color.BLACK);
		} else if (index == 2) {
			chat.setTextColor(Color.BLACK);
			find.setTextColor(0xff228B22);
			contacts.setTextColor(Color.BLACK);
			wo.setTextColor(Color.BLACK);
		} else {
			chat.setTextColor(Color.BLACK);
			find.setTextColor(Color.BLACK);
			contacts.setTextColor(Color.BLACK);
			wo.setTextColor(0xff228B22);
		}
	}

	@Override
	public void OnViewChange(int view) {

		setCurPoint(view);
	}

	@Override
	public void onClick(View v) {

		int pos = (Integer) (v.getTag());
		setCurPoint(pos);
		mScrollLayout.snapToScreen(pos);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_MENU)) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void btn_shake(View v) { // 手机摇一摇
		Intent intent = new Intent(WeChatMain2.this, ShakeActivity.class);
		startActivity(intent);
	}
}
