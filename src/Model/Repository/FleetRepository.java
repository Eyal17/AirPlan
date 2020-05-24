package Model.Repository;

import Model.Plane;

public interface FleetRepository {
	public void add(Plane p);
	public void delete(int id);
	public void print();
}
