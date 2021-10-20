
public class SingletonTest {

	public static void main(String[] args) {
//		Singleton inst = new Singleton();
//		Singleton inst =  Singleton.inst;
		Singleton inst1 = Singleton.getInstance();
		Singleton inst2 = Singleton.getInstance();
		
		System.out.println(inst1==inst2);
		System.out.println(inst1);
		System.out.println(inst2);

	}

}
