package DSA_Assignment4;
/**
 * Class Employee containing details of Employee like id, name and address
 * @author abhishek.dawer_metac
 *
 */
public class Employee implements Comparable<Employee> {
    int empId;
    String name, address;
    
    public Employee(int id, String name1, String address1) {
    	this.empId = id;
    	this.name = name1;
    	this.address = address1;
    }
    /**
     * Method to get Name of employee
     * @return
     */
    public String getName() {
    	return this.name;
    }
    
    /**
     * Method to Compare two employees with id
     */
	@Override
	public int compareTo(Employee newEmployee) {
		return this.empId - newEmployee.empId;
	}
	
	@Override
	public String toString() {
		return "Employee:- " + empId + ", " + name + ", " + address + "\n";
	}   
}
