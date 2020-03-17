package com.glarimy.cmad;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;


public class User {
	@Id
    @GeneratedValue 
	private int UserId;
	private String UserName;
	private String PassWord;
	private long MobileNumber;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	
	
}