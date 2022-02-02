package loginlabour;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateLabour {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBoxID;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void UpdateL() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
			        System.out.println("Connected Successfully");
					UpdateLabour window = new UpdateLabour();
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
	public UpdateLabour() {
		initialize();
	}
	   public void fillcombo() {
	    	try {
	    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
	            System.out.println("Connected Successfully");
	    		String query = "select * from Labour";
				PreparedStatement pst = connection.prepareStatement(query);
	    		ResultSet rs= pst.executeQuery();
	    		while(rs.next()) {
	    			comboBoxID.addItem(rs.getString("ID"));
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
		frame.setBounds(100, 100, 491, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Labour");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(125, 37, 149, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Labour ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(39, 88, 86, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		comboBoxID = new JComboBox();
		comboBoxID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
		              System.out.println("Connected Successfully");
					String query = "select * from Labour where ID= ?";
					PreparedStatement pstt=connection.prepareStatement(query);
					pstt.setString(1,(String) comboBoxID.getSelectedItem());
					ResultSet rs= pstt.executeQuery();
					while(rs.next()) {
						textField_4.setText(rs.getString("NameL"));
						textField.setText(rs.getString("Phno"));
						textField_2.setText(rs.getString("Worth"));
						textField_1.setText(rs.getString("WorkingHours"));		
						textField_3.setText(rs.getString("SalaryPerHour"));
						textField_5.setText(rs.getString("FatherName"));
						textField_6.setText(rs.getString("Address"));
					}
					pstt.close();
				}catch(Exception b) {
					b.printStackTrace();
				}
			}
		});
		comboBoxID.setBounds(135, 84, 105, 23);
		frame.getContentPane().add(comboBoxID);
		fillcombo();
		
		JLabel lblNewLabel_1_1 = new JLabel("Labour Phno");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(39, 117, 86, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Working Hours");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(39, 146, 86, 19);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Worth");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(39, 175, 86, 19);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Salary");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(39, 204, 86, 19);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainForm f = new MainForm();
	            f. Window2();
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 14));
		btnNewButton.setBounds(71, 233, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
	            System.out.println("Connected Successfully");
	    		String query = "Update Labour set Phno='"+textField.getText()+"',WorkingHours='"+textField_1.getText()+"',Worth='"+textField_2.getText()+"',SalaryPerHour='"+textField_3.getText()+"',NameL='"+textField_4.getText()+"',FatherName='"+textField_5.getText()+"',Address='"+textField_6.getText()+"' where ID='"+comboBoxID.getSelectedItem()+ "' ";
				PreparedStatement pst = connection.prepareStatement(query);
	    		pst.executeUpdate();
	    		
	    		JOptionPane.showMessageDialog(null, "Data Updated Succesfully");
				}catch(Exception h) {
					h.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 14));
		btnNewButton_1.setBounds(228, 233, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(145, 117, 95, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 145, 93, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 174, 95, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 203, 95, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Name");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(250, 119, 86, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Father Name");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(250, 148, 86, 19);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Address");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1_3.setBounds(250, 177, 86, 19);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(326, 116, 95, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(326, 145, 95, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(326, 174, 95, 21);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
	}
}
