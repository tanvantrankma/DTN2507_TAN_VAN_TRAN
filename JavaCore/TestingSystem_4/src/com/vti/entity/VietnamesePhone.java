package com.vti.entity;

public class VietnamesePhone extends Phone {

	@Override
	public void insertContact(String name, String phone) {
		Contacts contactsName = new Contacts(name, phone);
		contactList.add(contactsName);
	}

	@Override
	public void removeContact(String name) {
		for (Contacts x : contactList) {
			if (x.getName().equalsIgnoreCase(name)) {
				contactList.remove(x);
				System.out.println("Đã xóa liên hệ: " + name);
				return;
			}
		}
		System.out.println("Không tìm thấy liên hệ để xóa: " + name);

	}

	@Override
	public void updateContact(String name, String newPhone) {
		for (Contacts xContacts : contactList) {
			if (xContacts.getName().equalsIgnoreCase(name)) {
				xContacts.setPhone(newPhone);
				System.out.println("Đã cập nhật số điện thoại cho: " + name);
				return;
			}
		}
		System.out.println("Không tìm thấy liên hệ để cập nhật: " + name);
	}

	@Override
	public void searchContact(String name) {
		for (Contacts xContacts : contactList) {
			if (xContacts.getName().equalsIgnoreCase(name)) {
				System.out.println("Tìm thấy: " + xContacts.toString());
				return;
			}
		}
		System.out.println("Không tìm thấy liên hệ: " + name);
	}

	public void printContact() {
		for (Contacts contact : contactList) {
			System.out.println(contact);
		}
	}

}
