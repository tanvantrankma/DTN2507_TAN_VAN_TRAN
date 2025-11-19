package com.vti.frontend;

import com.vti.entity.Department;
import com.vti.entity.Exercise_5;

public class Program_Exercise_5 {
	public static void main(String[] args) {
		Department[] departments = new Department[5];
		Department dep1 = new Department(1, "Java Backend");
		Department dep2 = new Department(2, "BA");
		Department dep3 = new Department(3, "Full Stack");
		Department dep4 = new Department(4, "VTI Academy");
		Department dep5 = new Department(5, "OOP C++");

		departments[0] = dep1;
		departments[1] = dep2;
		departments[2] = dep3;
		departments[3] = dep4;
		departments[4] = dep5;

		Exercise_5.Question_1(dep1);

		// Question 2
		for (int i = 0; i < departments.length; i++) {
			System.out.println(departments[i]);
		}
	}
}
