package Model.Repository;

public class ModelRepository {

	public AirportRepositoryImpl airportRepo;
	public FleetRepositoryImpl fleetRepo;
	public FlightRepositoryImpl flightRepo;
	
	public ModelRepository() {
		airportRepo = new AirportRepositoryImpl ();
		fleetRepo = new FleetRepositoryImpl();
		flightRepo = new FlightRepositoryImpl();
	}
}
