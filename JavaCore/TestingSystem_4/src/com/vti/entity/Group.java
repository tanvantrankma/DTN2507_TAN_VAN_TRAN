package com.vti.entity;

import java.time.LocalDate;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public LocalDate createDate;
	public Account[] accounts;

	public Group() {
		super();
	}

	public Group(String name, Account creator, LocalDate createDate, Account[] accounts) {
		super();
		this.name = name;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
	}

}
