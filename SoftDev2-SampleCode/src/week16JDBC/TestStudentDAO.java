package week16JDBC;

import java.util.List;

public class TestStudentDAO {

	public static void main(String[] args) {
		Student student = new Student(14,"joe",22);
		StudentDAO dao = new StudentDAO();
		//dao.create(student);
		//dao.incrementAges();
		
		//student = dao.findById(14);
		//System.out.println(student);
		
		List<Student> students = dao.getAll();
		for (Student oneStudent : students){
			System.out.println(oneStudent);
		}
		System.out.println("older students");
		students = dao.getAllOlderThan(24);
		for (Student oneStudent : students){
			System.out.println(oneStudent);
		}
		

	}

}
