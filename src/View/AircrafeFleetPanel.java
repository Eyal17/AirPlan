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

import javax.swing.JTable;

import Model.Plane;
import Model.Repository.DBManager;
import javax.swing.JScrollPane;
public class AircrafeFleetPanel extends JPanel {
	private JTable FleetTable;
	private Connection connection = null;
	private FleetTableModel fleetModel;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public AircrafeFleetPanel() throws SQLException {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		fleetModel = new FleetTableModel();
		FleetTable = new JTable(fleetModel);
		JLabel lblAircraftFleet = new JLabel("AirCraft Fleet");
		lblAircraftFleet.setBounds(303, 30, 230, 49);
		lblAircraftFleet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAircraftFleet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblAircraftFleet);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 100, 741, 378);
		add(scrollPane);
		scrollPane.setViewportView(FleetTable);
		
				
		connection = DBManager.connect();
		String query = "select * from fleet";
		PreparedStatement pst = connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();

		
		//FleetTable.setModel(DbUtils.resultSetToTableModel(rs));
		List<Plane> test = ParseResultSet(rs);
		fleetModel.setList(test);
		}
	
	public List<Plane> ParseResultSet(ResultSet rs)
	{
		List<Plane> list = new ArrayList<>();
		try {
			while(rs.next())
			{
				Plane plane = new Plane(rs.getString(1),rs.getInt(2));
				list.add(plane);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
