package View;

import Controllers.Controller;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



@SuppressWarnings("serial")
public class MapControllerPanel extends JPanel {
	
	private Controller viewCtrl;
	private JTextPane distanceTextBox;
	private JTextPane taxTextBox;
	private JTextPane fuelTextBox;
	private JTextPane airportName;
	private JLabel fuelTextLabel;
	private JLabel distanceTextLabel;
	private JLabel lblNewLabel;
	private JLabel airportTextLabel;
	private JPanel bgPanel;
	
	int airportTax = 0;
	
	
	public MapControllerPanel(Controller view) {
		
		viewCtrl = view;
		setBackground(new Color(198,198,198));
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		Image mapIcon = new ImageIcon(this.getClass().getResource("/map.png")).getImage();
		Image locationIcon = new ImageIcon(this.getClass().getResource("/location.png")).getImage();
		Image locationHoverIcon = new ImageIcon(this.getClass().getResource("/location2.png")).getImage();
		
		JLabel telAvivLbl = new JLabel("");
		telAvivLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		telAvivLbl.setBounds(578, 186, 41, 52);
		telAvivLbl.setIcon(new ImageIcon(locationIcon));
		add(telAvivLbl);
		
		JLabel newYorkLbl = new JLabel("");
		newYorkLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newYorkLbl.setBounds(254, 165, 41, 52);
		newYorkLbl.setIcon(new ImageIcon(locationIcon));
		add(newYorkLbl);
		
		JLabel sydneyLbl = new JLabel("");
		sydneyLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sydneyLbl.setBounds(897, 367, 41, 52);
		sydneyLbl.setIcon(new ImageIcon(locationIcon));
		add(sydneyLbl);
		
		JLabel RomeLbl = new JLabel("");
		RomeLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RomeLbl.setBounds(511, 154, 41, 52);
		RomeLbl.setIcon(new ImageIcon(locationIcon));
		add(RomeLbl);
		
		JLabel RioLbl = new JLabel("");
		RioLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RioLbl.setBounds(346, 344, 41, 52);
		RioLbl.setIcon(new ImageIcon(locationIcon));
		add(RioLbl);
		
		JLabel capeTownLbl = new JLabel("");
		capeTownLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		capeTownLbl.setBounds(530, 378, 41, 52);
		capeTownLbl.setIcon(new ImageIcon(locationIcon));
		add(capeTownLbl);
		
		JLabel madridLbl = new JLabel("");
		madridLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		madridLbl.setBounds(459, 165, 41, 52);
		madridLbl.setIcon(new ImageIcon(locationIcon));
		add(madridLbl);
		
		JLabel bangkokLbl = new JLabel("");
		bangkokLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bangkokLbl.setBounds(757, 242, 41, 52);
		bangkokLbl.setIcon(new ImageIcon(locationIcon));
		add(bangkokLbl);
		
		JLabel delhiLbl = new JLabel("");
		delhiLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delhiLbl.setBounds(684, 186, 41, 52);
		delhiLbl.setIcon(new ImageIcon(locationIcon));
		add(delhiLbl);
		
		JLabel mapLbl = new JLabel("");
		mapLbl.setIcon(new ImageIcon(mapIcon));
		mapLbl.setBounds(0, 11, 1028, 494);
		add(mapLbl);
		
		bgPanel = new JPanel();
		bgPanel.setBounds(387, 504, 304, 153);
		add(bgPanel);
		bgPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Tax price:");
		lblNewLabel.setBounds(10, 108, 100, 20);
		bgPanel.add(lblNewLabel);
		
		distanceTextLabel = new JLabel("Distance from origin:");
		distanceTextLabel.setBounds(10, 77, 129, 20);
		bgPanel.add(distanceTextLabel);
		
		fuelTextLabel = new JLabel("Fuel price per gallon:");
		fuelTextLabel.setBounds(10, 43, 129, 20);
		bgPanel.add(fuelTextLabel);
		
		airportTextLabel = new JLabel("Airport City:");
		airportTextLabel.setBounds(10, 12, 100, 20);
		bgPanel.add(airportTextLabel);
		
		fuelTextBox = new JTextPane();
		fuelTextBox.setBounds(170, 43, 129, 20);
		bgPanel.add(fuelTextBox);
		fuelTextBox.setBackground(new Color(240,240,240));
		
		distanceTextBox = new JTextPane();
		distanceTextBox.setBounds(170, 77, 129, 20);
		bgPanel.add(distanceTextBox);
		distanceTextBox.setBackground(new Color(240,240,240));
		
		taxTextBox = new JTextPane();
		taxTextBox.setBounds(170, 108, 129, 20);
		bgPanel.add(taxTextBox);
		taxTextBox.setBackground(new Color(240,240,240));
		
		airportName = new JTextPane();
		airportName.setBounds(170, 12, 129, 20);
		bgPanel.add(airportName);
		airportName.setBackground(new Color(240,240,240));
//		

		setInfoFalse();
		
		telAvivLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				telAvivLbl.setIcon(new ImageIcon(locationHoverIcon));
				telAvivLbl.setToolTipText("Tel Aviv");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				telAvivLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("Tel Aviv");
				setInfoTrue();
			}
		});
		newYorkLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newYorkLbl.setIcon(new ImageIcon(locationHoverIcon));
				newYorkLbl.setToolTipText("New York");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newYorkLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("New York");
				setInfoTrue();
			}
		});
		
		sydneyLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sydneyLbl.setIcon(new ImageIcon(locationHoverIcon));
				sydneyLbl.setToolTipText("Sydney");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sydneyLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("Sydney");
				setInfoTrue();
			}
		});
		
		RomeLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RomeLbl.setIcon(new ImageIcon(locationHoverIcon));
				RomeLbl.setToolTipText("Rome");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RomeLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("Rome");
				setInfoTrue();
			}
		});
		RioLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RioLbl.setIcon(new ImageIcon(locationHoverIcon));
				RioLbl.setToolTipText("Rio");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RioLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("Rio");
				setInfoTrue();
			}
		});
		capeTownLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				capeTownLbl.setIcon(new ImageIcon(locationHoverIcon));
				capeTownLbl.setToolTipText("Cape Town");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				capeTownLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("Cape Town");
				setInfoTrue();
			}
		});
		madridLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				madridLbl.setIcon(new ImageIcon(locationHoverIcon));
				madridLbl.setToolTipText("Madrid");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				madridLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("Madrid");
				setInfoTrue();
			}
		});
		bangkokLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bangkokLbl.setIcon(new ImageIcon(locationHoverIcon));
				bangkokLbl.setToolTipText("Bangkok");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bangkokLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("Bangkok");
				setInfoTrue();
			}
		});
		delhiLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				delhiLbl.setIcon(new ImageIcon(locationHoverIcon));
				delhiLbl.setToolTipText("Delhi");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				delhiLbl.setIcon(new ImageIcon(locationIcon));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateInfo("Delhi");
				setInfoTrue();
			}
		});
	}
	
	/* A function to hide all labels */
	public void setInfoFalse()
	{
		fuelTextLabel.setVisible(false);
		distanceTextLabel.setVisible(false);
		lblNewLabel.setVisible(false);
		airportTextLabel.setVisible(false);
		taxTextBox.setVisible(false);
		distanceTextBox.setVisible(false);
		airportName.setVisible(false);
		fuelTextBox.setVisible(false);
		bgPanel.setVisible(false);
	}
	
	/* A function to show all labels */

	public void setInfoTrue()
	{
		bgPanel.setVisible(true);
		fuelTextLabel.setVisible(true);
		distanceTextLabel.setVisible(true);
		lblNewLabel.setVisible(true);
		airportTextLabel.setVisible(true);
		taxTextBox.setVisible(true);
		distanceTextBox.setVisible(true);
		airportName.setVisible(true);
		fuelTextBox.setVisible(true);
	}
	
	/* A function to set info on the screen from the airport object */
	public void updateInfo(String airport)
	{
		taxTextBox.setText(Integer.toString(viewCtrl.getAirport(airport).getLocalTax()));
		distanceTextBox.setText(Double.toString(viewCtrl.getAirport(airport).getDistance()));
		airportName.setText(airport);
		fuelTextBox.setText(Double.toString(viewCtrl.getAirport(airport).getFuelPrice()));
	}
}
