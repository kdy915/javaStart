

public class ForExample {

	public static void main(String[] args) {
		int sum = 0;
		for(int i=0; i<100; i++) {
			sum += i;
//			System.out.println(i);
		}
		System.out.println(sum);
		sum =0;
		int j =0;
		for( ; ; ) {
			if(j<=100) {
				sum = sum+j;
				j++;
			}else {
				break;
			}
		}
		System.out.println(sum);
		
		int[] intArrs = {1,2,3,4,5,6,7,8,9,10};
		// intArr 배열의 모든 요소의 합을 출력
		int sumArr = 0;
//		for(int i=0; i<intArrs.length;i++) {
//			sumArr += intArrs[i];
//		}
		for (int data:intArrs) { //intArrs에 있는 객체가 모두 소비될때 까지 값을 data에 전달해 준다
			sumArr += data;
		}
		System.out.println(sumArr);
	}// end main
}// end class
