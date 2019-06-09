package com.journaldev.spring.model;

import com.journaldev.spring.db.DBConnector;

public class User {
	
	
	private DBConnector dbConnector = new DBConnector();
		
	private String userName;
	
	private String address;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		System.out.println("db connector");
		if(dbConnector != null) {
			if(this.dbConnector.getUsers(this.userName) ==null) {
				return "null";
			}
			return "No Address";
		}
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
