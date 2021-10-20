
public class MethodExample {

	public static void main(String[] args) { 
		MethodExample obj = new MethodExample(); //객체를 생성하고 호출한다.
		double result = obj.add(10,20); //호출
		System.out.println(result);
		System.out.println(obj.add(10, 20));
		System.out.println(obj.add(10, 30, 40));
		System.out.println(obj.add(3.5, 10));
	}
	
//	int add(int a, int b) {  //선언, 정의
//		int result = a+b;
//		return result;
//	}
	
//	int add(int a, int b, int c) {
//		return a+b+c;
//	}
//	
//	int add(int a, int b, int c, int d) {
//		return a+b+c+d;
//	}
	int add(int a, int b, int...nums) { //a, b는 꼭 들어가야 하는것이고 nums는 배열타입으로 나머지 것들이 들어간다
		add(3.5,4.3);
		int sum = a+b;
		for(int num : nums) {
			sum += num;
		}
		return sum;
	}
	
	double add(double a, double b) {  
		System.out.println("double,double");
		return a+b;
	}
}
