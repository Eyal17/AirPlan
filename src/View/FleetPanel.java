package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import Controllers.Controller;

public class FleetPanel extends JPanel implements ActionListener{
	
	/* Private variables we use in this page  */
	private JTable fleetTable;
	private FleetTableModel fleetModel;
	private JLabel lblAircraftFleet;
	private JScrollPane scrollPane;
	private JComboBox<String> planeChoice;
	private JButton addBtn;
	private JButton deleteBtn;
	private Controller viewCtrl;

	/* Constructor uses functions to initialize the page */
	public FleetPanel(Controller ctrl) {
		
		viewCtrl = ctrl;
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 1028, 681);
		setLayout(null);

		initialize();
		setListeners();
		buildTable();
	}
	
	/* A Function to initialize the graphical parameters in the page */
	public void initialize() {
		fleetModel = new FleetTableModel();
		fleetTable = new JTable(fleetModel);
		//fleetTable = new JTable(); // to design 

		/* AirCraft title parameters */ 
		lblAircraftFleet = new JLabel("AirCraft Fleet");
		lblAircraftFleet.setBounds(74, 23, 230, 49);
		lblAircraftFleet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAircraftFleet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblAircraftFleet);
		
		/* scrollPane parameters */ 
		scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 104, 245, 425);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),4));
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane);
		scrollPane.setViewportView(fleetTable);
		fleetTable.getTableHeader().setBackground(new Color(37,114,162));
		fleetTable.getTableHeader().setForeground (Color.WHITE);
		fleetTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
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
		panel.setBounds(509, 0, 535, 681);
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
		fleetModel.setList(viewCtrl.getFleetTable());
		fleetTable.invalidate();
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
				viewCtrl.addPlane(selectedBox);
				//buildTable();
				
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
				viewCtrl.deletePlane(p);
				//buildTable(); // should do it from controller
			}
			else {JOptionPane.showMessageDialog(null, "Choose a plane to delete.");}
			fleetTable.repaint();	
		}
		fleetTable.clearSelection();
	}
}
