

import java.util.Scanner;

public class SwitchExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.입력 2.수정 3.삭제 4.조회 0.종료");
		System.out.print("메뉴 : ");
		int menu = scan.nextInt();
		System.out.println(menu);
		switch(menu) {
		case 1:
			System.out.println("입력합니다.");
			break;
		case 2:
			System.out.println("수정합니다.");
			break;
		case 3:
			System.out.println("삭제합니다.");
			break;
		case 4:
			System.out.println("조회합니다.");
			break;
		case 0:
			System.out.println("종료합니다.");
			break;
		default:  //위에 메뉴와 다른 값이 나오면 default가 실행된다.
			System.out.println("없는 메뉴입니다.");
			break;
		}
		scan.close();

	}

}
