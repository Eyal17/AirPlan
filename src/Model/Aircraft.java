package Model;

public class Aircraft {
	String planeModel;
	int fuelTankSize;
	int maxKmPerFlight;
	int fuelPerKm;
	int speed;
	int []rowsPerClass = new int[3] ;//FIRST, BUSINESS, ECONOMY
	String pictureName;
	
	/* A constructor to build an aircraft with different parameters per plane */
	public Aircraft(String m) {
		switch(m) {
		case "Boeing 777":
			planeModel = m;
			fuelTankSize = 150000;
			maxKmPerFlight = 15000;
			fuelPerKm = 10;
			speed = 900;
			setnumOfRows(4, 4, 20);
			pictureName = "Image777";
			break;
		case "Boeing 737":
			planeModel = m;
			fuelTankSize = 200000;
			maxKmPerFlight = 20000;
			fuelPerKm = 10;
			speed = 1000;
			setnumOfRows(8, 8, 40);
			pictureName = "Image737";
			break;
		case "Boeing 787":
			planeModel = m;
			fuelTankSize = 250000;
			maxKmPerFlight = 30000;
			fuelPerKm = 10;
			speed = 1000;
			setnumOfRows(8, 8, 40);
			pictureName = "Image787";
			break;
		case "Airbus A380":
			planeModel = m;
			fuelTankSize = 300000;
			maxKmPerFlight = 35000;
			fuelPerKm = 10;
			speed = 1500;
			setnumOfRows(8, 8, 40);
			pictureName = "ImageA380";
			break;
		default:
			//throw/exception
			System.out.println("plane not exist");
		}
		
	};
	
	/* Getters for Aircraft class */
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
	public int getSpeed() {
		return speed;
	}
	public String getPictureName() {
		return pictureName;
	}
	public int getnumOfRows() {
		return rowsPerClass[0]+rowsPerClass[1]+rowsPerClass[2];
	}
	public int[] getRowsPerClass() {
		return rowsPerClass;
	}
	
	/* Setters for Aircraft class */
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
	
