package GraphicsLibrary;

import java.sql.Timestamp;
/**
 * Class implementing Shape interface and its methods
 * @author abhishek.dawer_metac
 *
 */
public class Polygon implements Shape {
	double side, numberOfSides;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.POLYGON.toString();
    
    /**
     * Constructor to set the values of Polygon
     * @param originValue containing coordinate of Polygon
     * @param sideValue containing value of side
     * @param numberOfSides1 containing number of sides
     */
    public Polygon(Point originValue, double sideValue, double numberOfSides1) {
    	this.side = sideValue;
    	this.numberOfSides = numberOfSides1;
    	this.origin = originValue;
    }
    /**
     * Method to get the shape type
     */
	public String getType() {
		return this.shapeType;
	}
	
	/**
	 * Method to get area of Polygon
	 */
	public double getArea() {
		double angle = Math.toRadians(180 / numberOfSides);
		double area = (side * side* numberOfSides) / (4 * (Math.tan(angle)));
		return area;
	}
	
	/**
	 * Method to get perimeter of Polygon
	 */
	public double getPerimeter() {
		return numberOfSides * side;
	}
	
	/**
	 * Method to check point is enclosed
	 */
	public boolean isPointEnclosed(Point point) {
		if((origin.xAxisCoordinate < point.xAxisCoordinate) || (origin.yAxisCoordinate < point.yAxisCoordinate))
		    return false;
		return true;
	}
	
	/**
	 * Method to get origin coordinates
	 */
	public Point getOrigin() {
		return new Point(origin.xAxisCoordinate, origin.yAxisCoordinate);
    }
	
	/**
	 * Method to get the time  
	 */
	public Timestamp getTimestamp() {
		return this.timeStamp;
	}
}
