package com.example.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "t_user")
public class TUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_uuid", nullable = false)
	private int userUuid;
	
	@Column(name = "user_id", nullable = false)
	private String userId;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "user_pwd", nullable = false)
	private String userPwd;

	@Column(name = "role", nullable = false)
	private String role;

	@Column(name = "user_content")
	private String userContent;

	@Column(name = "status")
	private String status;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	@CreationTimestamp
	@Column(name = "create_time", nullable = false, insertable = true, updatable = false)
	private Timestamp createTime;

	@UpdateTimestamp
	@Column(name = "update_time", nullable = false, insertable = true, updatable = true)
	private Timestamp updateTime;

	@Column(name = "user_sex")
	private String userSex;

	@Column(name = "user_birth")
	private Timestamp userBirth;

	@Column(name = "user_identity")
	private String userIdentity;

	@Column(name = "user_address")
	private String userAddress;

//	@Column(name = "user_name")
//	private String userName;

	@Column(name = "user_savor")
	private String userSavor;

	@Column(name = "user_introduction")
	private String userIntroduction;

	@Column(name = "user_photo")
	private String userPhoto;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Timestamp getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Timestamp userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}


	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserSavor() {
		return userSavor;
	}

	public void setUserSavor(String userSavor) {
		this.userSavor = userSavor;
	}

	public String getUserIntroduction() {
		return userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserContent() {
		return userContent;
	}

	public void setUserContent(String userContent) {
		this.userContent = userContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(int userUuid) {
		this.userUuid = userUuid;
	}




}
