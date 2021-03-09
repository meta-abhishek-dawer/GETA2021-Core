package GraphicsLibrary;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * class in which we create different objects and different methods
 * @author abhishek.dawer_metac
 *
 */
public class ShapesMain {
	ArrayList<Double> newArrayList = new ArrayList<Double>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter the screen size");
		double xAxis = scanner.nextDouble();
		double yAxis = scanner.nextDouble();
		Screen screen= new Screen(xAxis, yAxis);
		
		Point point = new Point(0, 0);
		ShapeFactory newShapeFactory = new ShapeFactory();
		ShapesMain newShapesMain1 = new ShapesMain();
		newShapesMain1.newArrayList.add(2.0);
		newShapesMain1.newArrayList.add(3.5);
		
		Shape shape1 = newShapeFactory.createShape("Square", point, newShapesMain1.newArrayList);
		screen.addShape(shape1);
		
		Point point2 = new Point(2, 1);
		ShapesMain newShapesMain2 = new ShapesMain();
		newShapesMain2.newArrayList.add(1.4);
		newShapesMain2.newArrayList.add(1.4);
		Shape shape2 = newShapeFactory.createShape("Circle", point2, newShapesMain2.newArrayList);
		screen.addShape(shape2);
		
		//screen.showAllAddedShapes();
		
		Point point3 = new Point(2, 1);
		ShapesMain newShapesMain3= new ShapesMain();
		newShapesMain3.newArrayList.add(1.5);
		newShapesMain3.newArrayList.add(1.4);
		Shape shape3 = newShapeFactory.createShape("Rectangle", point3, newShapesMain3.newArrayList);
		screen.addShape(shape3);
		
		ArrayList<Shape> shapesArea = screen.sortingByArea();
		System.out.println("List sorted by area");
		for(Shape list : shapesArea)
			System.out.println(list.getShapeType() + " "+ list.getArea());
		
		System.out.println();
		screen.deleteSpecificShape("Rectangle");
		screen.showAllAddedShapes();
		
	}

}
