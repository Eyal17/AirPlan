package Model.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Flight;
import Model.Plane;

public class FlightRepositorylmpl implements FlightRepository {
	
	Map<Integer, Flight> flights = new HashMap<Integer, Flight>();
	

	@Override
	public void add(Flight f) {
		flights.put(f.getFlightID(), f);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flight find(int id) {
		return flights.get(id);
	}

	@Override
	public void print() {
		for(Map.Entry i: flights.entrySet()) {
			System.out.println(i + "\n");
	}
	}
}
