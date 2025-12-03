package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Department;

public class Exercise_1 {

//	Question 1:
//		Tạo constructor cho department:
//		a) không có parameters
//		b) Có 1 parameter là nameDepartment và default id của
//		Department = 0
//		Khởi tạo 1 Object với mỗi constructor ở trên	

	private static void question_1() {
		Department dep = new Department();
		Department dep1 = new Department("Dep1");
	}

//	Question 2:
//		Tạo constructor cho Account:
//		a) Không có parameters
//		b) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName)
//		c) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName) và
//		Position của User, default createDate = now
//		d) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName) và
//		Position của User, createDate
//		Khởi tạo 1 Object với mỗi constructor ở trên

	public static void question_2() {
//		Account acc1 = new Account();
		Account acc2 = new Account(2, "email2", "username2", "fullname2");
	}

}
