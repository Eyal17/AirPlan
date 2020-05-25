package Controllers;

import Model.Plane;
import Model.Repository.templateRepository;
import Model.Repository.FleetRepositoryImpl;


public class FleetController {

	private templateRepository<Integer, Plane> repFleet;
	
	public FleetController(FleetRepositoryImpl r){
		repFleet = r;
	}
	
	 public void addPlane(String model){
		if (model != "727" && model != "737") {
			// throw exepction
			System.out.println(model + " not correct");
		}
		else {
			Plane p = new Plane(model,0);
			repFleet.add(p);
		}
	}
	public void deletePlane(int id){
		repFleet.delete(id);
	}
	
	public void print() {
		repFleet.print();
	}
	
}
