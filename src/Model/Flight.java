package Model;
import java.util.ArrayList;
import java.util.Date;


public class Flight {
	public static int flightCounter = 1000;
	int flightID;
	//int distance;
	//double cost;
	Plane plane;
	//Date arrival;
	//Date departure;
	ArrayList<ArrayList<Seat>> passengers;
	//Airport origin;
	//Airport dest;
	
	public Flight(Plane p) {//, Date a, Date d, Airport orig, Airport des) {
		plane = p;
		//arrival = a;
		//departure = d;
		//origin = orig;
		//dest = des;
		flightID = flightCounter++;
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
	
	
}
