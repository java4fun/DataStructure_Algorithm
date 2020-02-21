package sort;

public class Circle implements Comparable<Circle> {

	public double radius;

	public Circle(double r) {
		if (r < 0)
			throw new RuntimeException("Radius cannot be negative");
		this.radius = r;
	}

	public Circle() {
		this(1);
	}

	@Override
	public int compareTo(Circle o) {
		if (this.radius > o.radius) return 1;
		if (this.radius == o.radius) return 0;
		return -1;
	}

	public double getRadius() {
		return radius;
	}

	public double area() {
		return Math.PI * this.radius * this.radius;
	}

	public double perimeter() {
		return Math.PI * 2 * this.radius;
	}


	@Override
	public String toString() {
		return "This Circle is of radius: " + this.radius;
	}

}
