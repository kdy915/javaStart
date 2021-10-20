
public abstract class Shape {
	int x;
	int y;
	
	public Shape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public abstract double calcArea();
}
