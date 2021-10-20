package kr.or.kosa.myprj;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super(); // Object클래스의 기본 생성자 호출
		this.name = name;
		this.age = age;
	}

	public String getDetails() {
		return "이름: " + name + ", 나이: " + age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
	
}
