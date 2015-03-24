package com.jintaimei.support.bean;

import java.io.Serializable;
import java.util.Date;

public class ProjectDesc implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2336428000470846481L;
	
	private String projectDescId;
	private String title;
	private String content;
	private String projectId;
	private String projectDescOrder;
	private String creator;
	private Date createTime;
	private String state;
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectDescOrder() {
		return projectDescOrder;
	}
	public void setProjectDescOrder(String projectDescOrder) {
		this.projectDescOrder = projectDescOrder;
	}
	public String getProjectDescId() {
		return projectDescId;
	}
	public void setProjectDescId(String projectDescId) {
		this.projectDescId = projectDescId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
