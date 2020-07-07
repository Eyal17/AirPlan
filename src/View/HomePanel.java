package View;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class HomePanel extends JPanel {

	public HomePanel() {
		setBounds(0, 0, 1028, 681);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel welcomeLbl = new JLabel("Welcome");
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setFont(new Font("Segoe UI Light", Font.BOLD, 49));
		welcomeLbl.setBounds(242, 44, 544, 95);
		add(welcomeLbl);
		
		JLabel netanelLbl = new JLabel("Netanel Haim-Pour");
		netanelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		netanelLbl.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
		netanelLbl.setBounds(242, 113, 544, 95);
		netanelLbl.setVisible(false);
		add(netanelLbl);
		
		JLabel omerLbl = new JLabel("Omer Borshan");
		omerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		omerLbl.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
		omerLbl.setBounds(242, 113, 544, 95);
		omerLbl.setVisible(false);
		add(omerLbl);
		
		JLabel amirLbl = new JLabel("Amir Goldstein");
		amirLbl.setHorizontalAlignment(SwingConstants.CENTER);
		amirLbl.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
		amirLbl.setBounds(242, 113, 544, 95);
		amirLbl.setVisible(false);
		add(amirLbl);
		
		JLabel eyalLbl = new JLabel("Eyal Geron");
		eyalLbl.setHorizontalAlignment(SwingConstants.CENTER);
		eyalLbl.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
		eyalLbl.setBounds(242, 113, 544, 95);
		eyalLbl.setVisible(false);
		add(eyalLbl);
		
		JLabel globeGifLbl = new JLabel("");
		globeGifLbl.setBounds(354, 243, 320, 240);
		add(globeGifLbl);
		
		Image globeGif = new ImageIcon(this.getClass().getResource("/globe2.gif")).getImage();
		globeGifLbl.setIcon(new ImageIcon(globeGif));
		
		JLabel motText = new JLabel("");
		motText.setHorizontalAlignment(SwingConstants.CENTER);
		motText.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		motText.setBounds(35, 505, 957, 131);
		add(motText);
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add('"' + "Your limitation—it’s only your imagination" + '"');
		arr.add('"' + "Push yourself, because no one else is going to do it for you" + '"');
		arr.add('"' + "Sometimes later becomes never. Do it now" + '"');
		arr.add('"' + "Great things never come from comfort zones" + '"');
		arr.add('"' + "Dream it. Wish it. Do it" + '"');
		arr.add('"' + "Dream it. Believe it. Build it" + '"');
		arr.add('"' + "Wake up with determination. Go to bed with satisfaction" + '"');
		arr.add('"' + "Do something today that your future self will thank you for" + '"');
		arr.add('"' + "Little things make big days" + '"');
		arr.add('"' + "Don’t wait for opportunity. Create it" + '"');
		
		Random rand = new Random();
		
		String[] str = arr.toArray(new String[arr.size()]);
		motText.setText(str[rand.nextInt(10)]);
		
		
		
	}
}
