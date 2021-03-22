package DSA_Assignment4;

import java.util.Comparator;
/**
 * Class to sort employees using name
 * @author abhishek.dawer_metac
 *
 */
public class EmployeeNameSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee newEmployee1, Employee newEmployee2) {
		return newEmployee1.getName().compareTo(newEmployee2.getName());
	}

}
