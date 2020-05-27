package View;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Model.Plane;

public class FleetTableModel extends AbstractTableModel {

	private final String[] col = {"planeid", "model" };
	//private ArrayList<Plane> fleetList;  // tried to change to arraylist 
	private ArrayList<Plane> fleetList;

	@Override
	public int getRowCount() {
		return fleetList.size();
	}

	@Override
	public int getColumnCount() {
		return col.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp = null;
		if(columnIndex==0)
			temp= fleetList.get(rowIndex).getPlaneID();
		else temp= fleetList.get(rowIndex).getName();
		return temp;
	}

	public void setList(ArrayList<Plane> fleetReadyTable) {
		// TODO Auto-generated method stub
		fleetList = fleetReadyTable;
	}
}