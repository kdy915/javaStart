
public class Circle extends Shape {
	int radius;

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	@Override
	public double calcArea() {
		return 3.14*radius*radius;
	}
}
