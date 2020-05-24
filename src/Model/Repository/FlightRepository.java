package Model.Repository;

import Model.Flight;

public interface FlightRepository {

	void add(Flight f);
	void delete(int id);
}
