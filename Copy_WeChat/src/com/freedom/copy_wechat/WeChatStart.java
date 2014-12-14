package com.freedom.copy_wechat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WeChatStart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wechat_start);
		// 延迟一秒跳转
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(WeChatStart.this, WelcomeLogin.class));
				WeChatStart.this.finish();
			}
		}, 1000);
	}

}
