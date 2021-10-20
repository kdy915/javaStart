

public class BreakExample {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			if(i==5) {
				continue;
			}
			System.out.println(i);
		}
		// for문에 이름을 명시해서 break 구문과 continue 구문의 빠져나가는 루프를 설정해 줄 수 있다.
		outer: for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if (j==i) { 
					break outer; //가장 안쪽에 있는 구문에서 빠져나간다.
				}
				System.out.println(i + " " + j);
			}
		}
		
		/*
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 * 별의 수를 입력받아서....5를 입력하면 위의 별 피라미드처럼 출력
		 */
		for(int i=0; i<5; i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print("*");

			}
			System.out.println("");
		}
//		int dan = 2;
		for(int i=1;i<10;i++) {
			for(int dan=2; dan<=9;dan++) {		
				System.out.printf("%d*%d=%2d\t",dan,i,i*dan);
			}
			System.out.println();
		}
		/*          행(i)    열(j)      5-i
		 * *****     0      5번 반복
		 * ****      1      4번 반복
		 * ***       2      3번 반복
		 * **        3      2번 반복
		 * *         4      1번 반복
		 * 별의 수를 입력받아서....5를 입력하면 위의 별 피라미드처럼 출력
		 */
		for (int i=0; i<5;i++) {
			for(int j=0;j<5-i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		/*
		 *      *
		 *     **
		 *    ***
		 *   ****
		 *  *****  
		 */
		for(int i=0;i<5;i++) {
			for(int j=0;j<5-i-1;j++) {
				System.out.print("_");
			}
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for (int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(j<5-i-1) {
					System.out.print(" ");
				}else {
					System.out.print("*");	
				}
			}
			System.out.println("");
		}
		
	}

}
