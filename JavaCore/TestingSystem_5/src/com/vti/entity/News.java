package com.vti.entity;

import java.util.Scanner;

public class News implements INews {
	private int id;
	private String title, publishDate, author, content;
	private float averageRate;
	private int[] rates = new int[3];

	public News() {
		super();
	}

	public News(int id, String title, String publishDate, String author, String content, int[] rates) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.rates = rates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public void inputRates() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			rates[i] = scanner.nextInt();
		}
	}

	@Override
	public void Display() {
		System.out.println(
				this.title + " " + this.publishDate + " " + this.author + " " + this.content + " " + this.averageRate);
	}

	@Override
	public float Calculate() {
		int sum = 0;
		for (int x : rates) {
			sum += x;
		}
		averageRate = (float) sum / 3;
		return averageRate;
	}

	public static int getPhoneNumberInput(Scanner scanner, String message) {
		while (true) {
			try {
				System.out.print(message);
				String phone = scanner.nextLine();
				if (phone.length() != 10) {
					System.err.println("Phone number must be 10 numeric characters in length");
				}
				return Integer.parseInt(phone);
			} catch (NumberFormatException e) {
				System.err.println("Phone number must not contain any non-numeric characters");
			}
		}
	}

}
