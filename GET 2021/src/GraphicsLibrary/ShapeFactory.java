package GraphicsLibrary;

import java.util.ArrayList;

/**
 * Factory class to create different methods
 * @author abhishek.dawer_metac
 *
 */
public class ShapeFactory {
    Shape newShape;
    /**
     * Method to create objects of different shapes
     * @param shapeType containing the type of shape
     * @param point containing coordinate of shapes
     * @param newArrayList containing the values of particular shape 
     * @return object of particular created shape
     * If shape name is not correct then it throw null pointer exception
     */
    public Shape createShape(String shapeType, Point point, ArrayList<Double> newArrayList) {
    	try {
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
        		throw new NullPointerException();
        	}
    	}
    	catch(NullPointerException e) {
    		System.out.println("Invalid Input!!");
    	}
    	
    	return newShape;
    }
}
