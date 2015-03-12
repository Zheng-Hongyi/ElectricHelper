package com.e_helper.app.model;

import java.io.Serializable;

public class SerializedCommonSense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String commonSenceAuthor;
	private String commonSenceContent;
	private String commonSenceTitle;
	private String commonSenceTime;
	public String getCommonSenceTime() {
		return commonSenceTime;
	}
	public void setCommonSenceTime(String commonSenceTime) {
		this.commonSenceTime = commonSenceTime;
	}
	public String getCommonSenceAuthor() {
		return commonSenceAuthor;
	}
	public void setCommonSenceAuthor(String commonSenceAuthor) {
		this.commonSenceAuthor = commonSenceAuthor;
	}
	public String getCommonSenceContent() {
		return commonSenceContent;
	}
	public void setCommonSenceContent(String commonSenceContent) {
		this.commonSenceContent = commonSenceContent;
	}
	public String getCommonSenceTitle() {
		return commonSenceTitle;
	}
	public void setCommonSenceTitle(String commonSenceTitle) {
		this.commonSenceTitle = commonSenceTitle;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
