package Model.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Flight;
import Model.Plane;

public class FlightRepositoryImpl implements templateRepository<Integer, Flight> {
	Map<Integer, Flight> flights = new HashMap<Integer, Flight>();
	@Override
	public void add(Flight v) {
		flights.put(v.getFlightID(), v);
		String query = "INSERT INTO flightboard(flightid,planeid)" + "VALUES (" + v.getFlightID() + "," + v.getPlane().getPlaneID() + ")";
		DBManager.addToDB(query);
	}
	@Override
	public void delete(Integer id) {
		flights.remove(id);		
		String query = "DELETE from flightboard WHERE flightboard.flightid=" + id;
		DBManager.deleteFromDB(query);
	}
	@Override
	public void print() {
//		for(Map.Entry i: flights.entrySet()) {
//			System.out.println(i + "\n");
//		}
		try {
			FleetRepositoryImpl.printResultSet(DBManager.readFromDB("SELECT * from flightboard"));
		} catch (SQLException e) {
			System.out.println("Error in printing!");
			e.printStackTrace();
		}
	}
	
	@Override
	public Flight find(Integer id) {
		return flights.get(id);
//		String query = "SELECT * from fleet WHERE flightboard.flightid =" + id;
//		try {
//			ResultSet result = DBManager.readFromDB(query);
//			if (result.next())
//				return new Flight(new Plane(result));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return new Plane("",0);
//	}
	}
	public void checkIn()
	{
		
	}
	@Override
	public ArrayList<Flight> getTable() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}