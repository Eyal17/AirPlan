package Model.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;



public class DBManager {
	private static Connection connection;
	private static ResultSet resultSet;
	public static void main(String[] args) throws Exception {
		// (connection type : DB type : DB host IP : DB port / DB name), username, password)
		//Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AirPlanDB", "postgres", "postgres");
		//Plane p = new Plane("727");
		connect();
		addToDB("INSERT INTO fleet(plane)" + "VALUES (727)");//change to template
		//deleteFromDB("fleet");
		resultSet = readFromDB("SELECT * from fleet");
		printResultSet(resultSet);
	}
	
//
//	public static void addToDB(Plane p,Connection c) throws SQLException {
//		if(p != null) {
//			PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO fleet(plane,id)" + "VALUES (?,?)"); // Query all entry in user table
//			preparedStatement.setString(1,p.name); // Run SQL query (This method goes to the DB and collect the results)
//			preparedStatement.setInt(2, p.getPlaneID());
//			preparedStatement.addBatch();
//			preparedStatement.executeBatch();
//		}
//		}

	
//	public static void deleteFromDB(String table, int id, Connection c) throws SQLException {
//		PreparedStatement preparedStatement = c.prepareStatement("DELETE from " + table + " WHERE " + table + ".id=" + id); 
//		preparedStatement.executeUpdate(); 
//	}
	
	private static Connection connect() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AirPlanDB", "postgres", "postgres");
			System.out.println("Connected succesfully to DB!");
		}
		return connection;
	}
	public static ResultSet readFromDB(String sql) throws SQLException {
		System.out.println("Reading...");
		return connect().createStatement().executeQuery(sql);
	}
	
	public static boolean addToDB(String sql){
		try {
			PreparedStatement preparedStatement = connect().prepareStatement(sql);
			preparedStatement.executeUpdate();
			System.out.println("Added succesfully!");
			return true;
		}
		catch (SQLException e) {
			System.out.println("Error in addToDB!");
			return false;
		}
	}
	
	public static boolean deleteFromDB(String sql) {
		try {
			connect().createStatement().executeUpdate(sql);
			return true;
		}
		catch (SQLException e) {
			System.out.println("Error in deleteToDB!");
			return false;
		}
	}
	
	public static void printResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) { //.next() return true if we have more result + move to the next result (row)
			//Plane p = (Plane) resultSet.getObject("Plane");
			//String name = resultSet.getString("plane");
			String id = resultSet.getString("planeid");
			System.out.println(MessageFormat.format("PlaneID={0}", id));
		}
	}
//
//
	
}
