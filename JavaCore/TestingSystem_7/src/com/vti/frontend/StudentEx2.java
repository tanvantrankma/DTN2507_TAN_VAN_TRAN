package com.vti.frontend;

public class StudentEx2 {
	private final int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public StudentEx2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static void study() {
		System.out.println("Đang học bài");
	}

	@Override
	public String toString() {
		return "StudentEx2 [id=" + id + ", name=" + name + "]";
	}

}
