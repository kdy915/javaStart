package kr.or.kosa.myprj;

public class Teacher extends Person {
//	String name;
//	int age;
	String teacherID;
	String subject;
	
	public Teacher(String name, int age, String teacherID, String subject) {
		super(name, age);
		this.teacherID = teacherID;
		this.subject = subject;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails() + 
				", 교번: " + teacherID + ", 과목: " + subject;
	}
}
