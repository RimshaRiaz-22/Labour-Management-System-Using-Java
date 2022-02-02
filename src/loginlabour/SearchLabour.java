package loginlabour;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchLabour {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public void SearchL() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
			        System.out.println("Connected Successfully");
					SearchLabour window = new SearchLabour();
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
	public SearchLabour() {
		initialize();
	}
	   public void fillcombo1() {
	    	try {
	    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
	            System.out.println("Connected Successfully");
	    		String query = "select * from Labour";
				PreparedStatement pst = connection.prepareStatement(query);
	    		ResultSet rs= pst.executeQuery();
	    		while(rs.next()) {
	    			comboBox.addItem(rs.getString("ID"));
	    		}
	    	}catch(Exception a) {
	    		a.printStackTrace();
	    	}
	    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Labour");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(99, 31, 147, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(57, 91, 71, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		 comboBox = new JComboBox();
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
		              System.out.println("Connected Successfully");
					String query = "select * from Labour where ID= ?";
					PreparedStatement pstt=connection.prepareStatement(query);
					pstt.setString(1,(String) comboBox.getSelectedItem());
					ResultSet rs= pstt.executeQuery();
					while(rs.next()) {
						textField.setText(rs.getString("NameL"));
						textField_1.setText(rs.getString("Phno"));
						textField_2.setText(rs.getString("Worth"));
						textField_3.setText(rs.getString("WorkingHours"));
						textField_4.setText(rs.getString("SalaryPerHour"));
						textField_5.setText(rs.getString("Address"));
					}
					pstt.close();
				}catch(Exception b) {
					b.printStackTrace();
				}
		 	}
		 });
		comboBox.setBounds(150, 94, 90, 23);
		frame.getContentPane().add(comboBox);
		fillcombo1();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 128, 371, 23);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Labour Table");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(57, 161, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Phno#");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(111, 161, 54, 15);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Worth");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(175, 161, 54, 15);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Working Hours");
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(239, 161, 98, 15);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("SalaryPer Month");
		lblNewLabel_3_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3_4.setBounds(326, 161, 98, 15);
		frame.getContentPane().add(lblNewLabel_3_4);
		
		textField = new JTextField();
		textField.setBounds(30, 176, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 176, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 176, 71, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(249, 176, 76, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(335, 176, 89, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainForm f = new MainForm();
	            f. Window2();
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 14));
		btnNewButton.setBounds(164, 217, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Address");
		lblNewLabel_3_4_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3_4_1.setBounds(437, 161, 98, 15);
		frame.getContentPane().add(lblNewLabel_3_4_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(434, 176, 66, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
	}
}
