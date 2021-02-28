package JUnit;

import java.util.Scanner;

public class ArrOperation {
	public int findLargestMirror(int[] arr){
		int maxResult=0;
		try{
			if(arr.length==0)
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

	}

}
