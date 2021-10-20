

import java.util.Scanner;

public class SwitchExample2 {

	public static void main(String[] args) {
		System.out.println("(I)nsert, (U)pdate, (D)elete, (S)elect, (E)xit");
		Scanner scan = new Scanner(System.in);
		String menu = scan.next();
		switch(menu.charAt(0)) {
		case 'i':
		case 'I':
		case 'ㅑ':
			System.out.println("입력이 선택되었습니다.");
			break;
		case 'u':
		case 'U':
		case 'ㅕ':
			System.out.println("수정이 선택되었습니다.");
			break;
		case 'd':
		case 'D':
		case 'ㅇ':
			System.out.println("삭제가 선택되었습니다.");
			break;
		case 's':
		case 'S':
		case 'ㄴ':
			System.out.println("조회가 선택되었습니다.");
			break;
		case 'e':
		case 'E':
		case 'ㄷ':
			System.out.println("종료가 선택되었습니다.");
			break;
		case '3','2','1': 
			System.out.println("숫자");
		}
//		System.out.println(menu);
		scan.close();
	}

}
