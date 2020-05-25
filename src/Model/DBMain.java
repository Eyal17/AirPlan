package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;



public class DBMain {
	
	public static void main(String[] args) throws Exception {
		// (connection type : DB type : DB host IP : DB port / DB name), username, password)
		Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/AirPlanDB", "postgres", "postgres");
		Plane p = new Plane("727");
		//addToDB(p, connection);//change to template
		deleteFromDB("fleet",5517,connection);
		readFromDB("fleet",connection);
		
	}
	public static void addToDB(Plane p,Connection c) throws SQLException {
		if(p != null) {
			PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO fleet(plane,id)" + "VALUES (?,?)"); // Query all entry in user table
			preparedStatement.setString(1,p.name); // Run SQL query (This method goes to the DB and collect the results)
			preparedStatement.setInt(2, p.getPlaneID());
			preparedStatement.addBatch();
			preparedStatement.executeBatch();
		}
		}
	public static void readFromDB(String table, Connection c) throws SQLException {
		PreparedStatement preparedStatement = c.prepareStatement("SELECT * from " + table); // Query all entry in user table
		ResultSet resultSet = preparedStatement.executeQuery(); 
		while (resultSet.next()) { //.next() return true if we have more result + move to the next result (row)
			//Plane p = (Plane) resultSet.getObject("Plane");
			String name = resultSet.getString("plane");
			String ID = resultSet.getString("id");
			System.out.println(MessageFormat.format("Plane={0},\nID={1}", name, ID));
		}
	}
	public static void deleteFromDB(String table, int id, Connection c) throws SQLException {
		PreparedStatement preparedStatement = c.prepareStatement("DELETE from " + table + " WHERE " + table + ".id=" + id); 
		preparedStatement.executeUpdate(); 
	}
}
