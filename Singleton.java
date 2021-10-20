
public class Singleton {
	private static Singleton inst = new Singleton();
	private Singleton(){ // private은 현재 클래스에서만 참조 가능하고 다른 곳에서 참조 불가능 강력한 접근 제한
		}
	public static Singleton getInstance(){
		return inst;
		}
}
