package week21_employeeDAO;

import java.util.List;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		Employee employee1 = new Employee(1001,"joe");
		employeeDAO.create(employee1);
		// now lets see if I cqan get this from DB
		Employee returnedEmployee = employeeDAO.findById(1001);
		if (!returnedEmployee.getName().equals("joe")){
			// we got the wrong employee
			throw new RuntimeException("could not get empoyee back from DB");
		}
		employee1.setName("frank");
		employeeDAO.update(employee1);
		returnedEmployee = employeeDAO.findById(1001);
		if (!returnedEmployee.getName().equals("frank")){
			// we got the wrong employee
			throw new RuntimeException("update did not work");
		}
		System.out.println("testing get all");
		List<Employee> employees = employeeDAO.getAll();
		for (Employee employee : employees){
			System.out.println(employee);
		}
		
		// test delete
		employeeDAO.delete(1001);
		returnedEmployee = employeeDAO.findById(1001);
		if (!(returnedEmployee == null)){
			// there should have been no employee now with id 1001
			throw new RuntimeException("delete did not work");
		}

	}

}
