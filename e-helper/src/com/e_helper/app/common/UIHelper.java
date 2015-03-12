package com.e_helper.app.common;

import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.feedback.FeedbackAgent;
import com.e_helper.app.AppManager;
import com.e_helper.app.model.Business;
import com.e_helper.app.model.CommonSense;
import com.e_helper.app.ui.AppAboutUs;
import com.e_helper.app.ui.AppCommonBusinese;
import com.e_helper.app.ui.AppCommonBusinessDetail;
import com.e_helper.app.ui.AppCommonSence;
import com.e_helper.app.ui.AppCommonSenceDetail;
import com.e_helper.app.ui.AppMessageNotify;
import com.e_helper.app.ui.AppOnlineBeg;
import com.e_helper.app.ui.AppUserInfo;
import com.e_helper.app.ui.AppUserLogin;
import com.e_helper.app.ui.AppUserRegister;
import com.e_helper.app.ui.MainActivity;

import android.R.integer;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

/**
 * UI相关的操作
 * @author zheng
 *
 */
public class UIHelper {
	
	/**
	 * 进入主页
	 * @param context
	 */
	public static void showMainPage(Context context) {
		Intent intent = new Intent(context, MainActivity.class);
		context.startActivity(intent);
	}

	/**
	 * 进入用户信息
	 * @param context
	 */
	public static void showUserInfo(Context context) {
		Intent intent = new Intent(context, AppUserInfo.class);
		context.startActivity(intent);
	}
	
	/**
	 * 进入常规业务
	 * @param context
	 */
	public static void showCommonBusiness(Context context) {
		Intent intent = new Intent(context, AppCommonBusinese.class);
		context.startActivity(intent);
	}
	
	/**
	 * 进入用电常识
	 * @param context
	 */
	public static void showCommonSence(Context context) {
		Intent intent = new Intent(context, AppCommonSence.class);
		context.startActivity(intent);
	}
	
	/**
	 * 进入在线求助
	 * @param context
	 */
	public static void showOnlineBeg(Context context) {
		Intent intent = new Intent(context, AppOnlineBeg.class);
		context.startActivity(intent);
	}
	
	/**
	 * 进入消息界面
	 * @param context
	 */
	public static void showMessageNotify(Context context) {
		Intent intent = new Intent(context, AppMessageNotify.class);
		context.startActivity(intent);	
	}
	
	/**
	 * 进入关于页
	 * @param context
	 */
	public static void showAboutUs(Context context) {
		Intent intent = new Intent(context, AppAboutUs.class);
		context.startActivity(intent);
	}
	
	/**
	 * 进入业务详情
	 * @param context
	 * @param business
	 */
	public static void showCommonBusinessDetail(Context context, Business business) {
		Intent intent = new Intent(context, AppCommonBusinessDetail.class);
		intent.putExtra("business", business.generateSerializedModel());
		context.startActivity(intent);
	}
	
	/**
	 * 进入尝试详情
	 * @param context
	 * @param commonSense
	 */
	public static void showCommonSenseDetail(Context context, CommonSense commonSense) {
		Intent intent = new Intent(context, AppCommonSenceDetail.class);
		intent.putExtra("commonsense", commonSense.generateSerializedModel());
		context.startActivity(intent);
	}
	
	/**
	 * 用户登录
	 * @param context
	 */
	public static void showAppLogin(Context context) {
		Intent intent = new Intent(context, AppUserLogin.class);
		context.startActivity(intent);
	}
	
	/**
	 * 用户注册
	 * @param context
	 */
	public static void showAppRegister(Context context) {
		Intent intent = new Intent(context, AppUserRegister.class);
		context.startActivity(intent);
	}
	
	/**
	 * 用户反馈
	 * @param context
	 */
	public static void showFeedback(Context context) {
		FeedbackAgent agent = new FeedbackAgent(context);
		agent.startDefaultThreadActivity();
	}
	
	/**
	 * 显示提示信息
	 * @param cont
	 * @param msg
	 */
	public static void ToastMessage(Context cont, String msg) {
		Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
	}

	public static void ToastMessage(Context cont, int msg) {
		Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
	}

	public static void ToastMessage(Context cont, String msg, int time) {
		Toast.makeText(cont, msg, time).show();
	}
	
	/**
	 * 退出应用程序
	 * @param context
	 */
	
	public static void exitApp(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(android.R.drawable.ic_dialog_info);
		builder.setTitle("确定退出程序吗？");
		builder.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						// 退出
						AVUser.logOut();
						AppManager.getAppManager().AppExit(context);
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
}
