package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

	public static int inputAge() {
		while (true) {
			System.out.println("Nhập tuổi: ");
			String ageString = scanner.nextLine();

			try {
				int ageInt = Integer.parseInt(ageString);
				if (ageInt >= 0) {
					return ageInt;
				} else {
					System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
				}
			} catch (Exception e) {
				System.out.println("Wrong inputing! Please input an age as int, input again.");
			}
		}
	}

	public static int inputInt() {
		System.out.println("Nhập số nguyên : ");
		String intString = scanner.nextLine();

		while (true) {
			try {
				return Integer.parseInt(intString.trim());
			} catch (Exception e) {
				System.out.println("Nhập lại");
			}

		}
	}

	public static float inputFloat() {
		System.out.println("Nhập số thực : ");
		String floatString = scanner.nextLine();

		while (true) {
			try {
				return Float.parseFloat(floatString.trim());
			} catch (Exception e) {
				System.out.println("Nhập lại");
			}

		}
	}

	public static double inputDouble() {
		System.out.println("Nhập số thực : ");
		String doubleString = scanner.nextLine();

		while (true) {
			try {
				return Double.parseDouble(doubleString.trim());
			} catch (Exception e) {
				System.out.println("Nhập lại");
			}

		}
	}

	public static String inputString() {
		System.out.println("Nhập chuỗi : ");
		String string = scanner.next();

		while (true) {
			if (!string.isEmpty()) {
				return string;
			} else {
				System.out.println("Nhập lại :");
			}

		}
	}
}
