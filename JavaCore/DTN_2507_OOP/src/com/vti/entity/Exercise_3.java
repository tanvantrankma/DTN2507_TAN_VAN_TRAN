package com.vti.entity;

public class Exercise_3 {

//	Question 1:
//		Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//		Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//		float có 2 số sau dấu thập phân)

	public static void Question_1() {
		Integer luongInteger = 5000;
		float luong = luongInteger;
		System.out.println(String.format("%.2f", luong));
	}

//	Question 2:
//		Khai báo 1 String có value = "1234567"
//		Hãy convert String đó ra số int

	public static void Question_2() {
		String string = "1234567";
		int a = Integer.parseInt(string);
		System.out.println(a);
	}

//	Question 3:
//		Khởi tạo 1 số Integer có value là chữ "1234567"
//		Sau đó convert số trên thành datatype int

	public static void Question_3() {
		Integer aInteger = 1234567;
		int a = aInteger.intValue();
		System.out.println(a);
	}
}
