package com.vti.backend;

import com.vti.entity.VietnamesePhone;

public class Exercise_6 {

	public static void Question_1() {
		VietnamesePhone acc = new VietnamesePhone();

		acc.insertContact("Linh", "0972592280");
		acc.insertContact("Hoang", "0987228613");
		acc.insertContact("Kien", "0987654321");

		acc.removeContact("Kien");

		acc.updateContact("Hoang", "0988888888");
		acc.searchContact("Linh");

	}

}
