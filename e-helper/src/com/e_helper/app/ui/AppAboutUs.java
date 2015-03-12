package com.e_helper.app.ui;

import com.avos.avoscloud.AVUser;
import com.eWorld.e_helper.R;
import com.eWorld.e_helper.R.string;
import com.e_helper.app.AppManager;
import com.e_helper.app.common.E_HelperConfig;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppAboutUs extends BaseActivity {

	
	TextView titleTextView;
	LinearLayout phoneLayout;
	LinearLayout tousuLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_about_us);
		initializeUI();
	}
	
	/**
	 * 初始化标题
	 */
	private void initializeUI() {
		// 标题
		titleTextView = (TextView) this.findViewById(R.id.function_title);
		titleTextView.setText(R.string.about_us_title);
		
		tousuLayout = (LinearLayout) this.findViewById(R.id.tousu);
		tousuLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(AppAboutUs.this);
				builder.setIcon(android.R.drawable.ic_dialog_info);
				final String phoneString = E_HelperConfig.getAppConfigs().getAvConfig().getTousuPhone();
				builder.setTitle("确定拨打电话给："+ phoneString +"?");
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
								// 退出
								call(phoneString);
							}
						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
							}
						});
				builder.show();
			}
		});
		phoneLayout = (LinearLayout) this.findViewById(R.id.phone_us);
		phoneLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(AppAboutUs.this);
				builder.setIcon(android.R.drawable.ic_dialog_info);
				final String phoneString = E_HelperConfig.getAppConfigs().getAvConfig().getPhoneNum();
				builder.setTitle("确定拨打电话给："+ phoneString +"?");
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
								// 退出
								call(phoneString);
							}
						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
							}
						});
				builder.show();
			}
		});
	}
	
	private void call(String phoneString) {
		try {
			
			   Intent intent = new Intent(Intent.ACTION_CALL);
			
			   intent.setData(Uri.parse("tel:"+ phoneString));
			
			   startActivity(intent);
			
			} catch (Exception e) {
			
			   Log.e("SampleApp", "Failed to invoke call", e);
			
			}
	}

}
