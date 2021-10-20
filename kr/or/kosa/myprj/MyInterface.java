package kr.or.kosa.myprj;
@FunctionalInterface //메소드를 한개만 가질 수 있다. 람다식에 사용하기 위한 표현구
public interface MyInterface {
	void doIt(int a);
	static void doThat(int a) {
		System.out.println(a*10);
	}
}
