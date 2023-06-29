package com.petpeers.modal;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userid;
	private String name;
	private String mobileNumber;
	private String cityName;
	
	public User(String name, String mobileNumber, String cityName) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.cityName = cityName;
	}
	public User(int userid) {
		super();
		this.userid = userid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid, String name, String mobileNumber, String cityName) {
		super();
		this.userid = userid;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", mobileNumber=" + mobileNumber + ", cityName=" + cityName
				+ "]";
	}
	public int getuserid() {
		return userid;
	}
	public void setuserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
