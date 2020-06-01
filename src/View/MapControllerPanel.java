package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class MapControllerPanel extends JPanel {

	public MapControllerPanel() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Map Controller");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(242, 228, 544, 225);
		add(lblNewLabel);
	}
}
