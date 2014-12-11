package com.freedom.copy_wechat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AppStart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_start);
		//延迟一秒跳转  
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(AppStart.this, WelcomeLogin.class));
				AppStart.this.finish();
			}
		}, 1000);
	}

}
