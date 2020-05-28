package Model;

public class Seat extends PlaneClass {
	
	String seatNum;
	int checkIn;
	classType travelClass;
	
	public Seat(String seatType, String seatN, int chkIn) {
		switch(seatType) {
		case "FIRST":
			travelClass = classType.FIRST;
			this.seatPrice = 1000;
			break;
		case "BUSINESS":
			travelClass = classType.BUSINESS;
			this.seatPrice = 500;
			break;
		case "ECONOMY":
			travelClass = classType.ECONOMY;
			this.seatPrice = 100;
			break;
		default:
			//exception
		}
		seatNum = seatN;
		checkIn = chkIn;
	}

	public String getSeatNum() {
		return seatNum;
	}
	public int getCheckIn() {
		return checkIn;
	}
	public void setSeatNum(String s) {
		seatNum = s;
	}
	public void setCheckIn(int c) {
		checkIn = c;
	}
	public void print() {
		System.out.println(travelClass + " class. Price: " + seatPrice + ". Number of seat: " + seatNum + ". Passenger: " + checkIn);
	}
	public boolean checkAvailability() {
		if(getCheckIn()==0) {return true;}
		else {return false;}
	}
}
