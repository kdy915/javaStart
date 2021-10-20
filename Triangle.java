
public class Triangle extends Shape {
	int width;
	int height;
	
	public Triangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	@Override
	public double calcArea() {
		return width * height /2.0;
	}
}
