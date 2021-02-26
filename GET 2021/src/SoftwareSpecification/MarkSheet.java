package SoftwareSpecification;

import java.util.Scanner;

public class MarkSheet {

		/**
		 * Find average grade of all student
		 * @param arr contain values of n number of students
		 * @return average by calculating sum of all student divide by no. of student
		 */
		public double calculateAverage(int[] arr)
		{
			double average=0;
			
				int sum=0;
				for(int i=0;i<arr.length;i++)
					sum += arr[i];
				
				average = (double)sum/ arr.length;
			
			return average;
		}
		
		/**
		 * Find Maximum grade from all students grades
		 * @param arr contain grade value of all students
		 * @return maxResult which contain maximum grade
		 */
		public int findMaxGrade(int[] arr)
		{
			int maxResult=arr[0];
			
			for(int i=0;i<arr.length;i++)
			{
				if(maxResult<arr[i])
					maxResult = arr[i];
			}
			return maxResult;
		}
		
		/**
		 * Find minimum grade from all students grades
		 * @param arr contain grade values of all students
		 * @return minResult which contain maximum grade
		 */
		public int findMinGrade(int[] arr)
		{
			int minResult =arr[0]; // initialize with 1st element and compare with others
			
			for(int i=0;i<arr.length;i++)
			{
				if(minResult>arr[i])
				{
					minResult = arr[i];
				}
			}
			return minResult;
		}
		
		/**
		 * Find pass percentage of the class
		 * @param arr contain grade values of all students
		 * @return percentageResult by calculating pass percentage
		 */
		public double findPassPercentage(int[] arr)
		{
			double percentageResult =0;
			int count=0;
			
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]>=40)
					count++;
			}
			percentageResult = (double) count/arr.length*100;
			
			return percentageResult;
		}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numberOfStudents = scanner.nextInt();
		int[] studentGrades = new int[numberOfStudents];
		for(int i=0;i<numberOfStudents;i++)
			studentGrades[i] = scanner.nextInt();
		
		try{
			if(numberOfStudents==0)
				throw new ArithmeticException();
			
		MarkSheet obj1 = new MarkSheet();
			double averageResult = obj1.calculateAverage(studentGrades);
			System.out.println("Average grade in a class is:- "+averageResult);
			
			int maxResult = obj1.findMaxGrade(studentGrades);
			System.out.println("Maximum grade in a class is:- "+maxResult);
			
			int minResult = obj1.findMinGrade(studentGrades);
			System.out.println("Minimum grade in a class is:- "+minResult);
			
			double passPercentage = obj1.findPassPercentage(studentGrades);
			System.out.println("pass percentage of a class is:- "+ passPercentage);
		}
		
		catch(ArithmeticException e)
		{System.out.println("number of students cannot be zero");}
	}
}
