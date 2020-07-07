package Model.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Model.Airport;

 	/* A repository for Airport, using a repository template */
public class AirportRepositoryImpl implements TemplateRepository<String, Airport> {
	Map<String,Airport> airports = new HashMap<String,Airport>(); // Data structure to hold airport object by names
	/* A function to add a new airport */
	@Override
	public void add(Airport v) {
		airports.put(v.getCountry(), v);
	}
	/* A function to delete a airport */

	@Override
	public void delete(String k) {
		airports.remove(k);
	}
	
	@Override
	public ArrayList<Airport> getTable() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getMaxID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
