package GraphicsLibrary;

import java.sql.Timestamp;
import java.util.Date;

public class Square implements Shape {
	double side;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.Square.toString();
	
    public Square(Point originValue, double sideValue) {
    	this.origin = originValue;
    	this.side = sideValue;
    	this.timeStamp = new Timestamp(new Date().getTime());
    }
    
    @Override
	public String getShapeType() {
	return shapeType;
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		int squareSides = 4;
		return squareSides * 4;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.xAxisCoordinate < origin.xAxisCoordinate || point.yAxisCoordinate < origin.yAxisCoordinate)
			return false;
		if(point.xAxisCoordinate> origin.xAxisCoordinate + side || point.yAxisCoordinate> origin.yAxisCoordinate + side)
			return false;
		else
			return true;
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
