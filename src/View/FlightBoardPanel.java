package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.SwingConstants;
import Controllers.FleetController;
import Controllers.FlightBoardController;
import Model.Repository.FleetRepositoryImpl;
import Model.Repository.FlightRepositoryImpl;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FlightBoardPanel extends JPanel implements ActionListener {
	
	/* Private variables we use in this page  */

	private JTable flightTable;
	private JTable fleetTable;
	private FlightTableModel flightModel;
	private FlightRepositoryImpl rflight;
	private FleetRepositoryImpl rfleet;
	private FleetController fleetCtrl;
	private FleetTableModel fleetModel;
	private FlightBoardController flightCtrl;
	private JLabel lblFlightBoard;
	private JLabel lblPlaneTable;
	private JScrollPane scrollPane;
	private JButton addBtn;
	private JButton deleteBtn;
	private JTextField txtPlaneTable;
	private JScrollPane PlaneTable;
	private JComboBox<Integer> dayBox;
	private JComboBox<Integer>monthBox;
	private JComboBox<Integer>yearBox;

	/* Constructor uses functions to initialize the page */

	public FlightBoardPanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		rflight = new FlightRepositoryImpl();
		rfleet = new FleetRepositoryImpl();
		fleetCtrl = new FleetController(rflight,rfleet);
		flightCtrl = new FlightBoardController(rflight,rfleet);
		initialize();
		setListeners();
		buildFlightTable();
		buildFleetTable();

	}
	
	/* A Function to initialize the graphical parameters in the page */
	public void initialize() {
		flightModel = new FlightTableModel();
		
		flightTable = new JTable(flightModel);
		//flightTable = new JTable();//design
		
		fleetModel = new FleetTableModel();
		
		fleetTable = new JTable(fleetModel);
		//fleetTable = new JTable();//design
				
		flightTable.setBounds(77, 107, 684, 330);

		
		/* Flight Board title parameters */ 
		lblFlightBoard = new JLabel("Flight Board");
		lblFlightBoard.setBounds(303, 30, 230, 49);
		lblFlightBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightBoard.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblFlightBoard);
		
		/* Plane Table title parameters */ 
		lblPlaneTable = new JLabel("Plane Table");
		lblPlaneTable.setBounds(773, 35, 220, 39);
		lblPlaneTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaneTable.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblPlaneTable);
		
		/* scrollPane parameters */ 
		scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 89, 368, 378);
		add(scrollPane);
		scrollPane.setViewportView(flightTable);
		
		/* Add button parameters */ 
		addBtn = new JButton("Add new flight");
		addBtn.setBounds(10, 118, 130, 23);
		add(addBtn);
		
		
		/* Delete button parameters */
		deleteBtn = new JButton("Delete flight");
		deleteBtn.setBounds(10, 173, 130, 23);
		add(deleteBtn);
		
		/* scrollPane for PlaneTable parameters */
		PlaneTable = new JScrollPane();
		PlaneTable.setBounds(787, 89, 188, 378);
		add(PlaneTable);
		PlaneTable.setViewportView(fleetTable);

		
		/* Building Date object for new flights */
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
	
	/*A Function to set all the listeners in the page */
	public void setListeners() {
		addBtn.addActionListener(this);
		addBtn.setActionCommand("add flight");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete flight");
	}
	
	/*A Function to build the flight table from the database */
	public void buildFlightTable() {
	    flightModel.setList(flightCtrl.getTable());
	}
	
	/*A Function to build the fleet table from the database */
	public void buildFleetTable()
	{
		fleetModel.setList(fleetCtrl.getTable());
	}

	
	/*A Function for all of the actions performed buttons */
	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedRow = -1; /* A var to indicate which row in the table was chosen by the user */
		/* Add flight functionality when pressing the button */
		if(e.getActionCommand().equals("add flight")) {
			scrollPane.setVisible(false);
			selectedRow = fleetTable.getSelectedRow();
			scrollPane.setVisible(true);
	
			if (selectedRow != -1) { /* Add flight functionallity */
				int day = (int)dayBox.getSelectedItem();
				int month = (int)monthBox.getSelectedItem();
				int year = (int)yearBox.getSelectedItem();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				//Date date = new Date();
		     	//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43	
				//System.out.println(day + " " +  month + " " + year);
				Date selectedBox = new GregorianCalendar(year,month - 1,day).getTime();
				System.out.println(dateFormat.format(selectedBox));
				int p =  (int) fleetModel.getValueAt(selectedRow, 0);
				flightCtrl.addFlight(p);	
				buildFlightTable();
				flightTable.invalidate();
			}
			else { /* The user must choose a plane to add a flight */
				JOptionPane.showMessageDialog(null, "Choose a plane in order to create a flight!");
			}
		}
		
		/* Delete flight functionality when pressing the button */
		if(e.getActionCommand().equals("delete flight")) {
			selectedRow = flightTable.getSelectedRow();
			if (selectedRow != -1) {
				int f =  (int) flightModel.getValueAt(selectedRow, 0);
				flightCtrl.deleteFlight(f);	
				buildFlightTable();
			}
			else {
				JOptionPane.showMessageDialog(null, "Choose a flight to delete.");
			}
		}
		fleetTable.clearSelection();
		flightTable.clearSelection();
		flightTable.repaint();
	}
}
