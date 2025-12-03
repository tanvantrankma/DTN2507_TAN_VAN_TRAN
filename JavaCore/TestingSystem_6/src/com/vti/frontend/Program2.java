package com.vti.frontend;

public class Program2 {
	public static void main(String[] args) {
		System.out.println("1");
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("divide completed!");
		}
		System.out.println("2");

		// Question 3
		int number[] = { 1, 2, 3 };
		try {
			System.out.println(number[10]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static float divide(int a, int b) {
		return a / b;
	}
}
