package Controllers;

import Model.Flight;
import Model.Plane;
import Model.Repository.templateRepository;
import Model.Repository.FleetRepositoryImpl;
import Model.Repository.FlightRepositoryImpl;

public class FlightBoardController {
	
	private templateRepository<Integer, Flight> flightRepo;
	private templateRepository<Integer, Plane> fleetRepo;
	
	public FlightBoardController(FlightRepositoryImpl r, FleetRepositoryImpl s){
		flightRepo = r;
		fleetRepo = s;
	}
	
	public void addFlight(int planeID) {
		Plane p = fleetRepo.find(planeID);
		if(p != null) {
			Flight f = new Flight(p);
			flightRepo.add(f);
		}
		else {
			System.out.println("Error!");
		}
		flightRepo.print();
	}
	
	void editFlight() { 
		
	}
	
	public void deleteFlight(int id) { // omer added
		flightRepo.delete(id);
	}
	
	Flight searchFlight(int id) {
		return flightRepo.find(id);
	}
	
	public void print() {
		flightRepo.print();
	}
	
	// list of flights getFlights()
}
