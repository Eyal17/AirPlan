package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class FlightSchedulePanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public FlightSchedulePanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 208, 1008, 462);
		add(table);
	}
}
