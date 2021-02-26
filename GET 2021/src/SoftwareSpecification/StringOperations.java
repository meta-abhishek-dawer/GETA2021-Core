package SoftwareSpecification;

import java.util.Scanner;

public class StringOperations {
	
	
	/**
	 * Reverse a string
	 * @param str is value which we have to reverse
	 * @return result as reverse value of String str
	 */
	public String reverseString(String str)
	{
		char[] charArr = str.toCharArray(); // convert string into character array
		String result ="";
		
		for(int i= charArr.length-1;i>=0;i--)
		{
			result += charArr[i];
		}
		return result;
	}
	
	/**
	 * method to change the uppercase to lower and lowercase to uppercase
	 * @param str is a value on which oprations are performed
	 * @return result by changing cases of value str
	 */
	public String changeCase(String str)
	{
		String result="";
		char[] charArr = str.toCharArray();
		
		for(int i=0;i<charArr.length;i++)
		{
			if(charArr[i]>='A' && charArr[i]<='Z')
			{
				charArr[i]= (char)((int)charArr[i]+32);
			}
			else if(charArr[i]>='a' && charArr[i]<='z')
			{
				charArr[i]= (char)((int)charArr[i]-32);
			}
		}
		
		for(int i=0;i<charArr.length;i++)
			result += charArr[i];
		
		return result;
	}
	
	/**
	 * Find largest word in a String
	 * @param str is value from which we find largest word
	 * @return result where value in words array contain largest word
	 */
	
	public String largestWord(String str)
	{
		String result="",word="";
		String[] words = new String[100];
		int pos=0;
		
		str = str+ " ";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!=' ')
				word = word+str.charAt(i);
			else
			{
				words[pos]= word;
				pos++;
				word= "";
			}
		}
		result= words[0];
		for(int k=0;k<pos;k++)
		{
			//compare which value is large
			if(result.length()<words[k].length())
				result= words[k];
		}
		
		return result;
	}
	
	/**
	 * compare values of two strings are equal or not
	 * @param str1 contain value1 which we have to compare
	 * @param str2 contain value2 which we have to compare
	 * @return result true if value are equal and false if not equal
	 */
	public boolean equalOrNot(String str1,String str2)
	{
		boolean result = false;
		char[] charArr1 = str1.toCharArray();
		char[]charArr2 = str2.toCharArray();
		
		if(charArr1.length!=charArr2.length)
			return false;
		else
		{
			for(int i=0;i<charArr1.length;i++)
			{
				if(charArr1[i]!=charArr2[i])
				{
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		   String str1 = scanner.nextLine();
		   String str2 = scanner.nextLine();
		   
		   // reverse method
		   StringOperations obj1= new StringOperations();
		      String revString=obj1.reverseString(str1);
		      System.out.println("reverse of a string is:- "+ revString);
		      
		   // case change
		      String resultCase = obj1.changeCase(str1);
		      System.out.println("Case changes:- "+resultCase);
		      
		   //largest word in string   
		      String largestWordResult = obj1.largestWord(str1); 
		      System.out.println("largest word in a string is:- "+largestWordResult);
		      
		   //compare two strings   
		      boolean equalResult = obj1.equalOrNot(str1,str2);
		      System.out.println("String are equal or not:- "+equalResult);
	}

}
