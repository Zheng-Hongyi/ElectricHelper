package com.e_helper.app.model;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;

@AVClassName(Config.CLASS_NAME)
public class Config extends AVObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static final String CLASS_NAME="Config";
	
	private final String BANNER="banner";
	private final String PHONE="phoneNum";
	private final String PHONE2 = "tousuPhone";
	
	private AVFile banner;
	private String phoneNum;
	private String tousuPhone;
	
	

	public String getTousuPhone() {
		return this.getString(PHONE2);
	}

	public void setTousuPhone(String tousuPhone) {
		this.put(PHONE2, tousuPhone);
	}

	public String getPhoneNum() {
		return this.getString(PHONE);
	}

	public void setPhoneNum(String phoneNum) {
		this.put(PHONE, phoneNum);
	}

	public AVFile getBanner() {
		return this.getAVFile(BANNER);
	}

	public void setBanner(AVFile banner) {
		this.put(BANNER, banner);
	}

//	public static String getClassName() {
//		return CLASS_NAME;
//	}
//
//	public String getBANNER() {
//		return BANNER;
//	}
	
	

}
