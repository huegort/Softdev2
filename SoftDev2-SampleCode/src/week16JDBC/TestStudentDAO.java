package week16JDBC;

public class TestStudentDAO {

	public static void main(String[] args) {
		Student student = new Student(12,"mick",21);
		StudentDAO dao = new StudentDAO();
		dao.create(student);

	}

}
