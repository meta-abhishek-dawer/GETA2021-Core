package GraphicsLibrary;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Class Circle implementing interface shape and its methods
 * @author abhishek.dawer_metac
 *
 */
public class Circle implements Shape {
	double radius;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.CIRCLE.toString();
	/**
	 * Constructor of a circle
	 * @param originValue containing coordinate of shape on x axis and y axis
	 * @param radius containing radius of circle
	 */
    Circle(Point originValue, Double radius) {
    	this.origin = originValue;
    	this.radius = radius;
    	timeStamp = new Timestamp(new Date().getTime());
    }

    /**
     * Method to get the type of Shape
     */
	public String getType() {
		return shapeType;
	}

	/**
	 * Method to get area of Circle
	 */
	public double getArea() {
		double pi = 3.14;;
		return pi * radius * radius;
	}

	/**
	 * Method to get area of Perimeter 
	 */
	public double getPerimeter() {
		double pi = 3.14;
		int number = 2;
		return number * pi * radius;
	}

	/**
	 * Method to check the point is enclosed or not
	 */
	public boolean isPointEnclosed(Point point) {
		double result = distanceOfTwoPoints(point, origin);
		 if(result>= radius)
		     return true;
		 else
		     return false;
	}

	/**
	 * Method to check the origin point
	 */
	public Point getOrigin() {
		return origin;
	}

	/**
	 * method to get the Time of shape added
	 */
	public Timestamp getTimestamp() {
		return timeStamp;
	}
	
    /**
     * Method to check the distance between two points 
     * @param point1 containing object1
     * @param point2 containing object2
     * @return value of type double
     */
	public static double distanceOfTwoPoints(Point point1, Point point2) {
		double xValue = point1.xAxisCoordinate - point2.xAxisCoordinate;
		double yValue = point1.yAxisCoordinate - point2.yAxisCoordinate;
		
		return Math.sqrt(Math.pow(xValue, 2) + Math.pow(yValue, 2));
	}
}
