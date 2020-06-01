package Model;

import java.util.ArrayList;
import java.util.Date;

public class Flight {
	int flightID;
	int distance;
	double cost;
	Plane plane;
	Date arrival;
	Date departure;
	Airport origin;
	Airport dest;
	ArrayList<Seat>[] passengers;
	
	public Flight(Plane p,int id) {//Date arv,Airport orig, Airport des) {
		plane = p;
		//arrival = arv;
		//departure = d;
		//origin = orig;
		//dest = des;
		//distance = origin.distFromBase + dest.distFromBase;
		flightID = id;
		passengers = plane.seats;
	}
	
	public Plane getPlane() {
		return plane;
	}
	public Date getArrival() {
		return arrival;
	}
	public Date getDeparture() {
		return departure;
	}
	public Airport getOrigin() {
		return origin;
	}
	public Airport getDest() {
		return dest;
	}
	public int getFlightID() {
		return flightID;
	}
	
	public void setPlane(Plane p) {
		plane = p;
	}
	public void setArrival(Date a) {
		arrival = a;
	}
	public void setDeparture(Date d) {
		departure = d;
	}
	public void setOrigin(Airport o) {
		origin = o;
	}
	public void setDest(Airport d) {
		dest = d;
	}
	
	@Override
	public String toString() {
		return "Flight [flightID=" + flightID + ", plane=" + plane + ", passengers=" + passengers + "]";
	}
	
	Date getFlightDuration() {
		//Date time = arrival + distance*plane.speed;
		return arrival; // return time
	
	}
}
