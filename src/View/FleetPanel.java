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
import java.awt.Cursor;

import Controllers.Controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FleetPanel extends JPanel implements ActionListener {
	
	/* Private variables we use in this page  */
	private JTable fleetTable;
	private FleetTableModel fleetModel;
	private JLabel lblAircraftFleet;
	private JScrollPane scrollPane;
	private JComboBox<String> planeChoice;
	private JButton addBtn;
	private JButton deleteBtn;
	private Controller viewCtrl;
	private JLabel refreshLbl;
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
		planeChoice.addItem("Boeing 777");
		planeChoice.addItem("Boeing 737");
		planeChoice.addItem("Airbus A380");
		planeChoice.addItem("Boeing 787");
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
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBounds(509, 0, 519, 681);
		add(detailsPanel);
		detailsPanel.setVisible(false);
	
		
		refreshLbl = new JLabel("refreshLbl");
		refreshLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setVisible(false);
				buildTable();
				scrollPane.setVisible(true);
			}
		});
		Image refreshIcon = new ImageIcon(this.getClass().getResource("/refresh.png")).getImage();
		refreshLbl.setIcon(new ImageIcon(refreshIcon));
		refreshLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refreshLbl.setBounds(329, 494, 35, 35);
		add(refreshLbl);
		
		JLabel detailsBtn = new JLabel("New label");
		detailsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = -1;
				selectedRow = fleetTable.getSelectedRow();
				if (selectedRow != -1) {
					detailsPanel.setVisible(true);
				}
				else
					detailsPanel.setVisible(false);
				fleetTable.clearSelection();
			}
		});
		detailsBtn.setBounds(287, 625, 66, 29);
		add(detailsBtn);
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
	public JTable getFleetTable() {
		return fleetTable;
	}
}
