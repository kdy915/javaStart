package kr.or.kosa.myprj;

public class GenericTest {
	public static void main(String[] args) {
		// 제한된 타입 파라미터 extends에서 최상위 타입과 상속 타입들만 생성 가능
		SingleLinkedList<Student> list = new SingleLinkedList<Student>();
		GenericExample exam = new GenericExample();
		exam.doIt(list);
		}
}
