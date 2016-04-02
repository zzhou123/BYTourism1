package com.ezz.bean;

import android.R.integer;

public class Scenic {
	private int id;
	private String scenicname;
	private String describe;
	private int cityid;
	private int avggrade;
	private int gradenum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScenicname() {
		return scenicname;
	}
	public void setScenicname(String scenicname) {
		this.scenicname = scenicname;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getAvggrade() {
		return avggrade;
	}
	public void setAvggrade(int avggrade) {
		this.avggrade = avggrade;
	}
	public int getGradenum() {
		return gradenum;
	}
	public void setGradenum(int gradenum) {
		this.gradenum = gradenum;
	}
	
}
