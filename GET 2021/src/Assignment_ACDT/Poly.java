package Assignment_ACDT;

import java.util.Scanner;

public class Poly {

	static Scanner scanner = new Scanner(System.in);
		private int degree;
		private int[] cofficient;
		
		private Poly(){
			degree = scanner.nextInt();
			cofficient = new int[degree+1];
			
			for(int i=0;i<degree+1;i++)
				cofficient[i] = scanner.nextInt();
			
			
		}
		
		private void showPolynomial()
		{
			for(int i=degree;i>0;i--)
			{
				System.out.print(cofficient[i]+"X"+i+" + ");
			}
			System.out.print(cofficient[0]);
			System.out.println();
			
		}
		
		// get degree of polynomial
		private int degree()
		{
			return degree;
		}
		
		//add two polynomial
		private static void addPolynomial(int[] poly1,int[] poly2)
		{
			int m = poly1.length;
			int n = poly2.length;
			
			int size = Math.max(m,n);
			int[] sumPoly = new int[size];
			
			for(int i=0;i<m;i++)
				sumPoly[i] = poly1[i];
			
			for(int i=0;i<n;i++)
				sumPoly[i] += poly2[i];
			
			for(int i=sumPoly.length-1;i>0;i--)
			{
				System.out.print(sumPoly[i]+"X"+i+" + ");
			}
			System.out.print(sumPoly[0]);
			System.out.println();
		}
		
		//multiply two polynomial
		private static void multiplyPolynomial(int[] poly1,int[] poly2)
		{
			int m = poly1.length;
			int n = poly2.length;
			
			int[] prod = new int[m+n-1];
			for(int i=0;i<m+n-1;i++)
				prod[i] =0;
			
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					prod[i+j] += poly1[i] * poly2[j];
				}
			}
			
			for(int i=0;i<m+n-1;i++)
			{
				System.out.print(prod[i]+" "); 
	            if (i != 0)  
	            { 
	                System.out.print("x" + i); 
	            } 
	            if (i != n - 1)  
	            { 
	                System.out.print(" + "); 
	            } 
			}
		}
		
		//function to evaluate polynomial
		private double evaluatePolynomial(Poly obj,int n)
		{
		double result = obj.cofficient[0];
		for(int i=1;i<obj.cofficient.length;i++)
		{
			result = result+ (obj.cofficient[i]*Math.pow(n, i));
		}
		
		return result;
		}
		
	public static void main(String[] args) {
		
		Poly obj1 = new Poly();
		obj1.showPolynomial();
		
		//Degree of a polynomial
		int degree = obj1.degree();
		System.out.println(degree);
		
		//Evaluate Polynomial
		int valueForEvaluation = scanner.nextInt();
		double evaluationResult=    obj1.evaluatePolynomial(obj1,valueForEvaluation);
		System.out.println("ëvaluation of polynomial:- "+ evaluationResult );
		
		Poly obj2 = new Poly();
		
		//add polynomial
		addPolynomial(obj1.cofficient, obj2.cofficient);
		
		//multiply polynomial
		multiplyPolynomial(obj1.cofficient,obj2.cofficient);
		
	}

}

