package Controllers;

import Model.Flight;
import Model.Plane;
import Model.Repository.FleetRepository;
import Model.Repository.FleetRepositorylmpl;
import Model.Repository.FlightRepository;
import Model.Repository.FlightRepositorylmpl;

public class FlightBoardController {
	
	private FlightRepository flightRepo;
	private FleetRepository fleetRepo;
	
	public FlightBoardController(FlightRepositorylmpl r, FleetRepositorylmpl s){
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
	
	void deleteFlight() {
		// new flight
		//repo.add(f);
	}
	
	Flight searchFlight(int id) {
		return flightRepo.find(id);
	}
	
	public void print() {
		flightRepo.print();
	}
	
	// list of flights getFlights()
}
