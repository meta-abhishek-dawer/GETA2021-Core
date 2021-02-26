package SoftwareSpecification;

import java.util.Scanner;

public class Area {
	
	/**
	 * Find the Area of Triangle
	 * @param width value contain base of triangle
	 * @param height value containing height of triangle
	 * @return areaResult by calculating area using formula 1/2 * base * height
	 */
	public double findTriangleArea(double width,double height)
	{
		double areaResult= 0.5 * width * height ;
		
		return areaResult;
	}
	
	/**
	 * Find the Area of Rectangle
	 * @param width value contain breadth of rectangle
	 * @param height value contain length of rectangle
	 * @return areaResult by calculating area using formula length * breadth
	 */
	public double findRectangleArea(double width, double height)
	{
		double areaResult = width*height;
		
		return areaResult;
	}
	
	/**
	 * Find the Area of Square
	 * @param width value contain side of square
	 * @return areaResult by calculating area using formula 4 * side
	 */
	public double findSquareArea(double width)
	{
		double areaResult= 4* width;
		return areaResult;
	}
	
	/**
	 * Find the area of Circle
	 * @param radius value contain radius of circle
	 * @return areaResult by  calculating area using formula pi * r * r
	 */
	public double findCircleArea(double radius)
	{
		double areaResult = 3.14 * radius * radius;
		return areaResult;
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			double width = scanner.nextDouble();
			double height = scanner.nextDouble();
			double radius = scanner.nextDouble();
			
			try{
			if(width>=0 || height>=0 || radius>=0)
				throw new ArithmeticException();
			
			Area obj = new Area();
			double triangleArea = obj.findTriangleArea(width,height);
			 System.out.println("Area of triangle is:- "+ triangleArea);
			 
			 double rectangleArea = obj.findRectangleArea(width,height);
			  System.out.println("Area of rectangle is:- "+rectangleArea);
			  
			 double squareArea = obj.findSquareArea(width);
			  System.out.println("Area of square is:- "+ squareArea);
			  
			 double circleArea = obj.findCircleArea(radius);
			  System.out.println("Area of circle is:- "+ circleArea);
			   }
			
			catch(ArithmeticException e){
			System.out.println("Input values cannot be zero or negative!!");}
	}

}
