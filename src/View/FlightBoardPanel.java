package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

import Controllers.Controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;



public class FlightBoardPanel extends JPanel implements ActionListener {
	
	/* Private variables we use in this page  */

	private JTable flightTable;
	private JTable fleetTable;
	private FlightTableModel flightModel;
	private FleetTableModel fleetModel;
	
	private Controller viewCtrl;

	private JLabel lblFlightBoard;
	private JLabel lblPlaneTable;
	private JScrollPane scrollPane;
	private JButton addBtn;
	private JButton deleteBtn;
	private JScrollPane PlaneTable;
	private JComboBox<Integer> dayBox;
	private JComboBox<Integer>monthBox;
	private JComboBox<Integer>yearBox;
	private JLabel refLbl;
	private JComboBox<String> destinationComboBox;


	/* Constructor uses functions to initialize the page */
	public FlightBoardPanel(Controller ctrl) {
		
		viewCtrl = ctrl;
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		
		initialize();
		setListeners();
		buildFlightTable();
		buildFleetTable();
		//flightTable.setAutoCreateRowSorter(true);
	}
	
	/* A Function to initialize the graphical parameters in the page */
	public void initialize() {
		flightModel = new FlightTableModel();
		fleetModel = new FleetTableModel();
		
		flightTable = new JTable(flightModel);
		//flightTable = new JTable();//design
		
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
		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
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
		PlaneTable.setBackground(Color.WHITE);
		PlaneTable.getViewport().setBackground(Color.WHITE);
		PlaneTable.setBounds(787, 89, 188, 378);
		add(PlaneTable);
		PlaneTable.setViewportView(fleetTable);

		
		dayBox = new JComboBox<Integer>();
		for (int i = 0;i < 32;i++) {
			dayBox.addItem(i);
		}
		dayBox.setSelectedItem(0);
		dayBox.setBounds(580, 104, 57, 23);
		add(dayBox);
		
		monthBox = new JComboBox<Integer>();
		for (int i = 0;i < 13;i++) {
			monthBox.addItem(i);
		}
		monthBox.setSelectedItem(0);
		monthBox.setBounds(650, 104, 57, 23);
		add(monthBox);
		
		yearBox = new JComboBox<Integer>();
		yearBox.addItem(0);
		for (int i = 2020;i < 2030;i++) {
			yearBox.addItem(i);
		}
		yearBox.setSelectedItem(0);
		yearBox.setBounds(720, 104, 57, 23);
		add(yearBox);
		String [] destinationList = new String[] {"Choose a city", "New York","Sydney", "Rome", "Rio", "Cape Town", "Madrid", "Bangkok", "Delhi"};
		destinationComboBox = new JComboBox<String>();
		destinationComboBox.setBounds(580, 187, 116, 23);
		for (String i : destinationList) {
			destinationComboBox.addItem(i);
		}
		destinationComboBox.setSelectedIndex(0);
		add(destinationComboBox);
		
//		originComboBox = new JComboBox<String>();
//		originComboBox.setBounds(580, 153, 116, 23);
//		for (String i : destinationList) {
//			originComboBox.addItem(i);
//		}
//		originComboBox.setSelectedIndex(0);
//		add(originComboBox);
		
		
		/* A function to refresh the tables when pressing the button */
		refLbl = new JLabel("");
		refLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setVisible(false);
				buildFleetTable();
				buildFlightTable();
				scrollPane.setVisible(true);
			}
		});
		
		
		Image refreshIcon = new ImageIcon(this.getClass().getResource("/refresh.png")).getImage();
		refLbl.setIcon(new ImageIcon(refreshIcon));
		refLbl.setBounds(571, 449, 35, 35);
		add(refLbl);
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
	    flightModel.setList(viewCtrl.getFlightTable());
	    flightTable.invalidate();
	}
	
	/*A Function to build the fleet table from the database */
	public void buildFleetTable() {
		fleetModel.setList(viewCtrl.getFleetTable());
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
				if(destinationComboBox.getSelectedItem().equals("Choose a city")) {
					JOptionPane.showMessageDialog(null, "Select destination");
				}
				else if(dayBox.getSelectedItem().equals(0) | monthBox.getSelectedItem().equals(0) | yearBox.getSelectedItem().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please fill in full departure date");}
				else {
					int day = (int)dayBox.getSelectedItem();
					int dayAfter = day+1;
					int month = (int)monthBox.getSelectedItem();
					int year = (int)yearBox.getSelectedItem();
					String destination = destinationComboBox.getSelectedItem().toString();
					Date departureDate = new GregorianCalendar(year,month - 1,day).getTime();
					Date toOrigin = new GregorianCalendar(year,month - 1,dayAfter).getTime();					
					int planeID =  (int) fleetModel.getValueAt(selectedRow, 0); 
					String planeType = (String) fleetModel.getValueAt(selectedRow, 1); 
					double []cost = viewCtrl.getAirport(destination).calculator(planeType,planeID);
					viewCtrl.addFlight(planeID, destination, departureDate, toOrigin);
					fleetTable.clearSelection();
					JOptionPane.showMessageDialog(null, "Flight added succesfully!\nFlight details: \nDestination = " +
														destination + "\nDeparture date = " + departureDate +
							 							"\nRecommended price for each class:\nFirst = " + String.format("%.2f", cost[0]) +
														"\nBusiness = " + String.format("%.2f", cost[1]) +
														"\nEconomy = " + String.format("%.2f",cost[2]));
				}
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
				viewCtrl.deleteFlight(f);	
				//buildFlightTable();
			}
			else {
				JOptionPane.showMessageDialog(null, "Choose a flight to delete.");
			}
		}
		//fleetTable.clearSelection();
		flightTable.clearSelection();
		flightTable.repaint();
	}
	public JTable getFlightTable() {
		return flightTable;
	}
	public JTable getFleetTable() {
		return fleetTable;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
}
