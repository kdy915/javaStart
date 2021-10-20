

import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		// 1
		int sum=0;
		for(int i=0;i<100;i++) {
			if(i%3==0) {
				sum += i;
			}
		}
		System.out.println(sum);
		// 2
		while(true) {
			int i = (int)(Math.random()*6);
			int j = (int)(Math.random()*6);
			if(i+j==5) {
				break;
			}
			System.out.printf("(%d, %d)",i,j);
		}
		System.out.println();
		//3
		for(int i=0;i<=10;i++) {
			for(int j=0;j<=10;j++) {
				if(4*i+5*j==60) {
					System.out.printf("(%d, %d)",i,j);
				}
			}
		}
		System.out.println();
		//4
		for(int i=0;i<5;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
			}
		System.out.println();
			
		}
		//5
		boolean run = true;
		int balance=0;
		Scanner scanner = new Scanner(System.in);
		while(run) {
			System.out.println("-----------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------");
			System.out.print("선택>");
			int select = scanner.nextInt();
			switch(select) {
			case 1:
				System.out.print("예금액>");
				int save = scanner.nextInt();
				balance += save;
				break;
			case 2:
				System.out.print("출금액>");
				int out = scanner.nextInt();
				balance -= out;
				break;
			case 3:
				System.out.print("잔고>");
				System.out.print(balance);
				break;
			case 4:
				System.out.println("프로그램 종료");
				scanner.close();
				run = false;
			}
		}

	}

}
