package com.vti.entity;

public class Department {
	public int id;
	public String name;

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.id + " " + this.name;
	}

}
