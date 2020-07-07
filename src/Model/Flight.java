package Model;

import java.util.ArrayList;
import java.util.Date;

public class Flight {
	int flightID;
	int distance;
	double cost;
	Plane plane;
	Date toOrigin;
	Date departure;
	Airport dest;
	ArrayList<Seat>[] passengers;
	
	/* A constructor for Flight */
	public Flight(Plane p,int id, Airport des, Date d1, Date d2) {
		plane = p;
		departure = d1;
		toOrigin = d2;
		dest = des;
		flightID = id;
		passengers = plane.seats;
	}
	
	/* Getters for flight class */
	public Plane getPlane() {
		return plane;
	}

	public Date getDeparture() {
		return departure;
	}
	
	public Date getToOrigin() {
		return toOrigin;
	}

	public String getDest() {
		return dest.getCountry();
	}
	public int getFlightID() {
		return flightID;
	}
	
	/* Setters for flight class */
	public void setPlane(Plane p) {
		plane = p;
	}

	public void setDeparture(Date d) {
		departure = d;
	}
	public void setDest(Airport d) {
		dest = d;
	}
	
	@Override
	public String toString() {
		return "Flight [flightID=" + flightID + ", plane=" + plane + ", passengers=" + passengers + "]";
	}
}
