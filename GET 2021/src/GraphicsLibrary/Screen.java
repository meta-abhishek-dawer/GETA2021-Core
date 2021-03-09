package GraphicsLibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Screen class
 * @author abhishek.dawer_metac
 *
 */
public class Screen {
    double xAxisLength, yAxisLength;
    static ArrayList<Shape> shapesList = new ArrayList<Shape>();
    
    /**
     * Constructor for setting up the maximum screen coordinates
     * @param xAxis containing maximum values of xAxis coordinate
     * @param yAxis containing maximum value of yAxis coordinate
     */
    public Screen(double xAxis, double yAxis) {
    	this.xAxisLength = xAxis;
    	this.yAxisLength = yAxis;
    }
    /**
     * Method to add shape in screen
     * @param shape containing type of shape
     * @return shape added
     */
    public String addShape(Shape shape) {
    	shapesList.add(shape);
    	return "Shape added";
    }
    
    /**
     * Method to delete all the specific shape from screen
     * @param type
     * @return
     */
    public String deleteSpecificShape(String type) {
    	if(type.equals(""))
    		return "Empty value";
    	else {
    		ArrayList<Shape> specificShapesList = new ArrayList<>();
    		for(Shape shape: shapesList) {
    			if(shape.getShapeType().equals(type))
    				specificShapesList.add(shape);
    		}
    		shapesList.removeAll(specificShapesList);
    		return "Shapes Deleted!!";
    	}
    }
    
    /**
     * Method to get all the added shapes
     */
    public void showAllAddedShapes() {
    	System.out.println("List of added shapes..");
    	for(Shape newShape : shapesList)
    		System.out.println(newShape.getShapeType());
    }
    
    /**
     * Method to get shape enclosed points
     * @param point containing point
     * @return list of shapes at particular points
     */
    public List<Shape> shapeEnclosedPoints(Point point) {
    	ArrayList<Shape> listOfShapes = new ArrayList<>();
    	for(Shape shape: shapesList) {
    		if(shape.isPointEnclosed(point)== true)
    			listOfShapes.add(shape);
    	}
    	return listOfShapes;
    }
    
    /**
     * Method to sort shape by area
     * @return list of sorted shapes
     */
    public ArrayList<Shape> sortingByArea() {
    	ArrayList<Shape> resultAfterSortedByArea = new ArrayList<Shape>(shapesList);
    	Collections.sort(resultAfterSortedByArea, sortShapesByArea);
    	return resultAfterSortedByArea;
    }
    
    /**
     * Comparator to sort shapes by area
     */
    public static Comparator<Shape> sortShapesByArea = new Comparator<Shape>() {
    	public int compare(Shape newShape1, Shape newShape2) {
    		if(newShape1.getArea() > newShape2.getArea())
    			return 1;
    		else
    			return -1;
    	}
    };
    
    /**
     * Method to sort shapes by Timestamp
     * @return list of sorted shapes
     */
    public List<Shape> sortingByTimeStamp() {
    	ArrayList<Shape> resultAfterSortedByTimestamp = new ArrayList<Shape>(shapesList);
    	Collections.sort(resultAfterSortedByTimestamp, sortShapesByTimestamp);
    	return resultAfterSortedByTimestamp;
    }
    
    /**
     * Comparator to ort shapes by Timestamp
     */
    public static Comparator<Shape> sortShapesByTimestamp = new Comparator<Shape>() {
    	public int compare(Shape newShape1, Shape newShape2) {
    		return (newShape1.getTimestamp().compareTo(newShape2.getTimestamp()));
    	}
    };
    
    /**
     * Method to sort shapes by Perimeter
     * @return list of sorted shapes
     */
    public List<Shape> sortinByPerimeter() {
    	ArrayList<Shape> resultAfterSortedByPerimeter = new ArrayList<Shape>(shapesList);
    	Collections.sort(resultAfterSortedByPerimeter, sortShapesByPerimeter);
    	return resultAfterSortedByPerimeter;
    }
    
    /**
     * Comparator to sort shapes by Perimeter
     */
    public static Comparator<Shape> sortShapesByPerimeter = new Comparator<Shape>() {
    	public int compare(Shape newShape1, Shape newShape2) {
    		if(newShape1.getPerimeter() > newShape2.getPerimeter())
    			return 1;
    		else
    			return -1;
    	}
    };
    
}
