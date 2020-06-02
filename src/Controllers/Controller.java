package Controllers;

import View.View;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Airport;
import Model.Flight;
import Model.Plane;
import Model.Repository.ModelRepository;

public class Controller {
	 
	 private View view;
	 private ModelRepository modelAP;
	 
	 public Controller(ModelRepository m, View v) {
		 modelAP = m;
		 view = v;
	 }
	 
	 public void addPlane(String model) {
		int pID =modelAP.fleetRepo.getMaxID()+1;
		Plane p = new Plane(model,pID);
		modelAP.fleetRepo.add(p);
	}
	 
	public void deletePlane(int id){
		if(modelAP.flightRepo.isPlaneExist(id)) {
			JOptionPane.showMessageDialog(null, "The plane is assigned to flights\nPlease delete the flights first.");
		}
		else {
			modelAP.fleetRepo.delete(id);
		}
	}
	
	public ArrayList<Plane> getFleetTable() {
		return modelAP.fleetRepo.getTable();
	}
	
	public void addFlight(int planeID, String origin, String dest) {
		int fID = modelAP.flightRepo.getMaxID()+1;
		Plane p = modelAP.fleetRepo.find(planeID);
		if(p != null) {
			Airport o = new Airport(origin);
			Airport d = new Airport(dest);

			Flight f = new Flight(p,fID, o, d);
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
	public void loginValidation(String user,String password) {
		if (password.equals(modelAP.loginRepo.valid(user))) {
			view.login.setVisible(false);
			view.homeBulider.setVisible(true);
		}
		else { JOptionPane.showMessageDialog(null, "Failed!");}
	}

}
