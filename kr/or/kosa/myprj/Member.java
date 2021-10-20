package kr.or.kosa.myprj;

import java.io.Serializable;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String email;
	private int age;
	private int phone;
	
	public Member(String name, String address, String email, int age) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Member(String name, String address, String email, int age, int phone) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", address=" + address + ", email=" + email + ", age=" + age + "]";
	}
	public String toCSV() {
		return name + "," + address + "," + email  + "," + age;
	}
	
}
