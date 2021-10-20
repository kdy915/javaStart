public class Car {

	String model;
	int speed;
	
	Car(String model){
		this.model = model;
	}
	void setSpeed(int speed) {
		this.speed = speed;
	}
	void run() {
		for(int i=10;i<=50;i+=10) {
			this.setSpeed(i);
			System.out.println(this.model +this.speed);
		}
		System.out.println('1');
	}
	
}
