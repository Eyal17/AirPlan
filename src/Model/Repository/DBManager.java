package Model.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;


public class DBManager {
	private static Connection connection;
	
	public static  Connection connect() throws SQLException {
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
			connect().createStatement().executeUpdate(sql);
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
//
//
	
}
