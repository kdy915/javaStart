package kr.or.kosa.myprj;

public class Employee extends Person {
//	String name;
//	int age;
	String employeeID;
	String department;
	public Employee(String name, int age, String employeeID, String department) {
		super(name, age);
		this.employeeID = employeeID;
		this.department = department;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails() + 
				", 사번: " + employeeID + ", 부서: " + department;
	}
}
