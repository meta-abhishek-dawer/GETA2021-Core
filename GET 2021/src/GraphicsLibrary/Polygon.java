package GraphicsLibrary;

import java.sql.Timestamp;

public class Polygon implements Shape {
	double side, numberOfSides;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.Polygon.toString();
    
    public Polygon(Point originValue, double sideValue, double numberOfSides1) {
    	this.side = sideValue;
    	this.numberOfSides = numberOfSides1;
    	this.origin = originValue;
    }
    
	@Override
	public String getShapeType() {
		return this.shapeType;
	}
	
	@Override
	public double getArea() {
		double angle = Math.toRadians(180 / numberOfSides);
		double area = (side * side* numberOfSides) / (4 * (Math.tan(angle)));
		return area;
	}
	@Override
	public double getPerimeter() {
		return numberOfSides * side;
	}
	@Override
	public boolean isPointEnclosed(Point point) {
		if((origin.xAxisCoordinate < point.xAxisCoordinate) || (origin.yAxisCoordinate < point.yAxisCoordinate)
			    || (origin.xAxisCoordinate > point.xAxisCoordinate + side) || (origin.yAxisCoordinate > point.yAxisCoordinate + side))
				    return false;
		return true;
	}
	
	@Override
	public Point getOrigin() {
		return new Point(origin.xAxisCoordinate, origin.yAxisCoordinate);
    }
	
	@Override
	public Timestamp getTimestamp() {
		return this.timeStamp;
	}
}
