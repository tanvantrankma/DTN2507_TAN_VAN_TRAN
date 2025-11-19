package com.vti.entity;

import java.util.Scanner;

public class Exercise_4 {
	Scanner sc = new Scanner(System.in);

//	Question 1:
//		Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//		thể cách nhau bằng nhiều khoảng trắng );

	public static void Question_1() {
		String string = "   Tran Van  Tan Va   ";
		String[] arr = string.trim().split("\\s+");
		System.out.println(arr.length);
	}

//	Question 2:
//		Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;

	public static void Question_2() {
		String s1 = "tan van tran";
		String s2 = "DTN_2507";
		String s3 = s1.concat(" ").concat(s2);
		System.out.println(s3);
	}

//	Question 3:
//		Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
//		viết hoa chữ cái đầu thì viết hoa lên

	public static void Question_3() {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String newName = "";
		String[] arr = name.trim().split("\\s+");
		for (String x : arr) {
			newName += Character.toUpperCase(x.charAt(0));
			for (int j = 1; j < x.length(); j++) {
				newName += Character.toLowerCase(x.charAt(j));
			}
			newName += " ";
		}
		String nameString = newName.trim();
		System.out.println(nameString);
	}

//	Question 4:
//		Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
//		của người dùng ra
//		VD:
//		Người dùng nhập vào "Nam", hệ thống sẽ in ra
//		"Ký tự thứ 1 là: N"
//		"Ký tự thứ 1 là: A"
//		"Ký tự thứ 1 là: M"

	public static void Question_4() {
		Scanner scanner = new Scanner(System.in);
		String nameString = scanner.nextLine();
		for (int i = 0; i < nameString.length(); i++) {
			System.out.printf("Ký tự thứ %s là : " + nameString.toUpperCase().charAt(i) + " \n", i);
		}
	}

//	Question 5:
//		Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//		dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ

	public static void Question_5() {
		Scanner sc = new Scanner(System.in);
		String lastName = sc.nextLine();
		String firstName = sc.nextLine();
		System.out.println(lastName + " " + firstName);
	}

//	Question 6:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//		VD:
//		Người dùng nhập vào "Nguyễn Văn Nam"
//		Hệ thống sẽ in ra
//		"Họ là: Nguyễn"
//		"Tên đệm là: Văn"
//		"Tên là: Nam"

	public static void Question_6() {
		String lastName = "";
		String middleName = "";
		String firstName = "";
		Scanner sc = new Scanner(System.in);
		String fullName = sc.nextLine();
		String[] arr = fullName.trim().split("\\s+");
		lastName = arr[0];
		firstName = arr[arr.length - 1];
		for (int i = 1; i < arr.length - 1; i++) {
			middleName += arr[i] + " ";
		}
		System.out.println(
				String.format("Họ là: %s\n" + "Tên đệm là: %s\n" + "Tên là: %s", lastName, middleName, firstName));
	}

//	Question 7:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		chuẩn hóa họ và tên của họ như sau:
//		a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập
//		vào3
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//		chuẩn hóa thành "nguyễn văn nam"
//		b) Viết hoa chữ cái mỗi từ của người dùng
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//		chuẩn hóa thành "Nguyễn Văn Nam"

	public static void Question_7() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = s.trim().split("\\s+");
		String newName = "";
		for (String x : arr) {
			newName += Character.toUpperCase(x.charAt(0));
			for (int j = 1; j < x.length(); j++) {
				newName += Character.toLowerCase(x.charAt(j));
			}
			newName += " ";
		}
		String newNameString = newName.trim();
		System.out.println(newNameString);
	}

//	Question 8:
//		In ra tất cả các group có chứa chữ "Java"
	public static void Question_8() {
		String[] groupname = { "Java core", "Java OOP", "Java lap trinh", "Lap Trình" };
		for (int i = 0; i < groupname.length; i++) {
			if (groupname[i].contains("Java")) {
				System.out.println(groupname[i] + " ");
			}
		}
	}

//	Question 9:
//		In ra tất cả các group "Java"

	public static void Question_9() {
		String[] groupname = { "Java", "Java OOP", "Java lap trinh", "Lap Trình" };
		for (int i = 0; i < groupname.length; i++) {
			if (groupname[i].equals("Java")) {
				System.out.println(groupname[i]);
			}
		}
	}

//	Question 10 (Optional):
//		Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//		Nếu có xuất ra “OK” ngược lại “KO”.
//		Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau

//	Question 11 (Optional): Count special Character
//	Tìm số lần xuất hiện ký tự "a" trong chuỗi

	public static void Question_11() {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'a') {
				count++;
			}
		}
		System.out.println(count);

	}

//	Question 12 (Optional): Reverse String
//	Đảo ngược chuỗi sử dụng vòng lặp

	public static void Question_12() {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		for (int i = string.length() - 1; i >= 0; i--) {
			System.out.print(string.charAt(i));
		}
	}

//	Question 13 (Optional): String not contains digit
//	Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
//	lại true.
//	Ví dụ:
//	"abc" => true
//	"1abc", "abc1", "123", "a1bc", null => false

	public static void Question_13() {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				System.out.println("false");
				break;
			} else {
				System.out.println("true");
				break;
			}
		}
	}

//	Question 14 (Optional): Replace character
//	Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
//	cho trước.
//	Ví dụ:
//	"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"

	public static void Question_14() {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		// StringBuilder sBuilder = string.split("\\s+");
		String string2 = string.replace("e", "*");
		System.out.println(string2);

	}

//	Question 15 (Optional): Revert string by word
//	Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng
//	thư viện.
//	Ví dụ: " I am developer " => "developer am I".
//	Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//	Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt
//	chuỗi theo dấu cách

	public static void Question_15() {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] arr = string.trim().split("\\s+");
		String newName = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			newName += arr[i] + " ";
		}
		newName.trim();
		System.out.println(newName);
	}

//	Question 16 (Optional):4
//	Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
//	bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
//	hình “KO”.

	public static void Question_16() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String string = scanner.nextLine();

		if (string == null || string.isEmpty() || string.length() % n != 0) {
			System.out.println("No");
			return;
		} else {
			for (int i = 0; i < string.length(); i += n) {
				System.out.println(string.substring(i, i + n));
			}
		}
	}

}
