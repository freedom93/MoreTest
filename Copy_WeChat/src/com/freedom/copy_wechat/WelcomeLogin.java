package com.freedom.copy_wechat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeLogin extends Activity {

	private EditText mUser; // 帐号编辑框
	private EditText mPassword; // 密码编辑框

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_login);

		ImageView top_left = (ImageView) findViewById(R.id.left_icon);
		top_left.setImageResource(R.drawable.actionbar_icon);
		TextView top_right = (TextView) findViewById(R.id.right_text);
		top_right.setText(R.string.other_acount);
		top_right.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "切换账号",
						Toast.LENGTH_SHORT).show();
			}
		});

		mUser = (EditText) findViewById(R.id.login_user_edit);
		mPassword = (EditText) findViewById(R.id.login_passwd_edit);
	}

	public void welcome_login(View v) {
		if ("Test".equals(mUser.getText().toString())
				&& "123".equals(mPassword.getText().toString())) {
			startActivity(new Intent().setClass(WelcomeLogin.this,
					LoadingLogin.class));
			Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT)
					.show();

		} else if ("".equals(mUser.getText().toString())
				|| "".equals(mPassword.getText().toString())) {
			new AlertDialog.Builder(WelcomeLogin.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登录错误").setMessage("微信帐号或者密码不能为空，\n请输入后再登录！")
					.create().show();
		} else {

			new AlertDialog.Builder(WelcomeLogin.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登录失败").setMessage("微信帐号或者密码不正确，\n请检查后重新输入！")
					.create().show();
		}
	}

	public void login_pw(View v) { // 忘记密码按钮
		Uri uri = Uri.parse("http://www.hao123.com");
		startActivity(new Intent(Intent.ACTION_VIEW, uri));
		// startActivity(new Intent().setClass(WelcomeLogin.this,Welcomes.class));
	}

	public void welcome_register(View v) {
		startActivity(new Intent().setClass(WelcomeLogin.this, Register.class));
		// this.finish();
	}

}