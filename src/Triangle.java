
import java.util.ArrayList;

public class Triangle extends Polygon {

	public Triangle(int numOfSides, ArrayList<Point> coors) { // 2 i
		super(numOfSides, coors);
	}

	public Triangle(int numOfSides) { // 2 ii
		super(numOfSides);
	}

	public Triangle(ArrayList<Point> coors) { // 3 i
		super(3, coors);

	}

	
	public Triangle() { // 3 ii
		numOfSides = 3;
	}
	/*
	 * public Triangle () {//3 ii super(3); super.addOneCoordinate(2, 3);
	 * super.addOneCoordinate(5, 7); super.addOneCoordinate(-1, 8); }
	 */

	public double area() {
		double area = 0;
		
		Point a = coordinates.get(0);
		Point b = coordinates.get(1);
		Point c = coordinates.get(2);
		
		double d1 = Math.sqrt((Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2)));
		double d2 = Math.sqrt((Math.pow((b.x - c.x), 2) + Math.pow((b.y - c.y), 2)));
		double d3 = Math.sqrt((Math.pow((a.x - c.x), 2) + Math.pow((a.y - c.y), 2)));

		double length = 0.5 * (d1 + d2 + d3);
		area = Math.sqrt(length * (length - d1) * (length - d2) * (length - d3));

		return area;
	}

	public boolean isEquilateral() {
		
		Point a = coordinates.get(0);
		Point b = coordinates.get(1);
		Point c = coordinates.get(2);
		
		boolean equilateral = false;
		if (distance(a, b) == distance(a, c) && distance(a, c) == distance(b, c)) {
			equilateral = true;
		}

		return equilateral;
	}

	public double distance(Point a, Point b) {
		double distance = Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
		
		return distance;
	}



}
