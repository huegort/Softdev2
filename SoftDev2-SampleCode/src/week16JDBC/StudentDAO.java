package week16JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentDAO {
	static String dbHost = "localhost";
	static String dbUser = "root";
	static String dbPassword ="";
	static String dbDatabase = "softdev2";

	static String dbURL="jdbc:mysql://"+dbHost+"/"+dbDatabase+"?user="+dbUser+"&password="+dbPassword;


	public void create(Student student){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("driver not loaded");
		}

		Connection connection = null;
		try{
			connection = DriverManager.getConnection(dbURL);


			String sql = "insert into student (id, name, age) values (?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, student.getId());
			statement.setString(2, student.getName());
			statement.setInt(3, student.getAge());
			
			statement.executeUpdate();
		}catch (SQLException sqle){
			throw new RuntimeException(sqle);
		}finally{
			if (connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	public void update(Student student){

	}
	public void delete(Student student){

	}
	public Student findById(long id){
		return null;
	}
	public List<Student> getAll(){
		return null;
	}
}
