package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	public static Scanner scanner = new Scanner(System.in);

	public static String inputString(Scanner scanner, String message) {
		while (true) {
			System.out.print(message);
			String inp = scanner.nextLine();
			if (inp.isEmpty()) {
				System.out.println("Input must not be empty, try again");
				continue;
			}
			return inp;
		}
	}
}
