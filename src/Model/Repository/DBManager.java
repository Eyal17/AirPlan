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
			// (connection type : DB type : DB host IP : DB port / DB name), username, password)
			//connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AirPlanDB", "postgres", "postgres");
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-34-225-82-212.compute-1.amazonaws.com:5432/d3q19tgb52t4up", "ptxcxqrycrcoep", "21ef1913fe59fd5e95151880ccaf98bc8bdbbc381d4820b95842124fa866e3b3");
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
