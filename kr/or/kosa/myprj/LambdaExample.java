package kr.or.kosa.myprj;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExample {
	static int member = 20;
	public static void main(String[] args) {
		//객체 생성해서 실행
		MyInterface obj = new MyImpl();
		obj.doIt(100);
		//익명 클래스 생성해서 실행
		MyInterface obj2 = new MyInterface() {
			public void doIt(int a) {
				System.out.println("Anony"+ a);
			}
		};
		obj2.doIt(200);
		//람다식으로 실행
		//매개변수가 하나면 타입, () 생략가능 생략 가능
//		MyInterface obj3 = (int a) -> {System.out.println("Lambda"+ a);}; 
//		MyInterface obj3 = (a) -> {System.out.println("Lambda"+ a);};
		MyInterface obj3 = a -> {System.out.println("Lambda"+ a);};
		obj3.doIt(300);
		
		int temp = 10;
		//매개 변수가 2개인 람다식 한문장이면 {}, return 생략가능
//		MyInterface2 obj4 = (int a, int b) -> {return a*b;};
//		MyInterface2 obj4 = (int a, int b) -> a*b;
		MyInterface2 obj4 = (int a, int b) -> {
			int result = a*b+temp+member; //지역변수를 참조하면 그 변수는 final이 됨
			//temp는 final int temp 로 봐뀐다.
			return result;
			};
		System.out.println(obj4.doThat(10, 3));
		// object에 람다식을 넣어서 메소드에 대입
		callMethod((int a, int b) -> {
			int result = a*b;
			return result;
		});
		// 자바에서 제공하는 기본 function 만들어 놓은 것
		Consumer<String> cons = (str) -> {System.out.println("Hello"+str);};
//		cons.accept("홍길동");
		Consumer<String> cons2 = (str) -> {System.out.println("World~"+str);};
		// andThen cons실행 후 결과값 cons2
		Consumer<String> consAnd = cons.andThen(cons2);
		consAnd.accept("홍길동");
		
		Function<Integer, Integer> func1 = (num1) -> { //function<매개변수 타입,리턴 타입> 
			int result = num1*10;
			return result;
		};
//		System.out.println(func1.apply(5));
		Function<Integer, Integer> func2 = (num1) -> { //function<매개변수 타입,리턴 타입> 
			int result = num1+5;
			return result;
		};
		//아래와 동일
		int r = func2.apply(3);
		System.out.println(func1.apply(r));
		// compose는 func2의 결과값을 func1에게 전달한다
		Function<Integer, Integer> func12 = func1.compose(func2);
		System.out.println(func12.apply(3));
		
		MyInterface.doThat(10);
		
		System.out.println("------------");
		MyInterface inter1 = (a) -> {
			System.out.println("람다식 실행" + a);
			Person p1 = new Person("홍길동",30);
			MyInterface.doThat(a);
		};
		inter1.doIt(10);
		// 람다식의 매개변수와 정적 메서드의 매개변수가 같을 경우 아래와 같이 사용 가능
		MyInterface inter2 = (a) -> MyInterface.doThat(a);
		MyInterface inter3 = MyInterface::doThat;
		inter2.doIt(10);
		inter3.doIt(10);
		
	}//end main
	public static void callMethod(MyInterface2 obj) {
		System.out.println("==============");
		System.out.println(obj.doThat(3,8));
		System.out.println("--------------");
	}
}
