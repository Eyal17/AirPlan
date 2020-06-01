package Controllers;

import View.View;

import java.util.ArrayList;

import Model.Flight;
import Model.Plane;
import Model.Repository.ModelRepository;

public class Controller {
	 //public FleetController fleetCtrl;
	 //public FlightBoardController flightCtrl;
	 //public MapController mapCtrl;
	 
	 private View view;
	 private ModelRepository modelAP;
	
	 
	 public Controller(ModelRepository m, View v) {
		 modelAP = m;
		 view = v;
		 //fleetCtrl = new FleetController(r, s);
		 //flightCtrl = new FlightBoardController(r, s);

	 }
	 
	 public void addPlane(String model){
		Plane p = new Plane(model,0);
		modelAP.fleetRepo.add(p);
	}
	 
	public boolean deletePlane(int id){
		if(modelAP.flightRepo.isPlaneExist(id)) {
			return false;
		}
		else {
			modelAP.fleetRepo.delete(id);
			return true;
		}
	}
	
	public ArrayList<Plane> getFleetTable(){
		return modelAP.fleetRepo.getTable();
	}
	
	public int getMaxPlaneID() {
		return modelAP.fleetRepo.getMaxID();
	}
	
	public void addFlight(int planeID) {
		Plane p = modelAP.fleetRepo.find(planeID);
		if(p != null) {
			Flight f = new Flight(p,0);
			modelAP.flightRepo.add(f);
		}
		else {
			System.out.println("Error!");
		}
	}
	
	public void deleteFlight(int id) {
		modelAP.flightRepo.delete(id);
	}
	
	boolean isPlaneExistInFlights(int id) {
		return modelAP.flightRepo.isPlaneExist(id);
	}
	
	public ArrayList<Flight> getFlightTable(){
		return modelAP.flightRepo.getTable();
	}
	
	public int getMaxFlightID() {
		return modelAP.flightRepo.getMaxID();
	}
}
