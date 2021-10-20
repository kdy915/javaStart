import java.util.Scanner;

public class ArrayCollectionExample {
	// 정수 10개를 저장할 수 있는 배열 선언
	static int[] intArr = new int[10];
	static int count = 0;
	static int index = -1;
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
//		intArr[0] = 10;
		while(true) {
			System.out.println("메뉴 입력 : 1. Append 2.Select All 3. Delete 4. Insert 0. Exit");
			System.out.println("메뉴 :");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.print("저장할 데이터 :");
				int data = scan.nextInt();
				append(data);
				break;
			case 2:
				System.out.println("모든 정보를 조회합니다.");
				selectAll();
				break;
			case 3:
				System.out.println("삭제할 인덱스를 입력하세요.");
				index = scan.nextInt();
				delete(index);
				break;
			case 4:
				System.out.println("입력할 위치(인덱스)와 값을 입력하세요");
				index = scan.nextInt();
				int insertData = scan.nextInt();
				insert(index, insertData);
				break;
			case 0:
				System.out.println("프로그램 종료합니다.");
				System.exit(0);
			}
		}//end while
	}// end main
	public static void append(int data) {
		intArr[count] = data;
		count++;
	}
	public static void selectAll() {
		for(int i =0; i<count; i++) {
			System.out.println(intArr[i]);
		}
	}
	public static void insert(int index, int data) {
		for(int i=count; i>index; i--) {
			intArr[i]=intArr[i-1];
		}
		intArr[index] = data;
		count++;
	}
	public static void delete(int index) {
		for(int i = index; i<count-1;i++) {
			intArr[i] = intArr[i+1];
		}
		count--;
	}
}
