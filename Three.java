

public class Three {

	public static void main(String[] args) {
		int x =1;
		System.out.println(~x);  
		// 00000000 00000000 00000000 00000010
		// 11111111 11111111 11111111 11111101
		System.out.println(5/2);
		x = 2147483647; // 01111111 11111111 11111111 11111111
		long x2 = (long)x + 1;      // 10000000 00000000 00000000 00000000
		System.out.println(x2);
		
		double x3 = 123456789123F;
		System.out.println(x3);  // 긴 자리 수는 정수로 표현해서 사용하는 것이 좋다
		//1
		int y = 10;
		int z = 20;
		int zz = (++y) + (z--);
		System.out.println(zz);
		//2
		int score = 85;
		String result = (!(score>90))? "가":"나";
		System.out.println(result);
		//3
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = 534/30;
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = 534%30;
		System.out.println(pencilsLeft);
		//4
		int value = 356;
		System.out.println(value);
		//5
		int lengthTop =5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((lengthTop + lengthBottom) * height) /2.;
		System.out.println(area);
		//6
		int xx=10;
		int yy=5;
		System.out.println((xx>7) && (yy<=5));
		System.out.println((xx%3 == 2) || (y%2 != 1));
		//7
		double xxx=5.0;
		double yyy=0.0;
		
		double zzz = xxx%yyy;
		
		if(yyy==0) {
			System.out.println("0으로 나눌 수 없다");
		}else {
			double result2 = zzz + 10;
			System.out.println("결과:"+result2);
		}
	}

}
