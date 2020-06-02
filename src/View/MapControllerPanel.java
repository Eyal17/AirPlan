package View;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapControllerPanel extends JPanel {

	public MapControllerPanel() {
		setBackground(new Color(198,198,198));
		setBounds(0, 0, 1028, 681);
		setLayout(null);
		Image mapIcon = new ImageIcon(this.getClass().getResource("/map.png")).getImage();
		Image locationIcon = new ImageIcon(this.getClass().getResource("/location.png")).getImage();
		Image locationHoverIcon = new ImageIcon(this.getClass().getResource("/location2.png")).getImage();
	//	Image mapIcon = new ImageIcon(this.getClass().getResource("/map.png")).getImage();
	//	Image mapIcon = new ImageIcon(this.getClass().getResource("/map.png")).getImage();
		
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
		sydneyLbl.setBounds(842, 370, 41, 52);
		sydneyLbl.setIcon(new ImageIcon(locationIcon));
		add(sydneyLbl);
		
		JLabel RomeLbl = new JLabel("");
		RomeLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RomeLbl.setBounds(455, 155, 41, 52);
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
		
		JLabel mapLbl = new JLabel("");
		mapLbl.setIcon(new ImageIcon(mapIcon));
		mapLbl.setBounds(0, 11, 1028, 494);
		add(mapLbl);
		
		
		// Oveerides
		telAvivLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				telAvivLbl.setIcon(new ImageIcon(locationHoverIcon));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				telAvivLbl.setIcon(new ImageIcon(locationIcon));
			}
		});
		newYorkLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newYorkLbl.setIcon(new ImageIcon(locationHoverIcon));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newYorkLbl.setIcon(new ImageIcon(locationIcon));
			}
		});
		sydneyLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sydneyLbl.setIcon(new ImageIcon(locationHoverIcon));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sydneyLbl.setIcon(new ImageIcon(locationIcon));
			}
		});
		RomeLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RomeLbl.setIcon(new ImageIcon(locationHoverIcon));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RomeLbl.setIcon(new ImageIcon(locationIcon));
			}
		});
		RioLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RioLbl.setIcon(new ImageIcon(locationHoverIcon));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RioLbl.setIcon(new ImageIcon(locationIcon));
			}
		});
		capeTownLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				capeTownLbl.setIcon(new ImageIcon(locationHoverIcon));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				capeTownLbl.setIcon(new ImageIcon(locationIcon));
			}
		});
	}
}
