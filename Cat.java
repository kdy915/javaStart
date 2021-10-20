
public class Cat extends Animal implements Pet {

	@Override
	public void play() {
		System.out.println("냐옹");

	}
	public void doIt() {
		System.out.println("디폴트 메서드 재정의");
	}
	
	public void doThat() {
		System.out.println("재정의합니다.");
	}
}
