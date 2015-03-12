package com.e_helper.app.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import android.annotation.SuppressLint;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVClassName;

@AVClassName(Business.BusinessClass)
public class Business extends AVObject implements Serializable{

     /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 public static final String BusinessClass = "Business";
	 private static final String B_TITLE_STRING = "businessName";
	 private static final String B_INTRO_STRING = "businessIntro";
	 private static final String B_INTRO_RELEASEUSER = "releaseUser";
	 
	 public String businessName;
	 public String businessIntro;
	 public String releaseUser;
	 
	 
   @SuppressLint("SimpleDateFormat")
   public SerializedBusiness generateSerializedModel() {
		SerializedBusiness temp = new SerializedBusiness();
		temp.setBusinessAuthorString(this.getReleaseUser());
		temp.setBusinessContentString(this.getBusinessIntro());
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		temp.setBusinessTimeString(format.format(getCreatedAt()));
		temp.setBusinessTitlelString(this.getBusinessName());
		return temp;
	}
	 
	 public String getReleaseUser() {
		return this.getString(B_INTRO_RELEASEUSER);
	}
	public void setReleaseUser(String releaseUser) {
		this.put(B_INTRO_RELEASEUSER, releaseUser);
	}
	public static String getbIntroReleaseuser() {
		return B_INTRO_RELEASEUSER;
	}
	
	public String getBusinessName() {
		return this.getString(B_TITLE_STRING);
	}
	public void setBusinessName(String businessName) {
		this.put(B_TITLE_STRING, businessName);
	}
	public String getBusinessIntro() {
		return this.getString(B_INTRO_STRING);
	}
	public void setBusinessIntro(String businessIntro) {
		this.put(B_INTRO_STRING, businessIntro);
	}
	public static String getBusinessclass() {
		return BusinessClass;
	}
	public static String getbTitleString() {
		return B_TITLE_STRING;
	}
	public static String getbIntroString() {
		return B_INTRO_STRING;
	}
	 
	 
}
