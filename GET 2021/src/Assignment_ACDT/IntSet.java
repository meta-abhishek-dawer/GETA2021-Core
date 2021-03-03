package Assignment_ACDT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class IntSet {
	static Scanner scanner = new Scanner(System.in);
	private int setSize; //size of set
	private int[] arrSet;  // array for set values
	
	private IntSet(){
		int inputSize = scanner.nextInt();
		int[] arr = new int[inputSize]; 
		for(int i=0; i< inputSize; i++){
			arr[i] = scanner.nextInt();
		}
		int k=0;
		Arrays.sort(arr);
		arrSet = new int[inputSize];
		for(int j= 0; j< inputSize - 1; j++){
			if(arr[j]!= arr[j + 1])
				arrSet[k++] = arr[j];
		}
		arrSet[k++] = arr[inputSize - 1];
		setSize= k;
	}
	
	// to check value is present or not in set
	public boolean isMember(int value){
		for(int i= 0; i< setSize; i++){
			if(value== arrSet[i])
				return true;
		}
		return false;
	}
	
	// function to check size of set array
	public int size(){
		return arrSet.length;
	}
	
	//to check subset array of other
	public static boolean isSubSet(IntSet set1, IntSet set2){
		int i=0, j=0;
		for( i=0; i< set2.arrSet.length; i++){
			for(j=0; j< set1.arrSet.length; j++){
				if(set2.arrSet[i]== set1.arrSet[j])
					break;
			}
		if(j== set1.arrSet.length)
			return false;
		}
		return true;
	}
	
	//function for union of two set
	public static void unionOfSets(IntSet set1, IntSet set2){
		HashSet<Integer> newHashSet = new HashSet<>();
		for(int i=0; i< set1.arrSet.length; i++)
			newHashSet.add(set1.arrSet[i]);
		  
		for(int j= 0; j<set2.arrSet.length; j++)
			newHashSet.add(set2.arrSet[j]);
		  
		System.out.println(newHashSet);
	}
	
	//function for intersection of two set
	public static void intersectionSets(IntSet set1, IntSet set2){
		int size1= set1.arrSet.length;
		int size2 = set2.arrSet.length;
		int i=0, j=0;
		while(i< size1 && j< size2){
			if(set1.arrSet[i]> set2.arrSet[j])
				j++;
			else if(set2.arrSet[j]>set1.arrSet[i])
				i++;
			else{
				System.out.print(set1.arrSet[i]+" ");
				i++;
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		IntSet obj1 = new IntSet();
		int isValueMember = scanner.nextInt();
		boolean memberResult= obj1.isMember(isValueMember);
		System.out.println(memberResult);
		int setLength= obj1.size();
		System.out.println(setLength);

		IntSet obj2 = new IntSet();
		boolean subsetResult = isSubSet(obj1,obj2);
		System.out.println(subsetResult);
		unionOfSets(obj1,obj2);
		intersectionSets(obj1,obj2);
	}
}
