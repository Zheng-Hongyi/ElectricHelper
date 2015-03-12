package com.e_helper.app.ui;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.eWorld.e_helper.R;
import com.e_helper.app.adapter.AppCommonSenceAdapter;
import com.e_helper.app.adapter.AppMessageNofityAdapter;
import com.e_helper.app.common.UIHelper;
import com.e_helper.app.model.CommonSense;
import com.e_helper.app.model.Message;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class AppMessageNotify extends BaseActivity implements OnItemClickListener{

	TextView titleTextView;
	ListView mListView;
	
	ArrayList<Message> messages;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_msg_notify);
		initailizeUI();
		loadData();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	/**
	 * 初始化ui
	 */
	private void initailizeUI() {
		// 标题
		titleTextView = (TextView) this.findViewById(R.id.function_title);
		titleTextView.setText(R.string.msg_notify_title);
		
		mListView = (ListView) this.findViewById(R.id.app_message_list);
		mListView.setOnItemClickListener(this);
	}
	
	private void loadData() {
		AVQuery<Message> query = AVObject.getQuery(Message.class);
		query.whereEqualTo("user", AVUser.getCurrentUser());
		query.orderByDescending("createdAt");
		query.findInBackground(new FindCallback<Message>() {
			
			@Override
			public void done(List<Message> arg0, AVException arg1) {
				// TODO Auto-generated method stub
				if (arg0.size() == 0) {
					UIHelper.ToastMessage(AppMessageNotify.this, R.string.common_e_noresults);
					return;
				}
				messages = new ArrayList<Message>();
				for (Message message : arg0) {
					messages.add(message);
				}
				AppMessageNofityAdapter adapter = new AppMessageNofityAdapter(AppMessageNotify.this, messages);
				mListView.setAdapter(adapter);
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

}
