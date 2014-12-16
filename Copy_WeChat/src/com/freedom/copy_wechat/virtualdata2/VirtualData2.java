package com.freedom.copy_wechat.virtualdata2;

import java.util.ArrayList;

import com.freedom.copy_wechat.R;
import com.freedom.copy_wechat.main2.ContactP;
import com.freedom.copy_wechat.virtualdata.Chatting;

public class VirtualData2 {

	public static ArrayList<ContactP> getContact() {
		ArrayList<ContactP> hcList = new ArrayList<ContactP>();
		ContactP c2 = new ContactP();
		c2.setTxPath(R.drawable.bind_mcontact_reco_friends + "");
		c2.setName("服务号");

		ContactP c1 = new ContactP();
		c1.setTxPath(R.drawable.bind_qq_icon + "");
		c1.setName("QQ团队");

		ContactP c0 = new ContactP();
		c0.setTxPath(R.drawable.icon + "");
		c0.setName("微信团队");

		ContactP c3 = new ContactP();
		c3.setTxPath(R.drawable.headshow3 + "");
		c3.setName("Coffee");

		ContactP c4 = new ContactP();
		c4.setTxPath(R.drawable.headshow4 + "");
		c4.setName("SB不哭");

		ContactP c5 = new ContactP();
		c5.setTxPath(R.drawable.personactivity_cover_heart + "");
		c5.setName("Zoe");

		ContactP c6 = new ContactP();
		c6.setTxPath(R.drawable.headshow6 + "");
		c6.setName("向西去大理");

		ContactP c7 = new ContactP();
		c7.setTxPath(R.drawable.headshow7 + "");
		c7.setName("Marrey");

		ContactP c10 = new ContactP();
		c10.setTxPath(R.drawable.headshow5 + "");
		c10.setName("旅怪");

		ContactP c8 = new ContactP();
		c8.setTxPath(R.drawable.headshow8 + "");
		c8.setName("Bigr");

		ContactP c9 = new ContactP();
		c9.setTxPath(R.drawable.headshow9 + "");
		c9.setName("Sunshine");

		ContactP c11 = new ContactP();
		c11.setTxPath(R.drawable.headshow10 + "");
		c11.setName("疯女");

		ContactP c12 = new ContactP();
		c12.setTxPath(R.drawable.headshow2 + "");
		c12.setName("Sky");

		ContactP c13 = new ContactP();
		c13.setTxPath(R.drawable.headshow1 + "");
		c13.setName("Gift");

		ContactP c14 = new ContactP();
		c14.setTxPath(R.drawable.headshow2 + "");
		c14.setName("Follow");

		ContactP c15 = new ContactP();
		c15.setTxPath(R.drawable.headshow8 + "");
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

	public static ArrayList<Chatting> getHuahui() {
		ArrayList<Chatting> hhList = new ArrayList<Chatting>();
		Chatting h1 = new Chatting();
		h1.setTxPath(R.drawable.headshow10 + "");
		h1.setName1("疯女");
		h1.setLastContent("正常人不会懂疯子的快乐！");
		h1.setLastTime("下午 18:00");

		Chatting h2 = new Chatting();
		h2.setTxPath(R.drawable.headshow3 + "");
		h2.setName1("SB不哭");
		h2.setLastContent("傻逼不哭");
		h2.setLastTime("昨天 17:00");

		Chatting h3 = new Chatting();
		h3.setTxPath(R.drawable.headshow2 + "");
		h3.setName1("向西去大理");
		h3.setLastContent("风吹得很清新，云飘荡在南边的天空");
		h3.setLastTime("昨天  16:11");

		Chatting h4 = new Chatting();
		h4.setTxPath(R.drawable.headshow6 + "");
		h4.setName1("Sunshine");
		h4.setLastContent("Don't look me, I will eat you, Are you know？");
		h4.setLastTime("昨天  15:08");

		Chatting h5 = new Chatting();
		h5.setTxPath(R.drawable.headshow9 + "");
		h5.setName1("Marrey");
		h5.setLastContent("我就是这么一个人，就喜欢一个人，不管是不是一个人");
		h5.setLastTime("前天 14:50");

		Chatting h6 = new Chatting();
		h6.setTxPath(R.drawable.personactivity_cover_heart + "");
		h6.setName1("Zoe");
		h6.setLastContent("this is very good fill");
		h6.setLastTime("前天 14:00");

		Chatting h7 = new Chatting();
		h7.setTxPath(R.drawable.headshow1 + "");
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
}
