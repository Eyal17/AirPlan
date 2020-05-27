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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AircrafeFleetPanel extends JPanel {
	private JTable FleetTable;
	private FleetTableModel fleetModel;
	
	FleetRepositoryImpl r = new FleetRepositoryImpl();
	FleetController fleetCtrl = new FleetController(r);

	public AircrafeFleetPanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		fleetModel = new FleetTableModel();
		FleetTable = new JTable(fleetModel);
		//FleetTable = new JTable(); // to design 

		JLabel lblAircraftFleet = new JLabel("AirCraft Fleet");
		lblAircraftFleet.setBounds(303, 30, 230, 49);
		lblAircraftFleet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAircraftFleet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblAircraftFleet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 90, 554, 378);
		add(scrollPane);
		scrollPane.setViewportView(FleetTable);
		JButton btnNewButton = new JButton("Add new plane");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fleetCtrl.addPlane("727");	
				scrollPane.setVisible(false);
				//buildTable();
				scrollPane.setVisible(true);
				//FleetTable.setModel(fleetModel);
				//FleetTable.invalidate();
				//FleetTable.repaint();
			}
		});
		btnNewButton.setBounds(10, 118, 130, 23);
		add(btnNewButton);
		
		
		String[] planeTypes = {"none", "737", "727"};
		JComboBox planeChoice = new JComboBox(planeTypes);
		planeChoice.setSelectedIndex(0);
		planeChoice.setBounds(150, 118, 60, 22);
		add(planeChoice);
		
		buildTable();
	
		
		
//		try {
//			connection = DBManager.connect();
//			String query = "select * from fleet";
//			ResultSet rs = connection.createStatement().executeQuery(query);
//			
//			//FleetTable.setModel(DbUtils.resultSetToTableModel(rs));
//			
//			ArrayList<Plane> test = ParseResultSet(rs);
//			fleetModel.setList(test);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		}
//	
//	public ArrayList<Plane> ParseResultSet(ResultSet rs)
//	{
//		ArrayList<Plane> list = new ArrayList<>();
//		try {
//			while(rs.next())
//			{
//				Plane plane = new Plane(rs.getString(1),rs.getInt(2));
//				list.add(plane);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
	}
	public void buildTable()
	{
		ArrayList<Plane> fleetArrayFromDB = fleetCtrl.getTable();
		fleetModel.setList(fleetArrayFromDB);
		//FleetTable.invalidate();
	}
}
