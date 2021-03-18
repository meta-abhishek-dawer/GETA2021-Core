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
		
		System.out.println("Please enter points for shape1");
		int value1 = scanner.nextInt();
		int value2 = scanner.nextInt();
		Point point = new Point(value1, value2);
		ShapeFactory newShapeFactory = new ShapeFactory();
		ShapesMain newShapesMain1 = new ShapesMain();
		
		System.out.println("Please enter side of square..");
		double side=  scanner.nextDouble();
		newShapesMain1.newArrayList.add(side);
		
		Shape shape1 = newShapeFactory.createShape("Square", point, newShapesMain1.newArrayList);
		screen.addShape(shape1);
		
		System.out.println("enter points of shape2..");
		int value3 = scanner.nextInt();
		int value4 = scanner.nextInt();
		Point point2 = new Point(value3, value4);
		ShapesMain newShapesMain2 = new ShapesMain();
		
		System.out.println("Enter value of two sides");
		double length = scanner.nextDouble();
		double breadth = scanner.nextDouble();
		newShapesMain2.newArrayList.add(length);
		newShapesMain2.newArrayList.add(breadth);
		Shape shape2 = newShapeFactory.createShape("Circle", point2, newShapesMain2.newArrayList);
		screen.addShape(shape2);
		
		screen.showAllAddedShapes();
		
		Point point3 = new Point(value3, value4);
		ShapesMain newShapesMain3= new ShapesMain();
		newShapesMain3.newArrayList.add(length);
		newShapesMain3.newArrayList.add(breadth);
		Shape shape3 = newShapeFactory.createShape("Rectangle", point3, newShapesMain3.newArrayList);
		screen.addShape(shape3);
		
		ArrayList<Shape> shapesArea = screen.sortingByArea();
		System.out.println("List sorted by area");
		for(Shape list : shapesArea)
			System.out.println(list.getType() + " "+ list.getArea());
		
		System.out.println();
		screen.deleteSpecificShape("Rectangle");
		screen.showAllAddedShapes();
		
	}

}
