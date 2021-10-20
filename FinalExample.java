
public class FinalExample {
	final double PI=3.141592;
	static final int MAX_NUM;
//	{
//		MAX_NUM = 100;
//	}
	
	static {
		MAX_NUM = 100; //정적 블록에서 static final을 초기화 시킬 수 있다.
	}
	public FinalExample() { //초기화는 한번만 해야하며 두번이상 하면 에러가 발생한다.
//		PI = 3.141592;  
//		MAX_NUM = 300; MAX_NUM은 static final은 생성자에서 초기화가 불가능하다
	}
	
}
