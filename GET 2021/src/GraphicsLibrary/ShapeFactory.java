package GraphicsLibrary;

import java.util.ArrayList;

public class ShapeFactory {
    Shape newShape;
    
    public Shape createShape(String shapeType, Point point, ArrayList<Double> newArrayList) {
    	if(shapeType.equals("Square")) {
    		newShape = new Square(point, newArrayList.get(0));
    	}
    	else if(shapeType.equals("Circle")) {
    		newShape = new Circle(point, newArrayList.get(0));
    	}
    	else if(shapeType.equals("Rectangle")) {
    		newShape = new Rectangle(point, newArrayList.get(0), newArrayList.get(1));
    	}
    	else if(shapeType.equals("Triangle")) {
    		newShape = new Triangle(point, newArrayList.get(0), newArrayList.get(1));
    	}
    	else if(shapeType.equals("Polygon")) {
    		newShape = new Polygon(point, newArrayList.get(0), newArrayList.get(1));
    	}
    	else {
    		newShape = null;
    	}
    	
    	return newShape;
    }
}
