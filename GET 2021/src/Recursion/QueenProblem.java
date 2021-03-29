package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class QueenProblem {
  public static void main(String[] ar ) {
    Scanner scanner = new Scanner(System.in);
    int boardSize = scanner.nextInt();
    int board[][] = new int[boardSize][boardSize];
    	
    QueenProblem newQueenProblem = new QueenProblem();
    if(newQueenProblem.nQueens(board,0, boardSize)) {
      System.out.println("Solution possible.");
      newQueenProblem.displayBoard(board, boardSize);
    }
    else {
      System.out.println("Solution not possible.");
    }
  }
  /**
  * method in which we place n queens on board
  * @param board contain values in which we placed
  * @param level contain value which represent queen number like 1 queen, 2 queen
  * @param boardSize size of board
  * @return true if combination possible else false
  */
  public boolean nQueens (int[][] board, int level, int boardSize) {
    if(level == boardSize)
      return true;
    	
    QueenProblem newQueenProblem1 = new QueenProblem();
    for(int i = 0; i < boardSize; i++) {
      if(newQueenProblem1.queenIsAttacked(level, i, board, boardSize)) {
        continue;
      }
      board[level][i] = 1;
      if(nQueens(board, level+1, boardSize))
    	return true;
    		
      board[level][i] = 0;
    }
    return false;
  }
  /**
  * method to check queen is safe or attacked
  * @param row contain row of that queen which we want to check
  * @param column contain column of that queen which we check
  * @param board values in which all queens placed
  * @param boardSize size of board
  * @return true if safe else false
  */
  public boolean queenIsAttacked (int row, int column, int board[][], int boardSize) {
    for(int i = 0; i< boardSize; i++) {
      if(board[row][i]==1 && i!=column )
        return true;
      if( board[i][column] == 1 && i!=row )
        return true;
    }
    for(int i = 0; i< boardSize; i++) {
      for(int j = 0; j < boardSize; j++) {
        if((i + j == row + column) || (i - j == row-column )){
    	  if((i != row || j != column) && board[i][j]== 1)
    	    return true;
    	}
      }
    }
    return false;
  }
  /**
  * method to show the board
  * @param board contain values on which queen is placed
  * @param boardSize size of board like 4x4, 5x5
  */
  public void displayBoard(int[][] board, int boardSize) {
    for(int i = 0; i < boardSize; i++) {
      for(int j =0; j < boardSize; j++) {
    	System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
