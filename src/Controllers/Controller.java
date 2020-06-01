package Controllers;

public class Controller {
	 public FleetController fleetCtrl;
	 public FlightBoardController flightCtrl;
	 //public MapController mapCtrl;
	 //private View view;
//	 private ModelRepository model;
	 
	 public Controller(FleetController fleet, FlightBoardController flight, ModelRepository m, View v) {
		 fleetCtrl = fleet;
		 flightCtrl = flight;
//		 model = m;
//		 view = v;
	 }
}
