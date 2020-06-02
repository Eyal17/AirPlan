package Model;
public class Destination {
	String country;
	int distFromBase;
	//coordinate
	public Destination(String c) { //ctor
		country = c;
	//	distFromBase = d;
		
	}
	public String getCountry() {
		return country;
	}

	public double getDistFromBase() {
		return distFromBase;
	}	
}
