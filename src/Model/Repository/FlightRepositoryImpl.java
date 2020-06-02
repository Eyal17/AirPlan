package Model.Repository;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import Model.Airport;
import Model.Flight;
import Model.Plane;

public class FlightRepositoryImpl implements TemplateRepository<Integer, Flight> {

	@Override
	public void add(Flight v) {
		//flights.put(v.getFlightID(), v);
		
		String query = "INSERT INTO flightboard(flightid,planeid,destination,departure)" + "VALUES (" + 
				v.getFlightID() + "," + 
				v.getPlane().getPlaneID() +",'"+  
				v.getDest()+ "','{" +
				v.getDeparture() + "}')";
				//v.getDeparture().getDate() + "," +
				//(v.getDeparture().getMonth()+1) + "," +
				//(v.getDeparture().getYear()+1900) + "}')";
		DBManager.getInstance().addToDB(query);
	}
	@Override
	public void delete(Integer id) {
		//flights.remove(id);		
		String query = "DELETE from flightboard WHERE flightboard.flightid=" + id;
		System.out.println(id);
		DBManager.getInstance().deleteFromDB(query);
	}

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
		//
		
		
		// here we need to split to load from db for the first time and update the list after each func
		// get table shuold take only the list
		
		//
		try {
			resultSet = DBManager.getInstance().readFromDB("SELECT * from flightboard join fleet using(planeid)");
			while (resultSet.next()) { //.next() return true if we have more result + move to the next result (row)
					Date date = resultSet.getDate(4);
					//Date d = new GregorianCalendar((TimeZone) date).getTime();
					System.out.println(date);
					//int day = (int) date.getArray(0,1);
					//System.out.println(day);
					Flight flight = new Flight(new Plane(resultSet.getString(5),
							resultSet.getInt(1)),
							resultSet.getInt(2),
							new Airport(resultSet.getString(3)),
							resultSet.getDate(4));
							//new GregorianCalendar(date).getTime());
					flightsList.add(flight);
			}
		} catch (SQLException e) {
			System.out.println("Error in reading from DB!");
			e.printStackTrace();
		}
		return flightsList;
	}
	
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
			return 4999;
		}
		return max;
	}
	
	
	
	
}