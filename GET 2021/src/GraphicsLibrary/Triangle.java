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
		Point point1, point2, point3;
		point1 = new Point(origin.xAxisCoordinate, origin.yAxisCoordinate);
		point2 = new Point(origin.xAxisCoordinate + base, origin.yAxisCoordinate);
		point3 = new Point(origin.xAxisCoordinate, origin.yAxisCoordinate + height);
		
		double d1 = sign(point, point1, point2);
		double d2 = sign(point, point2, point3);
		double d3 = sign(point, point3, point1);
		
		boolean has_negative = (d1 < 0) || (d2 < 0) || (d3 < 0);
		boolean has_positive = (d1 > 0) || (d2 > 0) || (d3 > 0);
		
		return !(has_negative && has_positive);
	}
	
	public double sign(Point point1, Point point2, Point point3) {
		return (point1.xAxisCoordinate- point3.xAxisCoordinate) * (point2.yAxisCoordinate- point3.yAxisCoordinate) - 
				(point2.xAxisCoordinate - point3.xAxisCoordinate) * (point1.yAxisCoordinate - point3.yAxisCoordinate);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public Timestamp getTimestamp() {
		return this.timeStamp;
	}

}
