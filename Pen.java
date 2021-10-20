

public class Pen {

		
		String color = "black"; // member variable, instance variable
		double width = 1;
		static int temp; //member variable, static variable, class variable
		
//		public Pen() {
//			super(); //생략 가능 
//		} // 기본 생성자, 클래스에 생성자가 없을 경우 컴파일러가 추가해 주는 생성자
		// 생성자는 객체의 맴버(변수)를 초기화 하기 위해 사용
		public Pen(String color) {
			this.color = color; // this.는 매개변수와 맴버변수와 이름이 같아도 구분 할수가 있다.
		}
		
		//Overloading 생성자를 중복되서 여러개 생성하는 것
		public Pen(double width) {
			this.width = width;
		}
		
		public Pen(String init_color, double init_width) {
			color = init_color;
			width = init_width;
		}
		
		public Pen(double init_width, String init_color) {
			this(init_color,init_width);  
//			color = init_color;
//			width = init_width;
		}
		
		
		void write(String message) { //message도 local variable, parameter variable(매개변수)
			int a = 5;
			int width = 30;
			for(int i=0;i<a;i++) {
				System.out.printf("%s색, %f 굵기로 %s를 씁니다 \n",color,this.width,message);			
			} // 객체의 속성은 행위에 영향을 준다.
		}

}
