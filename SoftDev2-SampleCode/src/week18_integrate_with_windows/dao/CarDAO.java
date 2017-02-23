package week18_integrate_with_windows.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarDAO {
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
	public void create(Car car){
		
		Connection connection = getConnection();
		try{
			String sql = "insert into car (id, reg, make, enginecc) values (?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, car.getId());
			statement.setString(2, car.getRegNum());
			statement.setString(3, car.getMake());
			statement.setInt(4, car.getEngineCC());
			
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
	public void update(Car car){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("driver not loaded",e);
		}

		Connection connection = null;
		try{
			connection = DriverManager.getConnection(dbURL);
			String sql = "update car set reg= ?, make=?, engineCC=? where id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(4, car.getId());
			statement.setString(1, car.getRegNum());
			statement.setString(2, car.getMake());
			statement.setInt(3, car.getEngineCC());
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
	
	
	public void delete(Car car){

	}
	public Car findById(long id){
		Car car = null;
		
		Connection connection = getConnection();
		try{
			String sql = "select * from car where id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()){
				car = new Car();
				car.setId(rs.getLong("id"));
				car.setRegNum(rs.getString("reg"));
				car.setMake(rs.getString("make"));
				car.setEngineCC(rs.getInt("enginecc"));
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
		return car;
	}
	public List<Car> getAll(){
		List<Car> cars = new ArrayList<Car>();
		
		Connection connection = getConnection();
		try{
			String sql = "select * from car;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()){
				Car car = new Car();
				car.setId(rs.getLong("id"));
				car.setRegNum(rs.getString("reg"));
				car.setMake(rs.getString("make"));
				car.setEngineCC(rs.getInt("enginecc"));
				cars.add(car);
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
		
		return cars;
	}

}
