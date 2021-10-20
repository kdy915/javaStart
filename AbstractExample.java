
public class AbstractExample {
public static void main(String[] args) {
//	Shape s1 = new Shape(); //abstract 클래스라서 객체를 생성할 수 없다.
	Shape s2 = new Circle(10, 20, 5);
	System.out.println(s2.calcArea()); //VMI 가상 메소드 호출
	
	}
}
