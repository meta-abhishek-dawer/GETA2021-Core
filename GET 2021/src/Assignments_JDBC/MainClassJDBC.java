package Assignments_JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class main which is used to call different methods of JDBC Assignments class
 * @author abhishek.dawer_metac
 *
 */
public class MainClassJDBC {

	public static void main(String[] args) throws Exception {
	    Assignments object = new Assignments();
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter id of user..");
	    int userId = scanner.nextInt();
	    object.fetchUserOrders(userId);
	    
	    String pathImage1 = "C:/Users/abhishek.dawer_metac/git/GETA2021-Core/GET 2021/images/paint1.png";
	    String pathImage2 = "C:/Users/abhishek.dawer_metac/git/GETA2021-Core/GET 2021/images/paint1.png";
	    String pathImage3 = "C:/Users/abhishek.dawer_metac/git/GETA2021-Core/GET 2021/images/paint1.png";
	    String pathImage4 = "C:/Users/abhishek.dawer_metac/git/GETA2021-Core/GET 2021/images/paint1.png";
	    String pathImage5 = "C:/Users/abhishek.dawer_metac/git/GETA2021-Core/GET 2021/images/paint1.png";
	    
	    ArrayList<InputStream> imageInput = new ArrayList<InputStream>();
	    InputStream input1 = new FileInputStream(pathImage1);
	    imageInput.add(input1);
	    InputStream input2 = new FileInputStream(pathImage2);
	    imageInput.add(input2);
	    InputStream input3 = new FileInputStream(pathImage3);
	    imageInput.add(input3);
	    InputStream input4 = new FileInputStream(pathImage4);
	    imageInput.add(input4);
	    InputStream input5 = new FileInputStream(pathImage5);
	    imageInput.add(input5);
	    
	    object.insertBatchUpdate(imageInput);
	    object.deleteProducts();
	    object.categoryNameCountSubcategories();
	}

}
