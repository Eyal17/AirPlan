import java.util.*;

import Controllers.FleetController;
import Controllers.FlightBoardController;
import Model.Plane;
import Model.Repository.FleetRepositorylmpl;
import Model.Repository.FlightRepositorylmpl;

@SuppressWarnings("unused")
public class Main {
	public static int flightCounter = 1000;
	public static void main(String[] args) {
		FleetRepositorylmpl r = new FleetRepositorylmpl();
		FleetController fleetCtrl = new FleetController(r);
		FlightRepositorylmpl f = new FlightRepositorylmpl();
		FlightBoardController flightCtrl = new FlightBoardController(f, r);
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		while(true) {
			System.out.println("Press 1 for check In. \nPress 2 for Fleet Board.\nPress 3 for Flight Board.\nPress 0 to exit");
			int choose = myObj.nextInt();  // Read user input
			switch (choose) {
			  case 1:
			  {
					 System.out.println("Here is the Fleet menu.\n");
					 System.out.println("Press 1 to add a new plane. \nPress 2 to delete an existing plane.");
					 int c1 = myObj.nextInt(); 
					 switch (c1) {
					  case 1:
						    // System.out.println("adding a plane");
						  	//adding new plane function
					    break;
					  case 2:
						     //deleting a plane function
					    break;
					}
			    break;
			  }
			  case 2:
					 System.out.println("Here is the fleet menu.\n");
					 System.out.println("Press 1 to add a new flight. \nPress 2 to delete an existing flight. \nPress 3 to search a flight. \nPress 4 to edit flight.\nPress 5 to print");
					 int c2 = myObj.nextInt(); 
					 switch (c2) {
					  case 1:
						  
						    System.out.println("choose 1 for 727\nchoose 2 for 737");
						    int mod = myObj.nextInt();
						    if (mod == 1) {
						    	fleetCtrl.addPlane("727");
						    }
						    else if(mod == 2){
						    	fleetCtrl.addPlane("737");
						    }
						    else {
						    	System.out.println("Invalid!");
						    	break;
						    }
						    System.out.println("Added succefully!");
					    break;
					  case 2:
						  	System.out.println("its our fleet, lets delete a flight");
						  	fleetCtrl.print();
						  	System.out.println("which airplane would you like to delete?\nPlease choose the plane ID");
						  	int id = myObj.nextInt();
							fleetCtrl.deletePlane(id);
							System.out.println("Plane number " + id + " Succesfully deleted!\n");
					    break;
					  case 3:
						     //searching a plane function
					    break;
					  case 4:
						     //editing a plane function
					    break;
					  case 5:
						fleetCtrl.print();
					}
			    break;
			  case 3:
					 System.out.println("Here is the flight Board menu.\n");
					 System.out.println("Press 1 to add flight.\nPress 2 to delete flight.\nPress 3 to print flight board.\n");
					 int c3 = myObj.nextInt(); 
					 switch (c3) {
					  case 1:
						  	System.out.println("Which airplane would you like to assign?\nPlease enter plane ID.\n");
						  	fleetCtrl.print();
						  	int id = myObj.nextInt();
							flightCtrl.addFlight(id);
							System.out.println("Flight added!\n");
					    break;
					 }
			    break;
			  case 0:
			  default:
					  System.out.println("Goodbye!");
					  System.exit(0);
			 }
		}
		
		//FleetRepositorylmpl r = new FleetRepositorylmpl();
		//FleetController fleetCtrl = new FleetController(r);
		//FlightRepositorylmpl f = new FlightRepositorylmpl();
		//FlightBoardController flightCtrl = new FlightBoardController(f, r);
		//fleetCtrl.addPlane("727");
		//fleetCtrl.print();
		//System.out.println("**************\n");
		//fleetCtrl.addPlane("737");
		//fleetCtrl.print();
		//fleetCtrl.deletePlane(1);
		//System.out.println("**************\n");
		//fleetCtrl.print();
//		flightCtrl.addFlight(1);
		//fleetCtrl.addPlane("727");
		//fleetCtrl.print();
		

		//FlightBoardController flightCtrl = new FlightBoardController();
		//Plane a = new Plane("727");
		//a.print();
		//Date a = new Date();
		//System.out.println(a);
	}
}
