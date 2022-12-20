package send_to_mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class registration {

	private JFrame frame;
	private JTextField tname;
	private JTextField trollno;
	private JTextField temail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration window = new registration();
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
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 672, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(197, 11, 328, 36);
		frame.getContentPane().add(lblNewLabel);
		
		tname = new JTextField();
		tname.setBounds(182, 83, 86, 20);
		frame.getContentPane().add(tname);
		tname.setColumns(10);
		
		trollno = new JTextField();
		trollno.setColumns(10);
		trollno.setBounds(182, 130, 86, 20);
		frame.getContentPane().add(trollno);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(39, 84, 76, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Roll no :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(39, 131, 76, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gender :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(39, 173, 76, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fav.prog,lang :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(39, 217, 112, 20);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(39, 264, 76, 14);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JRadioButton r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.BOLD, 15));
		r1.setBounds(184, 171, 109, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("female");
		r2.setFont(new Font("Tahoma", Font.BOLD, 15));
		r2.setBounds(363, 171, 109, 23);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=new  ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"C", "Java", "R", "Python"}));
		c1.setBounds(182, 218, 111, 22);
		frame.getContentPane().add(c1);
		
		temail = new JTextField();
		temail.setBounds(182, 263, 86, 20);
		frame.getContentPane().add(temail);
		temail.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tname.getText();
				String rollno=trollno.getText();
				String gender;
				if(r1.isSelected())
				{
					gender="Male";
				}
				else
				{
				    gender="female";
				}
				String pro=(String) c1.getSelectedItem();
				String email=temail.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/it1757","root","welcome@123");
					String q="insert into student values('"+name+"','"+rollno+"','"+gender+"','"+pro+"','"+email+"')";
					Statement st=con.createStatement();
					st.executeUpdate(q);
					JOptionPane.showMessageDialog(btnNewButton, "Done");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(269, 348, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
