package week16JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	static String dbHost = "localhost";
	static String dbUser = "root";
	static String dbPassword ="";
	static String dbDatabase = "softdev2";

	static String dbURL="jdbc:mysql://"+dbHost+"/"+dbDatabase+"?user="+dbUser+"&password="+dbPassword;

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("driver not loaded");
		}

		try {
			return  DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public void create(Student student){
		
		Connection connection = getConnection();
		try{
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("driver not loaded",e);
		}

		Connection connection = null;
		try{
			connection = DriverManager.getConnection(dbURL);
			String sql = "update student set name= ?, age=? where id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(3, student.getId());
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			
			statement.executeUpdate();
		}catch (SQLException sqle){
			throw new RuntimeException(sqle);
		}finally{
			if (connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	public void incrementAges(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("driver not loaded",e);
		}

		Connection connection = null;
		try{
			connection = DriverManager.getConnection(dbURL);
			String sql = "update student set age= age+1;";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.executeUpdate();
		}catch (SQLException sqle){
			throw new RuntimeException(sqle);
		}finally{
			if (connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	public void delete(Student student){

	}
	public Student findById(long id){
		Student student = null;
		
		Connection connection = getConnection();
		try{
			String sql = "select * from student where id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()){
				student = new Student();
				student.setId(rs.getLong("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
			}
			
		}catch(SQLException sqle){
			throw new RuntimeException(sqle);
		}finally{
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return student;
	}
	public List<Student> getAll(){
		List<Student> students = new ArrayList<Student>();
		
		Connection connection = getConnection();
		try{
			String sql = "select * from student;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()){
				Student student = new Student();
				student.setId(rs.getLong("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				students.add(student);
			}
			
		}catch(SQLException sqle){
			throw new RuntimeException(sqle);
		}finally{
			if (connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		return students;
	}
	public List<Student> getAllOlderThan(int age){
		List<Student> students = new ArrayList<Student>();
		
		Connection connection = getConnection();
		try{
			String sql = "select * from student where age > ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, age);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()){
				Student student = new Student();
				student.setId(rs.getLong("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				students.add(student);
			}
			
		}catch(SQLException sqle){
			throw new RuntimeException(sqle);
		}finally{
			if (connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		return students;
	}
}
