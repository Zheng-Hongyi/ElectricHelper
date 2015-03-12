package com.e_helper.app.ui;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.eWorld.e_helper.R;
import com.e_helper.app.common.E_HelperConfig;
import com.e_helper.app.common.StringUtils;
import com.e_helper.app.common.UIHelper;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AppUserLogin extends BaseActivity {

	TextView titleTextView;
	private Button loginbButton;
	private Button registerButton;
	private EditText loginAccounEditText;
	private EditText loginPassEditText;
	InputMethodManager imm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_user_login);
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
		titleTextView.setText(R.string.login_title);
		
		imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
		loginAccounEditText = (EditText) findViewById(R.id.login_account);
		loginPassEditText = (EditText) findViewById(R.id.login_password);
		
		loginAccounEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(hasFocus){  
					imm.showSoftInput(v, 0);  
		        }  
		        else{  
		            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);  
		        } 
			}
		});
		loginPassEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(hasFocus){  
					imm.showSoftInput(v, 0);  
		        }  
		        else{  
		            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);  
		        } 
			}
		});
		
		loginbButton = (Button) findViewById(R.id.app_login_btn);
		registerButton = (Button) findViewById(R.id.app_register_btn);
		loginAccounEditText.clearFocus();
		loginPassEditText.clearFocus();
		
		loginbButton.setOnClickListener(loginClickListener);
		registerButton.setOnClickListener(registerClickListener);
	}
	
	/**
	 * 登陆
	 */
	OnClickListener loginClickListener =  new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			loginAccounEditText.clearFocus();
			loginPassEditText.clearFocus();
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(loginPassEditText.getWindowToken(), 0);
			String accountString = loginAccounEditText.getText().toString();
			String passString = loginPassEditText.getText().toString();
			if (StringUtils.isEmpty(accountString) || StringUtils.isEmpty(passString)) {
				UIHelper.ToastMessage(AppUserLogin.this, R.string.app_leave_name_or_pass);
			}else {
				AVUser.logInInBackground(accountString, passString, new LogInCallback() {
				    public void done(AVUser user, AVException e) {
				        if (user != null) {
				            // 登录成功
				        	AppUserLogin.this.finish();
				        	user.put("lastLoginTime", new Date());
				        	user.put("installationId", E_HelperConfig.getAppConfigs().getInstallationId());
				        	user.saveInBackground();
				        } else {
				            // 登录失败
				        	UIHelper.ToastMessage(getApplicationContext(), R.string.app_login_failed);
				        }
				    }
				});
			}
		}
	};
	/**
	 * 注册
	 */
	OnClickListener registerClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			UIHelper.showAppRegister(AppUserLogin.this);
			AppUserLogin.this.finish();
		}
	};

}
