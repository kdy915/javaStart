package kr.or.kosa.myprj;

import java.util.Objects;

public class Student extends Person {
	String studentID;
	String major;
	public Student(String name, int age, String studentID, String major) {
//		super(); // Person은 기본생성자가 없으므로 에러
		super(name, age);
		this.studentID = studentID;
		this.major = major;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails() + 
				", 학번: " + studentID + ", 전공: " + major;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", major=" + major + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(major, studentID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(major, other.major) && Objects.equals(studentID, other.studentID);
	}
	
	
}
