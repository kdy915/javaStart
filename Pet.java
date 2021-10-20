
public interface Pet { // 모든 메서드는 abstract 메소드이다 변수 메소드 는 public제한자를 포함한다
	/*public static final*/ int MAX = 10;
	/*public abstract*/ void play(); //public abstract가 자동으로 생성
	//JDK 8에 추가된 디폴트 메서드
	public default void doIt() {
		System.out.println("디폴트 메소드입니다.");
	}
	//JDK8에 추가된 정적 메서드
	public static void doThat() {
		System.out.println("정적 메소드입니다.");
	}
}
