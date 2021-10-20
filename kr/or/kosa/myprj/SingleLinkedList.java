//package kr.or.kosa.myprj;
////제한된 파라미터를 사용할 때 필요
//public class SingleLinkedList<E extends Person> { // 일반적으로 E element T type K key V value를 의미한다 
////public class SingleLinkedList<? super Student> {
//	private E element;
//	
//	public void add(E input) { // 새로운 클래스를 만들때도 제네릭을 사용할 수 있다
//		System.out.println("add");
//	}
//	public E get(){
//		System.out.println("get");
//		return element;
//	}
//}
package kr.or.kosa.myprj;
public class SingleLinkedList<E> {
	private Node<E> head = null;
	private int size = 0;
	private Node<E> tail = null;
	
	@Override
	public String toString() {
		if(head == null) {
			return "[]";
		}
		Node<E> temp = head;
		String str = "[";
		while(temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		str += temp.data;
		return str + "]";
	}
	public void addFirst(E input) {
		Node<E> newNode = new Node<>(input);
		newNode.next = head;
		head = newNode;
		size++;
		if (head.next == null) {
			tail = head;
		}
		
	}
	public void addLast(E input) {
		Node<E> newNode = new Node<>(input);
		if(size==0) {
			addFirst(input);
		}else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	public void add(E input) {
		addLast(input);
	}
	public void add(int index, E input) {
		if(index==0) {
			addFirst(input);
		}else if(index==size) {
			addLast(input);
		}else if(index >size || index < 0) {
//			System.out.println("인덱스 오류"); // 1번
			throw new IndexOutOfBoundsException(String.valueOf(index)); // 2번을 권장
		}else {
			Node<E> prev = head;
			for(int i=0; i<index-1;i++) {
				prev = prev.next;
			}
			Node<E> newNode = new Node<>(input);
			newNode.next = prev.next;
			prev.next = newNode;
			size++;
		}
	}
	public E removeFirst() {
		Node<E> temp = head;
		head = temp.next;
		E data = temp.data;
		temp = null;
		size--;
		return data;
	}
	public E remove(int index) {
		if(index==0) {
			return removeFirst();
		}else if(index >= size || index<0) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		Node<E> prev = head;
		for(int i=0; i<index-1; i++) {
			prev = prev.next;
		}
		Node<E> todoDeleted = prev.next;
		prev.next = todoDeleted.next;
		
		E returnData = todoDeleted.data;
		if(todoDeleted == tail) { //삭제하려는 노드가 마지막 노드일 경우
			tail = prev;
		}
		size --;
		todoDeleted = null;
		return returnData;
	}
} // end SingleLinkedList
