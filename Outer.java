
public class Outer {
	class Inner1 {
		static int a = 10; 
		int b = 20;
		void doInner1() {
			System.out.println("Inner.doInner1");
		}
	}
	
	static class Inner2{
		static int a = 100;
		int b = 200;
		void doInner2() {
			Outer out = new Outer();
			out.doOuter();
			System.out.println("Inner.doInner2");
		}
	}
	void doOuter() {
		/*final*/ int a = 10;  //8부터 지역클래스가 참조할 경우 final
		Inner1 in1 = new Inner1();
		in1.doInner1();
		
		Inner2 in2 = new Inner2();
		in2.doInner2();
		
		class LocalInner {
			void doLocalInner() {
//				a=20;  //지역변수를 지역클래스에서 수정 못함
				System.out.println(a);
				System.out.println("LocalInner");
			}
		}
		LocalInner in = new LocalInner();
		in.doLocalInner();
	}
}
