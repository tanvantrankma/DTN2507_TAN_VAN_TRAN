package com.vti.frontend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Student;

public class Program1_Exercise1_Q1 {
	public static void main(String[] args) {
		ArrayList<Student> arrayList = new ArrayList<Student>();

		Student student1 = new Student(1, "Trần Văn Tân");
		Student student2 = new Student(2, "Đinh Tuấn Anh");
		Student student3 = new Student(3, "Đỗ Đình Linh");

		arrayList.add(student1);
		arrayList.add(student2);
		arrayList.add(student3);

		Student.college = "Đại học Bách Khoa";

		for (Student student : arrayList) {
			System.out.println(student);
		}

		Student.college = "Đại học Công Nghệ";
		arrayList.forEach(x -> System.out.println(x));
		System.out.println("------------------");

		// Question 2

		System.out.println("Tiền quỹ: " + Student.money_Group);

		Student.money_Group += 50 * arrayList.size();
		System.out.println("Tiền quỹ: " + Student.money_Group);

		// Question 4
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập cocollege: ");
		String college = scanner.nextLine();
		Student.college = college;
		for (Student x : arrayList) {
			System.out.println(x);
		}

		// Q5
		System.out.println(arrayList.size());
	}
}
