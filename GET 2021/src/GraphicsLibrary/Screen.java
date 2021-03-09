package GraphicsLibrary;

import java.util.ArrayList;

public class Screen {
    double xAxisLength, yAxisLength;
    static ArrayList<Shape> shapesList = new ArrayList<Shape>();
    
    public Screen(double xAxis, double yAxis) {
    	this.xAxisLength = xAxis;
    	this.yAxisLength = yAxis;
    }
    
    public String addShape(Shape shape) {
    	shapesList.add(shape);
    	return "Shape added";
    }
    
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
    
    public void showAllAddedShapes() {
    	System.out.println("List of added shapes..");
    	for(Shape newShape : shapesList)
    		System.out.println(newShape.getShapeType());
    }
}
