package com.vti.entity;

import java.util.ArrayList;

import com.vti.utils.ScannerUtils;

public class Department {
	public static int COUNT;
	private int id;
	private String name;

	public Department(String name) {
		super();
		COUNT++;
		this.id = COUNT;
		this.name = name;
	}

	public Department() {
		super();
		COUNT++;
		this.id = COUNT;
		System.out.println("Nhập tên phòng ban: ");
		this.name = ScannerUtils.inputString();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	private static void question9_Dep() {
		Department dep1 = new Department();
		Department dep2 = new Department();
		Department dep3 = new Department();
		ArrayList<Department> listDep = new ArrayList<Department>();
		listDep.add(dep1);
		listDep.add(dep2);
		listDep.add(dep3);
		System.out.println("Thông tin phòng vừa nhập: ");
		for (Department department : listDep) {
			System.out.println(department);
		}

	}

}
