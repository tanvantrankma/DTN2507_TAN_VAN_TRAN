package com.vti.frontend;

import java.util.ArrayList;

import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;

public class Program_Q6 {
	public static void main(String[] args) {

		ArrayList<PrimaryStudent> arrPri = new ArrayList();
		ArrayList<SecondaryStudent> arrSec = new ArrayList();

		PrimaryStudent priStu1 = new PrimaryStudent(1, "Hoang Văn Hải");
		PrimaryStudent priStu2 = new PrimaryStudent(2, "Lê Văn Giang");

		arrPri.add(priStu1);
		arrPri.add(priStu2);

		SecondaryStudent secStu3 = new SecondaryStudent(3, "Đinh Văn Nơi");
		SecondaryStudent secStu4 = new SecondaryStudent(4, "Quản Thị Hoa");
		SecondaryStudent secStu5 = new SecondaryStudent(5, "Lê Hồng Quân");
		SecondaryStudent secStu6 = new SecondaryStudent(6, "Phạm Thế Hùng");
		SecondaryStudent secStu7 = new SecondaryStudent(7, "Bùi Thu Huyền");
		SecondaryStudent secStu8 = new SecondaryStudent(8, "Cao Sơn Hà");

		arrSec.add(secStu3);
		arrSec.add(secStu4);
		arrSec.add(secStu5);
		arrSec.add(secStu6);
		arrSec.add(secStu7);
		arrSec.add(secStu8);

		System.out.println("Số lượng học sinh " + (arrPri.size() + arrSec.size()));
		System.out.println("Số Primary " + arrPri.size());
		System.out.println("Số Secondary " + arrSec.size());

	}
}