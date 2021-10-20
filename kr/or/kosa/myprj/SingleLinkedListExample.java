package kr.or.kosa.myprj;

public class SingleLinkedListExample {
	public static void main(String[] args) {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
//		System.out.println(list);
//		list.addFirst("A"); list.addFirst("B"); list.addFirst("C");
//		System.out.println(list);
//		list.addLast("D");
//		System.out.println(list);
//		list.add("E");
//		System.out.println(list);
//		list.add(2, "F");
//		System.out.println(list);
//		list.removeFirst();
//		System.out.println(list);
//		list.remove(3);
//		System.out.println(list);
		list.addLast("A"); list.addLast("B");
		System.out.println(list);
		list.add(1, "F");
		System.out.println(list);
	}
}
