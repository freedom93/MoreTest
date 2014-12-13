package com.freedom.copy_wechat;

import java.util.ArrayList;

import android.app.Activity;
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
import com.freedom.copy_wechat.utils.ContactAdapter;
import com.freedom.copy_wechat.utils.ContactP;
import com.freedom.copy_wechat.utils.HuiHua;
import com.freedom.copy_wechat.utils.HuihuaAdapter;
import com.freedom.copy_wechat.utils.MyScrollLayout;
import com.freedom.copy_wechat.utils.OnViewChangeListener;
import com.freedom.copy_wechat.utils.SelectAddPopupWindow;

public class WeChatMain2 extends Activity implements OnViewChangeListener, OnClickListener{
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
	
	//自定义的弹出框类
	SelectAddPopupWindow menuWindow; //弹出框
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wechat_main2);
		init();
	}

	private void init()
    {
		chat = (TextView)findViewById(R.id.chat);
		find = (TextView)findViewById(R.id.find);
		contacts = (TextView)findViewById(R.id.contacts);
		wo = (TextView)findViewById(R.id.wo);
		
		listview1 = (ListView)findViewById(R.id.listView1);
		listview2 = (ListView)findViewById(R.id.listView2);
		
		HuihuaAdapter ha = new HuihuaAdapter(this,getHuahui());
		listview1.setAdapter(ha);
		listview1.setCacheColorHint(0);
		
		ContactAdapter hc = new ContactAdapter(this,getContact());
		listview2.setAdapter(hc);
		listview2.setCacheColorHint(0);
		
    	mScrollLayout = (MyScrollLayout) findViewById(R.id.ScrollLayout); 	
    	LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lllayout);   	
    	mViewCount = mScrollLayout.getChildCount();
    	mImageViews = new LinearLayout[mViewCount];   	
    	for(int i = 0; i < mViewCount; i++)    	{
    		mImageViews[i] = (LinearLayout) linearLayout.getChildAt(i);
    		mImageViews[i].setEnabled(true);
    		mImageViews[i].setOnClickListener(this);
    		mImageViews[i].setTag(i);
    	}    	
    	mCurSel = 0;
    	mImageViews[mCurSel].setEnabled(false);    	
    	mScrollLayout.SetOnViewChangeListener(this);
    	
    	add = (ImageView)findViewById(R.id.add);
    	
    	add.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View arg0) {
    			uploadImage(WeChatMain2.this);
    		}
    	});
    }
	

	private ArrayList<ContactP> getContact(){
		ArrayList<ContactP> hcList = new ArrayList<ContactP>();
		ContactP c2 = new ContactP();
		c2.setTxPath(R.drawable.bind_mcontact_reco_friends+"");
		c2.setName("服务号");
		
		ContactP c1 = new ContactP();
		c1.setTxPath(R.drawable.bind_qq_icon+"");
		c1.setName("QQ团队");
		
		ContactP c0 = new ContactP();
		c0.setTxPath(R.drawable.icon+"");
		c0.setName("微信团队");
		
		ContactP c3 = new ContactP();
		c3.setTxPath(R.drawable.headshow3+"");
		c3.setName("Coffee");
		
		ContactP c4 = new ContactP();
		c4.setTxPath(R.drawable.headshow4+"");
		c4.setName("SB不哭");
		
		ContactP c5 = new ContactP();
		c5.setTxPath(R.drawable.personactivity_cover_heart+"");
		c5.setName("Zoe");
		
		ContactP c6 = new ContactP();
		c6.setTxPath(R.drawable.headshow6+"");
		c6.setName("向西去大理");
		
		ContactP c7 = new ContactP();
		c7.setTxPath(R.drawable.headshow7+"");
		c7.setName("Marrey");
		
		ContactP c10 = new ContactP();
		c10.setTxPath(R.drawable.headshow5+"");
		c10.setName("旅怪");
		
		ContactP c8 = new ContactP();
		c8.setTxPath(R.drawable.headshow8+"");
		c8.setName("Bigr");
		
		ContactP c9 = new ContactP();
		c9.setTxPath(R.drawable.headshow9+"");
		c9.setName("Sunshine");
		
		ContactP c11 = new ContactP();
		c11.setTxPath(R.drawable.headshow10+"");
		c11.setName("疯女");
		
		ContactP c12 = new ContactP();
		c12.setTxPath(R.drawable.headshow2+"");
		c12.setName("Sky");
		
		ContactP c13 = new ContactP();
		c13.setTxPath(R.drawable.headshow1+"");
		c13.setName("Gift");
		
		ContactP c14 = new ContactP();
		c14.setTxPath(R.drawable.headshow2+"");
		c14.setName("Follow");
		
		ContactP c15 = new ContactP();
		c15.setTxPath(R.drawable.headshow8+"");
		c15.setName("NightCat");
		
		hcList.add(c0);
		hcList.add(c1);
		hcList.add(c2);
		hcList.add(c3);
		hcList.add(c4);
		hcList.add(c5);
		hcList.add(c6);
		hcList.add(c7);
		hcList.add(c8);
		hcList.add(c9);
		hcList.add(c10);
		hcList.add(c11);
		hcList.add(c12);
		hcList.add(c13);
		hcList.add(c14);
		hcList.add(c15);
		
		return hcList;
	}
	private ArrayList<HuiHua> getHuahui(){
		ArrayList<HuiHua> hhList = new ArrayList<HuiHua>();
		HuiHua h1 = new HuiHua();
		h1.setTxPath(R.drawable.headshow10+"");
		h1.setName1("疯女");
		h1.setLastContent("正常人不会懂疯子的快乐！");
		h1.setLastTime(" 18:00");
		
		HuiHua h2 = new HuiHua();
		h2.setTxPath(R.drawable.headshow3+"");
		h2.setName1("SB不哭");
		h2.setLastContent("傻逼不哭");
		h2.setLastTime("昨天 17:00");
		
		HuiHua h3 = new HuiHua();
		h3.setTxPath(R.drawable.headshow2+"");
		h3.setName1("向西去大理");
		h3.setLastContent("风吹得很清新，云飘荡在南边的天空");
		h3.setLastTime("昨天  16:11");
		
		HuiHua h4 = new HuiHua();
		h4.setTxPath(R.drawable.headshow6+"");
		h4.setName1("Sunshine");
		h4.setLastContent("Don't look me, I will eat you, Are you know？");
		h4.setLastTime("昨天  15:08");
		
		HuiHua h5 = new HuiHua();
		h5.setTxPath(R.drawable.headshow9+"");
		h5.setName1("Marrey");
		h5.setLastContent("我就是这么一个人，就喜欢一个人，不管是不是一个人");
		h5.setLastTime("前天 14:50");
		
		HuiHua h6 = new HuiHua();
		h6.setTxPath(R.drawable.personactivity_cover_heart+"");
		h6.setName1("Zoe");
		h6.setLastContent("this is very good fill");
		h6.setLastTime("前天 14:00");
		
		HuiHua h7 = new HuiHua();
		h7.setTxPath(R.drawable.headshow10+"");
		h7.setName1("Gift");
		h7.setLastContent("生活就像一个礼物，没打开盒子谁也不知道里面是什么。");
		h7.setLastTime("前天 14:00");
		
		hhList.add(h1);
		hhList.add(h2);
		hhList.add(h3);
		hhList.add(h4);
		hhList.add(h5);
		hhList.add(h6);
		hhList.add(h7);

		return hhList;
	} 
	
	 public void uploadImage(final Activity context){
		 menuWindow = new SelectAddPopupWindow(WeChatMain2.this, itemsOnClick);
		 //显示窗口
		 menuWindow.showAtLocation(WeChatMain2.this.findViewById(R.id.add), Gravity.TOP|Gravity.RIGHT, 10, 118); //设置layout在PopupWindow中显示的位置
	 }
	 
	    //为弹出窗口实现监听类
	    private OnClickListener  itemsOnClick = new OnClickListener(){
	    	
	    	public void onClick(View v) {
	    		menuWindow.dismiss();
	    	}
	    };
	    
	private void setCurPoint(int index)
    {
    	if (index < 0 || index > mViewCount - 1 || mCurSel == index){
    		return ;
    	}    	
    	mImageViews[mCurSel].setEnabled(true);
    	mImageViews[index].setEnabled(false);    	
    	mCurSel = index;
    	
    	if(index == 0){
    		chat.setTextColor(0xff228B22);
    		find.setTextColor(Color.BLACK);
    		contacts.setTextColor(Color.BLACK);
    		wo.setTextColor(Color.BLACK);
    	}else if(index==1){
    		chat.setTextColor(Color.BLACK);
    		find.setTextColor(Color.BLACK);
    		contacts.setTextColor(0xff228B22);
    		wo.setTextColor(Color.BLACK);
    	}else if(index==2){
    		chat.setTextColor(Color.BLACK);
    		find.setTextColor(0xff228B22);
    		contacts.setTextColor(Color.BLACK);
    		wo.setTextColor(Color.BLACK);
    	}else{
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

		int pos = (Integer)(v.getTag());
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

}
