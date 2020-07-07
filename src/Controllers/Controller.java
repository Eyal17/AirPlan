package Controllers;

import View.View;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import Model.Aircraft;
import Model.Airport;
import Model.Flight;
import Model.Plane;
import Model.Repository.ModelRepository;

public class Controller {
	 
	 private View view; // A variable to access the view panels
	 private ModelRepository modelAP; // A variable to access the model repositories
	 
	 public Controller(ModelRepository m, View v) {
		 modelAP = m;
		 view = v;
	 }
	 
	 /* A function to add a new plane to the database */
	 public void addPlane(String model) {
		int pID =modelAP.fleetRepo.getMaxID()+1;
		Plane p = new Plane(model,pID);
		modelAP.fleetRepo.add(p);
		view.homeBulider.fleetPanel.buildTable(); // table recreation
	}
	 /* A function to delete a plane to the database */
	public void deletePlane(int id){
		if(modelAP.flightRepo.isPlaneExist(id)) {
			JOptionPane.showMessageDialog(null, "The plane is assigned to flights\nPlease delete the flights first.");
		}
		else {
			modelAP.fleetRepo.delete(id);
		}
		view.homeBulider.fleetPanel.buildTable();
	}
	
	public ArrayList<Plane> getFleetTable() {
		return modelAP.fleetRepo.getTable();
	}
	
	 /* A function to add a new flight to the database */
	public void addFlight(int planeID, String dest, Date depart, Date toorigin) {
		int fID = modelAP.flightRepo.getMaxID()+1;
		Plane p = modelAP.fleetRepo.find(planeID);
		if(p != null) {
			Airport d = new Airport(dest);
			Flight f = new Flight(p,fID, d,depart,toorigin);
			modelAP.flightRepo.add(f);
			view.homeBulider.flightBoardPanel.buildFlightTable();
		}
		else {
			System.out.println("Error!");
		}
	}
	
	 /* A function to delete a flight from the database */
	public void deleteFlight(int id) {
		modelAP.flightRepo.delete(id);
	}
	/* A function to check if a plane exists in a flight - to avoid deleting a plane that contains flights */
	boolean isPlaneExistInFlights(int id) {
		return modelAP.flightRepo.isPlaneExist(id);
	}
	
	public ArrayList<Flight> getFlightTable(){
		return modelAP.flightRepo.getTable();
	}
	
	/* A function to validate login + encryption */ 
	public void loginValidation(String user,char[] password) {
		String encryptedPassword = "";
		for (char i : password) {
			encryptedPassword += (char)(i + user.hashCode()%26); // encrypting with hashcode
			encryptedPassword += (char)(i + user.hashCode()%20); // encrypting with hashcode
		}
		if (encryptedPassword.equals(modelAP.loginRepo.valid(user))) {
			view.login.setVisible(false);
			view.homeBulider.setVisible(true);
		}
		else { JOptionPane.showMessageDialog(null, "Failed!");}
	}
	
	/* A function to return the airport chosen */
	public Airport getAirport(String airport) {
		return new Airport(airport);
	}
	
	/* A function to load aircraft updated details to screen */
	public void setAircraftDetails(String aircraft) {
		Aircraft a = new Aircraft(aircraft);
		view.homeBulider.fleetPanel.SpeedTextField.setText(Integer.toString(a.getSpeed()));
		view.homeBulider.fleetPanel.FuelTextField.setText(Integer.toString(a.getFuelPerKm()));
		view.homeBulider.fleetPanel.KmTextField.setText(Integer.toString(a.getMaxKm()));
		view.homeBulider.fleetPanel.TankTextField.setText(Integer.toString(a.getFuelTank()));
		view.homeBulider.fleetPanel.modelTextField.setText(a.getName());

	}

}
