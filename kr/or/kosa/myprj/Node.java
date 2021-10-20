package kr.or.kosa.myprj;

public class Node<T> {
	T data;
	Node<T> next; //다음 노드의 주소
	public Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
	
}
