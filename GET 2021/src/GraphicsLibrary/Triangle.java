package GraphicsLibrary;

import java.sql.Timestamp;
import java.util.Date;
/**
 * class Triangle implementing Shape interface and methods
 * @author abhishek.dawer_metac
 *
 */
public class Triangle implements Shape {
	double base, height;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.Triangle.toString();
    
    /**
     * Constructor setting up the values
     * @param originValue containing origin values
     * @param baseValue containing base of triangle
     * @param heightValue containing height of triangle
     */
    public Triangle(Point originValue, double baseValue, double heightValue) {
    this.base = baseValue;
    this.height = heightValue;
    this.timeStamp = new Timestamp(new Date().getTime());
    this.origin = originValue;
    }
    
    /**
     * Method to get the type of shape
     */
	@Override
	public String getShapeType() {
		return shapeType;
	}

	/**
	 * Method to get area of triangle
	 */
	@Override
	public double getArea() {
		double number = 0.5;
		return number * base * height;
	}

	/**
	 * method to get perimeter of triangle
	 */
	@Override
	public double getPerimeter() {
		return this.base + this.height + Math.sqrt(base * base + height * height);
	}

	/**
	 * method to check point is enclosed
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if((origin.xAxisCoordinate < point.xAxisCoordinate) || (origin.yAxisCoordinate < point.yAxisCoordinate))
		    return false;
		return true;
	}
	
	/**
	 * Method to get origin of type point
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 * Method to get TimeStamp
	 */
	@Override
	public Timestamp getTimestamp() {
		return this.timeStamp;
	}

}
