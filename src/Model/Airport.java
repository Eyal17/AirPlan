package Model;

public class Airport extends Destination {
	int localTax;
	double fuelPrice;
	int distFromBase;

	public Airport(String city) {
		super(city);
		switch(city){ 
			case "New York":
			{
				localTax = 1000;
				fuelPrice =  50;
				distFromBase = 9109;
				break;
			}
			case "Sydney":
			{
				localTax = 1500;
				fuelPrice =  60;
				distFromBase = 14171;
				break;
			}
			case "Rome":
			{
				localTax = 800;
				fuelPrice =  80;
				distFromBase = 4044;
				break;
			}
			case "Rio":
			{
				localTax = 500;
				fuelPrice =  30;
				distFromBase = 10281;
				break;
			}
			case "Johannesburg":
			{
				localTax = 750;
				fuelPrice =  70;
				distFromBase = 9220;
				break;
			}
			case "Tel Aviv":
			{
				localTax = 2200;
				fuelPrice =  7000000;
				distFromBase = 0;
				break;
			}
			default: break;
		}	
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
	
	//public double calculator(Plane p) {
		//fuelprice, localtax,distfrombase,plane(fuelTank ,maxKm,fuelPerKm,numOfSeats)
		//dist = 1000
		//fuelprice = 10
		//localtax = 200
		//plane 727(fuelTank = 150000;
		//maxKm = 15000;
		//fuelPerKm = 10;
		//numOfSeats = 100;)
		//if (p.name == "727"){
		//	cost = ((this.distFromBase*p.getFuelPerKm()) * fuelprice + localTax) / 100 // = minimum price for a ticket
		//}
		//else if(p.name == "737"){
		//	cost = ((this.distFromBase*p.getFuelPerKm()) * fuelprice + localTax) / 200 // = minimum price for a ticket
		//}
		//return cost;
	//}
}
