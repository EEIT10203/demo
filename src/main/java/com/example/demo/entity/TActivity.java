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
@Table(name = "t_activity")
public class TActivity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_id", unique = true, nullable = false)
	private int activityId;

	@Column(name = "activity_name", nullable = false)
	private String activityName;

	@Column(name = "activity_date", nullable = false)
	private Timestamp activityDate;

	@Column(name = "activity_place", nullable = false)
	private String activityPlace;

	@Column(name = "actiivity_description")
	private String actiivityDescription;

	@Column(name = "create_user", nullable = false, insertable = true, updatable = false)
	private String createUser;

	@CreationTimestamp
	@Column(name = "create_time", nullable = false, insertable = true, updatable = false)
	private Timestamp createTime;

	@Column(name = "update_user", nullable = false, insertable = true, updatable = true)
	private String updateUser;

	@UpdateTimestamp
	@Column(name = "update_time", nullable = false, insertable = true, updatable = true)
	private Timestamp updateTime;

	@Column(name = "activity_image")
	private String activityImage;

	@Column(name = "activity_host")
	private String activityHost;

	@Column(name = "host_mail")
	private String hostMail;

	@Column(name = "host_tel")
	private String hostTel;

	@Column(name = "joinnum")
	private int joinnum;

	@Column(name = "end_time")
	private Timestamp endTime;

	@Column(name = "maxnum")
	private int maxnum;

	@Column(name = "minnum")
	private int minnum;

	@Column(name = "activity_map")
	private String activityMap;

	@Column(name = "activity_type")
	private String activityType;

	@Column(name = "tag_activity")
	private String tagActivity;

	@Column(name = "tag_location")
	private String tagLocation;

	@Column(name = "activity_status")
	private String activityStatus;

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getActivityId() {
		return activityId;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Timestamp getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Timestamp activityDate) {
		this.activityDate = activityDate;
	}

	public String getActivityPlace() {
		return activityPlace;
	}

	public void setActivityPlace(String activityPlace) {
		this.activityPlace = activityPlace;
	}

	public String getActiivityDescription() {
		return actiivityDescription;
	}

	public void setActiivityDescription(String actiivityDescription) {
		this.actiivityDescription = actiivityDescription;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getActivityImage() {
		return activityImage;
	}

	public void setActivityImage(String activityImage) {
		this.activityImage = activityImage;
	}

	public String getActivityHost() {
		return activityHost;
	}

	public void setActivityHost(String activityHost) {
		this.activityHost = activityHost;
	}

	public String getHostMail() {
		return hostMail;
	}

	public void setHostMail(String hostMail) {
		this.hostMail = hostMail;
	}

	public String getHostTel() {
		return hostTel;
	}

	public void setHostTel(String hostTel) {
		this.hostTel = hostTel;
	}

	public int getJoinnum() {
		return joinnum;
	}

	public int getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}

	public int getMinnum() {
		return minnum;
	}

	public void setMinnum(int minnum) {
		this.minnum = minnum;
	}

	public void setJoinnum(int joinnum) {
		this.joinnum = joinnum;
	}

	public String getTagActivity() {
		return tagActivity;
	}

	public void setTagActivity(String tagActivity) {
		this.tagActivity = tagActivity;
	}

	public String getTagLocation() {
		return tagLocation;
	}

	public void setTagLocation(String tagLocation) {
		this.tagLocation = tagLocation;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityMap() {
		return activityMap;
	}

	public void setActivityMap(String activityMap) {
		this.activityMap = activityMap;
	}

}
