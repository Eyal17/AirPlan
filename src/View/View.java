package View;

import Controllers.Controller;

public class View{
	

	public LogInPage login;
	public HomeBuilder homeBulider;
	private Controller viewCtrl;

	public void setViewCtrl(Controller ctrl) {
		this.viewCtrl = ctrl;
	}
	
	public void build() {
		login = new LogInPage(viewCtrl);
		homeBulider = new HomeBuilder(viewCtrl);
		login.setVisible(true);
		homeBulider.setVisible(false);

	}
}

