package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;
import Controllers.Controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class FleetPanel extends JPanel {
	
	/* Private variables we use in this page  */
	private JTable fleetTable;
	private FleetTableModel fleetModel;
	private JLabel lblAircraftFleet;
	private JScrollPane scrollPane;
	private JComboBox<String> planeChoice;
//	private JButton addBtn;
//	private JButton deleteBtn;
	private Controller viewCtrl;
	private JLabel refreshLbl;
	private JLabel FuelTankSizeLbl;
	private JLabel KmRangeLbl;
	private JLabel fuelKmLbl;
	private JLabel speedLbl;
	public JLabel addPlaneLbl;
	public JLabel deletePlaneLbl;
	public JTextField SpeedTextField;
	public JTextField FuelTextField;
	public JTextField KmTextField;
	public JTextField TankTextField;
	public JTextField modelTextField;
	public JLabel planePhotoLbl;



	/* Constructor uses functions to initialize the page */
	public FleetPanel(Controller ctrl) {
		
		viewCtrl = ctrl;
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 1028, 681);
		setLayout(null);

		initialize();
		//setListeners();
		buildTable();
	}
	
	/* A Function to initialize the graphical parameters in the page */
	public void initialize() {
		
		Image refreshIcon = new ImageIcon(this.getClass().getResource("/refresh.png")).getImage();
		Image detailsIcon = new ImageIcon(this.getClass().getResource("/info.png")).getImage();
		Image addIcon = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		Image deleteIcon = new ImageIcon(this.getClass().getResource("/remove.png")).getImage();
		Image Image737 = new ImageIcon(this.getClass().getResource("/737.jpg")).getImage();
		Image Image777 = new ImageIcon(this.getClass().getResource("/777.jpg")).getImage();
		Image Image787 = new ImageIcon(this.getClass().getResource("/787.jpg")).getImage();
		Image ImageA380 = new ImageIcon(this.getClass().getResource("/A380.jpg")).getImage();

		fleetModel = new FleetTableModel();
		fleetTable = new JTable(fleetModel);
//		fleetTable = new JTable(); // to design 

		/* AirCraft title parameters */ 
		lblAircraftFleet = new JLabel("AirCraft Fleet");
		lblAircraftFleet.setBounds(80, 30, 230, 49);
		lblAircraftFleet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAircraftFleet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblAircraftFleet);
		
		/* scrollPane parameters */ 
		scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 104, 245, 425);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),4));
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setViewportView(fleetTable);
		fleetTable.getTableHeader().setBackground(new Color(37,114,162));
		fleetTable.getTableHeader().setForeground (Color.WHITE);
		fleetTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(scrollPane);
		
		
		/* Choosing plane type combobox parameters */ 
		planeChoice = new JComboBox<String>();
		planeChoice.addItem("");
		planeChoice.addItem("Boeing 777");
		planeChoice.addItem("Boeing 737");
		planeChoice.addItem("Airbus A380");
		planeChoice.addItem("Boeing 787");
		planeChoice.setSelectedItem("");
		planeChoice.setSelectedIndex(0);
		planeChoice.setBounds(375, 120, 111, 22);
		add(planeChoice);
		
		
//		/* Add button parameters */ 
//		addBtn = new JButton("Add new plane");
//		addBtn.setBounds(36, 566, 130, 23);
//		add(addBtn);
//		
//		
//		/* Delete button parameters */ 
//		deleteBtn = new JButton("Delete plane");
//		deleteBtn.setBounds(36, 621, 130, 23);
//		add(deleteBtn);
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBounds(509, 0, 519, 681);
		add(detailsPanel);
		detailsPanel.setLayout(null);
		
		SpeedTextField = new JTextField();
		SpeedTextField.setBounds(291, 634, 157, 25);
		detailsPanel.add(SpeedTextField);
		SpeedTextField.setColumns(10);
		
		JLabel aircraftInfoLbl = new JLabel("Aircraft Information:");
		aircraftInfoLbl.setFont(new Font("Stencil", Font.BOLD, 31));
		aircraftInfoLbl.setBounds(57, 390, 403, 39);
		detailsPanel.add(aircraftInfoLbl);
		
		JLabel modelLbl = new JLabel("Model:");
		modelLbl.setFont(new Font("Stencil", Font.PLAIN, 20));
		modelLbl.setBounds(78, 467, 75, 25);
		detailsPanel.add(modelLbl);
		
		FuelTankSizeLbl = new JLabel("Tank Size:");
		FuelTankSizeLbl.setFont(new Font("Stencil", Font.PLAIN, 20));
		FuelTankSizeLbl.setBounds(78, 508, 115, 25);
		detailsPanel.add(FuelTankSizeLbl);
		
		KmRangeLbl = new JLabel("KM Range:");
		KmRangeLbl.setFont(new Font("Stencil", Font.PLAIN, 20));
		KmRangeLbl.setBounds(78, 549, 115, 25);
		detailsPanel.add(KmRangeLbl);
		
		fuelKmLbl = new JLabel("Fuel Per Km:");
		fuelKmLbl.setFont(new Font("Stencil", Font.PLAIN, 20));
		fuelKmLbl.setBounds(78, 592, 157, 25);
		detailsPanel.add(fuelKmLbl);
		
		speedLbl = new JLabel("Speed:");
		speedLbl.setFont(new Font("Stencil", Font.PLAIN, 20));
		speedLbl.setBounds(78, 633, 75, 25);
		detailsPanel.add(speedLbl);
		
		FuelTextField = new JTextField();
		FuelTextField.setColumns(10);
		FuelTextField.setBounds(291, 593, 157, 25);
		detailsPanel.add(FuelTextField);
		
		KmTextField = new JTextField();
		KmTextField.setColumns(10);
		KmTextField.setBounds(291, 550, 157, 25);
		detailsPanel.add(KmTextField);
		
		TankTextField = new JTextField();
		TankTextField.setColumns(10);
		TankTextField.setBounds(291, 509, 157, 25);
		detailsPanel.add(TankTextField);
		
		modelTextField = new JTextField();
		modelTextField.setColumns(10);
		modelTextField.setBounds(291, 468, 157, 25);
		detailsPanel.add(modelTextField);
		
		planePhotoLbl = new JLabel("");
		planePhotoLbl.setIcon(new ImageIcon(Image737));
		planePhotoLbl.setBounds(103, 81, 310, 215);
		detailsPanel.add(planePhotoLbl);
		detailsPanel.setVisible(false);
	
		
		refreshLbl = new JLabel("refreshLbl");
		refreshLbl.setIcon(new ImageIcon(refreshIcon));
		refreshLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refreshLbl.setBounds(329, 235, 30, 30);
		add(refreshLbl);
		
		JLabel detailsBtn = new JLabel("");
		detailsBtn.setIcon(new ImageIcon(detailsIcon));
		detailsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		detailsBtn.setBounds(329, 195, 30, 30);
		add(detailsBtn);
		
		/*add button */
		addPlaneLbl = new JLabel("");
		addPlaneLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addPlaneLbl.setIcon(new ImageIcon(addIcon));
		addPlaneLbl.setBounds(329, 115, 30, 30);
		add(addPlaneLbl);
		
		/*delete button */
		deletePlaneLbl = new JLabel("");
		deletePlaneLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deletePlaneLbl.setIcon(new ImageIcon(deleteIcon));
		deletePlaneLbl.setBounds(329, 155, 30, 30);
		add(deletePlaneLbl);
		
		//Overrides
		
		refreshLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.setVisible(false);
				buildTable();
				scrollPane.setVisible(true);
			}
		});
		
		detailsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = -1;
				selectedRow = fleetTable.getSelectedRow();
				if (selectedRow != -1) {
					String model = (String)fleetTable.getValueAt(selectedRow, 1);
					viewCtrl.setAircraftDetails(model);
					switch(model)
					{
					case "Boeing 777":
						planePhotoLbl.setIcon(new ImageIcon(Image777));
						break;
					case "Boeing 737":
						planePhotoLbl.setIcon(new ImageIcon(Image737));
						break;
					case "Boeing 787":
						planePhotoLbl.setIcon(new ImageIcon(Image787));
						break;
					case "Airbus A380":
						planePhotoLbl.setIcon(new ImageIcon(ImageA380));
						break;
						default: break;
					}		
					detailsPanel.setVisible(true);		
				}
				else {
					JOptionPane.showMessageDialog(null, "Select plane to get details");
					detailsPanel.setVisible(false);
				}
				fleetTable.clearSelection();
			}
		});
		
		addPlaneLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				fleetTable.clearSelection();

			}
		});
		
		deletePlaneLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = -1;
				selectedRow = fleetTable.getSelectedRow();
				if (selectedRow != -1) {
					int p =  (int) fleetModel.getValueAt(selectedRow, 0);
					viewCtrl.deletePlane(p);
					//buildTable(); // should do it from controller
				}
				else 
					JOptionPane.showMessageDialog(null, "Choose a plane to delete.");
				fleetTable.repaint();
				fleetTable.clearSelection();
			}
		});
		
		
		
	}
	
	/*A Function to set all the listeners in the page */
//	public void setListeners() { 
//		addBtn.addActionListener(this);
//		addBtn.setActionCommand("add plane");
//		deleteBtn.addActionListener(this);
//		deleteBtn.setActionCommand("delete plane");
//	}
	
	/*A Function to build the fleet table from the database */
	public void buildTable()
	{
		fleetModel.setList(viewCtrl.getFleetTable());
		fleetTable.invalidate();
	}

//	/*A Function for all of the actions performed buttons */
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		/* Add plane functionality when pressing the button */
//		if(e.getActionCommand().equals("add plane")) {
//			scrollPane.setVisible(false);
//			String selectedBox = planeChoice.getSelectedItem().toString();
//			scrollPane.setVisible(true);	
//			if(selectedBox != ""){  /* Add plane functionality */
//				viewCtrl.addPlane(selectedBox);
//				//buildTable();
//			}
//			else { /* The user must choose a plane type */
//				JOptionPane.showMessageDialog(null, "Please choose plane type. ");
//			}
//		
//		}
//		/* Delete plane functionality when pressing the button */
//		if(e.getActionCommand().equals("delete plane")) {
//			int selectedRow = -1;
//			selectedRow = fleetTable.getSelectedRow();
//			if (selectedRow != -1) {
//				int p =  (int) fleetModel.getValueAt(selectedRow, 0);
//				viewCtrl.deletePlane(p);
//				//buildTable(); // should do it from controller
//			}
//			else {JOptionPane.showMessageDialog(null, "Choose a plane to delete.");}
//			fleetTable.repaint();	
//		}
//		fleetTable.clearSelection();
//	}
	
	public JTable getFleetTable() {
		return fleetTable;
	}
	
}
