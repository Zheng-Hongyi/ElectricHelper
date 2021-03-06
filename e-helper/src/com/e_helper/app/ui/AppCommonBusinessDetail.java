package com.e_helper.app.ui;

import java.text.SimpleDateFormat;

import com.eWorld.e_helper.R;
import com.e_helper.app.model.Business;
import com.e_helper.app.model.SerializedBusiness;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class AppCommonBusinessDetail extends BaseActivity {

	TextView titleTextView;
	TextView bTitleTextView;
	TextView bTimeTextView;
	TextView bContentTextView;
	TextView bAuthorTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_common_business_detail);
		initializeUI();
		initData();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	/**
	 * 初始化UI
	 */
	private void initializeUI() {
		// 标题
		titleTextView = (TextView) this.findViewById(R.id.function_title);
		titleTextView.setText(R.string.common_b_business_title);
		
		bTimeTextView = (TextView) this.findViewById(R.id.app_common_b_d_time);
		bTitleTextView = (TextView) this.findViewById(R.id.app_common_b_d_title);
		bContentTextView = (TextView) this.findViewById(R.id.app_common_b_d_content);
		bAuthorTextView = (TextView) this.findViewById(R.id.app_common_b_d_author);
		
		bContentTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
	}
	
	/**
	 * 初始化数据
	 */
	private void initData() {
		SerializedBusiness business = (SerializedBusiness)getIntent().getSerializableExtra("business");
		if (null != business) {
			bTitleTextView.setText(business.getBusinessTitlelString());
			bAuthorTextView.setText(business.getBusinessAuthorString().toString());
			bContentTextView.setText(business.getBusinessContentString().toString());
			bTimeTextView.setText(business.getBusinessTimeString());
		}
		
	}

}
