package com.vti.entity;

public class SecondaryStudent extends Student {
	public static int COUNTsec = 0;

	public SecondaryStudent(int id, String name) {
		super(id, name);
		COUNTsec++;
	}

}
