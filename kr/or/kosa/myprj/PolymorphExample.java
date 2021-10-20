package kr.or.kosa.myprj;

public class PolymorphExample {
public static void main(String[] args) {
	Person p1 = new Person("홍길동", 20);
	Person p2 = new Student("홍길서", 20, "123456789", "컴퓨터공학");
	Student s1 = new Student("홍길남", 22, "987654321", "경제학");
	Person p3 = s1; //Promotion
//	s1 = (Student) p1; // type casting, runtime error, class cast exception
	s1 = (Student) p2; //type casting
	Person[] personList = new Person[4];
	personList[0] = p1;
	personList[1] = p2;
	personList[2] = s1;
	personList[3] = new Teacher("홍길동", 40, "1234567", "인공신경망");
	for(Person p : personList) {
		System.out.println(p.getDetails());
	}
	Object[] objList = new Object[5];
	objList[0] = "Hello";
	objList[1] = p1;
	objList[2] = s1;
	objList[3] = 10; // auto boxing 기능으로 인해 가능함.
	objList[4] = new Integer(100); //9 버전부터 deprecated 됨
	// byte, short, Integer, Long, Float, Double, Boolean, Character = Wrapper class
	for(Object obj : objList) {
		System.out.println(obj.toString()); // Object클래스는 실행시키면 toString을 실행한다.
	}
	System.out.println(((Student)objList[2]).getDetails()); // 함수를 실행 시키고 싶으면 형변환을 시켜줘야 된다
	// 다형적 객체로 메서드 호출 시 선언한 타입에 있는 메서드만 호출 할 수 있다.
	// virtual Method Invocation
	// 컴파일 시 선언한 클래스의 메서드를 체크, 런타임 시 생성한 클래스의 메서드를 실행
	System.out.println(s1.getDetails());
	
	System.out.println(p1.getDetails());
	System.out.println(p2.getDetails());
	// static 블록에서 non-static을 직접 참조할 수 없다
	// 그래서 doit()을 호출하려면....
//	PolyExample ex = new PolyExample();
//	ex.doIt(p3);
	doIt(p3);
	doIt(p1);
	doIt(new Teacher("이순신", 45, "2222333", "교육처"));
    } // end main

public static void doIt(Person p) {
	String message = "";
	if(p instanceof Student) {
		message = "학생";
	}else if(p instanceof Teacher) {
		message = "교수";
	}else if (p instanceof Employee) {
		message = "직원";
	}else {
		message = "사람";	}
	System.out.print(message);
	System.out.println("정보를 출력합니다.");
	System.out.println("============");
	System.out.println(p.getDetails());
	System.out.println("------------");
}
} // end class