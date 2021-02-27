package SCFO;

public class Items {
		int quantity,price;
		
		Items(int itemQuantity,int itemPrice)
		{
			this.quantity = itemQuantity;
			this.price = itemPrice;
		}
		
		public int getQuantity()
		{
			return quantity;
		}
		public int getPrice()
		{
			return price;
		}
		public void showList()
		{
			System.out.print(this.quantity+" "+this.price);
		}
		
}
