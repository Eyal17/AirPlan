package Model.Repository;

import java.util.HashMap;
import java.util.Map;

import Model.Flight;

public class FlightRepositoryImpl implements templateRepository<Integer, Flight> {
	Map<Integer, Flight> flights = new HashMap<Integer, Flight>();
	@Override
	public void add(Flight v) {
		flights.put(v.getFlightID(), v);
	}
	@Override
	public void delete(Integer k) {
		flights.remove(k);		
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