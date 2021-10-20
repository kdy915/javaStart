
public class InterfaceExample {
public static void main(String[] args) {
	Pet.doThat();
	Pet c1 = new Cat();
	c1.doIt();
	c1.play();
//	Cat.doThat();
	
	Pet p1 = new Pet() {
		@Override
		public void play() {
			System.out.println("Pet play");
		}
	}; // 구현이랑 생성을 같이 한다.
	p1.play();
}
}
