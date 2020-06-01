package Model.Repository;

public class ModelRepository {

	public final AirportRepositoryImpl airportRepo;
	public final FleetRepositoryImpl fleetRepo;
	public final FlightRepositoryImpl flightRepo;
	public final LoginRepository loginRepo;
	
	public ModelRepository() {
		airportRepo = new AirportRepositoryImpl();
		fleetRepo = new FleetRepositoryImpl();
		flightRepo = new FlightRepositoryImpl();
		loginRepo = new LoginRepository();
	}
}
