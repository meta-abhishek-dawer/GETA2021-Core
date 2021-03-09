package GraphicsLibrary;

import java.sql.Timestamp;
import java.util.Date;
/** 
 * class square which implements Shape interface and its methods
 * @author abhishek.dawer_metac
 *
 */
public class Square implements Shape {
	double side;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.Square.toString();
	
    /**
     * Constructor setting up the values of square
     * @param originValue containing origin coordinates
     * @param sideValue containing side of square
     */
    public Square(Point originValue, double sideValue) {
    	this.origin = originValue;
    	this.side = sideValue;
    	this.timeStamp = new Timestamp(new Date().getTime());
    }
    
    /**
     * Method to get the type of shape
     */
    @Override
	public String getShapeType() {
	return shapeType;
	}

    /**
     * Method to get area of Square
     */
	@Override
	public double getArea() {
		return side * side;
	}

	/**
	 * Method to get perimeter of rectangle
	 */
	@Override
	public double getPerimeter() {
		int squareSides = 4;
		return squareSides * 4;
	}

	/**
	 * Method to check enclosed point
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.xAxisCoordinate < origin.xAxisCoordinate || point.yAxisCoordinate < origin.yAxisCoordinate)
			return false;
		if(point.xAxisCoordinate> origin.xAxisCoordinate + side || point.yAxisCoordinate> origin.yAxisCoordinate + side)
			return false;
		else
			return true;
	}

	/**
	 * Method to get origin coordinates
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 * Method to get the time
	 */
	@Override
	public Timestamp getTimestamp() {
		return this.timeStamp;
	}

}
