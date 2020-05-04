import java.util.*;
import java.util.ArrayList;

public class Flight {
	static int flightID = 1000;
	//int distance;
	//double cost;
	Plane plane;
	Date arrival;
	Date departure;
	//ArrayList<Seat> passengers;
	Airport origin;
	Airport dest;
	
	public Flight(Plane p, Date a, Date d, Airport orig, Airport des) {
		plane = p;
		arrival = a;
		departure = d;
		origin = orig;
		dest = des;
		flightID++;
		//passengers = plane.seats;
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
	
	
}
