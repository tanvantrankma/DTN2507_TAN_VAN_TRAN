package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Program1 {
	public static void main(String[] args) {
		// Tạo Department
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Marketing";

		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Sale";

		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "BOD";

		// Tạo Position
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.Dev;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.PM;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.Scrum_Master;

		// Tạo Account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "tanvantran@gmail.com";
		acc1.userName = "tanvantran";
		acc1.fullName = "Trần Văn Tân";
		acc1.department = dep1;
		acc1.position = pos1;
		acc1.createDate = LocalDate.of(2025, 11, 12);

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "linhdo@gmail.com";
		acc2.userName = "linhdo";
		acc2.fullName = "Đỗ Đình Linh";
		acc2.department = dep2;
		acc2.position = pos2;
		acc2.createDate = LocalDate.now();

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "huynguyenvan@gmail.com";
		acc3.userName = "huynguyenvan";
		acc3.fullName = "Nguyễn Văn Huy";
		acc3.department = dep3;
		acc3.position = pos3;
		acc3.createDate = LocalDate.of(2025, 10, 07);

		// Tạo Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		group1.creator = acc1;
		group1.createDate = LocalDate.now();

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Group Development";
		group2.creator = acc2;
		group2.createDate = LocalDate.now();

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale Gr";
		group3.creator = acc3;
		group3.createDate = LocalDate.now();

		//
		Group[] groupAcc1 = { group1, group2 };
		acc1.groups = groupAcc1;

		acc2.groups = new Group[] { group3, group2 };

		System.out.println("Thông tin Account 1: ");
		System.out.println("Email: " + acc1.email);
		System.out.println("UserName: " + acc1.userName);
		System.out.println("FullName: " + acc1.fullName);
		System.out.println("Department: " + acc1.department.name);
		System.out.println("Position: " + acc1.position.name);
		System.out.println("CreateDate: " + acc1.createDate);

		System.out.println("Thông tin Account 2: ");
		System.out.println("Email: " + acc2.email);
		System.out.println("UserName: " + acc2.userName);
		System.out.println("FullName: " + acc2.fullName);
		System.out.println("Department: " + acc2.department.name);
		System.out.println("Position: " + acc2.position.name);
		System.out.println("CreateDate: " + acc2.createDate);

		System.out.println("Thông tin Account 3: ");
		System.out.println("Email: " + acc3.email);
		System.out.println("UserName: " + acc3.userName);
		System.out.println("FullName: " + acc3.fullName);
		System.out.println("Department: " + acc3.department.name);
		System.out.println("Position: " + acc3.position.name);
		System.out.println("CreateDate: " + acc3.createDate);
	}
}
