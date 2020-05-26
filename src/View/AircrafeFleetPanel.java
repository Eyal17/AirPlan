package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AircrafeFleetPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AircrafeFleetPanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		
		JLabel lblAircraftFleet = new JLabel("AirCraft Fleet");
		lblAircraftFleet.setBounds(399, 316, 230, 49);
		lblAircraftFleet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAircraftFleet.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblAircraftFleet);
	}

}
