package com.freedom.copy_wechat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeLogin extends Activity {

	private EditText mUser; // 帐号编辑框
	private TextView mUser_tv; // 帐号文本
	private EditText mPassword; // 密码编辑框
	private Button other_acount;// 切换账户按钮
	private Button back_login;// 返回按钮
	private ImageView user_img; // 用户头像
	private String user;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_login);
		other_acount = (Button) findViewById(R.id.other_acount);
		back_login = (Button) findViewById(R.id.back_login);
		user_img = (ImageView) findViewById(R.id.user_img);
		mUser_tv = (TextView) findViewById(R.id.login_user_tv);
		mUser = (EditText) findViewById(R.id.login_user_edit);
		mPassword = (EditText) findViewById(R.id.login_passwd_edit);
		user = mUser_tv.getText().toString().trim();
	}

	public void other_acount(View v) {
		user_img.setImageResource(R.drawable.wechat);
		mUser.setVisibility(View.VISIBLE);
		mUser_tv.setVisibility(View.GONE);
		other_acount.setVisibility(View.GONE);
		// back_login.setVisibility(View.VISIBLE);

	}

	public void back_login(View v) {
		user_img.setImageResource(R.drawable.freedom);
		mUser.setVisibility(View.GONE);
		mUser_tv.setVisibility(View.VISIBLE);
		other_acount.setVisibility(View.VISIBLE);
		back_login.setVisibility(View.GONE);
		user = mUser_tv.getText().toString().trim();
		Log.i("user_tv", user);

	}

	public void welcome_login(View v) {
		String passwd = mPassword.getText().toString();
		Log.i("user", user);
		if (!user.equals("freedom")) {
			user = mUser.getText().toString().trim();
		}
		if (("Test".equals(user) || "freedom".equals(user))
				&& "123".equals(passwd)) {
			startActivity(new Intent().setClass(WelcomeLogin.this,
					LoadingLogin.class));

		} else if ("".equals(user) || "".equals(passwd)) {
			new AlertDialog.Builder(WelcomeLogin.this)
					.setIcon(getResources().getDrawable(R.drawable.error_icon))
					.setTitle("登录错误").setMessage("帐号或者密码不能为空，\n请输入后再登录！")
					.create().show();
		} else {

			new AlertDialog.Builder(WelcomeLogin.this)
					.setIcon(getResources().getDrawable(R.drawable.error_icon))
					.setTitle("登录失败").setMessage("帐号或密码不正确，\n请检查后重新输入！")
					.create().show();
		}
	}

	public void login_forget_pwd(View v) { // 忘记密码按钮
		Toast.makeText(getApplicationContext(), "忘记密码", Toast.LENGTH_SHORT)
				.show();
		// Uri uri = Uri.parse("http://www.hao123.com");
		// startActivity(new Intent(Intent.ACTION_VIEW, uri));
		// startActivity(new
		// Intent().setClass(WelcomeLogin.this,Welcomes.class));
	}

	public void welcome_register(View v) {
		startActivity(new Intent().setClass(WelcomeLogin.this,
				WelcomeRegister.class));
		// this.finish();
	}

}
