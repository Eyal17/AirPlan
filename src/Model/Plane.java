package Model;

import java.util.ArrayList;



public class Plane extends Aircraft {
	final int planeID; 
	ArrayList<Seat>[] seats;
	/* Constructor for plane */
	public Plane(String model, int id) {
		super(model);
		setSeats(rowsPerClass[0] + rowsPerClass[1] + rowsPerClass[2]); // Building a seat array template
		planeID = id;
	}
	
	/* Getters */
	public int getPlaneID() {
		return planeID;
	}
	

	/* A function to set up the seats arrangement in the plane */
	@SuppressWarnings("unchecked")
	void setSeats(int rows) {
		seats =  new ArrayList[rows];
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
	
	/* A function to create a string of the the plane details */
	@Override
	public String toString() {
		return  "\nModel: " + this.getName() +
				"\nfuel per KM: " + this.getFuelPerKm() +
				"\nfuel tank size: " + this.getFuelTank() +
				"\nnumber of rows: " + this.getnumOfRows() +
				"\nplane ID: " + planeID;
	}

}

