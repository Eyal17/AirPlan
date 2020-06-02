//package Controllers;
//
//import java.util.ArrayList;
//
//import Model.Plane;
//import Model.Repository.FleetRepositoryImpl;
//import Model.Repository.FlightRepositoryImpl;
//import Model.Repository.ModelRepository;
//import View.View;
//
//
//
//public class FleetController {
//
//	private ModelRepository model1;
//	private View view;
//	
//	//public FleetController(FlightRepositoryImpl r, FleetRepositoryImpl s) { // add view
//	public FleetController(ModelRepository m, View v) { // add view
//		model1 = m;
//		view = v;
//		model.fleetRepo.add(p);
//	}
//	
//	 public void addPlane(String model){
//		Plane p = new Plane(model,0);
//		model1.fleetRepo.add(p);
//	}
//	public boolean deletePlane(int id){
//		if(flightRepo.isPlaneExist(id)) {
//			return false;
//		}
//		else {
//			fleetRepo.delete(id);
//			return true;
//		}
//	}
//	
////	public void print() {
////		repFleet.print();
////	}
//	
//	public ArrayList<Plane> getTable(){
//		return fleetRepo.getTable();
//	}
//	
//	public int getMax() {
//		return fleetRepo.getMaxID();
//	}
//
//}
