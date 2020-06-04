package View;

import Controllers.Controller;

public class View{
	
	//public HomePanel homePanel;
	//public FleetPanel fleetPanel;
	//public FlightBoardPanel flightBoardPanel;
	//public MapControllerPanel mapPanel;
	
	public LogInPage login;
	public HomeBuilder homeBulider;
	
	private Controller viewCtrl;
	
//	public View() {
//		// maybe need to delete ctor
//		//
//		//
//	
//	}
	
	// instead of Observable!
	public void setViewCtrl(Controller ctrl) {
		this.viewCtrl = ctrl;
	}
	
	public void build() {
		login = new LogInPage(viewCtrl);
		homeBulider = new HomeBuilder(viewCtrl);
		
		login.setVisible(true);
		homeBulider.setVisible(false);
//		login.setVisible(false); 		// FOR TESTS
//		homeBulider.setVisible(true);  // FOR TESTS
	}
}

