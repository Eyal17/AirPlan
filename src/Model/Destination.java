package Model;
public class Destination {
	String country;
	int distFromBase;
	
	/* A constructor for destination */
	public Destination(String c) { 
		country = c;		
	}
	/* Getters for Destination class */
	public String getCountry() {
		return country;
	}
	
	public double getDistance() {
		return distFromBase;
	}	
}
