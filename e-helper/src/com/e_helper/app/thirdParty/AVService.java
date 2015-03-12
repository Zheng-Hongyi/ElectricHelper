package com.e_helper.app.thirdParty;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.PushService;
import com.avos.avoscloud.SaveCallback;
import com.e_helper.app.AppConfig;
import com.e_helper.app.common.E_HelperConfig;
import com.e_helper.app.model.Business;
import com.e_helper.app.model.CommonSense;
import com.e_helper.app.model.Config;
import com.e_helper.app.model.Message;
import com.e_helper.app.model.Product;
import com.e_helper.app.ui.AppDefaultPushHandler;
import com.e_helper.app.ui.AppPrivatePushHandler;
import com.e_helper.app.ui.AppPublicPushHandler;

import android.R.anim;
import android.content.Context;

public class AVService {

	public static void AVInit(Context ct) {
		System.out.println("hello world");
		AVOSCloud.initialize(ct, AppConfig.AVOS_APP_ID, AppConfig.AVOS_APP_KEY);
		AVObject.registerSubclass(Business.class);
		AVObject.registerSubclass(CommonSense.class);
		AVObject.registerSubclass(Product.class);
		AVObject.registerSubclass(Message.class);
		AVObject.registerSubclass(Config.class);
//		AVOSCloud.initialize(ct, "70l90kzm53nplnu013ala0j8wipr594d36m5zuz94ukvmh5s",
//		        "lamrsuheyiaqcx4o7m3jaz4awaeukerit1mucnjwk7ibokfv");
		//AVObject.registerSubclass(Business.class);
	}
	
	public static void AVPushInit(Context context) {
		// set a default callback. It's necessary for current SDK.
		// 在v2.0以后的版本请务必添加这段代码，以避免推送无法成功达到客户端的问题
		PushService.setDefaultPushCallback(context, AppDefaultPushHandler.class);
		PushService.subscribe(context, "public", AppPublicPushHandler.class);
		PushService.subscribe(context, "private", AppPrivatePushHandler.class);
		
		 AVInstallation.getCurrentInstallation().saveInBackground(new SaveCallback() {
		      @Override
		      public void done(AVException e) {
		        AVInstallation.getCurrentInstallation().saveInBackground();
		        if (null == e) {
		        	String installationId = AVInstallation.getCurrentInstallation().getInstallationId();
		        	E_HelperConfig.getAppConfigs().setInstallationId(installationId);
				} else {

				}
		      }
		    });
	}
}
