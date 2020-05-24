import java.util.*;

import Controllers.FleetController;
import Controllers.FlightBoardController;
import Model.Plane;
import Model.Repository.FleetRepositorylmpl;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Seat a = new Seat(2,1,1,1);
		//a.print();
		//a.setCheckIn(4);
		//a.setSeatNum(3);
		//a.print();
		//Plane b = new Plane("727");
		//Plane c = new Plane("737");
		FleetRepositorylmpl r = new FleetRepositorylmpl();
		FleetController fleetCtrl = new FleetController(r);
		fleetCtrl.addPlane("727");
		fleetCtrl.print();
		System.out.println("**************\n");
		fleetCtrl.addPlane("737");
		fleetCtrl.print();
		fleetCtrl.deletePlane(1);
		System.out.println("**************\n");
		fleetCtrl.print();
		//fleetCtrl.addPlane("727");
		//fleetCtrl.print();


		//FlightBoardController flightCtrl = new FlightBoardController();
		//Plane a = new Plane("727");
		//a.print();
		//Date a = new Date();
		//System.out.println(a);
	}
}
