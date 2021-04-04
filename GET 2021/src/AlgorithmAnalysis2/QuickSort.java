package AlgorithmAnalysis2;

public class QuickSort {
    public Employee head = null;
    
    /**
     * Method to insert employee in LinkedList
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
	public Employee sort(Employee startHead, Employee lastNode) {
		if(startHead == null || startHead == lastNode)
			return startHead;
		Employee[] employees = doPartition(startHead, lastNode);
		Employee newHead = employees[0];
		Employee pivot = employees[1];
		Employee newEnd = employees[2];
		if(newHead != pivot) {
			Employee temp = newHead;
			while(temp.next != pivot) {
				temp = temp.next;
			}
			temp.next = null;
			newHead = sort(newHead, temp);
			temp = getLastNode(newHead);
			temp.next = pivot;
		}
		pivot.next = sort(pivot.next, newEnd);
		return newHead;
	}
	
	public Employee[] doPartition(Employee startHead, Employee lastNode) {
		Employee pivot = lastNode;
		Employee current = startHead;
		Employee previous = null, newHead = null, newEnd = null;
		
		while(current != pivot) {
			int compare = compareEmployees(current, pivot);
			if(compare == 1) {
				if(newHead == null)
					newHead = current;
				previous = current;
				current = current.next;
			}
			else {
				if(previous != null) 
					previous.next = current.next;
				Employee temp = current.next;
				current.next = null;
				lastNode.next = current;
				lastNode = current;
				current = temp;
			}
		}
		if(newHead == null)
			newHead = pivot;
		newEnd = lastNode;
		Employee employees[] = {newHead, pivot, lastNode};
		return employees;
	}
	
	public int compareEmployees(Employee employee1, Employee employee2) {
	    if(employee1.getSalary() > employee2.getSalary())
	    	return 1;
	    else if(employee1.getSalary() < employee2.getSalary())
	    	return -1;
	    else {
	    	if(employee1.getAge() > employee2.getAge())
	    		return -1;
	    	else if(employee1.getAge()< employee2.getAge())
	    		return 1;
	    	else
	    		return 0;
	    }
	}
	
	public Employee getLastNode(Employee temp) {
	    while(temp.next != null) {
	    	temp = temp.next;
	    }
	    return temp;
	}
	
	public void ShowEmployee() {
		Employee tempPrint = head;
		while(tempPrint != null) {
			System.out.println(tempPrint.name + " " + tempPrint.age + " " + tempPrint.salary);
			tempPrint = tempPrint.next;
		}
	}
	
}
