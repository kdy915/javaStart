// public class는 하나만 생성가능 파일명이랑 동일해야됨 여러개 클래스가 생성가능 bin에서 컴포트할때는 class여러개 생성해 준다
public class StaticExample {
	public static void main(String[] args) {
//		Static.a = 100;
		Static st = new Static();
		st.a = 100;
		System.out.println(st.a);
		Static.b = 200;
		Static.doThat();
		System.out.println(st.b);
	}
}

class Static{
	int a; // member, instance variable
	static int b; // member, static variable
	static {  
		System.out.println("클래스 로딩시 1번만 실행");
		b = 100;
//		a = 200;
	} // 정적 초기화자 static변수의 초기화에 사용, 거의 사용 안함 이유는 선언시 초기화 하면 편함.
	
	{
		a =20;
	} // instance initializer, 문법에는 있지만 실제 사용 x
	public Static() {
		System.out.println("객체 생성됨");
	}
	public Static(int a) {
		this.a = a;
	}
	void doIt() {
		a= 10;
		b--;
		System.out.println(a+""+b);
	}
	static void doThat() {
		Static st = new Static();
		st.a ++;
		b++;
		System.out.println("non static"+ st.a);  //main에서 생성한 객체와 dothat에서 생성한 객체는 다른 객체임으로 1이 나온다
		System.out.println("static "+b);
	}
}