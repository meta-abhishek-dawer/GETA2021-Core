package AlgorithmAnalysis1;

/**
 * Class Insertion sort in which we can insert employee, sort in LinkedList
 * @author abhishek.dawer_metac
 *
 */
public class InsertionSort {
    Employee head = null, sortedHead;
	
    /**
     * Method to insert employee in LinkedList (insert in begining)
     * @param id containing id of employee
     * @param name containing name of employee
     * @param age containing age of employee
     * @param salary containing salary of employee
     */
	public void insertEmployee(int id, String name, int age, int salary) {
		Employee employee = new Employee(id, name, age, salary);
		if(head == null)
			head = employee;
		else {
			employee.next = head;
			head = employee;
		}
	}
	
	/**
	 * Method to sort employees using insertion sort
	 */
	public void insertionSort() {
		sortedHead = null;
		Employee current = head;
		while(current!= null) {
			Employee temp = current.next;
			sortedInsert(current);
			current = temp;
		}
		this.head = sortedHead;
	}
	
	/**
	 * Method to insert sort values in node sortedHead
 	 * @param node containing node of employee
	 */
	public void  sortedInsert(Employee node) {
		if(sortedHead == null || sortedHead.salary < node.salary) {
			node.next = sortedHead;
			sortedHead = node;
		}
		else if(sortedHead.salary == node.salary && sortedHead.age > node.age) {
			node.next = sortedHead;
			sortedHead = node;
		}
		else {
			Employee temp1 = sortedHead;
			while(temp1.next != null && temp1.next.salary > node.salary) {
				temp1 = temp1.next;
			}
			node.next = temp1.next;
			temp1.next = node;
		}
	}
	
	public void printLinkedlist() {
		Employee traverse = head;
		while(traverse!= null) {
			System.out.println(traverse.id + " " + traverse.name + " " + traverse.age + " " + traverse.salary);
			traverse = traverse.next;
		}
	}
}
