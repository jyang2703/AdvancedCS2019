import java.util.ArrayList;

public class PolygonCreator {

	public static void main(String[] args) {
		
		
		
		ArrayList<Point> testCoordinates = new ArrayList<Point>(); //2i
		testCoordinates.add(new Point(2.0, 3.0));
		testCoordinates.add(new Point(5.0, 7.0));
		testCoordinates.add(new Point(1.0, 9.0));
		
		Triangle t1 = new Triangle(3, testCoordinates);
		
		Triangle t2 = new Triangle(3); //2ii
		t2.addOneCoordinate(3.0, 4.0);
		t2.addOneCoordinate(4.0, 5.0);
		t2.addOneCoordinate(11.0, 9.0);
		
		Triangle t3 = new Triangle(testCoordinates); //3i
				
		Triangle t4 = new Triangle(); //3ii
		t4.addOneCoordinate(2.0, 3.0);
		t4.addOneCoordinate(3.0, 4.0);
		t4.addOneCoordinate(10.0, 1.0);
		
		double a = distance(new Point(2.0, 2.0), new Point (3.0, 3.0) );
		
	}
	
	public static double distance(Point a, Point b) {
		double distance = Math.round((Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2)))*100.0) / 100.0;
		
		return distance;
	}

}
