package com.e_helper.app.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

@AVClassName(CommonSense.COMMONSENSE_STRING)
public class CommonSense extends AVObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String COMMONSENSE_STRING = "CommonSense";
	
	private final String COMMONSENSETITLE = "commonSenseTitle";
	private final String COMMONSENSECONTENT = "commonSenseContent";
	private final String COMMONSENSEAUTHOR = "commonSenceAuthor";

	private String commonSenseTitle;
	private String commonSenseContent;
	private String commonSenceAuthor;
	
	
	public SerializedCommonSense generateSerializedModel() {
		SerializedCommonSense tempCommonSense = new SerializedCommonSense();
		tempCommonSense.setCommonSenceAuthor(this.getCommonSenceAuthor());
		tempCommonSense.setCommonSenceContent(this.getCommonSenseContent());
		tempCommonSense.setCommonSenceTitle(this.getCommonSenseTitle());
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		tempCommonSense.setCommonSenceTime(format.format(this.getCreatedAt()));
		return tempCommonSense;
	}
	
	public String getCommonSenceAuthor() {
		return this.getString(COMMONSENSEAUTHOR);
	}
	public void setCommonSenceAuthor(String commonSenceAuthor) {
		this.put(COMMONSENSEAUTHOR, commonSenceAuthor);
	}
	public String getCommonSenseTitle() {
		return commonSenseTitle;
	}
	public void setCommonSenseTitle(String commonSenseTitle) {
		this.put(COMMONSENSETITLE, commonSenseTitle);
	}
	public String getCommonSenseContent() {
		return this.getString(COMMONSENSECONTENT);
	}
	public void setCommonSenseContent(String commonSenseContent) {
		this.put(COMMONSENSECONTENT, commonSenseContent);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getCommonsenseString() {
		return COMMONSENSE_STRING;
	}
	public String getCOMMONSENSETITLE() {
		return COMMONSENSETITLE;
	}
	public String getCOMMONSENSECONTENT() {
		return COMMONSENSECONTENT;
	}
	
	
}
