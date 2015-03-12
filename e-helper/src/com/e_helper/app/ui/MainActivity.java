package com.e_helper.app.ui;

import java.util.List;

import org.w3c.dom.Comment;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.eWorld.e_helper.R;
import com.eWorld.e_helper.R.layout;
import com.e_helper.app.AppConfig;
import com.e_helper.app.common.E_HelperConfig;
import com.e_helper.app.common.UIHelper;
import com.e_helper.app.model.Config;
import com.e_helper.app.thirdParty.AVService;
public class MainActivity extends BaseActivity {

	TextView titleTextView;
	ImageView imageView;
	
	LinearLayout userInfoView;
	LinearLayout commonBuseView;
	LinearLayout eCommonView;
	LinearLayout onlineBegView;
	LinearLayout messageView;
	LinearLayout aboutView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// initialize avos
		AVService.AVInit(this);
		//AVService.AVPushInit(this);
		
		// 
		initilizeUI();
		loadData();
		
	}
	
	/**
	 * load data
	 */
	private void loadData() {
		AVQuery<Config> query = AVObject.getQuery(Config.class);
		query.findInBackground(new FindCallback<Config>() {
			
			@Override
			public void done(List<Config> arg0, AVException arg1) {
				// TODO Auto-generated method stub
				if (arg0.size() > 0) {
					Config config = arg0.get(0);
					E_HelperConfig.getAppConfigs().setAvConfig(config);
					AVFile avFile = config.getBanner();
					String urlString = avFile.getUrl();
					imageLoader.displayImage(urlString, imageView);
				}
			}
		});
	}
	
	/**
	 * 初始化标题
	 */
	private void initilizeUI() {
		// 标题
		titleTextView = (TextView) this.findViewById(R.id.function_title);
		titleTextView.setText(R.string.main_title);
		
		imageView = (ImageView) this.findViewById(R.id.main_banner);
		
		// 用户信息
		userInfoView = (LinearLayout)findViewById(R.id.main_item_userinfo);
		ImageView uImageView = (ImageView)userInfoView.findViewById(R.id.main_item_icon);
		uImageView.setImageDrawable(getResources().getDrawable(R.drawable.main_item_user_info));
		TextView uTitleTextView = (TextView) userInfoView.findViewById(R.id.main_item_title);
		uTitleTextView.setText(R.string.main_item_userinfo);
		userInfoView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AVUser currentUser = AVUser.getCurrentUser();
				if (currentUser != null) {
					UIHelper.showUserInfo(MainActivity.this);
				} else {
					UIHelper.showAppLogin(MainActivity.this);
				}
				
			}
		});
	
		// 常规业务
		commonBuseView = (LinearLayout)findViewById(R.id.main_item_common_buse);
		ImageView cImageView = (ImageView)commonBuseView.findViewById(R.id.main_item_icon);
		cImageView.setImageDrawable(getResources().getDrawable(R.drawable.main_item_common_business));
		TextView cTitleTextView = (TextView) commonBuseView.findViewById(R.id.main_item_title);
		cTitleTextView.setText(R.string.main_item_common_buse);
		commonBuseView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UIHelper.showCommonBusiness(MainActivity.this);
			}
		});
		
		// 用电常识
		eCommonView = (LinearLayout) findViewById(R.id.main_item_common_sence);
		ImageView eImageView = (ImageView)eCommonView.findViewById(R.id.main_item_icon);
		eImageView.setImageDrawable(getResources().getDrawable(R.drawable.main_item_common_sense));
		TextView eTitleTextView = (TextView) eCommonView.findViewById(R.id.main_item_title);
		eTitleTextView.setText(R.string.main_item_e_common_sence);
		eCommonView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UIHelper.showCommonSence(MainActivity.this);
			}
		});
		
		// 在线求助
		onlineBegView = (LinearLayout)findViewById(R.id.main_item_online_bed);
		ImageView oImageView = (ImageView)onlineBegView.findViewById(R.id.main_item_icon);
		oImageView.setImageDrawable(getResources().getDrawable(R.drawable.main_item_online_chat));
		TextView oTitleTextView = (TextView) onlineBegView.findViewById(R.id.main_item_title);
		oTitleTextView.setText(R.string.main_item_online_beg);
		onlineBegView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//UIHelper.showOnlineBeg(MainActivity.this);
				UIHelper.showFeedback(MainActivity.this);
			}
		});
		
		// 消息通知
		messageView = (LinearLayout)findViewById(R.id.main_item_msg_notify);
		ImageView mImageView = (ImageView)messageView.findViewById(R.id.main_item_icon);
		mImageView.setImageDrawable(getResources().getDrawable(R.drawable.main_item_message));
		TextView mTitleTextView = (TextView) messageView.findViewById(R.id.main_item_title);
		mTitleTextView.setText(R.string.main_item_message_notify);
		messageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AVUser currentAvUser = AVUser.getCurrentUser();
				if (null == currentAvUser) {
					UIHelper.showAppLogin(MainActivity.this);
				} else {
					UIHelper.showMessageNotify(MainActivity.this);
				}
			}
		});
		
		// 关于我们
		aboutView = (LinearLayout) findViewById(R.id.main_item_about_us);
		ImageView aImageView = (ImageView)aboutView.findViewById(R.id.main_item_icon);
		aImageView.setImageDrawable(getResources().getDrawable(R.drawable.main_item_feedback));
		TextView aTitleTextView = (TextView) aboutView.findViewById(R.id.main_item_title);
		aTitleTextView.setText(R.string.main_item_about_us);
		aboutView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UIHelper.showAboutUs(MainActivity.this);
			}
		});
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		UIHelper.exitApp(this);
		return false; 
	}
}
