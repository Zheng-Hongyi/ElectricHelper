package com.e_helper.app.adapter;

import java.util.ArrayList;

import com.eWorld.e_helper.R;
import com.e_helper.app.model.Message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AppMessageNofityAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private ArrayList<Message> messages;
	
	public AppMessageNofityAdapter(Context context,ArrayList<Message> list) {
		// TODO Auto-generated constructor stub
		super();
		this.mInflater = LayoutInflater.from(context);
		this.messages = list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return messages.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return messages.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (arg1 == null) {
			arg1 = mInflater.inflate(R.layout.app_msg_notify_list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.titleTextView = (TextView) arg1.findViewById(R.id.app_msg_list_item_title);
			viewHolder.contentTextView = (TextView) arg1.findViewById(R.id.app_msg_content);
			arg1.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) arg1.getTag();
		}
		Message msg = messages.get(arg0);
		viewHolder.contentTextView.setText(msg.getMessageContent());
		viewHolder.titleTextView.setText(msg.getMessageTitle());
		return arg1;
	}
	
	public class ViewHolder {
		TextView titleTextView;
		TextView contentTextView;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
