package Controllers;

import java.util.ArrayList;

import Model.Plane;
import Model.Repository.FleetRepositoryImpl;
import Model.Repository.FlightRepositoryImpl;


public class FleetController {

	private FlightRepositoryImpl flightRepo;
	private FleetRepositoryImpl fleetRepo;
	
	public FleetController(FlightRepositoryImpl r, FleetRepositoryImpl s) {
		flightRepo = r;
		fleetRepo = s;
	}
	
	 public void addPlane(String model){
		Plane p = new Plane(model,0);
		fleetRepo.add(p);
	}
	public boolean deletePlane(int id){
		if(flightRepo.isPlaneExist(id)) {
			return false;
		}
		else {
			fleetRepo.delete(id);
			return true;
		}
	}
	
//	public void print() {
//		repFleet.print();
//	}
	
	public ArrayList<Plane> getTable(){
		return fleetRepo.getTable();
	}
	
	public int getMax() {
		return fleetRepo.getMaxID();
	}

}
