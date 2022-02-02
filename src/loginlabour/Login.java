package loginlabour;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Sql Connection string with database Ms-Access
				
				try {
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String DatabaseURL="jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb";
					System.out.println("Connected Successfully");
					Connection conn = DriverManager.getConnection(DatabaseURL);
					
				}catch(SQLException e) {
					e.printStackTrace();
				}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(99, 26, 125, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(77, 94, 93, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(77, 134, 76, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(193, 91, 101, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, 
                        "No New User SignUp", 
                        "TITLE", 
                        JOptionPane.WARNING_MESSAGE);
			}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(77, 177, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DatabaseURL="jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb";
				String user=textField.getText();
				String pass=passwordField.getText();
				
				try {
					String chk="Select * from Login where UserName=? and Password=?";
					Connection conn = DriverManager.getConnection(DatabaseURL);
					PreparedStatement pst=conn.prepareStatement(chk);
					pst.setString(1, user);
					pst.setString(2, pass);
					ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						String password =rs.getString("Password");
						if(pass.equals(password)) {
							MainForm f = new MainForm();
				            f. Window2();
						}else {
							JOptionPane.showMessageDialog(null, "Invalid Password","Login Error", JOptionPane.ERROR_MESSAGE);
						}
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Invalid Username Or Password","Login Error", JOptionPane.ERROR_MESSAGE);
						//textField_1.setText("");
					}
					
					
					
				}catch(SQLException ex) {
					ex.printStackTrace();
				}						
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBounds(215, 177, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 132, 101, 21);
		frame.getContentPane().add(passwordField);
	}
}
