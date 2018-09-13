package com.example.demo.formbean;

import java.sql.Timestamp;

import com.example.demo.entity.TUser;

public class RegisterFormBean {

	private TUser user = new TUser();

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public int hashCode() {
		return user.hashCode();
	}

	public String getUserId() {
		return user.getUserId();
	}

	public void setUserId(String userId) {
		user.setUserId(userId);
	}

	public String getUserName() {
		return user.getUserName();
	}

	public void setUserName(String userName) {
		user.setUserName(userName);
	}

	public String getUserPwd() {
		return user.getUserPwd();
	}

	public void setUserPwd(String userPwd) {
		user.setUserPwd(userPwd);
	}

	public String getUserContent() {
		return user.getUserContent();
	}

	public void setUserContent(String userContent) {
		user.setUserContent(userContent);
	}

	public String getStatus() {
		return user.getStatus();
	}

	public void setStatus(String status) {
		user.setStatus(status);
	}

	public Timestamp getCreateTime() {
		return user.getCreateTime();
	}

	public void setCreateTime(Timestamp createTime) {
		user.setCreateTime(createTime);
	}

	public Timestamp getUpdateTime() {
		return user.getUpdateTime();
	}

	public void setUpdateTime(Timestamp updateTime) {
		user.setUpdateTime(updateTime);
	}

	public String getUserSex() {
		return user.getUserSex();
	}

	public void setUserSex(String userSex) {
		user.setUserSex(userSex);
	}

	public Timestamp getUserBirth() {
		return user.getUserBirth();
	}

	public void setUserBirth(Timestamp userBirth) {
		user.setUserBirth(userBirth);
	}

	public String getUserIdentity() {
		return user.getUserIdentity();
	}

	public void setUserIdentity(String userIdentity) {
		user.setUserIdentity(userIdentity);
	}

	public String getUserAddress() {
		return user.getUserAddress();
	}

	public void setUserAddress(String userAddress) {
		user.setUserAddress(userAddress);
	}

	public String getUserSavor() {
		return user.getUserSavor();
	}

	public void setUserSavor(String userSavor) {
		user.setUserSavor(userSavor);
	}

	public String getUserIntroduction() {
		return user.getUserIntroduction();
	}

	public void setUserIntroduction(String userIntroduction) {
		user.setUserIntroduction(userIntroduction);
	}

	public String getUserPhoto() {
		return user.getUserPhoto();
	}

	public void setUserPhoto(String userPhoto) {
		user.setUserPhoto(userPhoto);
	}

	public String getRole() {
		return user.getRole();
	}

	public void setRole(String role) {
		user.setRole(role);
	}

	public String getMobile() {
		return user.getMobile();
	}

	public boolean equals(Object obj) {
		return user.equals(obj);
	}

	public void setMobile(String mobile) {
		user.setMobile(mobile);
	}

	public String getEmail() {
		return user.getEmail();
	}

	public void setEmail(String email) {
		user.setEmail(email);
	}

	public int getUserUuid() {
		return user.getUserUuid();
	}

	public void setUserUuid(int userUuid) {
		user.setUserUuid(userUuid);
	}

	public String toString() {
		return user.toString();
	}
	
	
}
