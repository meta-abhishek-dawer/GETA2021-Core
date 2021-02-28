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
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfElements = scanner.nextInt();
		int[] arr = new int[numberOfElements];
		
		for(int i=0;i<numberOfElements;i++){
			arr[i]= scanner.nextInt();
		}
		ArrOperation newArrOperation = new ArrOperation();
		int maxResult= newArrOperation.findLargestMirror(arr);
		System.out.println("Maximum mirror section is:- "+ maxResult);

	}

}
