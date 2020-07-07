package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import Controllers.Controller;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class LogInPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Controller viewCtrl;
	private boolean flag;
	int xMouse;
	int yMouse;
	
	public LogInPage(Controller ctrl) {
		
		viewCtrl = ctrl;
		
		// Loading images icons
		Image midImg = new ImageIcon(this.getClass().getResource("/login_mid.png")).getImage();
		Image signInIconHover = new ImageIcon(this.getClass().getResource("/send_button2.png")).getImage();
		Image signInIcon = new ImageIcon(this.getClass().getResource("/send_button.png")).getImage();
		Image managerSwitchIcon = new ImageIcon(this.getClass().getResource("/check_box_m1.png")).getImage();
		Image userSwitchIcon = new ImageIcon(this.getClass().getResource("/check_box_c1.png")).getImage();
		Image exitIcon = new ImageIcon(this.getClass().getResource("/exitBlue.png")).getImage();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1255, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setLocationRelativeTo(null);
		
		JLabel midLbl = new JLabel("");
		midLbl.setIcon(new ImageIcon(midImg));
		midLbl.setBounds(281, 102, 411, 481);
		contentPane.add(midLbl);
		
		JPanel Right = new JPanel();
		Right.setBackground(Color.WHITE);
		Right.setBounds(295, 146, 819, 388);
		contentPane.add(Right);
		Right.setLayout(null);
		
		JLabel LogInLbl = new JLabel("Log in");
		LogInLbl.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		LogInLbl.setHorizontalAlignment(SwingConstants.CENTER);
		LogInLbl.setBounds(456, 11, 275, 36);
		Right.add(LogInLbl);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(456, 121, 275, 36);
		Right.add(textField);
		
		JLabel PassLbl = new JLabel("User Name");
		PassLbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
		PassLbl.setBounds(456, 83, 121, 27);
		Right.add(PassLbl);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(456, 180, 121, 27);
		Right.add(lblNewLabel_3_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(456, 218, 275, 36);
		Right.add(passwordField);
		
		JLabel signInBtn = new JLabel("");
		signInBtn.setIcon(new ImageIcon(signInIcon));
		signInBtn.setBounds(557, 281, 60, 60);
		Right.add(signInBtn);
		
		JLabel exitLbl = new JLabel("");
		exitLbl.setIcon(new ImageIcon(exitIcon));
		exitLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitLbl.setBounds(789, 5, 25, 25);
		Right.add(exitLbl);
		
		JLabel leftLbl = new JLabel("");
		flag = true;
		leftLbl.setIcon(new ImageIcon(managerSwitchIcon));
		leftLbl.setBounds(167, 146, 120, 388);
		contentPane.add(leftLbl);
		
		leftLbl.setVisible(false); // checker log in need an update!
		
		signInBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewCtrl.loginValidation(textField.getText(),passwordField.getPassword());
				passwordField.setText("");	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				signInBtn.setIcon(new ImageIcon(signInIconHover));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				signInBtn.setIcon(new ImageIcon(signInIcon));
			}
		});
		
		leftLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag) {
					leftLbl.setIcon(new ImageIcon(userSwitchIcon));
					flag = false;
				}
				else {
					leftLbl.setIcon(new ImageIcon(managerSwitchIcon));
					flag = true;
				}
			}
		});
		exitLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
