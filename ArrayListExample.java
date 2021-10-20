import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayListExample {
	public static void main(String[] args) {
		List intList = new ArrayList();
		intList.add(10);
		intList.add(20);
		intList.add(30);
		intList.add(1,40);
		System.out.println(intList);
		intList.remove(1);
		System.out.println(intList);
		// 연결링크 리스트는 주소와 값의 구조로 된 노드를 가지고 있으며 주소를 통해서 값의 순서를 정하기 때문에 삽입 삭제가 용이하고 빠르다.
		// 대신 용량의 크기가 array list보다 크다
		List intList2 = new LinkedList();
		intList2.add(10);
		intList2.add(20);
		intList2.add(30);
		intList2.add("Hello");
		System.out.println(intList2);
		int data = (int)(intList2.get(0));  //Integer vs Object Object가 더크다
		// 제너릭을 사용하면 리스트에 적용되는 기존 default값 Object타입을 다른 타입으로 수정할 수 있다.
		// 사용하는 모든함수에 적용된다. 
		List<Integer> intList3 = new ArrayList</*Integer*/>(); // 생성은 생략가능
		intList3.add(10);
		intList3.add(20);
		intList3.add(1, 30);
//		intList3.add("Hello");
		int data1 = intList3.get(1); // default가 Object일때는 형변환을 통해서 값을 얻어 왔었다.
		System.out.println(data1);
		// Vector는 스레드 safe를 하기 위해 사용된다. arraylist와 linkedlist에서 safe를 보안하는 코드와 함께 더 많이 쓰인다
		Vector<String> strList = new Vector<String>();
		strList.add("Hello");
		strList.add("World");
		System.out.println(strList.get(0));
	}
}
