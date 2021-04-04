package AlgorithmAnalysis2;

/**
 * Class Employee having entities like id, name, age, salary of person
 * @author abhishek.dawer_metac
 *
 */
public class Employee {
    int id, age, salary;
    String name;
    Employee next;

    /**
     * Constructor of class Employee for setting values
     * @param id containing id of employee
     * @param name containing name of employee
     * @param age containing age of employee
     * @param salary containing salary of employee
     */
    public Employee(int id, String name, int age, int salary) {
    	this.id = id;
    	this.name = name;
    	this.age = age;
    	this.salary = salary;
    	this.next = null;
    }

    /**
     * Method to get id
     * @return id value of type int
     */
    public int getId() {
    	return this.id;
    }

    /**
     * Method to get name
     * @return value of type string
     */
    public String getName() {
    	return this.name;
    }

    /**
     * Method to get age
     * @return value of type int
     */
    public int getAge() {
    	return this.age;
    }

    /**
     * Method to get salary
     * @return value of type int
     */
    public int getSalary() {
    	return this.salary;
    }
}