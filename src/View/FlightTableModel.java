package View;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Model.Flight;

public class FlightTableModel extends AbstractTableModel {

	private final String[] col = {"Flight ID", "Plane ID","From","To"};
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
		switch (columnIndex)
		{
		case 0:
			temp= flightList.get(rowIndex).getFlightID();
			break;
		case 1:
			temp= flightList.get(rowIndex).getPlane().getPlaneID();
			break;
		case 2:
			temp= flightList.get(rowIndex).getOrigin();
			break;
		case 3:
			temp= flightList.get(rowIndex).getDest();
			break;
		default: break;
		}
		return temp;
	}
	/* A function to set the returned list to the table */
	public void setList(List<Flight> flightReadyTable) {
		this.flightList= flightReadyTable;
	}
	
	public String getColumnName(int c) {
		return col[c];
	}
}
