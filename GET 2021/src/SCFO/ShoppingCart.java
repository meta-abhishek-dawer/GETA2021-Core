package SCFO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ShoppingCart {
	static HashMap<String,Items> itemDetails = new HashMap<>();
	static HashMap<String,Integer> itemPrice = new HashMap<>();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the number of items to add in cart:- ");
		int numberOfItems = scanner.nextInt();
		
		for(int i=0;i<numberOfItems;i++)
		{
			String itemName = scanner.next();
			int quantity = scanner.nextInt();
			int price = scanner.nextInt();
			
			Items items = new Items(quantity,price);
			itemDetails.put(itemName,items);
			//itemPrice.put(itemName,price);
		}
		
		ShoppingCart obj = new ShoppingCart();
		 obj.showCart();
		int inputOperation = scanner.nextInt();
		switch(inputOperation)
		{
		case 1: 
			System.out.println("enter item name and quantity whose quantity you want to change:-");
			String itemChange = scanner.next();
			int quantityChange = scanner.nextInt();
			System.out.println("enter 1 to increase and 2 to decrease");
			int increaseOrDecrease = scanner.nextInt();
			if(increaseOrDecrease==1)
				obj.increaseQuantity(itemChange,quantityChange);
			else if(increaseOrDecrease==2)
				obj.decreaseQuantity(itemChange,quantityChange);
		}
	}
	
	public void increaseQuantity(String itemName,int quantityChange)
	{
		//itemDetails.put(itemName, itemDetails.get(itemDetails.Items.getQuantity())+1);
	}
	
	public void decreaseQuantity(String ItemName,int quantity)
	{
		
	}
	public void showCart()
	{
		for(Map.Entry<String, Items> entry: itemDetails.entrySet())
		{
			String key = entry.getKey();
			Items i1 = entry.getValue();
			System.out.println(key+" "+i1.getQuantity()+" "+i1.getPrice());
		}
	}
}
