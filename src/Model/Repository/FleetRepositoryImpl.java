package Model.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Plane;

public class FleetRepositoryImpl implements templateRepository<Integer, Plane> {
	
	@Override
	public void add(Plane p) {
		String query = "INSERT INTO fleet(model,planeid)" + "VALUES (" + p.getName() + "," + p.getPlaneID() + ")";
		DBManager.getInstance().addToDB(query);
	}

	@Override
	public void delete(Integer id) {
		//fleet.remove(id);
		String query = "DELETE from fleet WHERE fleet.planeid=" + id;
		DBManager.getInstance().deleteFromDB(query);
	}

//	@Override
//	public void print() {
//		try {
//			printResultSet(DBManager.readFromDB("SELECT * from fleet"));
//		} catch (SQLException e) {
//			System.out.println("Error in printing!");
//			e.printStackTrace();
//		}
//	}

	//@Override
	public Plane find(Integer id) {
		//return fleet.get(id);
		String query = "SELECT * from fleet WHERE fleet.planeid =" + id;
		try {
			ResultSet result = DBManager.getInstance().readFromDB(query);
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
		ArrayList<Plane> fleet = new ArrayList<Plane>();
		//
		// here we need to split to load from db for the first time and update the list after each func
		// get table shuold take only the list
		//
		
		try {
			resultSet = DBManager.getInstance().readFromDB("SELECT * from fleet ORDER BY planeid ASC");
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
	
//	public static void printResultSet(ResultSet resultSet) throws SQLException {
//		while (resultSet.next()) { //.next() return true if we have more result + move to the next result (row)
//			String id = resultSet.getString("planeid");
//			System.out.println(MessageFormat.format("PlaneID={0}", id));
//		}
//	}

	@Override
	public int getMaxID() {
		ResultSet resultSet = null;
		int max = 0;
		try {
			resultSet = DBManager.getInstance().readFromDB("SELECT max(planeid) from fleet");
			resultSet.next();
			max = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(max == 0) {
			return 999;
		}
		return max;
	}
}
