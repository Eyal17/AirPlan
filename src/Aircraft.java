
public class Aircraft {
	
	String name;
	int fuelTank;
	int maxKm;
	int fuelPerKm;
	int []numOfRows;//FIRST, BUSINESS, ECONOMY
	
	public Aircraft(String m) {
		numOfRows = new int [3];
		switch(m) {
		case "727":
			name = m;
			fuelTank = 150000;
			maxKm = 15000;
			fuelPerKm = 10;
			numOfRows = new int[]{4, 4, 20};
			break;
		case "737":
			name = m;
			fuelTank = 200000;
			maxKm = 20000;
			fuelPerKm = 10;
			numOfRows = new int[]{8, 8, 40};
			break;
		default:
			//throw/exception
			System.out.println("plane not exist");
		}
		
	};

	
	public String getName() {
		return name;
	}
	public int getFuelTank() {
		return fuelTank;
	}
	public int getMaxKm() {
		return maxKm;
	}
	public int getFuelPerKm() {
		return fuelPerKm;
	}
	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	
	public void setName(String n) {
		name = n;
	}
	public void setFuelTank(int f) {
		fuelTank = f;
	}
	public void setMaxKm(int m) {
		maxKm = m;
	}
	public void setFuelPerKm(int f) {
		fuelPerKm = f;
	}
	public void setNumOfSeats(int n) {
		numOfSeats = n;
	}
	
}
	
