package kr.or.kosa.myprj;

public class Super2<K, V> {

}

class Sub2<K,V,M> extends Super2<K,V>{ 
	// Generic클래스를 상속 받을 경우 반드시 부모의 제네릭을 자식도 가져야 한다.
	// 자식은 추가 제네릭 정의 가능함
}