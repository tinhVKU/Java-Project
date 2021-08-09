package fruit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.MysqlDataTruncation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class insertFruit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	boolean b;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public insertFruit(String id,String name,String cost,String hsd,String origital,String picture,boolean c,manageFruit tinh) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 296);
		setLocation(870, 180);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin s\u1EA3n ph\u1EA9m");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 209, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn SP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 55, 46, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gi\u00E1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 90, 46, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("HSD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 125, 46, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Xu\u1EA5t x\u1EE9");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 160, 46, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u1EA2nh");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 195, 46, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setText(id);
		lblNewLabel_6.setForeground(new Color(152, 251, 152));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_6.setBounds(0, 0, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setText(name);
		textField.setBounds(83, 57, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(cost);
		textField_1.setBounds(83, 92, 136, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(hsd);
		textField_2.setBounds(83, 127, 136, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText(origital);
		textField_3.setBounds(83, 162, 136, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText(picture);
		textField_4.setBounds(83, 197, 136, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("H\u1EE7y");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(44, 230, 65, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==true) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/maganefruit","root","");
						Statement stm =conn.createStatement();
						String sqlString = "INSERT INTO `fruitfruit` VALUES (NULL, '"+textField_1.getText()+"', '"+textField_2.getText()+"', '"+textField_3.getText()+"', '"+textField_4.getText()+"', '"+textField.getText()+"')";
						stm.executeUpdate(sqlString);
					}
				
					catch(Exception e5){
						System.out.println(e5.getMessage());
					} 
				}else {
					
					 try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/maganefruit","root","");
							Statement stm =conn.createStatement();
						
							stm.executeUpdate("UPDATE `fruitfruit` SET `cots`='"+textField_1.getText()+"',`hsd`='"+textField_2.getText()+"',`original`='"+textField_3.getText()+"',`picture`='"+textField_4.getText()+"',`name`='"+textField.getText()+"' WHERE ma ='"+lblNewLabel_6.getText()+"' ");
							System.out.println(lblNewLabel_6.getText());
							}
							
						catch(Exception e1){
							System.out.println(e1.getMessage());
						}
				}
				
				dispose();
				tinh.dispose();
				new manageFruit();
			}
		});
		btnNewButton_1.setBounds(119, 230, 65, 23);
		contentPane.add(btnNewButton_1);
		setVisible(true);
	}
}
