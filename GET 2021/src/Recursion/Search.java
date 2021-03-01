package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Search {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter number of element you want to add in array. ");
		int numberOfElements = scanner.nextInt();
		int[] arr = new int[numberOfElements];
		System.out.println("enter array elements:- ");
		
		for(int i=0;i<numberOfElements;i++){
			arr[i] = scanner.nextInt();
		}
		System.out.println("enter the element you want to search.");
		int elementForSearch = scanner.nextInt();
		
		Search newSearch = new Search();
		int start=0, end= arr.length-1;
		System.out.println("Linear Search");
		int linearSearchresult = newSearch.linearSearch(arr,start, end, elementForSearch);
		if(linearSearchresult== -1)
			System.out.println("Element not found in array");
		else 
			System.out.println("element found at index "+linearSearchresult+" in aray.");
		
		System.out.println("Binary Search");
		Arrays.sort(arr);
		int binarySearchResult = newSearch.binarySearch(arr, start, end, elementForSearch);
		if(binarySearchResult== -1)
			System.out.println("Element not found in array");
		else 
			System.out.println("element found at index "+binarySearchResult+" in aray.");
	}
	/**
	 * Find element in array using linear search
	 * @param arr contain values in which we find
	 * @param start starting position in array
	 * @param end ending position in array
	 * @param searchElement value which we search in array
	 * @return index if value present else -1 
	 */
	public int linearSearch(int[] arr, int start, int end, int searchElement){
		if(end<start)
			return -1;
		if(arr[start]== searchElement)
			return start;
		if(arr[end]== searchElement)
			return end;
		return linearSearch(arr,start+1, end-1, searchElement);
	}
	/**
	 * find element in array using Binary search
	 * @param arr contain values in which we find
	 * @param start starting position in array
	 * @param end ending position in array
	 * @param searchElement value which we search in array
	 * @return index if value present else -1
	 */
	public int binarySearch(int[] arr, int start, int end, int searchElement){
		if(start<=end && start<arr.length-1){
			int middle = start + (end-start)/2;
			if(arr[middle]==searchElement)
				return middle;
			if(arr[middle]> searchElement)
				return binarySearch(arr, start, middle-1, searchElement);
			return binarySearch(arr, middle+1, end, searchElement);
		}
		return -1;
	}

}
