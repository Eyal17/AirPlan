import java.awt.EventQueue;

import Controllers.*;
import Model.Repository.*;
import View.*;

public class Driver {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					ModelRepository model = new ModelRepository();
					View view = new View();
					Controller ctrl = new Controller(model, view);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
