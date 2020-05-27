package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import Controllers.FleetController;
import Controllers.FlightBoardController;
import Model.Flight;
import Model.Plane;
import Model.Repository.FleetRepositoryImpl;
import Model.Repository.FlightRepositoryImpl;

import javax.swing.JTable;

public class FlightSchedulePanel extends JPanel implements ActionListener {
	
	private JTable FlightTable;
	private FlightTableModel flightModel;
	private FlightRepositoryImpl rflight;
	private FleetRepositoryImpl rfleet;
	private FleetController fleetCtrl;
	private FlightBoardController flightCtrl;
	private JLabel lblFlightBoard;
	private JScrollPane scrollPane;
	private JButton addBtn;
	private JButton deleteBtn;

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
		//add(FlightTable);
	
		
		lblFlightBoard = new JLabel("Flight Board");
		lblFlightBoard.setBounds(303, 30, 230, 49);
		lblFlightBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightBoard.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblFlightBoard);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 90, 554, 378);
		add(scrollPane);
		scrollPane.setViewportView(FlightTable);
		
		
		addBtn = new JButton("Add new flight");
		addBtn.setBounds(10, 118, 130, 23);
		add(addBtn);
		
		deleteBtn = new JButton("Delete plane");
		deleteBtn.setBounds(10, 173, 130, 23);
		add(deleteBtn);
	}
	
	public void setListeners() {
		addBtn.addActionListener(this);
		addBtn.setActionCommand("add flight");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete flight");
	}
	
	public void buildTable() {
	    ArrayList<Flight> test2 = flightCtrl.getTable();
	    flightModel.setList(test2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("add plane")) {
			scrollPane.setVisible(false);
			//String selectedBox = planeChoice.getSelectedItem().toString();
			//fleetCtrl.addPlane(selectedBox);	
			buildTable();
			FlightTable.invalidate();
			FlightTable.repaint();
			scrollPane.setVisible(true);
	}
	}
}
