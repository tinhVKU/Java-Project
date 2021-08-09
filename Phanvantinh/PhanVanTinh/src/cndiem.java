import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.MysqlDataTruncation;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class cndiem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public cndiem(String name,String mhs,String toan,String van,String anh,String hoa,String li,String sinh, point tinh) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 266);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(name);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(44, 7, 210, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(mhs);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(258, 7, 70, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To\u00E1n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(21, 67, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("V\u0103n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(154, 67, 61, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Anh V\u0103n");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(290, 67, 63, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("H\u00F3a");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(24, 114, 46, 17);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("L\u00ED");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(162, 113, 46, 19);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sinh");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(307, 115, 46, 17);
		panel.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setText(toan);
		textField.setBounds(21, 84, 62, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(van);
		textField_1.setBounds(154, 84, 62, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(anh);
		textField_2.setBounds(290, 84, 62, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText(hoa);
		textField_3.setBounds(21, 134, 62, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText(li);
		textField_4.setBounds(156, 134, 62, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText(sinh);
		textField_5.setBounds(289, 134, 62, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("H\u1EE7y b\u1ECF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(78, 178, 80, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
					Statement stm =conn.createStatement();
				
					stm.executeUpdate("update student set `Toan`='"+textField.getText()+"',`Van`='"+textField_1.getText()+"',`Anh`='"+textField_2.getText()+"',`Hoa`='"+textField_3.getText()+"',`Li`='"+textField_4.getText()+"',`Sinh`='"+textField_5.getText()+"' where MaHS = '"+lblNewLabel_1.getText()+"'");
					
					}
					
				catch(Exception e1){
					System.out.println(e1.getMessage());
				}
				tinh.dispose();
				dispose();
				new point();
			}
		});
		btnNewButton_1.setBounds(222, 178, 80, 23);
		panel.add(btnNewButton_1);
	}
}
