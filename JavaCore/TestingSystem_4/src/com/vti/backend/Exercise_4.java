package com.vti.backend;

import com.vti.entity.Student;

public class Exercise_4 {
	public static void InfoStuden() {
		Student st1 = new Student("Trần Văn Tân", "DTN2507", 5.5);
		st1.congDiem(5);
		System.out.println(st1);
	}
}
