package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import Controllers.FleetController;
import Controllers.FlightBoardController;
import Model.Flight;
import Model.Plane;
import Model.Repository.FleetRepositoryImpl;
import Model.Repository.FlightRepositoryImpl;

import javax.swing.JTable;

public class FlightSchedulePanel extends JPanel {
	private JTable FlightTable;
	private FlightTableModel flightModel;

	FlightRepositoryImpl rflight = new FlightRepositoryImpl();
	FleetRepositoryImpl rfleet = new FleetRepositoryImpl();
	FleetController fleetCtrl = new FleetController(rfleet);
	FlightBoardController flightCtrl = new FlightBoardController(rflight,rfleet);

	/**
	 * Create the panel.
	 */
	public FlightSchedulePanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		
		flightModel = new FlightTableModel();
		FlightTable = new JTable(flightModel);
		
		
		//FlightTable = new JTable();
		FlightTable.setBounds(77, 107, 684, 330);
		add(FlightTable);
		
	
		JLabel lblFlightBoard = new JLabel("Flight Board");
		lblFlightBoard.setBounds(303, 30, 230, 49);
		lblFlightBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightBoard.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblFlightBoard);
		
	    ArrayList<Flight> test2 = flightCtrl.getTable();
	    flightModel.setList(test2);
		
	}
}
