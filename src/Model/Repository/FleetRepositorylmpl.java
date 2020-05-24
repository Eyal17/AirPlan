package Model.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Plane;

public class FleetRepositorylmpl implements FleetRepository {
	
	Map<Integer,Plane> fleet = new HashMap<Integer,Plane>();
	@Override
	public void add(Plane p) {
		fleet.put(p.getPlaneID(), p);
	}

	@Override
	public void delete(int id) {
		fleet.remove(id);
	}

	@Override
	public void print() {
		for(Map.Entry i: fleet.entrySet()) {
			System.out.println(i + "\n");
			
		}
	}

	@Override
	public Plane find(int id) {
		return fleet.get(id);
	}
	

}
