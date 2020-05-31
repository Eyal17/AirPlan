package Controllers;

import java.util.ArrayList;

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
			Flight f = new Flight(p,0);
			flightRepo.add(f);
		}
		else {
			System.out.println("Error!");
		}
	}
	
	void editFlight() { 
		
	}
	
	public void deleteFlight(int id) { // omer added
		flightRepo.delete(id);
	}
	
	Flight searchFlight(int id) {
		return flightRepo.find(id);
	}
	
//	public void print() {
//		flightRepo.print();
//	}
	
	public ArrayList<Flight> getTable(){
		return flightRepo.getTable();
	}
	
	public int getMax() {
		return flightRepo.getMaxID();
	}


	
	// list of flights getFlights()
}
