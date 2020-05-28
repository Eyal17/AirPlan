package Model;

public class Aircraft {
	String planeModel;
	int fuelTankSize;
	int maxKmPerFlight;
	int fuelPerKm;
	int speed;
	int []rowsPerClass = new int[3] ;//FIRST, BUSINESS, ECONOMY
	
	public Aircraft(String m) {
		switch(m) {
		case "727":
			planeModel = m;
			fuelTankSize = 150000;
			maxKmPerFlight = 15000;
			fuelPerKm = 10;
			speed = 900;
			setnumOfRows(4, 4, 20);
			break;
		case "737":
			planeModel = m;
			fuelTankSize = 200000;
			maxKmPerFlight = 20000;
			fuelPerKm = 10;
			speed = 1000;
			setnumOfRows(8, 8, 40);
			break;
		default:
			//throw/exception
			System.out.println("plane not exist");
		}
		
	};

	public String getName() {
		return planeModel;
	}
	public int getFuelTank() {
		return fuelTankSize;
	}
	public int getMaxKm() {
		return maxKmPerFlight;
	}
	public int getFuelPerKm() {
		return fuelPerKm;
	}
	public int getnumOfRows() {
		return rowsPerClass[0]+rowsPerClass[1]+rowsPerClass[2];
	}
	
	
	public void setName(String n) {
		planeModel = n;
	}
	public void setFuelTank(int f) {
		fuelTankSize = f;
	}
	public void setMaxKm(int m) {
		maxKmPerFlight = m;
	}
	public void setFuelPerKm(int f) {
		fuelPerKm = f;
	}
	public void setnumOfRows(int a,int b,int c) {
		rowsPerClass[0] = a;
		rowsPerClass[1] = b;
		rowsPerClass[2] = c;
	}
	
}
	
