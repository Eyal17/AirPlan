package Model.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Airport;
import Model.Flight;
import Model.Plane;

public class FlightRepositoryImpl implements TemplateRepository<Integer, Flight> {

	/* A function to add a new flight to the database */
	@Override
	public void add(Flight v) {		
		String query = "INSERT INTO flightboard(flightid,planeid,destination,departure,toorigin)" + "VALUES (" + 
				v.getFlightID() + "," + 
				v.getPlane().getPlaneID() +",'"+  
				v.getDest()+ "','{" +
				v.getDeparture() + "}','{"+
				v.getToOrigin() +"}')";
				//v.getDeparture().getDate() + "," +
				//(v.getDeparture().getMonth()+1) + "," +
				//(v.getDeparture().getYear()+1900) + "}')";
		DBManager.getInstance().addToDB(query);
	}
	/* A function to delete a flight from the database */
	@Override
	public void delete(Integer id) {
		String query = "DELETE from flightboard WHERE flightboard.flightid=" + id;
		DBManager.getInstance().deleteFromDB(query);
	}

	/* A function to check if a plane exists in the database */
	public boolean isPlaneExist(int pID) {
		String query = "SELECT * from flightboard WHERE flightboard.planeid =" + pID;
		try {
			ResultSet result = DBManager.getInstance().readFromDB(query);
			if (result.next()) // check if there are flights with this plane id
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void checkIn()
	{
		
	}
	@Override
	public ArrayList<Flight> getTable() {
		ResultSet resultSet;
		ArrayList<Flight> flightsList = new ArrayList<Flight>();

		try {
			resultSet = DBManager.getInstance().readFromDB("SELECT * from flightboard join fleet using(planeid) ORDER BY departure ASC");
			while (resultSet.next()) { //.next() return true if we have more result + move to the next result (row)
					Flight flight = new Flight(new Plane(resultSet.getString(6),
							resultSet.getInt(1)),
							resultSet.getInt(2),
							new Airport(resultSet.getString(3)),
							resultSet.getDate(4), 
							resultSet.getDate(5));
					flightsList.add(flight);
			}
		} catch (SQLException e) {
			System.out.println("Error in reading from DB!");
			e.printStackTrace();
		}
		return flightsList;
	}
	
	/* A function to return the current maximum ID for flights that exists in the database, to avoid ID duplication  */
	public int getMaxID(){
		ResultSet resultSet = null;
		int max = 0;
		try {
			resultSet = DBManager.getInstance().readFromDB("SELECT max(flightid) from flightboard");
			resultSet.next();
			max = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(max == 0) {
			return 4999; // a number to indicate that there are no current flights
		}
		return max;
	}	
}