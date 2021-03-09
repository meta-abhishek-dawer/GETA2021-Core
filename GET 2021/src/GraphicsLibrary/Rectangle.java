package GraphicsLibrary;

import java.sql.Timestamp;
import java.util.Date;

public class Rectangle implements Shape {
	double length, breadth;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.Rectangle.toString();
    
    public Rectangle(Point originValue, double lengthValue, double breadthValue) {
        this.origin = originValue;
        this.length = lengthValue;
        this.breadth = breadthValue;
        this.timeStamp = new Timestamp(new Date().getTime());
    }
    
	@Override
	public String getShapeType() {
		return this.shapeType;
	}

	@Override
	public double getArea() {
		return this.length * this.breadth;
	}

	@Override
	public double getPerimeter() {
		int number = 2;
		return 2 * (this.length + this.breadth);
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		if((origin.xAxisCoordinate < point.xAxisCoordinate) || (origin.yAxisCoordinate < point.yAxisCoordinate)
		    || (origin.xAxisCoordinate > point.xAxisCoordinate + length) || (origin.yAxisCoordinate > point.yAxisCoordinate + breadth))
			    return false;
		return true;
	}

	@Override
	public Point getOrigin() {
		return this.origin;
	}

	@Override
	public Timestamp getTimestamp() {
		return this.timeStamp;
	}
  
}
