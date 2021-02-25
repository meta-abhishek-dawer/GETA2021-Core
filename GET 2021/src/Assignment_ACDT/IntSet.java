package Assignment_ACDT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class IntSet {
		
	static Scanner scanner = new Scanner(System.in);
	private int setSize; //size of set
	private int[] arrSet;  // array for set values
	
	private IntSet()
	{
		int inputSize = scanner.nextInt();
		int[] arr = new int[inputSize];
		 
		for(int i=0;i<inputSize;i++)
		{
			arr[i] = scanner.nextInt();
		}
		int k=0;
		
		Arrays.sort(arr);
		arrSet = new int[inputSize];
		
		for(int j=0;j<inputSize-1;j++)
		{
			if(arr[j]!= arr[j+1])
			  arrSet[k++] = arr[j];
		}
		
		arrSet[k++] = arr[inputSize-1];
		setSize= k;
	}
	
	// to check value is present or not in set
	public boolean isMember(int value)
	{
		for(int i=0;i<setSize;i++)
		{
			if(value== arrSet[i])
				return true;
		}
		return false;
	}
	
	// function to check size of set array
	public int size()
	{
		return arrSet.length;
	}
	
	//to check subset array of other
	public static boolean isSubSet(IntSet set1, IntSet set2)
	{
		int i=0,j=0;
		for( i=0;i<set2.arrSet.length;i++)
		{
			for(j=0;j<set1.arrSet.length;j++)
			{
				if(set2.arrSet[i]== set1.arrSet[j])
					break;
			}
			if(j== set1.arrSet.length)
				return false;
		}
		return true;
	}
	
	//function for union of two set
	public static void unionOfSets(IntSet s1,IntSet s2)
	{
		HashSet<Integer> hs = new HashSet<>();
		  for(int i=0;i<s1.arrSet.length;i++)
			  hs.add(s1.arrSet[i]);
		  
		  for(int j=0;j<s2.arrSet.length;j++)
			  hs.add(s2.arrSet[j]);
		  
		  System.out.println(hs);
	}
	
	//function for intersection of two set
	public static void intersectionSets(IntSet s1, IntSet s2)
	{
		int size1= s1.arrSet.length;
		int size2 = s2.arrSet.length;
		
		int i=0,j=0;
		while(i<size1 && j<size2)
		{
			if(s1.arrSet[i]>s2.arrSet[j])
				j++;
			else if(s2.arrSet[j]>s1.arrSet[i])
				i++;
			else
			{
				System.out.print(s1.arrSet[i]+" ");
				i++;
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
			IntSet obj1 = new IntSet();
			
			//function calling to check member
			int isValueMember = scanner.nextInt();
			boolean memberResult= obj1.isMember(isValueMember);
			System.out.println(memberResult);
			//function calling to check size
			int setLength= obj1.size();
			System.out.println(setLength);

			// function calling to check subset
			IntSet obj2 = new IntSet();
			boolean subsetResult = isSubSet(obj1,obj2);
			System.out.println(subsetResult);
			
			//union
			unionOfSets(obj1,obj2);
			
			//intersection
			intersectionSets(obj1,obj2);
	}

}
