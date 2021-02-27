package SCFO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
		static HashMap<String,Integer> itemDetails = new HashMap<>();
		static HashMap<String,Float> itemPrice = new HashMap<>();
		static Scanner scanner = new Scanner(System.in);
		
	public static void main(String[] args) {
		
		System.out.println("Please Enter the number of items to add in cart:- ");
		int numberOfItems = scanner.nextInt();
		
		for(int i=0;i<numberOfItems;i++)
		{
			String itemName = scanner.next();
			int quantity = scanner.nextInt();
			float price = scanner.nextFloat();
			
			itemDetails.put(itemName,quantity);
			itemPrice.put(itemName,price);
		}
		
		ShoppingCart obj = new ShoppingCart();
		obj.cartOperations();
	
	}
	
	public void cartOperations()
	{
		ShoppingCart obj1 = new ShoppingCart();
		System.out.println();
		System.out.println("press 1 to update quantity in cart");
		System.out.println("press 2 to add new item in cart");
		System.out.println("press 3 to remove Item from the cart");
		System.out.println("press 4 to show items with quantity in cart");
		System.out.println("press 5 to generate bill of all items in cart.");
		int inputOperation = scanner.nextInt();
		
	    if(inputOperation==1)
	    { 
		System.out.println("enter item name and quantity whose quantity you want to change:-");
		String itemChange = scanner.next();
		int quantityChange = scanner.nextInt();
		System.out.println("enter 1 to increase and 2 to decrease");
		int increaseOrDecrease = scanner.nextInt();
		if(increaseOrDecrease==1)
		{
			obj1.increaseQuantity(itemChange,quantityChange);
			obj1.cartOperations();
			}
		else if(increaseOrDecrease==2){
			
			obj1.decreaseQuantity(itemChange,quantityChange);
			obj1.cartOperations();
			}
		else{System.out.println("Invalid input!!");
		  obj1.cartOperations();}
		}
	    
	    else if(inputOperation==2)
	    {
	    	System.out.println("Input the new itemName, quantity and price:-");
	    	String newItemName = scanner.next();
	    	int newItemQuantity = scanner.nextInt();
	    	float newItemPrice = scanner.nextFloat();
	    	obj1.addNewItemInCart(newItemName, newItemQuantity, newItemPrice);
	    	obj1.cartOperations();
	    }
	    else if(inputOperation==3)
	    {
	    	System.out.println("please input name of item you want to remove:- ");
	    	String itemName = scanner.next();
	    	obj1.removeItemFromCart(itemName);
	    	obj1.cartOperations();
	    }
	    
	    else if(inputOperation==4)
	    {
	    	obj1.showCart();
	    	obj1.cartOperations();
	    }
	    else if(inputOperation==5)
	    {
	    	obj1.generateBill();
	    }
	}
	
	public void addNewItemInCart(String newItemName,int newItemQuantity,float newItemPrice)
	{
		if(itemDetails.containsKey(newItemName)== false){
    		itemDetails.put(newItemName,newItemQuantity);
    		itemPrice.put(newItemName, newItemPrice);}
    	else{
    		itemDetails.put(newItemName, itemDetails.get(newItemName)+newItemQuantity);
    		itemPrice.put(newItemName, itemPrice.get(newItemName)+newItemPrice);}
	}
	
	public void removeItemFromCart(String itemName)
	{
		itemDetails.remove(itemName);
		itemPrice.remove(itemName);
	}
	
	public void increaseQuantity(String itemName,int quantityChange)
	{
		if(itemDetails.containsKey(itemName)==false)
			itemDetails.put(itemName, quantityChange);
		else
			itemDetails.put(itemName,itemDetails.get(itemName)+quantityChange);
	}
	
	public void decreaseQuantity(String itemName,int quantity)
	{
		if(itemDetails.get(itemName)<quantity)
			itemDetails.put(itemName,0);
		else
			itemDetails.put(itemName,itemDetails.get(itemName)-quantity);
	}
	
	public void generateBill()
	{
	    float bill =0;
	      for(Map.Entry<String,Integer> entry : itemDetails.entrySet())
	      {
	    	  bill += (entry.getValue() * itemPrice.get(entry.getKey()));
	      }
	      System.out.println("Total bill of all item in cart is:- "+ bill);
	}
	
	public void showCart()
	{
		System.out.println("Items present with quantity in the list are:- ");
		for(Map.Entry<String,Integer> entry: itemDetails.entrySet())
			System.out.println(entry.getKey()+" "+entry.getValue());
		
	}
}
