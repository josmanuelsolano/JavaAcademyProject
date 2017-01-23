package com.softtek.jpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Audit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="create_user", nullable = true)
	protected String createUser;
	
	@Column(name="create_date", nullable = true)
	protected Date createDate;
	
	@Column(name="update_user", nullable = true)
	protected String updateUser;
	
	@Column(name="update_date", nullable = true)
	protected Date updateDate;
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
