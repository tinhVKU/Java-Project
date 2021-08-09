package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class insert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public insert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 277);
		setLocation(642,200);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0102NG K\u00CD");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 232, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00E0i Kho\u1EA3n");
		lblNewLabel_1.setBounds(10, 61, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(109, 58, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 96, 133, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(109, 134, 133, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_2.setBounds(10, 99, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập lần nữa");
		lblNewLabel_3.setBounds(10, 137, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("H\u1EE7y b\u1ECF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(15, 180, 89, 23);
		contentPane.add(btnNewButton);
	
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().equals("")&&!passwordField_1.getText().equals("")&&!passwordField.getText().equals("")) {
					if(passwordField_1.getText().equals(passwordField.getText())) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mesage","root","");
							Statement stm =conn.createStatement();
							String sqlString = "INSERT INTO `chat` VALUES ('"+textField.getText()+"', '"+passwordField_1.getText()+"')";
							stm.executeUpdate(sqlString);
							
							JOptionPane.showMessageDialog(null, "Đăng kí thành công");
							dispose();
							new Messager();
						}
						
						catch(Exception e7){
							System.out.println(e7.getMessage());
							}
					}
					else {
						JOptionPane.showMessageDialog(null, "Mật khẩu không khớp");
					}
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				
			
				
			}
		});
		btnNewButton_1.setBounds(153, 180, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		setVisible(true);
	}
}
