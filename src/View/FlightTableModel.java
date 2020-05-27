package View;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import Model.Flight;
import Model.Plane;

public class FlightTableModel extends AbstractTableModel {

	private final String[] col = {"flightid", "planeid" };
	private List<Flight> flightList;
	
	@Override
	public int getRowCount() {
		return flightList.size();
	}

	@Override
	public int getColumnCount() {
		return col.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp = null;
		if(columnIndex==0)
			temp= flightList.get(rowIndex).getFlightID();
		else if(columnIndex==1)
			temp= flightList.get(rowIndex).getPlane().getPlaneID();
		return temp;
	}

	public void setList(List<Flight> test3) {
		// TODO Auto-generated method stub
		this.flightList= test3;
	}
}
