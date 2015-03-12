package com.e_helper.app.ui;


import java.text.SimpleDateFormat;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.LogUtil.log;
import com.eWorld.e_helper.R;
import com.e_helper.app.common.UIHelper;
import com.e_helper.app.model.Message;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.widget.TextView;

public class AppPublicPushHandler extends BaseActivity {

	TextView titleTextView;
	TextView bTitleTextView;
	TextView bTimeTextView;
	TextView bContentTextView;
	TextView bAuthorTextView;
	
	Message message;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_public_push);
		
		initializeUI();
		loadMessage();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		UIHelper.showMainPage(this);
		return super.onKeyDown(keyCode, event);
	}
	
	/**
	 * 初始化UI
	 */
	private void initializeUI() {
		// 标题
		titleTextView = (TextView) this.findViewById(R.id.function_title);
		titleTextView.setText(R.string.user_info_title);
		
		bTimeTextView = (TextView) this.findViewById(R.id.app_msg_time);
		bTitleTextView = (TextView) this.findViewById(R.id.app_msg_title);
		bContentTextView = (TextView) this.findViewById(R.id.app_msg_content);
		bAuthorTextView = (TextView) this.findViewById(R.id.app_msg_author);
		
		bContentTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
	}
	
	/**
	 * 加载数据
	 */
	private void loadMessage() {
		AVQuery<Message> query = AVObject.getQuery(Message.class);
		query.whereEqualTo("messageType", "public");
		query.orderByDescending("createdAt");
		query.findInBackground(new FindCallback<Message>() {

			@Override
			public void done(List<Message> arg0, AVException arg1) {
				// TODO Auto-generated method stub
				if (arg0.size() == 0) {
					AppPublicPushHandler.this.finish();
					return;
				}
				message= arg0.get(0);
				if (null != message) {
					bTitleTextView.setText(message.getMessageTitle());
					bContentTextView.setText(message.getMessageContent());
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
					bTimeTextView.setText(format.format(message.getUpdatedAt()));
				}
			}
		});
	}
}
