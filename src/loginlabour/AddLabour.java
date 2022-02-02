package loginlabour;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLabour {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void LForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
		              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");//Establishing Connection
		              System.out.println("Connected Successfully");
					AddLabour window = new AddLabour();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					 System.out.println("Error in connection");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddLabour() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fill to add Labour");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(124, 35, 182, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Labour Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 88, 101, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Labour Phno :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(40, 124, 101, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Labour Worth :");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(40, 160, 101, 26);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Working Hours :");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(40, 196, 101, 26);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Salary Per Hour :");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(40, 232, 101, 26);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton(" Save And Get Salary");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//	String url="INSERT INTO   AdmissionForm(Name,FatherName,FatherID,UserID,DOB,POB,YearR,Nationaality,Religion,Sex,FOccupation,Income,Address,College,Field,UserPhno,Email,Fphno,Ptclno,Examination,Subjects,Institution,BoardOrUni,YOP,MarksQ,RollNo,AdmTest,Region,Authority,MarksAdm,DateE,Signature) Values('"+textField+"','"+textField_1+"','"+textField_2+"','"+textField_3+"','"+textField_4+"','"+textField_5+"','"+textField_6+"','"+textField_7+"','"+textField_8+"')";
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			              Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
			              System.out.println("Connected Successfully");
			              //Crating PreparedStatement object
			              PreparedStatement preparedStatement=connection.prepareStatement("insert into   Labour(NameL,Phno,Worth,WorkingHours,SalaryPerHour,FatherName,Address) Values(?,?,?,?,?,?,?)");
			              //Setting values for Each Parameter
			              preparedStatement.setString(1,textField.getText());
			              preparedStatement.setString(2,textField_1.getText());
			              preparedStatement.setString(3,textField_2.getText());
			              preparedStatement.setString(4,textField_3.getText());
			              preparedStatement.setString(5,textField_4.getText());
			              preparedStatement.setString(6,textField_5.getText());
			              preparedStatement.setString(7,textField_6.getText());
			              preparedStatement.executeUpdate();
			              System.out.println("Data inserted successfully");
			              JOptionPane.showMessageDialog(null, 
			                        "Welcome New Labour,We will Contact You later For Salary", 
			                        "TITLE", 
			                        JOptionPane.WARNING_MESSAGE);
						}catch(SQLException | ClassNotFoundException ex) {
						ex.printStackTrace();	
						}
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 14));
		btnNewButton.setBounds(222, 343, 182, 26);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to fill another Form?", "Swing Tester",
	                      JOptionPane.YES_NO_OPTION,
	                      JOptionPane.QUESTION_MESSAGE);
	                   if(result == JOptionPane.YES_OPTION){
	                	   AddLabour f = new AddLabour();
		       	            f. LForm();
		       	            
	                	   
	                	  
	                   }else if (result == JOptionPane.NO_OPTION){
	                	   MainForm f = new MainForm();
		   		            f. Window2();
	                   }else {
	                	   
	                   }
			}
		});
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 14));
		btnNewButton_1.setBounds(56, 343, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(162, 92, 120, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 128, 120, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(162, 164, 120, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(162, 200, 120, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(162, 236, 120, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Father Name :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(40, 270, 85, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Address :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(40, 299, 85, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(162, 268, 120, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(162, 297, 120, 21);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
	}
}
