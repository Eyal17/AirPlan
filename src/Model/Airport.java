package Model;

public class Airport extends Destination {
	int localTax;
	double fuelPrice;
	
	public Airport(int tax, int fuelP, String c, double d) {
		super(c,d);
		localTax = tax;
		fuelPrice = fuelP;
	}
	
	public int getLocalTax() {
		return localTax;
	}
	public double getFuelPrice() {
		return fuelPrice;
	}
	
	public void setLocalTax(int l) {
		localTax = l;
	}
	public void setFuelPrice(double f) {
		fuelPrice = f;
	}
	
	//public double calculator() {
		//fuelprice, localtax,distfrombase,plane(fuelTank ,maxKm,fuelPerKm,numOfSeats)
		//dist = 1000
		//fuelprice = 10
		//localtax = 200
		//plane 727(fuelTank = 150000;
		//maxKm = 15000;
		//fuelPerKm = 10;
		//numOfSeats = 100;)
		//((dist*fuelperkm) * fuelprice + localTa) \ numOfSeats = minimum price for a ticket
	//}
}
