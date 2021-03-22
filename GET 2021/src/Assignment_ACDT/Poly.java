package Assignment_ACDT;

import java.util.Scanner;

public class Poly {
    static Scanner scanner = new Scanner(System.in);
    private int[] cofficient;
	
	/**
	 * Method to get degree of a polynomial
	 * @return degree
	 */
	private int degree(){
		return cofficient.length-1;
	}
	
	/**
	 * Method to add two polynomial
	 * @param p1 object of first polynomial
	 * @param p2 object of second polynomial
	 * @return addResult object by calculating sum
	 */
	private Poly addPoly(Poly p1, Poly p2){
		int size1 = p1.cofficient.length;
		int size2 = p2.cofficient.length;	
		int size = Math.max(size1, size2);
		Poly addResult = new Poly();
		addResult.cofficient = new int[size];
		
		for(int i= 0; i< size1;i++)
			addResult.cofficient[i] = p1.cofficient[i];
			
		for(int i= 0; i< size2; i++)
			addResult.cofficient[i] += p2.cofficient[i];
			
		return addResult;
	}
		
	/**
	 * Method to multiply two polynomial
	 * @param p1 object of first polynomial
	 * @param p2 object of second polynomial
	 * @return multiplyResult object by calculating multiply
	 */
	private Poly multiplyPoly(Poly p1, Poly p2){
		int size1 = p1.cofficient.length;
		int size2 = p2.cofficient.length;
		Poly multiplyResult= new Poly();	
		multiplyResult.cofficient = new int[size1 + size2 - 1];
		for(int i= 0; i< size1 + size2 - 1; i++)
			multiplyResult.cofficient[i] =0;
			
		for(int i= 0; i< size1; i++){
			for(int j= 0; j< size2; j++){
				multiplyResult.cofficient[i+j] += p1.cofficient[i] * p2.cofficient[j];
			}
		}	
		return multiplyResult;
	}
		
	/**
	 * Method to evaluate Polynomial
	 * @param value for which we solve equation
	 * @return result by solving equation
	 */
	private float evaluate(float value){
		float result = this.cofficient[0];
		for(int i= 1; i< this.cofficient.length; i++){
			result = result + (float)(this.cofficient[i] * Math.pow(value, i));
		}
	    return result;
	}
	/**
	 * Method for taking input of a polynomial
	 */
	public void input() {
		int equationLength= 0;
		System.out.println("please enter the number for length of equation");
		equationLength = scanner.nextInt();
	    this.cofficient = new int[equationLength];
	    System.out.println("please enter values to make equation:-");
	    for(int i= 0; i< equationLength ; i++)
		    this.cofficient[i] = scanner.nextInt();
	}
	/**
	 * Method for taking output of a polynomial
	 */
	private void showPolynomial(){
	    for(int i= this.cofficient.length-1; i> 0; i--){
		    System.out.print(this.cofficient[i] + "x" + i + " + ");
		}
	    System.out.print(this.cofficient[0]);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Poly newPoly = new Poly();
		newPoly.input();
		newPoly.showPolynomial();
		int degreeResult = newPoly.degree();
		System.out.println("Degree of a polynomial:- "+degreeResult);
		
		int valueForEvaluation = scanner.nextInt();
		float evaluationResult= newPoly.evaluate(valueForEvaluation);
		System.out.println("ëvaluation of polynomial:- "+ evaluationResult );
		
		Poly newPoly2 = new Poly();
		newPoly2.input();
		newPoly2.showPolynomial();
		System.out.println("Addition of two polynomial:- ");
		Poly addResult= newPoly.addPoly(newPoly, newPoly2);
		addResult.showPolynomial();
		
		System.out.println("multiplication of two polynomial:- ");
		Poly multiplyResult= newPoly.multiplyPoly(newPoly, newPoly2);
		multiplyResult.showPolynomial();
	}
}

