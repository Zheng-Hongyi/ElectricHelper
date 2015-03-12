package com.e_helper.app.ui;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.LogUtil.log;
import com.eWorld.e_helper.R;
import com.e_helper.app.adapter.AppCommonSenceAdapter;
import com.e_helper.app.common.UIHelper;
import com.e_helper.app.model.CommonSense;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.TextView;

public class AppCommonSence extends BaseActivity implements OnItemClickListener{

	
	TextView titleTextView;
	ListView mListView;
	AppCommonSenceAdapter mAdapter;
	ArrayList<CommonSense> mArrayList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_common_sence);
		initializeUI();
		loadDatas();
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
		titleTextView.setText(R.string.common_e_title);
		
		mListView = (ListView) this.findViewById(R.id.app_common_sense_list);
		mListView.setOnItemClickListener(this);
	}
	
	/**
	 * 加载数据
	 */
	private void loadDatas() {
		AVQuery<CommonSense> query = AVObject.getQuery(CommonSense.class);
		query.orderByDescending("createdAt");
		query.findInBackground(new FindCallback<CommonSense>() {
			
			@Override
			public void done(List<CommonSense> arg0, AVException arg1) {
				// TODO Auto-generated method stub
				if (arg0.size() == 0) {
					UIHelper.ToastMessage(AppCommonSence.this, R.string.common_e_noresults);
					return;
				}
				mArrayList = new ArrayList<CommonSense>();
				for (CommonSense commonSense : arg0) {
					mArrayList.add(commonSense);
				}
				AppCommonSenceAdapter adapter = new AppCommonSenceAdapter(AppCommonSence.this, mArrayList);
				mListView.setAdapter(adapter);
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		CommonSense temCommonSense = mArrayList.get(arg2);
		UIHelper.showCommonSenseDetail(this, temCommonSense);
	}

}
