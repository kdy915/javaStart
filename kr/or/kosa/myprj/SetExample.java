package kr.or.kosa.myprj;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	public static void main(String[] args) {
		Set<String> strSet = new HashSet<String>();
		System.out.println(strSet.add("Hello"));
		strSet.add("World");
		System.out.println(strSet);
		System.out.println(strSet.add("Hello"));
		System.out.println(strSet);
		// Set의 특징 add한 순서를 지키지 않는다 hashcode 값의 순서대로 값이 나온다.
		strSet.add("홍길동");
		System.out.println(strSet);
		// set에 class를 넣을 때는 equals와 hashcode가 관여한다
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(new Person("홍길동", 25));
		Person p1 = new Person("홍길동", 25);
		personSet.add(p1);
		System.out.println(personSet);
		System.out.println("---------------");
		Student s1 = new Student("홍길서", 30, "123456789", "컴퓨터공학");
		Student s2 = new Student("홍길서", 30, "123456789", "컴퓨터공학");
		personSet.add(s1);
		personSet.add(s2);
		System.out.println(personSet);
		// 트리셋에 comparable을 구현해야 한다. Student 클래스 확인
		Set<String> strSet2 = new TreeSet<String>();
		strSet2.add("Hello");
		strSet2.add("Apple");
		strSet2.add("World");
		strSet2.add("banana");
		System.out.println(strSet2);
		
		Set<Person> psSet2 = new TreeSet<Person>();
		psSet2.add(p1);
		psSet2.add(s1);
		psSet2.add(s2);
		System.out.println(psSet2);
		
	}
}
