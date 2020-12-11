package Structural;

public class Point {
	private int x, y;
	private int radius;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		radius = 5;
	}
	
	public Point(int x, int y, int radius) {
		this.x = x;
		this.y = y;
	}
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
