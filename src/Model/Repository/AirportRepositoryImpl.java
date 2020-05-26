package Model.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Model.Airport;

public class AirportRepositoryImpl implements templateRepository<String, Airport> {
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
	public void print() {
		for(Map.Entry i: airports.entrySet()) {
			System.out.println(i + "\n");
		}
	}
	@Override
	public Airport find(String k) {
		return airports.get(k);
	}
	@Override
	public ArrayList<Airport> getTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
