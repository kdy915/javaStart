package Project;

public class SwimMemberVO {
	private String name;
	private int age;
	private String sex;
	private String phone;
	private String period;
	private String address;

	public SwimMemberVO(String name, int age, String sex, String phone, String period, String address) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.period = period;
		this.address = address;
	}
	
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	public String getSex() {return sex;}
	public void setSex(String sex) {this.sex = sex;}

	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}

	public String getPeriod() {return period;}
	public void setPeriod(String period) {this.period = period;}
	
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	@Override
	public String toString() {
		return "SwimMemberVO [name=" + name + ", age=" + age + ", sex=" + sex + ", phone=" + phone + ", period=" + period + ", address=" + address + "]";
	}

	public String toCSV() {
		return name + "," + age + "," + sex + "," + phone + "," + period + "," + address;
	}
}
