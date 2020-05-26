package Model.Repository;

import java.util.HashMap;
import java.util.Map;

import Model.Flight;

public class FlightRepositoryImpl implements templateRepository<Integer, Flight> {
	Map<Integer, Flight> flights = new HashMap<Integer, Flight>();
	@Override
	public void add(Flight v) {
		//flights.put(v.getFlightID(), v);
		String query = "INSERT INTO flightboard(flightid,planeid)" + "VALUES (" + v.getFlightID() + "," + v.getPlane().getPlaneID() + ")";
		DBManager.addToDB(query);
	}
	@Override
	public void delete(Integer id) {
		//flights.remove(k);		
		String query = "DELETE from flightboard WHERE flightboard.flightid=" + id;
		DBManager.deleteFromDB(query);
	}
	@Override
	public void print() {
		for(Map.Entry i: flights.entrySet()) {
			System.out.println(i + "\n");
		}
	}
	@Override
	public Flight find(Integer k) {
		return flights.get(k);
	}
	public void checkIn()
	{
		
	}
	
	
}