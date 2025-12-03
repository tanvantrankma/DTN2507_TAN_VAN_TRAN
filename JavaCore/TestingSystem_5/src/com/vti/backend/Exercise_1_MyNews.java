package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.News;

public class Exercise_1_MyNews {
	private static ArrayList<News> listNews = new ArrayList<News>();

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Chọn chức năng:");
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");

			int choise = scanner.nextInt();
			scanner.nextLine();

			switch (choise) {
			case 1: {
				insertNews();
				break;
			}
			case 2: {
				viewListNews();
				break;
			}
			case 3: {
				averageRates();
				break;
			}
			case 4: {
				System.out.println("Thoát chương trình !");
				return;
			}
			default:
				throw new IllegalArgumentException("Xin nhập lại các lựa chọn 1, 2, 3, 4");
			}
		}

	}

	private static void insertNews() {
		Scanner sc = new Scanner(System.in);
//		ArrayList<News> arrNews = new ArrayList<News>();
		News newsName = new News();
		System.out.println("Nhập Title :");
		newsName.setTitle(sc.nextLine());

		System.out.println("Nhập PublishDate:");
		newsName.setPublishDate(sc.nextLine());

		System.out.println("Nhập Author:");
		newsName.setAuthor(sc.nextLine());

		System.out.println("Nhập Content:");
		newsName.setContent(sc.nextLine());

		System.out.println("Nhập vào 3 đánh giá để lưu vào Rates");
		newsName.inputRates();

		listNews.add(newsName);
	}

	private static void viewListNews() {
		if (listNews.isEmpty()) {
			System.out.println("Danh sách rỗng");
			return;
		}
		for (News xNews : listNews) {
			xNews.Display();
			System.out.println("--------------------");
		}

	}

	private static void averageRates() {
		if (listNews.isEmpty()) {
			System.out.println("Danh sách rỗng");
			return;
		}
		for (News xNews : listNews) {
			xNews.Calculate();
			xNews.Display();
		}

	}
}
