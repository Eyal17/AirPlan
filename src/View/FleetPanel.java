package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import Controllers.FleetController;
import javax.swing.JTable;
import Model.Plane;
import Model.Repository.FleetRepositoryImpl;
import Model.Repository.FlightRepositoryImpl;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class FleetPanel extends JPanel implements ActionListener{
	
	/* Private variables we use in this page  */
	private JTable fleetTable;
	private FleetTableModel fleetModel;
	private JLabel lblAircraftFleet;
	private JScrollPane scrollPane;
	private JComboBox<String> planeChoice;
	private JButton addBtn;
	private JButton deleteBtn;
	private FleetRepositoryImpl fleetRep;
	private FlightRepositoryImpl flightRep;
	private FleetController fleetCtrl;

	/* Constructor uses functions to initialize the page */
	public FleetPanel() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		fleetRep = new FleetRepositoryImpl();
		flightRep = new FlightRepositoryImpl();
		fleetCtrl = new FleetController(flightRep, fleetRep);
		initialize();
		setListeners();
		buildTable();
	}
	
	/* A Function to initialize the graphical parameters in the page */
	public void initialize() {
		fleetModel = new FleetTableModel();
		//fleetTable = new JTable(fleetModel);
		fleetTable = new JTable(); // to design 

		
		/* AirCraft title parameters */ 
		lblAircraftFleet = new JLabel("AirCraft Fleet");
		lblAircraftFleet.setBounds(74, 23, 230, 49);
		lblAircraftFleet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAircraftFleet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblAircraftFleet);
		
		/* scrollPane parameters */ 

		scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 104, 245, 425);
		add(scrollPane);
		scrollPane.setViewportView(fleetTable);
		
		
		/* Choosing plane type combobox parameters */ 
		planeChoice = new JComboBox<String>();
		planeChoice.addItem("");
		planeChoice.addItem("727");
		planeChoice.addItem("737");
		planeChoice.setSelectedItem("");
		planeChoice.setSelectedIndex(0);
		planeChoice.setBounds(221, 566, 60, 22);
		add(planeChoice);
		
		
		/* Add button parameters */ 
		addBtn = new JButton("Add new plane");
		addBtn.setBounds(36, 566, 130, 23);
		add(addBtn);
		
		
		/* Delete button parameters */ 
		deleteBtn = new JButton("Delete plane");
		deleteBtn.setBounds(36, 621, 130, 23);
		add(deleteBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(493, 0, 535, 681);
		add(panel);
		
		JLabel refreshLbl = new JLabel("");
		Image refreshIcon = new ImageIcon(this.getClass().getResource("/refresh.png")).getImage();
		refreshLbl.setIcon(new ImageIcon(refreshIcon));
		refreshLbl.setBounds(329, 494, 35, 35);
		add(refreshLbl);
	}
	
	/*A Function to set all the listeners in the page */
	public void setListeners() { 
		addBtn.addActionListener(this);
		addBtn.setActionCommand("add plane");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete plane");
	}
	
	/*A Function to build the fleet table from the database */
	public void buildTable()
	{
		ArrayList<Plane> fleetArrayFromDB = fleetCtrl.getTable();
		fleetModel.setList(fleetArrayFromDB);
	}

	/*A Function for all of the actions performed buttons */
	@Override
	public void actionPerformed(ActionEvent e) {
		/* Add plane functionality when pressing the button */
		if(e.getActionCommand().equals("add plane")) {
			scrollPane.setVisible(false);
			String selectedBox = planeChoice.getSelectedItem().toString();
			scrollPane.setVisible(true);	
			if(selectedBox != ""){  /* Add plane functionality */
				fleetCtrl.addPlane(selectedBox);	
				buildTable();
				fleetTable.invalidate();
			}
			else { /* The user must choose a plane type */
				JOptionPane.showMessageDialog(null, "Please choose plane type. ");
			}
		
		}
		/* Delete plane functionality when pressing the button */
		if(e.getActionCommand().equals("delete plane")) {
			int selectedRow = -1;
			selectedRow = fleetTable.getSelectedRow();
			if (selectedRow != -1) {
				int p =  (int) fleetModel.getValueAt(selectedRow, 0);
				if (fleetCtrl.deletePlane(p)) {	
					buildTable();
					fleetTable.invalidate();
				}
				else {JOptionPane.showMessageDialog(null, "The plane is assigned to flights\nPlease delete the flights first.");}
			}
			else {JOptionPane.showMessageDialog(null, "Choose a plane to delete.");}
			fleetTable.repaint();	
		}
		fleetTable.clearSelection();
	}
}
