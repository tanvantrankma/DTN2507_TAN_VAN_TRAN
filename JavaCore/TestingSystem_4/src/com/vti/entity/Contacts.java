package com.vti.entity;

public class Contacts {
	private String phone;
	private String name;

	public Contacts(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Contacts [phone=" + phone + ", name=" + name + "]";
	}

	//

}
