package Model;

import java.util.ArrayList;
import Controllers.FleetController;
import Model.Repository.FleetRepositoryImpl;


public class Plane extends Aircraft {
	final int planeID; 
	ArrayList<ArrayList<Seat>> seats;
	FleetRepositoryImpl fleetRep = new FleetRepositoryImpl();
	FleetController fleetCtrl = new FleetController(null, fleetRep);
	
	public Plane(String model, int id) {
		super(model);
		setSeats(rowsPerClass[0] + rowsPerClass[1] + rowsPerClass[2]);
		if(id == 0) {
			planeID = fleetCtrl.getMax() + 1;
		}
		else {
			planeID = id;
		}
	}
	
	public int getPlaneID() {
		return planeID;
	}
	
	// toString
//	public void print() {
//		System.out.println("name: " + this.getName());
//		System.out.println("fuel per KM: " + this.getFuelPerKm());
//		System.out.println("fuel tank size: " + this.getFuelTank());
//		System.out.println("number of rows: " + this.getnumOfRows());
//		System.out.println("plane ID: " + planeID);
//	}


	public void setSeats(int rows) {
		//int rows = numOfRows[0] + numOfRows[1] + numOfRows[2];
		ArrayList<Seat>[] seats =  new ArrayList[rows];
        for (int i = 0; i < rows; i++) { 
            seats[i] = new ArrayList<Seat>();
            if(i < rowsPerClass[0]) {
            		seats[i].add(new Seat("FIRST","A",0));
            		seats[i].add(new Seat("FIRST","B",0));
            }
            else if(i < (rowsPerClass[1]+rowsPerClass[0]) && i < rowsPerClass[2]) {
            		seats[i].add(new Seat("BUSINESS","A",0));
            		seats[i].add(new Seat("BUSINESS","B",0));
            		seats[i].add(new Seat("BUSINESS","C",0));
            }
            else {
            		seats[i].add(new Seat("ECONOMY","A",0));
            		seats[i].add(new Seat("ECONOMY","B",0));
            		seats[i].add(new Seat("ECONOMY","C",0));
            		seats[i].add(new Seat("ECONOMY","D",0));
            }
        } 
	}
	
	@Override
	public String toString() {
		return  "\nModel: " + this.getName() +
				"\nfuel per KM: " + this.getFuelPerKm() +
				"\nfuel tank size: " + this.getFuelTank() +
				"\nnumber of rows: " + this.getnumOfRows() +
				"\nplane ID: " + planeID;
	}

}

