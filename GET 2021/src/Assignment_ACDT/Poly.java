package Assignment_ACDT;

import java.util.Scanner;

public class Poly {
    static Scanner scanner = new Scanner(System.in);
    private int degree;
    private int[] cofficient;
		
    private Poly(){
	    degree = scanner.nextInt();
	    cofficient = new int[degree + 1];	
	    for(int i= 0; i< degree + 1; i++)
		    cofficient[i] = scanner.nextInt();
	}
	//method to show polynomial
	private void showPolynomial(){
		for(int i= degree; i> 0; i--){
			System.out.print(cofficient[i] + "X" + i + " + ");
		}
		System.out.print(cofficient[0]);
		System.out.println();
	}
	
	// get degree of polynomial
	private int degree(){
		return degree;
	}
	
	//add two polynomial
	private static void addPolynomial(int[] polynomial1,int[] polynomial2){
		int size1 = polynomial1.length;
		int size2 = polynomial2.length;	
		int size = Math.max(size1, size2);
		int[] sumPolynomial = new int[size];
		for(int i= 0; i< size1;i++)
			sumPolynomial[i] = polynomial1[i];
			
		for(int i= 0; i< size2; i++)
			sumPolynomial[i] += polynomial2[i];
			
		for(int i= sumPolynomial.length - 1;i> 0; i--){
			System.out.print(sumPolynomial[i] + "X" + i + " + ");
		}
		System.out.print(sumPolynomial[0]);
		System.out.println();
	}
		
	//multiply two polynomial
	private static void multiplyPolynomial(int[] polynomial1,int[] polynomial2){
		int size1 = polynomial1.length;
		int size2 = polynomial2.length;
			
		int[] product = new int[size1 + size2 - 1];
		for(int i= 0; i< size1 + size2 - 1; i++)
			product[i] =0;
			
		for(int i= 0; i< size1; i++){
			for(int j= 0; j< size2; j++){
				product[i+j] += polynomial1[i] * polynomial2[j];
			}
		}	
		for(int i= 0; i< size1 + size2 - 1; i++){
			System.out.print(product[i]+" "); 
	        if (i != 0){ 
	        	System.out.print("x" + i); 
	        } 
	        if (i != size2 - 1){ 
	        	System.out.print(" + "); 
	        } 
		}
	}
		
	//function to evaluate polynomial
	private double evaluatePolynomial(Poly object, int value){
		double result = object.cofficient[0];
		for(int i= 1; i< object.cofficient.length; i++){
			result = result+ (object.cofficient[i] * Math.pow(value, i));
		}
	return result;
	}
		
	public static void main(String[] args) {
		Poly obj1 = new Poly();
		obj1.showPolynomial();
		int degree = obj1.degree();
		System.out.println(degree);
		
		int valueForEvaluation = scanner.nextInt();
		double evaluationResult= obj1.evaluatePolynomial(obj1, valueForEvaluation);
		System.out.println("ëvaluation of polynomial:- "+ evaluationResult );
		
		Poly obj2 = new Poly();
		addPolynomial(obj1.cofficient, obj2.cofficient);
		multiplyPolynomial(obj1.cofficient, obj2.cofficient);
	}
}

