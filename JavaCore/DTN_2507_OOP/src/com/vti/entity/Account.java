package com.vti.entity;

import java.time.LocalDate;

public class Account {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public LocalDate createDate;
//	public Department department;
//	public Position position;
//	public LocalDate createDate;
//	public Group[] groups;

	public Account(int id, String email, String userName, String fullName, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", createDate=" + createDate + "]";
	}

}
