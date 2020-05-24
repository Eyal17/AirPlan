package Model;
import java.util.ArrayList;


public class Plane extends Aircraft {
	final int planeID; 
	ArrayList<ArrayList<Seat>> seats;
	
	public Plane(String model) {
		super(model);
		setSeats(numOfRows[0] + numOfRows[1] + numOfRows[2]);
		planeID = random.nextInt(9999)+1000;
	}
	
	public int getPlaneID() {
		return planeID;
	}
	
	// toString
	public void print() {
		System.out.println("name: " + this.getName());
		System.out.println("fuel per KM: " + this.getFuelPerKm());
		System.out.println("fuel tank size: " + this.getFuelTank());
		System.out.println("number of rows: " + this.getnumOfRows());
		System.out.println("plane ID: " + planeID);
	}


	public void setSeats(int rows) {
		//int rows = numOfRows[0] + numOfRows[1] + numOfRows[2];
		ArrayList<Seat>[] seats = new ArrayList[rows];
        for (int i = 0; i < rows; i++) { 
            seats[i] = new ArrayList<Seat>();
            if(i < numOfRows[0]) {
            	for(int j = 1; j < 3; j++) {
            		seats[i].add(new Seat(1,j));
            	}
            }
            else if(i < (numOfRows[1]+numOfRows[0]) && i < numOfRows[2]) {
            	for(int j = 1; j < 4; j++) {
            		seats[i].add(new Seat(2,j));
            	}
            }
            else {
            	for(int j = 1; j < 5; j++) {
            		seats[i].add(new Seat(3,j));
            	}
            }
        } 

  
        //for (int i = 0; i < rows; i++) { 
        //	System.out.print("Row number " + (i+1) + "\n");
          //  for (int j = 0; j < seats[i].size(); j++) { 
            //	seats[i].get(j).print();
            //} 
            //System.out.print("\n");
        //}
	}
	
	@Override
	public String toString() {
		return  "\nModel: " + this.getName() +
				"\nfuel per KM: " + this.getFuelPerKm() +
				"\nfuel tank size: " + this.getFuelTank() +
				"\nnumber of rows: " + this.getnumOfRows() +
				"\nplane ID: " + planeID;
	}

}

