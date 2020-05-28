package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JToggleButton; 

public class LogInPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	int xMouse;
	int yMouse;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPage frame = new LogInPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInPage() {
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
		Image midImg = new ImageIcon(this.getClass().getResource("/login_mid.png")).getImage();
		midLbl.setIcon(new ImageIcon(midImg));
		midLbl.setBounds(281, 102, 411, 481);
		contentPane.add(midLbl);
		
		JPanel Right = new JPanel();
		Right.setBackground(Color.WHITE);
		Right.setBounds(173, 146, 941, 388);
		contentPane.add(Right);
		Right.setLayout(null);
		
		JLabel LogInLbl = new JLabel("Log in");
		LogInLbl.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		LogInLbl.setHorizontalAlignment(SwingConstants.CENTER);
		LogInLbl.setBounds(616, 21, 275, 36);
		Right.add(LogInLbl);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(616, 131, 275, 36);
		Right.add(textField);
		
		JLabel PassLbl = new JLabel("User Name");
		PassLbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
		PassLbl.setBounds(616, 93, 121, 27);
		Right.add(PassLbl);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(616, 190, 121, 27);
		Right.add(lblNewLabel_3_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(616, 228, 275, 36);
		Right.add(passwordField);
		
		JLabel signInBtn = new JLabel("");
		Image signInIconHover = new ImageIcon(this.getClass().getResource("/send_button2.png")).getImage();
		Image signInIcon = new ImageIcon(this.getClass().getResource("/send_button.png")).getImage();
		signInBtn.setIcon(new ImageIcon(signInIcon));
		signInBtn.setBounds(717, 291, 60, 60);
		Right.add(signInBtn);
		signInBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals("admin") && passwordField.getText().equals("admin123")) {
					JOptionPane.showMessageDialog(null, "Log in Success!");
					HomeBuilder Home = null;
					try {
						Home = new HomeBuilder();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Home.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Failed!");
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
	}
}
