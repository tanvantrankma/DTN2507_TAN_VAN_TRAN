package com.vti.entity;

public class Student {
	private int id;
	private String name, homeTown;
	private double diemHocLuc;

	public Student(String name, String homeTown, double diemHocLuc) {
		super();
		this.name = name;
		this.homeTown = homeTown;
		this.diemHocLuc = 0;
	}

	public void setDiemHocLuc(double diemHocLuc) {
		this.diemHocLuc = diemHocLuc;
	}

	public void congDiem(double diemHocLuc) {
		this.diemHocLuc = this.diemHocLuc + diemHocLuc;
	}

	@Override
	public String toString() {
		String xepLoai = "";
		if (this.diemHocLuc > 8) {
			xepLoai = "Gioi";
		} else if (this.diemHocLuc > 6) {
			xepLoai = "Khá";
		} else if (this.diemHocLuc > 4) {
			xepLoai = "Trung Bình";
		} else {
			xepLoai = "Yếu";
		}
		return this.name + " " + this.diemHocLuc + " " + xepLoai;
	}

}
