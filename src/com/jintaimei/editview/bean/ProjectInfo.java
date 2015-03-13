package com.jintaimei.editview.bean;

import java.io.Serializable;
import java.util.Date;

public class ProjectInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3202160603571816199L;
	
	
	private String porjectId;
	private String projectName;
	private String projectType;
	private String projectAbout;
	private String imgFile;
	private String projectDescId;
	private String projectImgId;
	private String creator;
	private Date createTime;
	private String state;
	
	public String getPorjectId() {
		return porjectId;
	}
	public void setPorjectId(String porjectId) {
		this.porjectId = porjectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getProjectAbout() {
		return projectAbout;
	}
	public void setProjectAbout(String projectAbout) {
		this.projectAbout = projectAbout;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public String getProjectDescId() {
		return projectDescId;
	}
	public void setProjectDescId(String projectDescId) {
		this.projectDescId = projectDescId;
	}
	public String getProjectImgId() {
		return projectImgId;
	}
	public void setProjectImgId(String projectImgId) {
		this.projectImgId = projectImgId;
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
