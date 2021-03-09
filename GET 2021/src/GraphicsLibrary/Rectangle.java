package GraphicsLibrary;

import java.sql.Timestamp;
import java.util.Date;
/**
 * Class implementing shape interface and its methods
 * @author abhishek.dawer_metac
 *
 */
public class Rectangle implements Shape {
	double length, breadth;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.Rectangle.toString();
    
    /**
     * Constructor setting up the values of Rectangle
     * @param originValue containing coordinates of shape Rectangle
     * @param lengthValue containing length of rectangle
     * @param breadthValue containing breadth of rectangle
     */
    public Rectangle(Point originValue, double lengthValue, double breadthValue) {
        this.origin = originValue;
        this.length = lengthValue;
        this.breadth = breadthValue;
        this.timeStamp = new Timestamp(new Date().getTime());
    }
    
    /**
     * Method to get the shape type
     */
	@Override
	public String getShapeType() {
		return this.shapeType;
	}

	/**
	 * Method to get area of Rectangle
	 */
	@Override
	public double getArea() {
		return this.length * this.breadth;
	}

	/**
	 * Method to get perimeter of rectangle
	 */
	@Override
	public double getPerimeter() {
		int number = 2;
		return 2 * (this.length + this.breadth);
	}

	/**
	 * Method to check point is enclosed
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if((origin.xAxisCoordinate < point.xAxisCoordinate) || (origin.yAxisCoordinate < point.yAxisCoordinate)
		    || (origin.xAxisCoordinate > point.xAxisCoordinate + length) || (origin.yAxisCoordinate > point.yAxisCoordinate + breadth))
			    return false;
		return true;
	}

	/**
	 * method to get origin coordinates of shape
	 */
	@Override
	public Point getOrigin() {
		return this.origin;
	}

	/**
	 * Method to get time
	 */
	@Override
	public Timestamp getTimestamp() {
		return this.timeStamp;
	}
  
}
