package JUnit;

import java.util.Scanner;

public class ArrOperation {
	/**
	 * Find largest Mirror Section in array
	 * @param arr contain values in which we find mirror section
	 * @return maxResult as size of largest mirror section in array
	 */
	public int findLargestMirror(int[] arr){
		int maxResult=0;
		try{
			if(arr.length==0) // if no element is present in array then throw error
				throw new AssertionError();
			
			for(int i=0;i<arr.length;i++){
				int countMirrors=0;
				for(int j= arr.length-1;(j>=0 && i+countMirrors<arr.length); j-- ){
					if(arr[i+countMirrors]== arr[j])
						countMirrors++;
					else {
						maxResult= Math.max(maxResult, countMirrors);
						countMirrors =0;
					}
				}
				maxResult = Math.max(maxResult,countMirrors);
			}
		}
		catch(AssertionError e){
			System.out.println("Array length cannot be zero!");
		}
		return maxResult;
	}
	/**
	 * Find number of Clumps in array
	 * @param arr contain values in which we find series of 2 or more adjacant elements
	 * @return numberOfClumps present in array
	 */
	public int findNumberClumps(int[] arr){
		int numberOfClumps =0;
		try{
			if(arr.length==0)
				throw new AssertionError();
			for(int i=0;i<arr.length-1;i++){
				int flag =0;
				while(i<arr.length-1 && arr[i]== arr[i+1]){
					flag=1;
					i++;
				}
				if(flag==1)
					numberOfClumps++;
			}
		}
		catch(AssertionError e){
			System.out.println("array length cannot be zero!");
		}
		return numberOfClumps;
	}
	/**
	 * Find index where left sum of array is equal to right sum of array
	 * @param arr contain values where we find index
	 * @return index of splitArray
	 */
	public int findIndexSplitArray(int[] arr){
		int leftSum =0;
		for(int i=0;i<arr.length;i++){
			leftSum += arr[i];
			
			int rightSum =0;
			for(int j= i+1;j<arr.length;j++)
				rightSum += arr[j];
			
			if(leftSum==rightSum)
				return i+1;
		}
		return -1;
	}
	/**
	 * Solve fixXY problem in array
	 * @param arr contain values which we have to rearrange
	 * @param x is value which do not move
	 * @param y is value which we place after x
	 * @return arr array after arranging x and y
	 */
	public int[] fixXY(int[] arr, int x, int y){
		try{
			if(arr.length==0)
				throw new AssertionError();
			else if(arr[arr.length-1]==x)
				throw new AssertionError();
			else{
				for(int i=0;i<arr.length-1;i++){
					if(arr[i]==x && arr[i+1]==x)
						throw new AssertionError();
				}
				int numberOfX=0, numberOfY=0;
				for(int i=0;i<arr.length;i++){
					if(arr[i]==x)
						numberOfX++;
					else if(arr[i]==y)
						numberOfY++;
				}
				if(numberOfX!= numberOfY)
					throw new AssertionError();
				
				for(int i=0;i<arr.length;i++){
					if(arr[i]==y){
						for(int j=1;j<arr.length;j++){
							if(arr[j]==x && arr[j+1]!=y && j!=arr.length-1){
								int temp = arr[i];
								arr[i] = arr[j+1];
								arr[j+1] = temp;
							}
						}
					}
				}
			}
		}
		catch(AssertionError e){
			System.out.println("Invalid Input!!");
		}
		return arr;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//method and inputs to find max mirror in java
		System.out.println("enter array size and elements of array for finding max mirror.");
		int numberOfElements = scanner.nextInt();
		int[] arr = new int[numberOfElements];
		
		for(int i=0;i<numberOfElements;i++){
			arr[i]= scanner.nextInt();
		}
		ArrOperation newArrOperation = new ArrOperation();
		int maxResult= newArrOperation.findLargestMirror(arr);
		System.out.println("Maximum mirror section is:- "+ maxResult);
		
		//method to find number of clumps in array
		System.out.println("enter array size and elements to find max clumps in array.");
		int numberOfElements2=  scanner.nextInt();
		int[] arr2 = new int[numberOfElements2];
		for(int i=0;i<numberOfElements2;i++)
			arr2[i] = scanner.nextInt();
		
		ArrOperation newArrOperation2 = new ArrOperation();
		int countClumpsResult = newArrOperation2.findNumberClumps(arr2);
		System.out.println("Number of clumps in array is:- "+ countClumpsResult);
		
		//method to find index where sum of left split is equal to right split
		System.out.println("enter array size and elements to find index in array");
		int numberOfElements3 = scanner.nextInt();
		int[] arr3= new int[numberOfElements3];
		for(int i=0;i<numberOfElements3;i++)
			arr3[i]= scanner.nextInt();
		
		ArrOperation newArrOperation3 = new ArrOperation();
		int indexResult = newArrOperation3.findIndexSplitArray(arr);
		System.out.println("index where left split sum = right split sum:- "+ indexResult);
		
		//method to solve fixXY problem
		System.out.println("enter array size and elements to find index in array:- ");
		int numberOfElements4 = scanner.nextInt();
		int[] arr4 = new int[numberOfElements4];
		for(int i=0;i<numberOfElements4;i++)
			arr4[i] = scanner.nextInt();
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		ArrOperation newArrOperation4 = new ArrOperation();
		int[] resultArr = newArrOperation4.fixXY(arr4, x, y);
		System.out.println("after fixing array:- ");
		
		for(int i=0;i<resultArr.length;i++)
			System.out.print(resultArr[i]+" ");

	}

}
