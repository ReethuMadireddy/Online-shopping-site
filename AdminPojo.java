package com.dxc.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminPojo {
	
	@Id
	private int id;
	private int password;
	
	@Override
	public String toString() {
		return "AdminPojo [id=" + id + ", password=" + password + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	

}
