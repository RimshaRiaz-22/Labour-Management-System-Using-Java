package loginlabour;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteLabour {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void Del() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
			        System.out.println("Connected Successfully");
					DeleteLabour window = new DeleteLabour();
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
	public DeleteLabour() {
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
		
		JLabel lblNewLabel = new JLabel("Delete Labour");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(112, 21, 139, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Labour ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(86, 95, 101, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(197, 92, 115, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
				    {
				    	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			            Connection conn= DriverManager.getConnection("jdbc:ucanaccess://C://Users//Administrator//eclipse-workspace//LabourInfo//Db.accdb");
			            System.out.println("Connected Successfully");
			            Statement statement = conn.createStatement();
			            statement.executeUpdate("DELETE FROM Labour WHERE ID=" + textField.getText() + "");  
			            JOptionPane.showMessageDialog(null, "Record deleted...");  
			            statement.close();  
			            conn.close();  
			       
				    }
				    catch (Exception excep)
				    {
				      System.err.println("Got an exception! ");
				    }
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 14));
		btnNewButton.setBounds(195, 158, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MainForm f = new MainForm();
	            f. Window2();
			}
		});
		btnNewButton_1.setFont(new Font("SimSun", Font.BOLD, 14));
		btnNewButton_1.setBounds(69, 158, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
