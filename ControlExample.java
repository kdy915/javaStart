

import java.util.Scanner;

public class ControlExample {
// if문은 범위가 넓은 순으로 정리해 나가면 좋다
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //기본 입력장치 System.in은 키보드를 의미하며 입력장치를 의미
		System.out.print("점수를 입력하세요 : ");
		int num = scan.nextInt();
		String grade = "F";
		if(num>=60){
			if(num>=90) {
				grade = "A";
			}else if(num>=80) {
				grade = "B";
			}else if(num>=70) {
				grade = "C";
			}else {
				grade = "D";
			}
			System.out.println("합격입니다");
		}else {
			System.out.println("불합격입니다");
		}
		System.out.println(grade + "등급입니다");
		scan.close();
		
		
		//		System.out.println(num*10);
		// 입력값이 60이상이면 합격을 출력합니다
//		if(num >=60) {
//			System.out.println("합격입니다.");
//		}else {
//			System.out.println("불합격입니다.");
//		}
//		String grade = "";
//		if(num>=90) {
//			grade = "A";
//		}else if(num>=80) {
//			grade = "B";
//		}else if(num>=70) {
//			grade = "C";
//		}else if(num>=60) {
//			grade = "D";
//		}else {
//			grade = "F";
//		}
//		System.out.println(grade + "등급입니다");
//		
//		int score = (int)(Math.random()*100); //난수를 생성한다
//		System.out.println(score);
//		scan.close();

	}

}
