package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controllers.FleetController;
import Controllers.FlightBoardController;

import javax.swing.JTable;

import Model.Plane;
import Model.Repository.DBManager;
import Model.Repository.FleetRepositoryImpl;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FleetPanel extends JPanel implements ActionListener{
	
	/* Private variables we use in this page  */
	private JTable FleetTable;
	private FleetTableModel fleetModel;
	private JLabel lblAircraftFleet;
	private JScrollPane scrollPane;
	private JComboBox<String> planeChoice;
	private JButton addBtn;
	private JButton deleteBtn;
	private FleetRepositoryImpl r;
	private FleetController fleetCtrl; 

	/* Constructor uses functions to initialize the page */
	public FleetPanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		r = new FleetRepositoryImpl();
		fleetCtrl = new FleetController(r);
		initialize();
		setListeners();
		buildTable();
	}
	
	/* A Function to initialize the graphical parameters in the page */
	public void initialize() {
		fleetModel = new FleetTableModel();
		FleetTable = new JTable(fleetModel);
		//FleetTable = new JTable(); // to design 

		
		/* AirCraft title parameters */ 
		lblAircraftFleet = new JLabel("AirCraft Fleet");
		lblAircraftFleet.setBounds(303, 30, 230, 49);
		lblAircraftFleet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAircraftFleet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblAircraftFleet);
		
		/* scrollPane parameters */ 

		scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 90, 554, 378);
		add(scrollPane);
		scrollPane.setViewportView(FleetTable);
		
		
		/* Choosing plane type combobox parameters */ 
		planeChoice = new JComboBox<String>();
		planeChoice.addItem("");
		planeChoice.addItem("727");
		planeChoice.addItem("737");
		planeChoice.setSelectedItem("");
		planeChoice.setSelectedIndex(0);
		planeChoice.setBounds(150, 118, 60, 22);
		add(planeChoice);
		
		
		/* Add button parameters */ 
		addBtn = new JButton("Add new plane");
		addBtn.setBounds(10, 118, 130, 23);
		add(addBtn);
		
		
		/* Delete button parameters */ 
		deleteBtn = new JButton("Delete plane");
		deleteBtn.setBounds(10, 173, 130, 23);
		add(deleteBtn);
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
				FleetTable.invalidate();
			}
			else { /* The user must choose a plane type */
				JOptionPane.showMessageDialog(null, "Please choose plane type. ");
			}
		
		}
		/* Delete plane functionality when pressing the button */
		if(e.getActionCommand().equals("delete plane")) {
			int selectedRow = -1;
			selectedRow = FleetTable.getSelectedRow();
			if (selectedRow != -1) {
				int p =  (int) fleetModel.getValueAt(selectedRow, 0);
				fleetCtrl.deletePlane(p);	
				buildTable();
				FleetTable.invalidate();
			}
			else {
				JOptionPane.showMessageDialog(null, "Choose a plane to delete.");
			}
			FleetTable.repaint();

		}
		
	}
}
