MoreTest
=============================================================================
MoreTest is set up for copying excellent apps with a huge amount of the user.

First: Copy_WeChat
-----------------------------------------------------------------------------
WeChat,, not just a mobile phone application, it is a way of life.

More than three hundred million people chat with others by using WeChat

it supports to send voice messages, video, pictures and text, and  chat groups.

What's more, it will only take a small amount of flow consumption, 

and suitable for most intelligent mobile phone.

PS:

I am a rookie in the development of Android. 

I want to own one app which is develped by myself.

It's a bit lonely. So what? I haved tried out.

No one join temporarily, becanse everyone is very hectic.

Now, I need more and more practice.

I plan to start up by copying excellent works step by step.

WeChat is one of the greatest APP in the zone of mobile applications.

This is Why I do this.

Come on，Freedom! You will achieve more happiness and fulfillment.


Luminous point 1: Omnipotent ViewHolder and Common Adapter for ListView
-----------------------------------------------------------------------------
Omnipotent ViewHolder: 

package com.freedom.copy_wechat.common.utils.adapter;

public class ViewHolder {
}

 * ViewHolder的作用:通过convertView.setTag与convertView进行绑定

 * 当convertView复用时，直接从与之对于的ViewHolder(getTag)中拿到convertView布局中的控件，省去了findViewById的时间。

 * 实际上们每个convertView会绑定一个ViewHolder对象，viewHolder主要是帮convertView存储布局中的控件。

 * 因此抽出一个通用的ViewHolder完全有可能，对于任意的convertView，提供一个对象让其setTag即可。

 * 针对不同的Item布局，提供一个容器，专门存每个Item布局中的所有控件，

 * 而且还能根据控件的Id通过getView(int viewId)方法查找出来；

 * 既然是通过查找方式，那么ListView肯定不行了，需要一个键值对进行保存，键为控件的Id，值为控件的引用，Map可以达到目的，

 * 但是在这里有比Map更好的替代类，android提供的SparseArray类，和Map类似，但是比Map效率，不过键只能为Integer.

Common Adapter for ListView：

package com.freedom.copy_wechat.common.utils.adapter;

public abstract class CommonAdapter<T> extends BaseAdapter {
}

 * Adapter的作用：使数据绑定到控件变得更加简单和灵活，为容器提供子视图，利用视图的数据和元数据来构建每个子视图。

 * 常用的Adapter： arrayAdapter  、simpleCursorAdapter、 cursorAdapter、 resourceCursorAdapter 等。

 * 如果需要自定义适配器 可以扩展抽象类BaseAdapter

 * CommonAdapter 一个抽象类，扩展了抽象类BaseAdapter，继承BaseAdapter的getView等方法，getView的实现中联合通用的ViewHolder。

 * CommonAdapter的抽象方法：public abstract void convert(ViewHolder holder, T item);
	
 * 另外，Adapter一般需要保持一个List对象，存储一个Bean的集合，不同的ListView，Bean肯定是不同的，

 * 因此这个CommonAdapter肯定需要支持泛型，内部维持一个List<T>，使用方法如下：
 
   CommonAdapter adapter = new CommonAdapter<String>(this, data, R.layout.c_adapter_list_item) {

			@Override
			public void convert(ViewHolder holder, String item) {
				TextView view = holder.getView(R.id.folder_name);
				view.setText(item);
			}
		};
   
   (RefleshListView) findViewById(R.id.folder_list).setAdapter(adapter);

Luminous point 2: RefleshListView
--------------------------------------------------------------------------------------------------------------------
RefleshListView：下拉刷新列表

package com.freedom.copy_wechat.common.utils.adapter;

public class RefleshListView extends ListView implements OnScrollListener{

}

c_adapter_refresh_list_head.xml

c_adapter_list_container.xml

 <com.freedom.copy_wechat.common.utils.adapter.RefleshListView
        android:id="@+id/folder_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="top"
    	android:cacheColorHint="#000000"
        android:divider="@drawable/divider_gray_line"
        android:dividerHeight="0dp"
        android:fadingEdge="none"
        android:headerDividersEnabled="false"/>

Luminous point 3: BadgeView
-----------------------------------------------------------------------------
BadgeView是一个开源组件
主要继承了TextView，实际上就是一个TextView，底层放了一个label，
可以自定义背景图，自定义背景颜色，是否显示，显示进入的动画效果以及显示的位置等等；


源码：package com.jauker.widget.BadgeView
具体使用方法：

private BadgeView mBadgeView;

//test badgeView
		TextView top_middle = (TextView)findViewById(R.id.top_middle);
		mBadgeView = new BadgeView(TestFunctionListActivity.this,top_middle);
		mBadgeView.setText("99+");
		mBadgeView.setTextColor(Color.WHITE);
//		mBadgeView.setTextSize(30);
		mBadgeView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT); //默认值
		mBadgeView.show();
		top_middle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 mBadgeView.toggle();
				
			}
		});




