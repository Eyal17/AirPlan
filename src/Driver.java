import java.awt.EventQueue;

import Controllers.*;
import Model.Repository.*;
import View.*;

public class Driver {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelRepository model = new ModelRepository();
					View view = new View();
					Controller ctrl = new Controller(model, view);
					view.setViewCtrl(ctrl);
					view.build();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
