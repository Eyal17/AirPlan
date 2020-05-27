package Model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Controllers.FleetController;
import Controllers.FlightBoardController;
import Model.Repository.FleetRepositoryImpl;
import Model.Repository.FlightRepositoryImpl;


public class Flight {
	int flightID;
	//int distance;
	//double cost;
	Plane plane;
	//Date arrival;
	//Date departure;
	//Airport origin;
	//Airport dest;
	ArrayList<ArrayList<Seat>> passengers;
	FlightRepositoryImpl flightRep = new FlightRepositoryImpl();
	FleetRepositoryImpl fleetRep = new FleetRepositoryImpl();
	FlightBoardController flightCtrl = new FlightBoardController(flightRep, fleetRep);
	
	public Flight(Plane p,int id) {//, Date a, Date d, Airport orig, Airport des) {
		plane = p;
		//arrival = a;
		//departure = d;
		//origin = orig;
		//dest = des;
		if (id == 0) {
			flightID = (flightCtrl.getMax()) + 1;
		}
		else{
			flightID = id;
		}
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
