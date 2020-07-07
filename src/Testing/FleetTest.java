package Testing;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Controllers.Controller;
import Model.Repository.ModelRepository;
import View.View;

class FleetTest {
	
	static ModelRepository model;
	static View view;
	static Controller ctrl;
	
	@BeforeAll
	public static void setup() {
		model = new ModelRepository();
		view = new View();
		ctrl = new Controller(model, view);
	}

	@Test
	public void addPlaneFailedWhenModelIsEmpty() {
		try {
			ctrl.addPlane(" ");
			Assertions.fail("Add plane success but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Model not exist", e.getMessage());
		}
	}
	
	@Test
	public void addPlaneFailedWhenModelIsInvalid() {
		try {
			ctrl.addPlane("777");
			Assertions.fail("Add plane success but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Model not exist", e.getMessage());
		}
	}
	
	@Test
	public void addPlaneFailedWhenModelIsJustBoeing() {
		try {
			ctrl.addPlane("Boeing");
			Assertions.fail("Add plane success but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Model not exist", e.getMessage());
		}
	}
	
	@Test
	public void setAircraftDetailsFailedWhenModelEmpty() {
		try {
			ctrl.setAircraftDetails("");
			Assertions.fail("Aircraft was set but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Model not exist", e.getMessage());
		}
	}
	
	@Test
	public void setAircraftDetailsFailedWhenModelInvalid() {
		try {
			ctrl.setAircraftDetails("727");
			Assertions.fail("Aircraft was set but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Model not exist", e.getMessage());
		}
	}
	

}
