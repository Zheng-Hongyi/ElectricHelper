package com.e_helper.app.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.eWorld.e_helper.R.string;


@AVClassName(Message.CLASS_NAME)
public class Message extends AVObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static final String CLASS_NAME = "Message"; 
	public final String MESSAGE_TYPE = "messageType";
	private final String MESSAGE_CONTENT = "messageContent";
	private final String MESSAGE_USER = "user";
	private final String MESSAGE_TITLE="messageTitle";
	
	private String messageType;
	private String messageContent;
	private String messageTitle;
	private AVUser user;
	public String getMessageTitle() {
		return this.getString(MESSAGE_TITLE);
	}
	public void setMessageTitle(String messageTitle) {
		this.put(MESSAGE_TITLE, messageTitle);
	}
	public String getMessageType() {
		return this.getString(MESSAGE_TYPE);
	}
	public void setMessageType(String messageType) {
		this.put(MESSAGE_TYPE, messageType);
	}
	public String getMessageContent() {
		return this.getString(MESSAGE_CONTENT);
	}
	public void setMessageContent(String messageContent) {
		this.put(messageContent, messageContent);
	}
	public AVUser getUser() {
		return this.getAVUser(MESSAGE_USER);
	}
	public void setUser(AVUser user) {
		this.put(MESSAGE_USER, user);
	}
	public String getMESSAGE_TYPE() {
		return MESSAGE_TYPE;
	}
	public String getMESSAGE_CONTENT() {
		return MESSAGE_CONTENT;
	}
	public String getMESSAGE_USER() {
		return MESSAGE_USER;
	}
	
	

}
