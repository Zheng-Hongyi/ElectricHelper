package com.e_helper.app.model;

import java.io.Serializable;

public class SerializedBusiness implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String businessTitlelString;
	String businessTimeString;
	String businessAuthorString;
	String businessContentString;
	public String getBusinessTitlelString() {
		return businessTitlelString;
	}
	public void setBusinessTitlelString(String businessTitlelString) {
		this.businessTitlelString = businessTitlelString;
	}
	public String getBusinessTimeString() {
		return businessTimeString;
	}
	public void setBusinessTimeString(String businessTimeString) {
		this.businessTimeString = businessTimeString;
	}
	public String getBusinessAuthorString() {
		return businessAuthorString;
	}
	public void setBusinessAuthorString(String businessAuthorString) {
		this.businessAuthorString = businessAuthorString;
	}
	public String getBusinessContentString() {
		return businessContentString;
	}
	public void setBusinessContentString(String businessContentString) {
		this.businessContentString = businessContentString;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
