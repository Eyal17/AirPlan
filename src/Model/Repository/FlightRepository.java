package Model.Repository;

import Model.Flight;

public interface FlightRepository {
	public void add(Flight f);
	public void delete();
	public void checkIn();
	public Flight find(int id);
	public void print();
	
}
