package booking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class passenger {

	private JFrame frame;
	private JTextField pname;
	protected int no_of_ticket;
	int cost;
	int nt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passenger window = new passenger();
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
	public passenger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 738, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metro Training Bookings");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(227, 11, 301, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passenger Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(27, 82, 146, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("From:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(27, 135, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("To:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(27, 182, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No. of Tickets:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(27, 228, 120, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		pname = new JTextField();
		pname.setBounds(183, 90, 109, 20);
		frame.getContentPane().add(pname);
		pname.setColumns(10);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Kukatpally", "Secunderabad", "Ameerpet", "Uppal", "JNTU", "Tharnaka", "Miyapur", "Dilshuknagar", "Kondapur", "Hitech-city", "Erragadda+"}));
		c1.setBounds(183, 133, 109, 22);
		frame.getContentPane().add(c1);
		
		JComboBox c2 = new JComboBox();
		c2.setModel(new DefaultComboBoxModel(new String[] {"Kukatpally", "Secunderabad", "Ameerpet", "Uppal", "JNTU", "Tharnaka", "Miyapur", "Dilshuknagar", "Kondapur", "Hitech-city", "Erragadda+"}));
		c2.setBounds(183, 180, 109, 22);
		frame.getContentPane().add(c2);
		
		JComboBox c3 = new JComboBox();
		c3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		c3.setBounds(183, 226, 109, 22);
		frame.getContentPane().add(c3);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=pname.getText();
				String source=(String) c1.getSelectedItem();
				String destination=(String) c2.getSelectedItem();
				String nooftickets=(String) c3.getSelectedItem();
				nt=Integer.parseInt(nooftickets);
				
				if(source.equals(c2))
				{
					JOptionPane.showMessageDialog(btnNewButton, "error");
				}
				else
				{
				    cost=nt*40;
					JOptionPane.showMessageDialog(btnNewButton,+cost);
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/it1757","root","welcome@123");
					String q="insert into booking values('"+name+"','"+source+"','"+destination+"','"+nt+"')";
					Statement st=con.createStatement();
					st.executeUpdate(q);
				} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(304, 320, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
