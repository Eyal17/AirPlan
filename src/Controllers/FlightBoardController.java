package Controllers;

import Model.Repository.FlightRepository;
import Model.Repository.FlightRepositoryImpl;

public class FlightBoardController {
	
	private FlightRepository repo;
	
	public FlightBoardController(FlightRepositoryImpl r){
		this.repo = r;
	}
	
	void addFlight() {
		// new flight
		repo.add(f);
	}
	
	// list of flights getFlights()
}
