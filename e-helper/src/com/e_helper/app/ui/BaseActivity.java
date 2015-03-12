package com.e_helper.app.ui;


import com.e_helper.app.AppManager;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class BaseActivity extends Activity {

		// 是否允许全屏
		private boolean allowFullScreen = true;

		// 是否允许销毁
		private boolean allowDestroy = true;

		private View view;
		
		protected ImageLoader imageLoader = ImageLoader.getInstance();
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			allowFullScreen = true;
			// 添加Activity到堆栈
			AppManager.getAppManager().addActivity(this);
			initImageLoader(this);
		}

		@Override
		protected void onDestroy() {
			super.onDestroy();

			// 结束Activity&从堆栈中移除
			AppManager.getAppManager().finishActivity(this);
		}

		public boolean isAllowFullScreen() {
			return allowFullScreen;
		}
		
		/**
		 * 设置是否可以全屏
		 * 
		 * @param allowFullScreen
		 */
		public void setAllowFullScreen(boolean allowFullScreen) {
			this.allowFullScreen = allowFullScreen;
		}

		public void setAllowDestroy(boolean allowDestroy) {
			this.allowDestroy = allowDestroy;
		}

		public void setAllowDestroy(boolean allowDestroy, View view) {
			this.allowDestroy = allowDestroy;
			this.view = view;
		}

		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			if (keyCode == KeyEvent.KEYCODE_BACK && view != null) {
				view.onKeyDown(keyCode, event);
				if (!allowDestroy) {
					return false;
				}
			}
			return super.onKeyDown(keyCode, event);
		}
		
		public static void initImageLoader(Context context) {
	        // This configuration tuning is custom. You can tune every option, you may tune some of them,
	        // or you can create default configuration by
	        //  ImageLoaderConfiguration.createDefault(this);
	        // method.
			
	        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
	                        .threadPriority(Thread.NORM_PRIORITY - 2)
	                        .denyCacheImageMultipleSizesInMemory()
	                        .discCacheFileNameGenerator(new Md5FileNameGenerator())
	                        .tasksProcessingOrder(QueueProcessingType.LIFO)
	                        .writeDebugLogs() // Remove for release app
	                        .build();
	        // Initialize ImageLoader with configuration.
	        ImageLoader.getInstance().init(config);
		}
}
