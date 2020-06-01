package Model.Repository;

public class ModelRepository {

	public AirportRepositoryImpl airportRepo;
	public FleetRepositoryImpl fleetRepo;
	public FlightRepositoryImpl flightRepo;
	public LoginRepository loginRepo;
	
	public ModelRepository() {
		airportRepo = new AirportRepositoryImpl ();
		fleetRepo = new FleetRepositoryImpl();
		flightRepo = new FlightRepositoryImpl();
		loginRepo = new LoginRepository();
	}
}
