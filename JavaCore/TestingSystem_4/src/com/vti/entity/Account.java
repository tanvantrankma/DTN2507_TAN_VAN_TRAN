package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	public Department department;
	public Position position;
	public LocalDate createDate;
	public Group[] groups;

	public Account() {
		super();
	}

	public Account(int id, String email, String userName, String fullName) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
	}

	public Account(int id, String email, String userName, String fullName, Position position) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
		this.createDate = LocalDate.now();
	}

	public Account(int id, String email, String userName, String fullName, Position position, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
		this.createDate = createDate;
	}

}
