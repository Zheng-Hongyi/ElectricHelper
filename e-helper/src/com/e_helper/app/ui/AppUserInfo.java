package com.e_helper.app.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.eWorld.e_helper.R;
import com.e_helper.app.common.UIHelper;
import com.e_helper.app.model.Product;

import android.os.Bundle;
import android.widget.TextView;

public class AppUserInfo extends BaseActivity {

	TextView titleTextView;
	TextView userNumTextView;
	TextView userLastTextView;
	TextView currentBalanceTextView;
	TextView currentConsumtionTextView;
	TextView remainTextView;
	TextView peakTextView;
	
	Product product;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_user_info);
		initializeUI();
		loadData();
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
		titleTextView.setText(R.string.user_info_title);
		
		userNumTextView = (TextView) this.findViewById(R.id.app_user_info_num);
		userNumTextView.setText(AVUser.getCurrentUser().getString("username"));
		
		userLastTextView = (TextView) this.findViewById(R.id.app_user_info_last_login_time);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		userLastTextView.setText(format.format(AVUser.getCurrentUser().getDate("lastLoginTime")));
		
		currentBalanceTextView = (TextView) this.findViewById(R.id.app_user_current_balance);
		currentConsumtionTextView = (TextView) this.findViewById(R.id.app_user_elec_consumption);
		remainTextView = (TextView) this.findViewById(R.id.app_user_remain_elec);
		peakTextView = (TextView) this.findViewById(R.id.app_user_peak_elec);
	}
	
	/**
	 * 加载数据
	 */
	private void loadData() {
		AVQuery<Product> query = AVObject.getQuery(Product.class);
		query.whereEqualTo("user", AVUser.getCurrentUser());
		query.findInBackground(new FindCallback<Product>() {
			
			@Override
			public void done(List<Product> arg0, AVException arg1) {
				// TODO Auto-generated method stub
				if (arg0.size() == 0) {
					UIHelper.ToastMessage(getApplicationContext(), R.string.user_info_failed);
					return;
				}
				product = arg0.get(0);
				currentBalanceTextView.setText(String.valueOf(product.getDouble("currentBalance")));
				currentConsumtionTextView.setText(String.valueOf(product.getDouble("electricityConsumption")));
				remainTextView.setText(String.valueOf(product.getDouble("remainElectricity")));
				peakTextView.setText(String.valueOf(product.getDouble("peakCase")));
				
			}
		});
	}

}
