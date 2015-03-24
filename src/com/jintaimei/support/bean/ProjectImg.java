package com.jintaimei.support.bean;

import java.io.Serializable;
import java.util.Date;

public class ProjectImg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3917236301404589845L;
	
	private String imgId;
	private String imgFile;
	private String projectId;
	private int imgOrder;
	private String creator;
	private Date createTime;
	private String state;
	
	public String getImgId() {
		return imgId;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public int getImgOrder() {
		return imgOrder;
	}
	public void setImgOrder(int imgOrder) {
		this.imgOrder = imgOrder;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
