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

Come on��Freedom! You will achieve more happiness and fulfillment.


Luminous point 1: Omnipotent ViewHolder and Common Adapter for ListView
-----------------------------------------------------------------------------
Omnipotent ViewHolder: 

package com.freedom.copy_wechat.common.utils.adapter;

public class ViewHolder {
}

 * ViewHolder������:ͨ��convertView.setTag��convertView���а�

 * ��convertView����ʱ��ֱ�Ӵ���֮���ڵ�ViewHolder(getTag)���õ�convertView�����еĿؼ���ʡȥ��findViewById��ʱ�䡣

 * ʵ������ÿ��convertView���һ��ViewHolder����viewHolder��Ҫ�ǰ�convertView�洢�����еĿؼ���

 * ��˳��һ��ͨ�õ�ViewHolder��ȫ�п��ܣ����������convertView���ṩһ����������setTag���ɡ�

 * ��Բ�ͬ��Item���֣��ṩһ��������ר�Ŵ�ÿ��Item�����е����пؼ���

 * ���һ��ܸ��ݿؼ���Idͨ��getView(int viewId)�������ҳ�����

 * ��Ȼ��ͨ�����ҷ�ʽ����ôListView�϶������ˣ���Ҫһ����ֵ�Խ��б��棬��Ϊ�ؼ���Id��ֵΪ�ؼ������ã�Map���ԴﵽĿ�ģ�

 * �����������б�Map���õ�����࣬android�ṩ��SparseArray�࣬��Map���ƣ����Ǳ�MapЧ�ʣ�������ֻ��ΪInteger.

Common Adapter for ListView��

package com.freedom.copy_wechat.common.utils.adapter;

public abstract class CommonAdapter<T> extends BaseAdapter {
}

 * Adapter�����ã�ʹ���ݰ󶨵��ؼ���ø��Ӽ򵥺���Ϊ�����ṩ����ͼ��������ͼ�����ݺ�Ԫ����������ÿ������ͼ��

 * ���õ�Adapter�� arrayAdapter  ��simpleCursorAdapter�� cursorAdapter�� resourceCursorAdapter �ȡ�

 * �����Ҫ�Զ��������� ������չ������BaseAdapter

 * CommonAdapter һ�������࣬��չ�˳�����BaseAdapter���̳�BaseAdapter��getView�ȷ�����getView��ʵ��������ͨ�õ�ViewHolder��

 * CommonAdapter�ĳ��󷽷���public abstract void convert(ViewHolder holder, T item);
	
 * ���⣬Adapterһ����Ҫ����һ��List���󣬴洢һ��Bean�ļ��ϣ���ͬ��ListView��Bean�϶��ǲ�ͬ�ģ�

 * ������CommonAdapter�϶���Ҫ֧�ַ��ͣ��ڲ�ά��һ��List<T>��ʹ�÷������£�
 
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
RefleshListView������ˢ���б�

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
BadgeView��һ����Դ���
��Ҫ�̳���TextView��ʵ���Ͼ���һ��TextView���ײ����һ��label��
�����Զ��屳��ͼ���Զ��屳����ɫ���Ƿ���ʾ����ʾ����Ķ���Ч���Լ���ʾ��λ�õȵȣ�


Դ�룺package com.jauker.widget.BadgeView
����ʹ�÷�����

private BadgeView mBadgeView;

//test badgeView
		TextView top_middle = (TextView)findViewById(R.id.top_middle);
		mBadgeView = new BadgeView(TestFunctionListActivity.this,top_middle);
		mBadgeView.setText("99+");
		mBadgeView.setTextColor(Color.WHITE);
//		mBadgeView.setTextSize(30);
		mBadgeView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT); //Ĭ��ֵ
		mBadgeView.show();
		top_middle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 mBadgeView.toggle();
				
			}
		});




