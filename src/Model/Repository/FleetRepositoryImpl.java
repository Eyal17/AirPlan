package Model.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Plane;

public class FleetRepositoryImpl implements templateRepository<Integer, Plane> {
	
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
		//for(Map.Entry i: fleet.entrySet()) {
			//System.out.println(i + "\n");
		try {
			DBManager.printResultSet(DBManager.readFromDB("SELECT * from fleet"));
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
}
