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
				fuelPrice =  3;
				distFromBase = 9109;
				break;
			}
			case "Sydney":
			{
				localTax = 1500;
				fuelPrice =  3.2;
				distFromBase = 14171;
				break;
			}
			case "Rome":
			{
				localTax = 800;
				fuelPrice =  3.1;
				distFromBase = 4044;
				break;
			}
			case "Rio":
			{
				localTax = 500;
				fuelPrice =  2.7;
				distFromBase = 10281;
				break;
			}
			case "Cape Town":
			{
				localTax = 750;
				fuelPrice =  2.9;
				distFromBase = 9220;
				break;
			}
			case "Madrid":
			{
				localTax = 600;
				fuelPrice =  3;
				distFromBase = 5464;
				break;
			}
			case "Bangkok":
			{
				localTax = 550;
				fuelPrice =  2.6;
				distFromBase = 6924;
				break;
			}
			case "Delhi":
			{
				localTax = 350;
				fuelPrice =  2.5;
				distFromBase = 4048;
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
	
	public double getDistance() {
		return distFromBase;
	}
	
	public void setLocalTax(int l) {
		localTax = l;
	}
	public void setFuelPrice(double f) {
		fuelPrice = f;
	}
	
	
	
	public double[] calculator(String model,int planeId) {
		Plane p = new Plane(model,planeId);
		double []cost = {0,0,0};
		cost[0] = ((((distFromBase*p.getFuelPerKm()) * fuelPrice) + localTax) * 0.2) / (p.getRowsPerClass()[0]*2); //calculation for first class  ( 2 seats in a row)
		cost[1] = ((((distFromBase*p.getFuelPerKm()) * fuelPrice) + localTax) * 0.2) / (p.getRowsPerClass()[1]*3); //calculation for business class ( 3 seats in a row)
		cost[2] = ((((distFromBase*p.getFuelPerKm()) * fuelPrice) + localTax) * 0.6) / (p.getRowsPerClass()[2]*4); //calculation for economy class ( 4 seats in a row)
		return cost;
	}
}
