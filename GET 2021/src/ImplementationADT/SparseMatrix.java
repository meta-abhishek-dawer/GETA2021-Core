package ImplementationADT;

import java.util.Scanner;

public class SparseMatrix {
    static Scanner scanner;
    int maxElement = 0;
    int row, column, length;
    int[][] sparseArr; 
    
    public SparseMatrix(int row1, int column1) {
        row = row1;
        column = column1;
        length = 0;
    }
    public void setSparseLength(int size) {
    	maxElement = size;
    	sparseArr = new int[maxElement][3];
    }
    public void insertInSparse(int row1, int column1, int value) {
    	sparseArr[length][0] = row1;
    	sparseArr[length][1] = column1;
    	sparseArr[length][2] = value;
    	length++;
    }
    
    public int[][] transposeArray() {
        SparseMatrix resultTranspose = new SparseMatrix(this.row, this.column);
        resultTranspose.setSparseLength(this.sparseArr.length);
        for(int i= 0; i< this.sparseArr.length; i++) {
            resultTranspose.sparseArr[i][0] = this.sparseArr[i][1];
            resultTranspose.sparseArr[i][1] = this.sparseArr[i][0];
            resultTranspose.sparseArr[i][2] = this.sparseArr[i][2];
        }
   
        resultTranspose.showSparseArray();
        return resultTranspose.sparseArr;
    }
    
    public void matrixAddition(SparseMatrix newSparseMatrix2) {
    	if(this.row != newSparseMatrix2.row || this.column!= newSparseMatrix2.column)
    		System.out.println("Addition not possible");
    	else {
    	    int position1= 0, position2= 0;
    	    SparseMatrix addResult = new SparseMatrix(this.row, this.column);
    	    addResult.setSparseLength(this.sparseArr.length + newSparseMatrix2.sparseArr.length);
    	    while(position1< this.length && position2< newSparseMatrix2.length) {
    	        if(this.sparseArr[position1][0]> newSparseMatrix2.sparseArr[position2][0] || (this.sparseArr[position1][0]== newSparseMatrix2.sparseArr[position2][0] && 
    	            this.sparseArr[position1][1]> newSparseMatrix2.sparseArr[position2][1])) {
    	        	    addResult.insertInSparse(newSparseMatrix2.sparseArr[position2][0], newSparseMatrix2.sparseArr[position2][1],newSparseMatrix2.sparseArr[position2][2]);
    	        	    position2++;
    	        }
    	        else if(this.sparseArr[position1][0]< newSparseMatrix2.sparseArr[position2][0] || (this.sparseArr[position1][0]== newSparseMatrix2.sparseArr[position2][0] && 
        	        this.sparseArr[position1][1]< newSparseMatrix2.sparseArr[position2][1])) {
    	        	    addResult.insertInSparse(this.sparseArr[position1][0], this.sparseArr[position1][1], this.sparseArr[position1][2]);
    	        	    position1++;
    	        }
    	        else {
    	            addResult.insertInSparse(this.sparseArr[position1][0], this.sparseArr[position1][1], (this.sparseArr[position1][2] + newSparseMatrix2.sparseArr[position2][2]));
    	            position1++;
    	            position2++;
    	        }
    	    }
    	    while(position1< length) {
    	    	addResult.insertInSparse(this.sparseArr[position1][0], this.sparseArr[position1][1], this.sparseArr[position1][2]);
    	    	position1++;
    	    }
    	    while(position2< newSparseMatrix2.length) {
    	    	addResult.insertInSparse(newSparseMatrix2.sparseArr[position2][0], newSparseMatrix2.sparseArr[position2][1], newSparseMatrix2.sparseArr[position2][2]);
    	    	position2++;
    	    }
    	    addResult.showSparseArray();
    	}
    }
    
    public void matrixMultiplication(SparseMatrix newSparseMatrix2) {
    	
    }
    public boolean isSymmetric(int[][] transpose) {
        for(int i=0; i< this.sparseArr.length; i++) {
        	if(transpose[i][0]!=this.sparseArr[i][0] || transpose[i][1]!= this.sparseArr[i][1] || transpose[i][2]!= this.sparseArr[i][2])
        	    return false;
        }
        return true;
    }
    
    public int[][] getInputArray(int row, int column) {
    	int[][] arr = new int[row][column];
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < column; j++) {
    			arr[i][j] = scanner.nextInt();
    		}
    	}
    	return arr;
    }
    public int checkNonZeroElement(int[][] arr) {
        int count =0;
        for(int i = 0; i < this.row ; i++) {
        	for(int j = 0; j < this.column; j++) {
        		if(arr[i][j]!=0) {
        		    count++;
        		}
        	}
        }
        return count;
    }
    public void showSparseArray() {
    	System.out.println("values in sparse array");
    	for(int i= 0; i< sparseArr.length; i++) {
    	    System.out.print(this.sparseArr[i][0] + " " + this.sparseArr[i][1] + " " + this.sparseArr[i][2]);
    	    System.out.println();
    	}
    }
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        SparseMatrix newSparseMatrix1 = new SparseMatrix(row, column);
        int[][] arr1 = newSparseMatrix1.getInputArray(row, column);
        int count = newSparseMatrix1.checkNonZeroElement(arr1);
        newSparseMatrix1.setSparseLength(count);
        for(int i= 0; i< row; i++) {
            for(int j= 0; j< column; j++) {
                if(arr1[i][j]!= 0)
            	    newSparseMatrix1.insertInSparse(i, j, arr1[i][j]);
            }
        }
        newSparseMatrix1.showSparseArray();
        System.out.println("Transpose of a matrix:- ");
        int[][] transposeResult= newSparseMatrix1.transposeArray();
        boolean symmetricResult = newSparseMatrix1.isSymmetric(transposeResult);
        System.out.println("is sparse matrix symmetric:- "+ symmetricResult);
        
        SparseMatrix newSparseMatrix2 = new SparseMatrix(row, column);
        int[][] arr2 = newSparseMatrix2.getInputArray(row, column);
        int count2 = newSparseMatrix1.checkNonZeroElement(arr2);
        newSparseMatrix2.setSparseLength(count2);
        for(int i= 0; i< row; i++) {
            for(int j= 0; j< column; j++) {
                if(arr2[i][j]!= 0)
            	    newSparseMatrix2.insertInSparse(i, j, arr2[i][j]);
            }
        }
        System.out.println("Addition of two matrix:- ");
        newSparseMatrix1.matrixAddition(newSparseMatrix2);
        
        System.out.println("Multiplication of matrix is:- ");
        newSparseMatrix1.matrixAddition(newSparseMatrix2);
    }

}
