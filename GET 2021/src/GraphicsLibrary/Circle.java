package GraphicsLibrary;

import java.sql.Timestamp;
import java.util.Date;

public class Circle implements Shape {
	double radius;
	Point origin;
	Timestamp timeStamp;
    final String shapeType = Shape.shapeType.Circle.toString();
	
    Circle(Point originValue, Double radius) {
    	this.origin = originValue;
    	this.radius = radius;
    	timeStamp = new Timestamp(new Date().getTime());
    }

	@Override
	public String getShapeType() {
		return shapeType;
	}

	@Override
	public double getArea() {
		double pi = 3.14;;
		return pi * radius * radius;
	}

	@Override
	public double getPerimeter() {
		double pi = 3.14;
		int number = 2;
		return number * pi * radius;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		double result = distanceOfTwoPoints(point, origin);
		 if(result>= radius)
		     return true;
		 else
		     return false;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public Timestamp getTimestamp() {
		return timeStamp;
	}
    
	public static double distanceOfTwoPoints(Point point1, Point point2) {
		double xValue = point1.xAxisCoordinate - point2.xAxisCoordinate;
		double yValue = point1.yAxisCoordinate - point2.yAxisCoordinate;
		
		return Math.sqrt(Math.pow(xValue, 2) + Math.pow(yValue, 2));
	}
}
