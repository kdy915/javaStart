package kr.or.kosa.myprj;

public class GenericExample{
	public void doIt(SingleLinkedList<? extends Person> list) {// Person 의 자식 타입만 들어 갈 수 있게끔 하고 싶을 때
//		list.get().getDetails();
		// 어떤타입의 상속만 가능하다
	}
	public void doThat(SingleLinkedList<? super Student> list) { // ?는 클래스를 제너릭 지정하지 않고 메소드에 정의할 때 사용
		// 어떤타입의 부모만 가능하다
	}
	public void doSomething(SingleLinkedList<?> list) { //안적는 거랑 같음
		
	}
}
