package Assignment_ACDT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
public class IntSet {
	
	static Scanner scanner = new Scanner(System.in);
	private int[] arrSet; 
	
	// to check value is present or not in set
	public boolean isMember(int value){
		for(int i= 0; i< this.arrSet.length; i++){
			if(value== this.arrSet[i])
				return true;
		}
		return false;
	}
	
	// function to check size of set array
	public int size(){
		return this.arrSet.length;
	}
	
	//to check subset array of other
	public boolean isSubSet(IntSet s){
		int i=0, j=0;
		for( i=0; i< s.arrSet.length; i++){
			for(j=0; j< this.arrSet.length; j++){
				if(s.arrSet[i]== this.arrSet[j])
					break;
			}
		if(j== this.arrSet.length)
			return false;
		}
		return true;
	}
	
	//function for union of two set
	public IntSet unionOfSets(IntSet s1, IntSet s2){
		HashSet<Integer> newHashSet = new HashSet<>();
		for(int i=0; i< s1.arrSet.length; i++)
			newHashSet.add(s1.arrSet[i]);
		  
		for(int j= 0; j<s2.arrSet.length; j++)
			newHashSet.add(s2.arrSet[j]);
		
		IntSet unionResult = new IntSet();
		unionResult.arrSet = new int[newHashSet.size()];
		int length=0;
		Iterator<Integer> i1 = newHashSet.iterator();
		while(i1.hasNext()) {
			unionResult.arrSet[length] = i1.next();
			length++;
		}
		return unionResult;
	}
	
	public IntSet getComplement() {
		int k=0;
		IntSet result = new IntSet();
		HashSet<Integer> newHashSet = new HashSet<Integer>();
		for(int i=1; i<= 1000;i++) {
			int flag=0;
			for(int j= 0; j< this.arrSet.length; j++) {
				if(this.arrSet[j]== i) {
					flag=1;
					break;
				}
			}
			if(flag== 0) {
				newHashSet.add(i);
			}
		}
		result.arrSet = new int[newHashSet.size()];
		int length=0;
		Iterator<Integer> i1 = newHashSet.iterator();
		while(i1.hasNext()) {
			result.arrSet[length] = i1.next();
			length++;
		}
		return result;
	}
	
	public void inputSet() {
		System.out.println("enter the number of set values you want to add");
		int inputSize = scanner.nextInt();
		System.out.println("please enter the set value in range 1 - 1000");
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
	}
	
	public static void main(String[] args) {
		IntSet newIntSet = new IntSet();
		newIntSet.inputSet();
		int isValueMember = scanner.nextInt();
		boolean memberResult= newIntSet.isMember(isValueMember);
		System.out.println(memberResult);
		int setLength= newIntSet.size();
		System.out.println(setLength);

		IntSet newIntSet2 = new IntSet();
		System.out.println("Enter the input of subset");
		newIntSet2.inputSet();
		boolean subsetResult = newIntSet.isSubSet(newIntSet2);
		System.out.println("Enter set is subset:- "+subsetResult);
		
		System.out.println("Union of two sets");
		IntSet unionSet= newIntSet.unionOfSets(newIntSet, newIntSet2);
		for(int i=0; i< unionSet.arrSet.length; i++)
			System.out.print(unionSet.arrSet[i]+" ");
		System.out.println();
		
		System.out.println("Complement of a set is:- ");
		IntSet complementSet= newIntSet.getComplement();
		for(int i=0; i< complementSet.arrSet.length; i++)
			System.out.print(complementSet.arrSet[i]+" ");
	}
}
