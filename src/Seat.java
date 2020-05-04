
public class Seat extends PlaneClass {
	
	String seatNum;
	int checkIn;
	classType travelClass;
	
	public Seat(int seatT, int sN) {
		switch(seatT) {
		case 1:
			travelClass = classType.FIRST;
			this.seatPrice = 1000;
			break;
		case 2:
			travelClass = classType.BUSINESS;
			this.seatPrice = 500;
			break;
		case 3:
			travelClass = classType.ECONOMY;
			this.seatPrice = 100;
			break;
		default:
			//exception
		}
		switch(sN) {
		case 1:
			seatNum = "A";
			break;
		case 2:
			seatNum = "B";
			break;
		case 3:
			seatNum = "C";
			break;
		case 4:
			seatNum = "D";
			break;
		default:
			//exception
		}
		checkIn = 0;
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
		if(getCheckIn()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
