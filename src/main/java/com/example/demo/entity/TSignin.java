package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_signin")
public class TSignin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sign_id", unique = true, nullable = false)
	private int signId;
	@Column(name = "activity_name")
	private String activityName;
	@Column(name = "activity_id", nullable = false)
	private int activityId;
	@Column(name = "user_id", nullable = false)
	private int userId;
	@Column(name = "join_time")
	private String joinTime;
	@Column(name = "signin_status")
	private String signinStatus;
	
	
	public int getSignId() {
		return signId;
	}
	public void setSignId(int signId) {
		this.signId = signId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	public String getSigninStatus() {
		return signinStatus;
	}
	public void setSigninStatus(String signinStatus) {
		this.signinStatus = signinStatus;
	}
	
}
