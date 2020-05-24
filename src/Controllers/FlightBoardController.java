package Controllers;

import Model.Flight;
import Model.Repository.FlightRepository;
import Model.Repository.FlightRepositoryImpl;

public class FlightBoardController {
	
	private FlightRepository repo;
	
	public FlightBoardController(FlightRepositoryImpl r){
		this.repo = r;
	}
	
	void addFlight() {
		Flight f = new Flight(p,x,c,v,d);
		repo.add(f);
	}
	
	void editFlight() { 
		
	}
	
	void deleteFlight() {
		// new flight
		//repo.add(f);
	}
	
	Flight searchFlight(int id) {
		return repo.find(id);
	}
	
	
	
	// list of flights getFlights()
}
