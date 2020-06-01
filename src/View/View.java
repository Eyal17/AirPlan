package View;

public class View {
	
	//public HomePanel homePanel;
	//public FleetPanel fleetPanel;
	//public FlightBoardPanel flightBoardPanel;
	//public MapControllerPanel mapPanel;
	
	public LogInPage login;
	public HomeBuilder homeBulider;
	
	public View() {
		login = new LogInPage();
		homeBulider = new HomeBuilder();
		

		login.setVisible(true);
		homeBulider.setVisible(false);
	
	}
}

