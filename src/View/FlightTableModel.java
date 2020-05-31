package View;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Model.Flight;

public class FlightTableModel extends AbstractTableModel {

	private final String[] col = {"flightid", "planeid" };
	private List<Flight> flightList;
	
	/* A Function to return the amount of rows in the arrayList of planes */
	@Override
	public int getRowCount() {
		return flightList.size();
	}

	/* A Function to return the amount of cols which represent cols in the data base */
	@Override
	public int getColumnCount() {
		return col.length;
	}
	
	/* A Function to return the specific object from the database - number of row and which column */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp = null;
		if(columnIndex==0)
			temp= flightList.get(rowIndex).getFlightID();
		else if(columnIndex==1)
			temp= flightList.get(rowIndex).getPlane().getPlaneID();
		return temp;
	}
	/* A function to set the returned list to the table */
	public void setList(List<Flight> test3) {
		// TODO Auto-generated method stub
		this.flightList= test3;
	}
}
