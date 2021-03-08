package DSA_Assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
   
public class EmployeeOperations {
    ArrayList<Employee> newArrayList = new ArrayList<Employee>();
    HashMap<Integer, Integer> newHashMap = new HashMap<>();
    
	public static void main(String[] args) {
		Employee newEmployee1 = new Employee(1, "Abhi", "Chandigarh");
		Employee newEmployee2 = new Employee(2, "Sam", "Jaipur");
		Employee newEmployee3 = new Employee(3, "Sachin", "Delhi");
		Employee newEmployee4 = new Employee(4, "Kashish", "Bombay");
		Employee newEmployee5 = new Employee(5, "Rahul", "Bathinda");
		Employee newEmployee6 = new Employee(2, "Sam", "Jaipur");
		
		EmployeeOperations newEmployeeOperations2 = new EmployeeOperations();
		newEmployeeOperations2.addEmployee(newEmployee1);
		newEmployeeOperations2.addEmployee(newEmployee6);
		newEmployeeOperations2.addEmployee(newEmployee5);
		newEmployeeOperations2.addEmployee(newEmployee4);
		newEmployeeOperations2.addEmployee(newEmployee2);
		newEmployeeOperations2.addEmployee(newEmployee3);
		
		System.out.println("List before sorting:- ");
		System.out.println(newEmployeeOperations2.newArrayList);
		
		System.out.println("List after sorting with Employee Id:- ");
		Collections.sort(newEmployeeOperations2.newArrayList);
		System.out.println(newEmployeeOperations2.newArrayList);
		
		System.out.println("Sorted with Name");
		Collections.sort(newEmployeeOperations2.newArrayList, new EmployeeNameSorter());
		System.out.println(newEmployeeOperations2.newArrayList);
		
	}
    /**
     * Method to add employees
     * @param newEmployee containing the details of employee like empID, name, address 
     */
	public void addEmployee(Employee newEmployee) {
		if(newHashMap.containsKey(newEmployee.empId)==false) {
			newArrayList.add(newEmployee);
			newHashMap.put(newEmployee.empId, 1);
			System.out.println("Employee added");
		}
		else
		{
			System.out.println("Employee already exist");
		}
	}
}
