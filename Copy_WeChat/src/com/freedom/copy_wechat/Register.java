package com.freedom.copy_wechat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	private EditText mUserPhone; // 帐号编辑框
	private EditText mPassword; // 密码编辑框
	private EditText mComfirmPassword; // 密码确认编辑框

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		mUserPhone = (EditText) findViewById(R.id.register_user_edit);
		mPassword = (EditText) findViewById(R.id.register_passwd_edit);
		mComfirmPassword = (EditText) findViewById(R.id.register_pwd_comfirm_edit);

	}

	public void register(View v) {
		String phone = mUserPhone.getText().toString().trim();
		String pwd = mPassword.getText().toString().trim();
		String cPwd = mComfirmPassword.getText().toString().trim();

		if(11 == phone.length() && phone.matches("[0-9]+") && phone.startsWith("13")
				&& !pwd.equals("") && pwd.equals(cPwd)){
			Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT)
			.show();
			startActivity(new Intent().setClass(Register.this,
					WelcomeLogin.class));
		}
		if("".equals(phone) || "".equals(pwd)) {
			new AlertDialog.Builder(Register.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.error_icon))
					.setTitle("错误信息").setMessage("帐号或者密码不能为空，\n请输入后再注册！")
					.create().show();
		}else if(11 != phone.length() && !phone.matches("[0-9]+")) {

			new AlertDialog.Builder(Register.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.error_icon))
					.setTitle("错误信息").setMessage("帐号为11位手机号，\n请检查后重新输入！")				
					.create().show();
		}else if(!phone.startsWith("13")){
			new AlertDialog.Builder(Register.this)
			.setIcon(
					getResources().getDrawable(
							R.drawable.error_icon))
			.setTitle("注册失败").setMessage("账号为非法手机号！")				
			.create().show();
		}else if(!pwd.equals(cPwd)){
			new AlertDialog.Builder(Register.this)
			.setIcon(
					getResources().getDrawable(
							R.drawable.error_icon))
			.setTitle("注册失败").setMessage("两次输入的密码不相同！")				
			.create().show();
		}

	}

	public void register_back(View v) { // 标题栏 返回登录
		this.finish();
	}
	

}
