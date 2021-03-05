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
    /**
     * method to set size of sparse array
     * @param size of non zero element in array
     */
    public void setSparseLength(int size) {
    	maxElement = size;
    	sparseArr = new int[maxElement][3];
    }
    /**
     * Method to insert value in sparse matrix
     * @param row1 contain position of row where non zero element is placed
     * @param column1 contain position of column where non zero element is placed
     * @param value contain non zero value
     */
    public void insertInSparse(int row1, int column1, int value) {
    	sparseArr[length][0] = row1;
    	sparseArr[length][1] = column1;
    	sparseArr[length][2] = value;
    	length++;
    }
    /**
     * Method to find transpose of sparse matrix
     * @return object of transposed sparse matrix
     */
    public SparseMatrix transposeMatrix() {
        SparseMatrix resultTranspose = new SparseMatrix(this.row, this.column);
        resultTranspose.setSparseLength(this.sparseArr.length);
        for(int i= 0; i< this.sparseArr.length; i++) {
            resultTranspose.sparseArr[i][0] = this.sparseArr[i][1];
            resultTranspose.sparseArr[i][1] = this.sparseArr[i][0];
            resultTranspose.sparseArr[i][2] = this.sparseArr[i][2];
        }
   
        //resultTranspose.showSparseArray();
        return resultTranspose;
    }
    /**
     * Method to add two sparse matrix
     * @param newSparseMatrix2 object of second sparse matrix
     */
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
    	    addResult.showSparseMatrix();
    	}
    }
    /**
     * Method for multiplication of two sparse matrix
     * @param newSparseMatrix2 object of second sparse matrix
     */
    public void matrixMultiplication(SparseMatrix newSparseMatrix2) {
        if(this.column!= newSparseMatrix2.row)
        	System.out.println("rows not equal to column. Multiply not Possible!!");
        else {
            SparseMatrix transposeMatrix2 = newSparseMatrix2.transposeMatrix();
            int position1, position2;
            SparseMatrix multiplyResult = new SparseMatrix(this.row, transposeMatrix2.row);
            multiplyResult.setSparseLength(this.sparseArr.length+1);
            for(position1= 0; position1< this.length;) {
            	int currentRow = this.sparseArr[position1][0];
            	for(position2= 0; position2< transposeMatrix2.length;) {
            	    int currentColumn = transposeMatrix2.sparseArr[position2][0];
            	    int temp1= position1;
            	    int temp2= position2;
            	    int sum= 0;
            	    while(temp1< this.length && this.sparseArr[temp1][0]== currentRow && temp2< transposeMatrix2.length && transposeMatrix2.sparseArr[temp2][0]== currentColumn) {
            	        if(this.sparseArr[position1][1]< transposeMatrix2.sparseArr[temp2][1])
            	            temp1++;
            	        else if(this.sparseArr[temp1][1]> transposeMatrix2.sparseArr[temp2][1]) 
            	        	temp2++;
            	        else 
            	        	sum += this.sparseArr[temp1++][2] * transposeMatrix2.sparseArr[temp2++][2];
            	    }
            	    if(sum!= 0)
            	        multiplyResult.insertInSparse(currentRow, currentColumn, sum);
            	    while(position2< transposeMatrix2.length && transposeMatrix2.sparseArr[position2][0]== currentColumn)
            	    	position2++;
            	}
            	while(position1< this.length && this.sparseArr[position1][0]== currentRow)
            		position1++;
            }
            multiplyResult.showSparseMatrix();
        }
    }
    /**
     * Method to check sparse matrix is symmetric or not
     * @param transpose contain object of transposed sparse matrix
     * @return true if symmetric else return false
     */
    public boolean isSymmetric(SparseMatrix transpose) {
        for(int i=0; i< this.sparseArr.length; i++) {
        	if(transpose.sparseArr[i][0]!=this.sparseArr[i][0] || transpose.sparseArr[i][1]!= this.sparseArr[i][1] || transpose.sparseArr[i][2]!= this.sparseArr[i][2])
        	    return false;
        }
        return true;
    }
    /**
     * Method to take simple input array
     * @param row contain the number of rows
     * @param column contain the number of column
     * @return simple array
     */
    public int[][] getInputArray(int row, int column) {
    	int[][] arr = new int[row][column];
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < column; j++) {
    			arr[i][j] = scanner.nextInt();
    		}
    	}
    	return arr;
    }
    /**
     * Method to calculate the number of non zero element in array
     * @param arr contain the simple array
     * @return count of non zero elements
     */
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
    /**
     * Method to display the sparse matrix
     */
    public void showSparseMatrix() {
    	System.out.println("values in sparse array");
    	for(int i= 0; i< sparseArr.length; i++) {
    	    System.out.print(this.sparseArr[i][0] + " " + this.sparseArr[i][1] + " " + this.sparseArr[i][2]);
    	    System.out.println();
    	}
    }
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("enter the number of rows and column:- ");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        SparseMatrix newSparseMatrix1 = new SparseMatrix(row, column);
        System.out.println("enter element of first array:- ");
        int[][] arr1 = newSparseMatrix1.getInputArray(row, column);
        int count = newSparseMatrix1.checkNonZeroElement(arr1);
        newSparseMatrix1.setSparseLength(count);
        for(int i= 0; i< row; i++) {
            for(int j= 0; j< column; j++) {
                if(arr1[i][j]!= 0)
            	    newSparseMatrix1.insertInSparse(i, j, arr1[i][j]);
            }
        }
        newSparseMatrix1.showSparseMatrix();
        System.out.println("Transpose of a matrix:- ");
        SparseMatrix resultTranspose= newSparseMatrix1.transposeMatrix();
        resultTranspose.showSparseMatrix();
        boolean symmetricResult = newSparseMatrix1.isSymmetric(resultTranspose);
        System.out.println("is sparse matrix symmetric:- "+ symmetricResult);
        
        SparseMatrix newSparseMatrix2 = new SparseMatrix(row, column);
        System.out.println("enter element of second array");
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
        newSparseMatrix1.matrixMultiplication(newSparseMatrix2);
    }

}
