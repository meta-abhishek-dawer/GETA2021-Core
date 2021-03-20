package Assignments_JDBC;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class in which we defines method to fetch user details, add images using batch insert technique
 * delete products which are not ordered in 1 year
 * count subcategories of particular category
 * @author abhishek.dawer_metac
 *
 */
public class Assignments {
	String url = "jdbc:mysql://localhost:3306/storefront";
	String username = "root";
	String password = "";
	Connection connection = null;
	public Assignments() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to fetch user details who ordered the products
	 * @param userId contain id of user
	 * @throws Exception if there is any issue in connection
	 */
	public void fetchUserOrders(int userId) {
		try {  
			if(connection == null)
				throw new NullPointerException();
			Statement statement = connection.createStatement();
	    	String query = "select user.UserId, user.UserName, user.Email from user Left Join itemorder ON (user.UserId = itemorder.UserId) where itemorder.UserId=" + userId + " AND itemorder.Status = 'Shipped' ORDER BY OrderDate";
	    	
	    	ResultSet resultSet = statement.executeQuery(query);
	    	
	    	while(resultSet.next()) {
	    		int id = resultSet.getInt(1);
	    		String name = resultSet.getString("UserName");
	    		String email = resultSet.getString("Email");
	    		System.out.println("Id: " + id + " Name " + name + " Email " + email);
	    	}
	    	
	    	statement.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to add images using batch insert technique
	 * @param input containing list of images of type inputStream
	 * @throws Exception if there is issue in connection
	 */
	public void insertBatchUpdate(ArrayList<InputStream> input) {
		try {
			if(connection == null)
				throw new NullPointerException();
			String query = "insert into images values(?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			for(int i=0; i<input.size(); i++) {
				preparedStatement.setInt(1, i+6);
				preparedStatement.setInt(2, 6);
				preparedStatement.setBlob(3, input.get(i));
				preparedStatement.addBatch();
			}
			int[] batchArray = preparedStatement.executeBatch();
			
			for(int i=0; i< batchArray.length; i++) {
				if(batchArray[i]<=0)
					System.out.println("At i position, pic not added!!");
				else {
					System.out.println("Pic added");
				}
			}
			preparedStatement.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to delete products which are not ordered in 1 year
	 * @throws Exception if connection is not available  
	 */
	public void deleteProducts()  {
	    try {
	    	String query = "DELETE from products WHERE Product_id NOT IN (SELECT o.Product_id from itemorder o WHERE DATEDIFF(CURDATE(), o.OrderDate)<= 365)";
	        if(connection == null)
	        	throw new NullPointerException();
	        PreparedStatement newStatement = connection.prepareStatement(query);
	        int numberOfRowsAffected = newStatement.executeUpdate();
	        
	        System.out.println("Number of rows Deleted are:- " + numberOfRowsAffected);
	        newStatement.close();
	        
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * Method to display count of subcategories of each category
	 * @throws NullPointerException if connection is not available
	 */
	public void categoryNameCountSubcategories() {
		try {
			if(connection == null)
				throw new NullPointerException();
			Statement statement2 = connection.createStatement();
			String query = "select c.CategoryName, COUNT(sc.CategoryId) SubcategoryCount from category c join subcategory sc On(c.CategoryId = sc.CategoryId) group by c.CategoryName order by c.CategoryName";
			ResultSet resultset = statement2.executeQuery(query);
			
			while(resultset.next()) {
				String CategoryName = resultset.getString("CategoryName");
				int Count = resultset.getInt("SubCategoryCount");
				System.out.println("CategoryName:- " + CategoryName + " Count:- " + Count);
			}
			statement2.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
