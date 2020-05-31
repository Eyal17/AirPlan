package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.FlightBoardController;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.CardLayout;

public class HomeBuilder extends JFrame {

	private JPanel contentPane;
	
	private HomePanel HomeP;
	private FleetPanel AirCraftP;
	private FlightBoardPanel FlightBoardP;
	private MapControllerPanel MapContP;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeBuilder frame = new HomeBuilder();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("AirPlan");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public HomeBuilder() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel NavBar = new JPanel();
		NavBar.setBackground(Color.WHITE);
		NavBar.setBounds(0, 0, 236, 692);
		contentPane.add(NavBar);
		NavBar.setLayout(null);
		
		JPanel HomeBtn = new JPanel();
		HomeBtn.setBackground(Color.WHITE);
		HomeBtn.setBounds(0, 102, 236, 59);
		NavBar.add(HomeBtn);
		HomeBtn.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setBounds(50, 11, 55, 37);
		HomeBtn.add(lblNewLabel);
		
		JPanel AircraftFleetBtn = new JPanel();
		AircraftFleetBtn.setLayout(null);
		AircraftFleetBtn.setBackground(Color.WHITE);
		AircraftFleetBtn.setBounds(0, 172, 236, 59);
		NavBar.add(AircraftFleetBtn);
		
		JLabel lblAircraftFleet = new JLabel("Aircraft Fleet");
		lblAircraftFleet.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAircraftFleet.setBounds(50, 11, 145, 37);
		AircraftFleetBtn.add(lblAircraftFleet);
		
		JPanel FlightScheduleBtn = new JPanel();
		FlightScheduleBtn.setLayout(null);
		FlightScheduleBtn.setBackground(Color.WHITE);
		FlightScheduleBtn.setBounds(0, 242, 236, 59);
		NavBar.add(FlightScheduleBtn);
		
		JLabel lblFlightBoard = new JLabel("Flight Board");
		lblFlightBoard.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFlightBoard.setBounds(50, 11, 132, 37);
		FlightScheduleBtn.add(lblFlightBoard);
		
		JPanel MapControllerBtn = new JPanel();
		MapControllerBtn.setLayout(null);
		MapControllerBtn.setBackground(Color.WHITE);
		MapControllerBtn.setBounds(0, 312, 236, 59);
		NavBar.add(MapControllerBtn);
		
		JLabel lblMapController = new JLabel("Map Controller");
		lblMapController.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMapController.setBounds(50, 11, 132, 37);
		MapControllerBtn.add(lblMapController);
		
		JPanel Viewpanel = new JPanel();
		Viewpanel.setBounds(236, 0, 1028, 681);
		contentPane.add(Viewpanel);
		Viewpanel.setLayout(new CardLayout(0, 0));
		
		HomeP = new HomePanel();
		AirCraftP = new FleetPanel();
		FlightBoardP = new FlightBoardPanel();
		MapContP = new MapControllerPanel();
		
		Viewpanel.add(HomeP, "name_78750354984400");
		Viewpanel.add(AirCraftP, "name_78750381602200");
		Viewpanel.add(FlightBoardP, "name_78750403585200");
		Viewpanel.add(MapContP);
		
		
		MenuClicked(HomeP);
		
		//Overrides
		
		HomeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				HomeBtn.setBackground(new Color(51, 153, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				HomeBtn.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuClicked(HomeP);
			}
		});
		
		AircraftFleetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AircraftFleetBtn.setBackground(new Color(102, 178, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AircraftFleetBtn.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuClicked(AirCraftP);
			}
		});
		
		FlightScheduleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				FlightScheduleBtn.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				FlightScheduleBtn.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuClicked(FlightBoardP);
			}
		});
		
		MapControllerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuClicked(MapContP);
			}
		});
	}
	
	
	//Functions
	
			public void MenuClicked(JPanel panel) {
				HomeP.setVisible(false);
				AirCraftP.setVisible(false);
				FlightBoardP.setVisible(false);
				panel.setVisible(true);
			}
			
}
