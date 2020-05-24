package Controllers;

import Model.Plane;
import Model.Repository.FleetRepository;
import Model.Repository.FleetRepositorylmpl;


public class FleetController {

	private FleetRepository repFleet;
	
	public FleetController(FleetRepositorylmpl r){
		repFleet = r;
	}
	
	 public void addPlane(String model){
		if (model != "727" && model != "737") {
			// throw exepction
			System.out.println(model + " not correct");
		}
		else {
			Plane p = new Plane(model);
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
