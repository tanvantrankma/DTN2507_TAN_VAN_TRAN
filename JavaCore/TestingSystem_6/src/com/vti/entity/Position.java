package com.vti.entity;

import com.vti.utils.ScannerUtils;

public class Position {
	public static int COUNTPos = 0;
	public int id;
	public PositionName name;

	public enum PositionName {
		Dev, Test, Scrum_Master, PM
	}

	public Position() {
		super();
		COUNTPos++;
		this.id = COUNTPos;

		System.out.println("Chọn tên vị trí muốn nhập: ");
		System.out.println("1. Dev, 2.Test, 3. Scrum_Master, 4. PM");

		while (true) {
			int chose = ScannerUtils.inputInt();

			switch (chose) {
			case 1: {
				this.name = PositionName.Dev;
				return;
			}
			case 2: {
				this.name = PositionName.Test;
				return;
			}
			case 3: {
				this.name = PositionName.Scrum_Master;
				return;
			}
			case 4: {
				this.name = PositionName.PM;
				return;
			}
			default:
				System.err.println("Nhập lại: " + chose);
			}

		}
	}

	private static void question9_Pos() {
		System.out.println("Tạo Position");
		Position pos1 = new Position();
		System.out.println("Thông tin Position vừa nhập: ");
		System.out.println(pos1);
	}

}
