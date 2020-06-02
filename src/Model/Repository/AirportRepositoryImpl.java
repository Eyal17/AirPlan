package Model.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Model.Airport;

public class AirportRepositoryImpl implements TemplateRepository<String, Airport> {
	Map<String,Airport> airports = new HashMap<String,Airport>();
	@Override
	public void add(Airport v) {
		airports.put(v.getCountry(), v);
	}
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
