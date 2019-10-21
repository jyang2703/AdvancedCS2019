import java.util.ArrayList;



public abstract class Polygon {
	
	int numOfSides;
	private int numberOfPoints = 0; //counter for my addOneCoordinate method 
	
	ArrayList<Point> coordinates;

	public Polygon(int numOfSides) {
		this.numOfSides = numOfSides;
		coordinates = new ArrayList<Point>();
		
	}
	
	public Polygon(int numOfSides, ArrayList<Point> coors) {
		this.numOfSides = numOfSides;
		coordinates = coors;
	}
	
	public Polygon (){
		coordinates = new ArrayList<Point>();
	}
	
	
	public void addOneCoordinate(double x, double y) {
		
		if(numberOfPoints < numOfSides){ //if statement prevents creating more points than number of sides
			coordinates.add(new Point(x,y));
			numberOfPoints ++; 
		} else {
			System.out.println("Error, number of points exceeds number of sides.");
		}
		
	}
	

	public abstract double area();
	
	public abstract boolean isEquilateral();
	
	public int sumOfInteriorAngles() {
		return 180*(numOfSides - 2);
	}
	
	public int interiorAngle() {
		if(isEquilateral()) return sumOfInteriorAngles()/numOfSides;
		return -1;
	}
}
