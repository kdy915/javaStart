
public class Rectangle extends Shape {
	int width;
	int height;
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	@Override
	public double calcArea() {
		return width*height;
	}
}
