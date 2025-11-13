package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Program2 {
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
		// Add Group Account
		group1.accounts = new Account[] { acc1 };
		group2.accounts = new Account[] { acc1, acc2 };
		group3.accounts = new Account[] { acc2 };

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

		// Q1
		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là " + acc2.department.name);
		}

		// Q2
		int count = acc2.groups.length;
		if (count == 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (count == 1 || count == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (count == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}

		// Q3
		System.out.println((acc2.department == null) ? ("Nhân viên này chưa có phòng ban")
				: ("Phòng ban của nhân viên này là " + acc2.department.name));

		// Q4
		System.out
				.println((acc1.position.equals("Dev")) ? ("Đây là Developer") : ("Người này không phải là Developer"));

		// Q5
		int countGroup1 = group1.accounts.length;
		switch (countGroup1) {
		case 1: {
			System.out.println("Nhóm có một thành viên");
			break;
		}
		case 2: {
			System.out.println("Nhóm có hai thành viên");
			break;
		}
		case 3: {
			System.out.println("Nhóm có ba thành viên");
			break;
		}
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}

		// Q6
		int countAcc2 = acc2.groups.length;
		switch (countAcc2) {
		case 1, 2: {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		}
		case 3: {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		}
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}

		// Q7
		String s = acc1.position.toString();
		switch (s) {
		case "Dev": {
			System.out.println("Đây là Developer");
			break;
		}
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}

		// Q8 In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
		// họ
		Account[] arrAcc = { acc1, acc2, acc3 };

		for (Account x : arrAcc) {
			System.out.println(x.email + " " + x.fullName + " " + x.department.name);
		}

		// Q9 : In ra thông tin các phòng ban bao gồm: id và name
		Department[] arrDepar = { dep1, dep2, dep3 };
		for (Department x : arrDepar) {
			System.out.println(x.id + " " + x.name);
		}

		// Q10:

		for (int i = 0; i < arrAcc.length; i++) {
			System.out.println("Thông tin Account thứ " + (i + 1) + " là: \n" + "Email: " + arrAcc[i].email + "\n"
					+ "FullName: " + arrAcc[i].fullName + "\n" + "Phòng ban: " + arrAcc[i].department.name);
		}

		// Q11
		for (int i = 0; i < arrDepar.length; i++) {
			System.out.println("Thong tin phong ban thứ " + (i + 1) + "là:\n" + "Id: " + arrDepar[i].id + "\n"
					+ "Name: " + arrDepar[i].name);
		}

		// Q12
		for (int i = 0; i < 2; i++) {
			System.out.println("Thong tin phong ban thứ " + (i + 1) + " là:\n" + "Id: " + arrDepar[i].id + "\n"
					+ "Name: " + arrDepar[i].name);
		}

		// Q13
		for (int i = 0; i < arrAcc.length; i++) {
			if (i == 1) {
				continue;
			} else {
				System.out.println("Thông tin Account thứ " + (i + 1) + " là: \n" + "Email: " + arrAcc[i].email + "\n"
						+ "FullName: " + arrAcc[i].fullName + "\n" + "Phòng ban: " + arrAcc[i].department.name);
			}
		}

		// Q14
		for (int i = 0; i < arrAcc.length; i++) {
			if (arrAcc[i].id < 4) {
				System.out.println("Thông tin Account thứ " + (i + 1) + " là: \n" + "Email: " + arrAcc[i].email + "\n"
						+ "FullName: " + arrAcc[i].fullName + "\n" + "Phòng ban: " + arrAcc[i].department.name);
			}
		}

		// Q15
		int n;
		for (int i = 0; i <= 20; i += 2) {
			System.out.print(i + " ");
		}

//////		// Q16
		// Q10
		int q = arrAcc.length;
		while (q-- > 0) {
			System.out.println("Thông tin Account thứ " + (q + 1) + " là: \n" + "Email: " + arrAcc[q].email + "\n"
					+ "FullName: " + arrAcc[q].fullName + "\n" + "Phòng ban: " + arrAcc[q].department.name);
		}

		// Q11
		int p = arrDepar.length;
		while (p-- > 0) {
			System.out.println("Thong tin phong ban thứ " + (p + 1) + "là:\n" + "Id: " + arrDepar[p].id + "\n"
					+ "Name: " + arrDepar[p].name);
		}

		// Q12
		int j = 2;
		while (j > 0) {
			System.out.println("Thong tin phong ban thứ " + (j) + " là:\n" + "Id: " + arrDepar[j - 1].id + "\n"
					+ "Name: " + arrDepar[j - 1].name);
			j--;
		}

		// Q13
		int t = 0;
		while (t < arrAcc.length) {
			if (t != 1) {
				System.out.println("Thông tin Account thứ " + (t + 1) + " là: \n" + "Email: " + arrAcc[t].email + "\n"
						+ "FullName: " + arrAcc[t].fullName + "\n" + "Phòng ban: " + arrAcc[t].department.name);
			}
			t++;
		}

		// Q14
		int jj = 0;
		while (jj < 3) {
			System.out.println("Thông tin Account thứ44 " + (jj + 1) + " là: \n" + "Email: " + arrAcc[jj].email + "\n"
					+ "FullName: " + arrAcc[jj].fullName + "\n" + "Phòng ban: " + arrAcc[jj].department.name);
			jj++;
		}

		// Q15
		int k = 0;
		while (k <= 20) {
			System.out.print(k + " ");
			k += 2;
		}

// DO-WHILE Q17
		// Q10

// Exercise 2 (Optional): System out printf
		// Q1
		int z = 5;
		System.out.println(z);

		// Q2
		int number = 100000000;
		System.out.printf("%,d", number);

		// Q3
		double q3 = 5.567098f;
		System.out.printf("%.4f", q3);

		// Q4
		String s3 = "Nguyễn Văn Hùng";
		System.out.println("Tôi là " + s + "tôi đang độc thân");

		// Q5
		System.out.println(LocalDate.now());

		// Q6

	}
}
