package com.jintaimei.support.bean;

import java.io.Serializable;
import java.util.Date;

public class GuestBook implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7822762597266407426L;
	
	private String id;
	private String guestName;
	private String guestEmail;
	private String guestPhone;
	private String guestMessage;
	private Date createTime;
	private String state;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestPhone() {
		return guestPhone;
	}
	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}
	public String getGuestMessage() {
		return guestMessage;
	}
	public void setGuestMessage(String guestMessage) {
		this.guestMessage = guestMessage;
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
