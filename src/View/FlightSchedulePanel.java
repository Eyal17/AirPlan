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
	private FlightRepositoryImpl rflight;
	private FleetRepositoryImpl rfleet;
	private FleetController fleetCtrl;
	private FlightBoardController flightCtrl;
	private JLabel lblFlightBoard;

	/**
	 * Create the panel.
	 */
	public FlightSchedulePanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		rflight = new FlightRepositoryImpl();
		rfleet = new FleetRepositoryImpl();
		fleetCtrl = new FleetController(rfleet);
		flightCtrl = new FlightBoardController(rflight,rfleet);

		initialize();
		
		buildTable();

	}
	
	public void initialize() {
		flightModel = new FlightTableModel();
		FlightTable = new JTable(flightModel);
		//FlightTable = new JTable();
		FlightTable.setBounds(77, 107, 684, 330);
		add(FlightTable);
	
		
		lblFlightBoard = new JLabel("Flight Board");
		lblFlightBoard.setBounds(303, 30, 230, 49);
		lblFlightBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightBoard.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblFlightBoard);
	}
	
	public void buildTable() {
	    ArrayList<Flight> test2 = flightCtrl.getTable();
	    flightModel.setList(test2);
	}
}
