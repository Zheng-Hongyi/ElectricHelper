package com.e_helper.app.ui;

import com.avos.avoscloud.feedback.FeedbackAgent;
import com.eWorld.e_helper.R;

import android.os.Bundle;
import android.widget.TextView;

public class AppOnlineBeg extends BaseActivity {

	TextView titleTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_online_beg);
		initializeUI();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	/**
	 * 初始化ui
	 */
	private void initializeUI() {
		// 标题
		titleTextView = (TextView) this.findViewById(R.id.function_title);
		titleTextView.setText(R.string.online_beg_title);
	}

}
