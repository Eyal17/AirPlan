package Model.Repository;

import java.util.HashMap;
import java.util.Map;

import Model.Plane;

// the new one
public class FleetRepositoryImpl implements templateRepository<Integer, Plane> {
	Map<Integer,Plane> fleet = new HashMap<Integer,Plane>();
	@Override
	public void add(Plane v) {
		fleet.put(v.getPlaneID(), v);
	}
	@Override
	public void delete(Integer k) {
		fleet.remove(k);		
	}
	@Override
	public void print() {
		for(Map.Entry i: fleet.entrySet()) {
			System.out.println(i + "\n");
		}
	}
	@Override
	public Plane find(Integer k) {
		return fleet.get(k);
	}
}
