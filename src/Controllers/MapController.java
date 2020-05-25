//package Controllers;
//import Model.Destination;
//import Model.Repository.DestinationRepository;
//import Model.Repository.DestinationRepositoryImpl;
//public class MapController {
//	private DestinationRepository repDest;
//	
//	public MapController(DestinationRepositoryImpl r){
//		repDest = r;
//	}
//	 public void addDest(String cityName, float dist){
//		 
//		Destination d = new Destination(cityName,dist);
//		repDest.add(d);
//	}
//	public void deleteDestination(String cityName){
//		repDest.delete(cityName);
//	}
//	public void print() {
//		repDest.print();
//	}
//	Destination searchDestination(String cityName) {
//		return repDest.find(cityName);
//	}
//}
