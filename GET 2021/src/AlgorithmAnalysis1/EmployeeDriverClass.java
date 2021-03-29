package AlgorithmAnalysis1;

/**
 * Driver class for calling different methods of class Insertion sort
 * @author abhishek.dawer_metac
 *
 */
public class EmployeeDriverClass {

	public static void main(String[] args) {
		InsertionSort newInsertionSort = new InsertionSort();
		newInsertionSort.insertEmployee(1, "Rahul", 10, 20000);
		newInsertionSort.insertEmployee(2,"Kavya", 20, 10000);
		newInsertionSort.insertEmployee(3, "Abhishek",21, 50000);
		newInsertionSort.insertEmployee(4,"Kashish", 16, 40000);
		newInsertionSort.insertEmployee(5, "Lovish", 22, 30000);
		newInsertionSort.insertionSort();
		newInsertionSort.printLinkedlist();
	}

}
