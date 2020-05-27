package Model.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;

import Model.Plane;

public class FleetRepositoryImpl implements templateRepository<Integer, Plane> {
	ArrayList<Plane> fleet = new ArrayList<>();
	@Override
	public void add(Plane p) {
		String query = "INSERT INTO fleet(model,planeid)" + "VALUES (" + p.getName() + "," + p.getPlaneID() + ")";
		DBManager.addToDB(query);
	}

	@Override
	public void delete(Integer id) {
		//fleet.remove(id);
		String query = "DELETE from fleet WHERE fleet.planeid=" + id;
		DBManager.deleteFromDB(query);
	}

	@Override
	public void print() {
		try {
			printResultSet(DBManager.readFromDB("SELECT * from fleet"));
		} catch (SQLException e) {
			System.out.println("Error in printing!");
			e.printStackTrace();
		}
	}

	@Override
	public Plane find(Integer id) {
		//return fleet.get(id);
		String query = "SELECT * from fleet WHERE fleet.planeid =" + id;
		try {
			ResultSet result = DBManager.readFromDB(query);
			if (result.next())
				return new Plane(result.getString(1), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Plane("",0);
	}

	@Override
	public ArrayList<Plane> getTable() {
		ResultSet resultSet;
		//
		// here we need to split to load from db for the first time and update the list after each func
		// get table shuold take only the list
		//
		
		try {
			resultSet = DBManager.readFromDB("SELECT * from fleet");
			while (resultSet.next()) { //.next() return true if we have more result + move to the next result (row)
					Plane plane = new Plane(resultSet.getString(1),resultSet.getInt(2));
					fleet.add(plane);
			}
		} catch (SQLException e) {
			System.out.println("Error in reading from DB!");
			e.printStackTrace();
		}
		return fleet;
	}
	
	public static void printResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) { //.next() return true if we have more result + move to the next result (row)
			String id = resultSet.getString("planeid");
			System.out.println(MessageFormat.format("PlaneID={0}", id));
		}
	}
}
