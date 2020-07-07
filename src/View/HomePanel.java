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

@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	
	public JLabel userNameLbl;
	JLabel welcomeLbl;
	JLabel globeGifLbl;
	JLabel motText;
	
	Random rand;
	Image globeGif = new ImageIcon(this.getClass().getResource("/globe2.gif")).getImage();

	public HomePanel() {
		setBounds(0, 0, 1028, 681);
		setBackground(Color.WHITE);
		setLayout(null);
		
		welcomeLbl = new JLabel("Welcome");
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setFont(new Font("Segoe UI Light", Font.BOLD, 49));
		welcomeLbl.setBounds(242, 44, 544, 95);
		add(welcomeLbl);
		
		userNameLbl = new JLabel("Visitor");
		userNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLbl.setFont(new Font("Segoe UI Light", Font.PLAIN, 40));
		userNameLbl.setBounds(242, 113, 544, 95);
		add(userNameLbl);
		
		globeGifLbl = new JLabel("");
		globeGifLbl.setBounds(354, 243, 320, 240);
		add(globeGifLbl);
		
		globeGifLbl.setIcon(new ImageIcon(globeGif));
		
		motText = new JLabel("");
		motText.setHorizontalAlignment(SwingConstants.CENTER);
		motText.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		motText.setBounds(35, 505, 957, 131);
		add(motText);
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add('"' + "Your limitation-it's only your imagination" + '"');
		arr.add('"' + "Push yourself, because no one else is going to do it for you" + '"');
		arr.add('"' + "Sometimes later becomes never. Do it now" + '"');
		arr.add('"' + "Great things never come from comfort zones" + '"');
		arr.add('"' + "Dream it. Wish it. Do it" + '"');
		arr.add('"' + "Dream it. Believe it. Build it" + '"');
		arr.add('"' + "Wake up with determination. Go to bed with satisfaction" + '"');
		arr.add('"' + "Do something today that your future self will thank you for" + '"');
		arr.add('"' + "Little things make big days" + '"');
		arr.add('"' + "Don't wait for opportunity. Create it" + '"');
		
		rand = new Random();
		
		String[] str = arr.toArray(new String[arr.size()]);
		motText.setText(str[rand.nextInt(10)]);
		
		
	}
	
	
	//Functions
	
	
}
