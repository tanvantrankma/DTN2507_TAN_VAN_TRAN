package com.vti.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Exercise_2 {

//	Question 1:
//		Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
//		tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//		 Email: "Email 1"
//		 Username: "User name 1"
//		 FullName: "Full name 1"
//		 CreateDate: now

	public static void Question_1() {
		Scanner sc = new Scanner(System.in);
		Account[] arrAccounts = new Account[5];
		for (int i = 0; i < arrAccounts.length; i++) {
			arrAccounts[i] = new Account(i, sc.nextLine() + i, sc.nextLine() + i, sc.nextLine() + i, LocalDate.now());

		}
		for (Account x : arrAccounts) {
			System.out.println(x);
		}
	}

}
