package Testing;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Controllers.Controller;
import Model.Repository.ModelRepository;
import View.View;

class FlightTest {
	
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
	public void addFlightFailedWhenDestIsEmpty() {
		try {
			ctrl.addFlight(1001,"", new GregorianCalendar(2020,2-1,1).getTime(),new GregorianCalendar(2020,2 - 1,2).getTime());
			Assertions.fail("add flight success but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Destination invalid!", e.getMessage());
		}
	}
	
	@Test
	public void addFlightFailedWhenDestIsNotExist() {
		try {
			ctrl.addFlight(1001,"Haifa", new GregorianCalendar(2020,2-1,1).getTime(),new GregorianCalendar(2020,2 - 1,2).getTime());
			Assertions.fail("add flight success but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Destination invalid!", e.getMessage());
		}
	}
	
	@Test
	public void addFlightFailedWhenPlaneNotExist() {
		try {
			ctrl.addFlight(1,"Rio", new GregorianCalendar(2020,2-1,1).getTime(),new GregorianCalendar(2020,2 - 1,2).getTime());
			Assertions.fail("add flight success but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Model not exist", e.getMessage());
		}
	}
	
	@Test
	public void getAirportFailedWhenDestIsNotExist() {
		try {
			ctrl.getAirport("Haifa");
			Assertions.fail("get airport success but should be failed");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("Destination invalid!", e.getMessage());
		}
	}
	
}
