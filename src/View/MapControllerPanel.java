package View;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MapControllerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MapControllerPanel() {
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Map Controller");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(242, 228, 544, 225);
		add(lblNewLabel);
	}

}
