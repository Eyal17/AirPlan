package Model;
public class Destination {
	String country;
	double distFromBase;
	//coordinate
	public Destination(String c, double d) { //ctor
		country = c;
		distFromBase = d;
		
	}
	public String getCountry() {
		return country;
	}

	public double getDistFromBase() {
		return distFromBase;
	}	
}
