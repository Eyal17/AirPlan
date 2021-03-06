package View;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Model.Plane;

@SuppressWarnings("serial")
public class FleetTableModel extends AbstractTableModel {

	private final String[] col = {"Plane ID", "Plane Model" };
	private ArrayList<Plane> fleetList;

	/* A Function to return the amount of rows in the arrayList of planes */
	@Override
	public int getRowCount() {
		return fleetList.size();
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
			temp= fleetList.get(rowIndex).getPlaneID();
		else temp= fleetList.get(rowIndex).getName();
		return temp;
	}

	/* A function to set the returned list to the table */
	public void setList(ArrayList<Plane> fleetReadyTable) {
		fleetList = fleetReadyTable;
	}
	/* A function to return the column name from the table */

	public String getColumnName(int c) {
		return col[c];
	}
}