package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.SwingConstants;

import Controllers.FleetController;
import Controllers.FlightBoardController;
import Model.Flight;
import Model.Plane;
import Model.Repository.FleetRepositoryImpl;
import Model.Repository.FlightRepositoryImpl;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;

public class FlightBoardPanel extends JPanel implements ActionListener {
	
	private JTable flightTable;
	private JTable fleetTable;
	private FlightTableModel flightModel;
	private FlightRepositoryImpl rflight;
	private FleetRepositoryImpl rfleet;
	private FleetController fleetCtrl;
	private FleetTableModel fleetModel;
	private FlightBoardController flightCtrl;
	private JLabel lblFlightBoard;
	private JScrollPane scrollPane;
	private JButton addBtn;
	private JButton deleteBtn;
	private JTextField txtPlaneTable;
	private JScrollPane PlaneTable;
	private JComboBox<Integer> dayBox;
	private JComboBox<Integer>monthBox;
	private JComboBox<Integer>yearBox;

	/**
	 * Create the panel.
	 */
	public FlightBoardPanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		rflight = new FlightRepositoryImpl();
		rfleet = new FleetRepositoryImpl();
		fleetCtrl = new FleetController(rfleet);
		flightCtrl = new FlightBoardController(rflight,rfleet);

		initialize();
		setListeners();
		
		buildFlightTable();
		buildFleetTable();

	}
	
	public void initialize() {
		flightModel = new FlightTableModel();
		flightTable = new JTable(flightModel);
		//flightTable = new JTable();//design
		fleetModel = new FleetTableModel();
		fleetTable = new JTable(fleetModel);
		//fleetTable = new JTable();//design
				
		flightTable.setBounds(77, 107, 684, 330);

		lblFlightBoard = new JLabel("Flight Board");
		lblFlightBoard.setBounds(303, 30, 230, 49);
		lblFlightBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightBoard.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblFlightBoard);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 89, 368, 378);
		add(scrollPane);
		scrollPane.setViewportView(flightTable);
		
		
		addBtn = new JButton("Add new flight");
		addBtn.setBounds(10, 118, 130, 23);
		add(addBtn);
		
		deleteBtn = new JButton("Delete flight");
		deleteBtn.setBounds(10, 173, 130, 23);
		add(deleteBtn);
		
		PlaneTable = new JScrollPane();
		PlaneTable.setBounds(830, 89, 188, 378);
		add(PlaneTable);
		PlaneTable.setViewportView(fleetTable);

		
		txtPlaneTable = new JTextField();
		txtPlaneTable.setBackground(Color.WHITE);
		txtPlaneTable.setText("Plane Table");
		txtPlaneTable.setBounds(689, 40, 124, 39);
		add(txtPlaneTable);
		txtPlaneTable.setColumns(10);
		
		dayBox = new JComboBox<Integer>();
		for (int i = 1;i < 32;i++) {
			dayBox.addItem(i);
		}
		//dayBox.setSelectedIndex(0);
		dayBox.setBounds(580, 104, 57, 23);
		add(dayBox);
		
		monthBox = new JComboBox<Integer>();
		for (int i = 1;i < 13;i++) {
			monthBox.addItem(i);
		}
		//monthBox.setSelectedIndex(0);
		monthBox.setBounds(650, 104, 57, 23);
		add(monthBox);
		
		yearBox = new JComboBox<Integer>();
		for (int i = 2020;i < 2030;i++) {
			yearBox.addItem(i);
		}
		//yearBox.setSelectedIndex(0);
		yearBox.setBounds(720, 104, 57, 23);
		add(yearBox);
	}
	
	public void setListeners() {
		addBtn.addActionListener(this);
		addBtn.setActionCommand("add flight");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete flight");
	}
	
	public void buildFlightTable() {
	    flightModel.setList(flightCtrl.getTable());
	}
	
	public void buildFleetTable()
	{
		fleetModel.setList(fleetCtrl.getTable());
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("add flight")) {
			scrollPane.setVisible(false);
			int selectedRow = fleetTable.getSelectedRow();
			
			int day = (int)dayBox.getSelectedItem();
			int month = (int)monthBox.getSelectedItem();
			int year = (int)yearBox.getSelectedItem();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			//Date date = new Date();
		//	System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
			
			//System.out.println(day + " " +  month + " " + year);
			Date selectedBox = new GregorianCalendar(year,month - 1,day).getTime();
			System.out.println(dateFormat.format(selectedBox));
			
			int p =  (int) fleetModel.getValueAt(selectedRow, 0);
			flightCtrl.addFlight(p);	
			buildFlightTable();
			flightTable.invalidate();
			scrollPane.setVisible(true);
	}
		if(e.getActionCommand().equals("delete flight")) {
			int selectedRow = -1;
			selectedRow = flightTable.getSelectedRow();
			if (selectedRow != -1) {
				int f =  (int) flightModel.getValueAt(selectedRow, 0);
				//System.out.println(p);
				flightCtrl.deleteFlight(f);	
				buildFlightTable();
			}
		}
		flightTable.repaint();
	}
}
