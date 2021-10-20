
public class InnerExample {
	public static void main(String[] args) {
//		Outer out = new Outer();
//		Outer.Inner1 in1 = out.new Inner1();
		Outer.Inner1 in1 = new Outer().new Inner1(); // 4, 5 line을 합쳐서 한줄로
		in1.doInner1();
		System.out.println(Outer.Inner2.a);
		
		new Outer().doOuter();
		Outer.Inner2 in2 = new Outer.Inner2();
	}
}
