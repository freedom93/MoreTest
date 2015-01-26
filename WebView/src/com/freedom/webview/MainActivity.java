package com.freedom.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends Activity {

	private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //加载页面
        webView = (WebView) findViewById(R.id.webview);
        //允许JavaScript执行
        webView.getSettings().setJavaScriptEnabled(true);
        //找到Html文件，也可以用网络上的文件
        webView.loadUrl("file:///android_asset/index.html");
        // 添加一个对象, 让JS可以访问该对象的方法, 该对象中可以调用JS中的方法
        //webView.addJavascriptInterface(new Contact(), "contact");
    }
/*
    private final class Contact {
        //JavaScript调用此方法拨打电话
        public void call(String phone) {
//            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
        	Toast.makeText(MainActivity.this, phone, Toast.LENGTH_LONG).show();
        }

        //Html调用此方法传递数据
        public void showcontacts() {
           // String json = "[{\"name\":\"freedom\", \"amount\":\"9999999\", \"phone\":\"13812345678\"}]"; 
            // 调用JS中的方法
           // webView.loadUrl("javascript:show('" + json + "')");
        }
        
        public void toast(String str){
        	Toast.makeText(MainActivity.this, "aaaaaaaaaaaa  --- " + str, Toast.LENGTH_LONG).show();
        }
    }
*/
}
