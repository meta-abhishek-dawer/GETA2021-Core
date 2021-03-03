package ImplementationADT;

import java.util.Scanner;

public class SparseMatrix {
    static Scanner scanner;
    int maxElement = 0;
    int row, column, length;
    int[][] sparseArr = new int[maxElement][3];
    public SparseMatrix(int row1, int column1) {
        row = row1;
        column = column1;
        length = 0;
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
    	for(int i= 0; i< this.row; i++) {
    	    System.out.print(this.sparseArr[i][0] + " " + this.sparseArr[i][1] + " " + this.sparseArr[i][2]);
    	    System.out.println();
    	}
    }
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        SparseMatrix newSparseMatrix1 = new SparseMatrix(row, column);
        int[][] arr = newSparseMatrix1.getInputArray(row, column);
        int count = newSparseMatrix1.checkNonZeroElement(arr);
        newSparseMatrix1.maxElement = count;
        newSparseMatrix1.showSparseArray();
    }

}
