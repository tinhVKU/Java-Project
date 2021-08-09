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

public class doimk extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public doimk(String mahs) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 212);
		setLocation(642,200);
		setVisible(true);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("B\u1EA1n Mu\u1ED1n \u0110\u1ED5i M\u1EADt Kh\u1EA9u");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(6, 11, 274, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u c\u0169");
		lblNewLabel_1.setBounds(3, 47, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(109, 44, 169, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewLabel_2.setBounds(3, 78, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 75, 170, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nh\u1EADp l\u1EA1i l\u1EA7n n\u1EEFa");
		lblNewLabel_3.setBounds(3, 112, 101, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 106, 168, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("H\u1EE7y b\u1ECF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(26, 140, 89, 23);
		contentPane.add(btnNewButton);
	
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("")&&!textField_1.getText().equals("")&&!textField_2.getText().equals("")) {
					if(textField.getText().equals("123")) {
						if(textField_1.getText().equals(textField_2.getText())) {
							 try {
									Class.forName("com.mysql.jdbc.Driver");
									Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
									Statement stm =conn.createStatement();
								
									stm.executeUpdate("update dangnhap set Matkhau = '"+textField_1.getText()+"' where MaHS = '"+mahs+"'");
									
									}
									
								catch(Exception e1){
									System.out.println(e1.getMessage());
								}
							JOptionPane.showMessageDialog(null, "Đổi thành công");
						}
						else {
							JOptionPane.showMessageDialog(null, "Mật khẩu không thống nhất");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Lỗi ! Sai mật khẩu cũ");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				
			}
		});
		btnNewButton_1.setBounds(170, 140, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
