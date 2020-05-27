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
	ArrayList<Flight> flightsList;

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
		System.out.println(id);
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
		ResultSet resultSet;
		flightsList = new ArrayList<Flight>();

		//
		
		
		// here we need to split to load from db for the first time and update the list after each func
		// get table shuold take only the list
		
		//
		try {
			resultSet = DBManager.readFromDB("SELECT * from flightboard join fleet using(planeid)");
			while (resultSet.next()) { //.next() return true if we have more result + move to the next result (row)
					//System.out.println("test flight");
					Flight flight = new Flight(new Plane(resultSet.getString(3),resultSet.getInt(1)),resultSet.getInt(2));
					flightsList.add(flight);
			}
		} catch (SQLException e) {
			System.out.println("Error in reading from DB!");
			e.printStackTrace();
		}
		return flightsList;
	}
	
	public int getMaxID(){
		ResultSet resultSet = null;
		int max = 0;
		try {
			resultSet = DBManager.readFromDB("SELECT max(flightid) from flightboard");
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