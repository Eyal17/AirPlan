package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
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
public class AircrafeFleetPanel extends JPanel implements ActionListener{
	
	private JTable FleetTable;
	private FleetTableModel fleetModel;
	private JLabel lblAircraftFleet;
	private JScrollPane scrollPane;
	private JComboBox planeChoice;
	private JButton btnNewButton;
	private JButton deleteBtn;

	private FleetRepositoryImpl r;
	private FleetController fleetCtrl; 

	public AircrafeFleetPanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		r = new FleetRepositoryImpl();
		fleetCtrl = new FleetController(r);
		initialize();
		setListeners();
		buildTable();
	}
	
	public void initialize() {
		fleetModel = new FleetTableModel();
		FleetTable = new JTable(fleetModel);
		//FleetTable = new JTable(); // to design 

		
		lblAircraftFleet = new JLabel("AirCraft Fleet");
		lblAircraftFleet.setBounds(303, 30, 230, 49);
		lblAircraftFleet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAircraftFleet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblAircraftFleet);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 90, 554, 378);
		add(scrollPane);
		scrollPane.setViewportView(FleetTable);
		
		planeChoice = new JComboBox();
		planeChoice.addItem("");
		planeChoice.addItem("727");
		planeChoice.addItem("737");
		planeChoice.setSelectedItem("");
		planeChoice.setSelectedIndex(0);
		planeChoice.setBounds(150, 118, 60, 22);
		add(planeChoice);
		
		btnNewButton = new JButton("Add new plane");
		btnNewButton.setBounds(10, 118, 130, 23);
		add(btnNewButton);
		
		deleteBtn = new JButton("Delete plane");
		deleteBtn.setBounds(10, 173, 130, 23);
		add(deleteBtn);
	}
	
	public void setListeners() {
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("add plane");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete plane");
	}
	
	public void buildTable()
	{
		ArrayList<Plane> fleetArrayFromDB = fleetCtrl.getTable();
		fleetModel.setList(fleetArrayFromDB);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("add plane")) {
			scrollPane.setVisible(false);
			String selectedBox = planeChoice.getSelectedItem().toString();
			fleetCtrl.addPlane(selectedBox);	
			buildTable();
			FleetTable.invalidate();
			scrollPane.setVisible(true);	
		}
		if(e.getActionCommand().equals("delete plane")) {
			//scrollPane.setVisible(false);
			int selectedRow = -1;
			selectedRow = FleetTable.getSelectedRow();
			if (selectedRow != -1) {
				System.out.println("what are you doing here?!?!?");
				int p =  (int) fleetModel.getValueAt(selectedRow, 0);
				//System.out.println(p);
				fleetCtrl.deletePlane(p);	
				buildTable();
				//selectedRow = -1;
			//	FleetTable.invalidate();
				//scrollPane.setVisible(true);
			}
			FleetTable.repaint();

		}
		
	}
}
