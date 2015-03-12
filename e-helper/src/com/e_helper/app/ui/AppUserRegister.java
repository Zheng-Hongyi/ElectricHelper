package com.e_helper.app.ui;

import java.util.Date;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.eWorld.e_helper.R;
import com.eWorld.e_helper.R.layout;
import com.e_helper.app.common.E_HelperConfig;
import com.e_helper.app.common.StringUtils;
import com.e_helper.app.common.UIHelper;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AppUserRegister extends BaseActivity {

	TextView titleTextView;
	private Button registerButton;
	private EditText loginAccounEditText;
	private EditText loginPassEditText;
	private EditText loginConfirmPassEditText;
	InputMethodManager imm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_user_register);
		initializeUI();
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
		titleTextView.setText(R.string.register_title);
		
		imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
		loginAccounEditText = (EditText) findViewById(R.id.register_account);
		loginPassEditText = (EditText) findViewById(R.id.register_password);
		loginConfirmPassEditText = (EditText) findViewById(R.id.register_confirm_pass);
		
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
		
		loginConfirmPassEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
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
		
		registerButton = (Button) findViewById(R.id.app_register_register_btn);
		loginAccounEditText.clearFocus();
		loginPassEditText.clearFocus();
		loginConfirmPassEditText.clearFocus();
		registerButton.setOnClickListener(registerClickListener);
	}
	
	/**
	 * 注册
	 */
	OnClickListener registerClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String accountString = loginAccounEditText.getText().toString();
			String passString = loginPassEditText.getText().toString();
			String confirmString = loginConfirmPassEditText.getText().toString();
			if (StringUtils.isEmpty(accountString) || StringUtils.isEmpty(passString) || StringUtils.isEmpty(confirmString)) {
				UIHelper.ToastMessage(getApplicationContext(), R.string.register_leave_msg);
			} else if (!passString.equals(confirmString)) {
				UIHelper.ToastMessage(getApplicationContext(), R.string.register_pass_un_same);
			} else {
				AVUser user = new AVUser();
				user.setUsername(accountString);
				user.setPassword(passString);

				user.signUpInBackground(new SignUpCallback() {
				    public void done(AVException e) {
				        if (e == null) {
				            // successfully
				        	AVUser user = AVUser.getCurrentUser();
				        	user.put("lastLoginTime", new Date());
				        	user.put("installationId", E_HelperConfig.getAppConfigs().getInstallationId());
				        	user.saveInBackground();
				        	AppUserRegister.this.finish();
				        } else {
				            // failed
				        	UIHelper.ToastMessage(getApplicationContext(), R.string.app_register_failed);
				        }
				    }
				});
			}
		}
	};
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		UIHelper.showAppLogin(this);
		this.finish();
		return false; 
	}
}
