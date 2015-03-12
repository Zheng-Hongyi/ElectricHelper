package com.e_helper.app.model;

import java.io.Serializable;
import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;

@AVClassName("Product")
public class Product extends AVObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double currentBalance;
	private double electricityConsumption;
	private double peakCase;
	private double remainElectricity;
	private AVUser user;
	
	private final String PRODUCT_BALANCE = "currentBalance"; 
	private final String PRODUCT_CONSUMPTION="electricityConsumption";
	private final String PRODUCT_PEAKCASE="peakCase";
	private final String PRODUCT_REMAIN = "remainElectricity";
	private final String PRODUCT_USER = "user";
	

	public double getCurrentBalance() {
		return this.getDouble(PRODUCT_BALANCE);
	}
	public void setCurrentBalance(double currentBalance) {
		this.put(PRODUCT_BALANCE, currentBalance);
	}
	public double getElectricityConsumption() {
		return this.getDouble(PRODUCT_CONSUMPTION);
	}
	public void setElectricityConsumption(double electricityConsumption) {
		this.put(PRODUCT_CONSUMPTION, electricityConsumption);
	}
	public double getPeakCase() {
		return this.getDouble(PRODUCT_PEAKCASE);
	}
	public void setPeakCase(double peakCase) {
		this.put(PRODUCT_PEAKCASE, peakCase);
	}
	public double getRemainElectricity() {
		return this.getDouble(PRODUCT_REMAIN);
	}
	public void setRemainElectricity(double remainElectricity) {
		this.put(PRODUCT_REMAIN, remainElectricity);
	}
	public AVUser getUser() {
		return this.getAVUser(PRODUCT_USER);
	}
	public void setUser(AVUser user) {
		this.put(PRODUCT_USER, user);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPRODUCT_BALANCE() {
		return PRODUCT_BALANCE;
	}
	public String getPRODUCT_CONSUMPTION() {
		return PRODUCT_CONSUMPTION;
	}
	public String getPRODUCT_PEAKCASE() {
		return PRODUCT_PEAKCASE;
	}
	public String getPRODUCT_REMAIN() {
		return PRODUCT_REMAIN;
	}
	public String getPRODUCT_USER() {
		return PRODUCT_USER;
	}
	
	

}
