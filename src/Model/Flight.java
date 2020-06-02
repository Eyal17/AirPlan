package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Flight {
	int flightID;
	int distance;
	double cost;
	Plane plane;
	//Date arrival;
	Date departure;
	//Airport origin;
	Airport dest;
	ArrayList<Seat>[] passengers;
	
	public Flight(Plane p,int id, Airport des, Date d) {//Date arv) {
		plane = p;
		//arrival = arv;
		departure = d;
		//origin = orig;
		dest = des;
		//distance = origin.distFromBase + dest.distFromBase;
		flightID = id;
		passengers = plane.seats;
	}
	
	public Plane getPlane() {
		return plane;
	}

	public Date getDeparture() {
		return departure;
	}


	public String getDest() {
		return dest.getCountry();
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
