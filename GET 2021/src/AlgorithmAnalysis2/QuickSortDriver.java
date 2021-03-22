package AlgorithmAnalysis2;

public class QuickSortDriver {

	public static void main(String[] args) {

		QuickSort newQuickSort = new QuickSort();
		newQuickSort.insertEmployee(1, "Rahul", 10, 20000);
		newQuickSort.insertEmployee(2,"Kavya", 20, 10000);
		newQuickSort.insertEmployee(4,"Kashish", 16, 40000);
		newQuickSort.insertEmployee(5, "Lovish", 22, 30000);
		newQuickSort.insertEmployee(3, "Abhishek",21, 50000);
		
		newQuickSort.ShowEmployee();
		Employee start = newQuickSort.head;
		Employee last = newQuickSort.getLastNode(newQuickSort.head);
		newQuickSort.head = newQuickSort.sort(start, last);
		newQuickSort.ShowEmployee();
	}

}
