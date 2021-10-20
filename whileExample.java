

import java.util.Scanner;

public class whileExample {

	public static void main(String[] args) {
		int i=0;
		while(i>10) {
			System.out.println(i);
			i++;
		}
		int j=0;
		do {
			System.out.println(j);
			j++;
		}while(j>10);
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("메뉴를 입력하세요. 1:하나 2:둘 0:종료");
			System.out.println("메뉴입력 : ");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("하나입니다.");
				break;
			case 2:
				System.out.println("둘입니다.");
				break;
			case 0:
				System.out.println("종료합니다.");
				scan.close();
				return; //메서드를 종료시킨다
			} // end switch
		} // end while

	} // end main

} // emd class
