package com.e_helper.app.ui;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.eWorld.e_helper.R;
import com.e_helper.app.adapter.AppCommonBusineseAdapter;
import com.e_helper.app.common.UIHelper;
import com.e_helper.app.model.Business;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.TextView;

public class AppCommonBusinese extends BaseActivity implements OnItemClickListener{

	TextView titleTextView;
	
	ListView mListView;
	AppCommonBusineseAdapter mAdapter;
	ArrayList<Business> listDatArrayList;
	/* (non-Javadoc)
	 * @see com.e_helper.app.ui.BaseActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_common_businese);
		initializeUI();
		initListView();
		loadBusinessDatas();
	}
	
	/**
	 * 初始化UI
	 */
	private void initializeUI() {
		// 标题
		titleTextView = (TextView) this.findViewById(R.id.function_title);
		titleTextView.setText(R.string.common_b_title);
	}
	
	/**
	 * 初始化列表
	 */
	private void initListView() {
		mListView = (ListView) this.findViewById(R.id.app_common_business_list);
		mListView.setOnItemClickListener(this);
	}
	
	/**
	 * 加载业务列表
	 */
	private void loadBusinessDatas() {
		AVQuery<Business> query = AVObject.getQuery(Business.class);
		query.orderByDescending("createdAt");
		query.findInBackground(new FindCallback<Business>() {
			
			@Override
			public void done(List<Business> arg0, AVException arg1) {
				// TODO Auto-generated method stub
				//ArrayList<Business> tempArrayList = arg0.toArray();
				if (arg0.size() == 0) {
					UIHelper.ToastMessage(AppCommonBusinese.this, R.string.common_b_noresults);
					return;
				}
				ArrayList<Business> tempArrayList = new ArrayList<Business>();
				for (Business business : arg0) {
					tempArrayList.add(business);
				}
				listDatArrayList = tempArrayList;
				AppCommonBusineseAdapter adapter = new AppCommonBusineseAdapter(AppCommonBusinese.this, tempArrayList);
				mListView.setAdapter(adapter);
				adapter.notifyDataSetChanged();
			}
		});
		
		
	}

//	@Override
//	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
//			long arg3) {
//		// TODO Auto-generated method stub
//		Business temBusiness = listDatArrayList.get(arg2);
//		UIHelper.showCommonBusinessDetail(this, temBusiness);
//	}
//
//	@Override
//	public void onNothingSelected(AdapterView<?> arg0) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Business temBusiness = listDatArrayList.get(arg2);
		UIHelper.showCommonBusinessDetail(this, temBusiness);
	}

}
