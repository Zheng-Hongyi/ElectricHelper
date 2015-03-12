package com.e_helper.app;

import com.e_helper.app.thirdParty.AVService;

import android.app.Application;

public class EHelperApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		AVService.AVInit(this);
	}
}
