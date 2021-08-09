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
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class tcdiem extends JFrame {

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
	public tcdiem(String name,String mhs) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 233, 277);setUndecorated(true);
		setVisible(true);
		setLocation(750,250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(name);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(0, 0, 121, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(mhs);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(122, 0, 61, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To\u00E1n");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(25, 44, 61, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("V\u0103n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(25, 95, 61, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Anh V\u0103n");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(25, 145, 62, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("H\u00F3a");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(122, 43, 61, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("L\u00ED");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(122, 95, 61, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sinh");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(122, 145, 61, 14);
		panel.add(lblNewLabel_7);
		
		textField = new JTextField();
		
		textField.setBounds(24, 61, 62, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
	
		textField_1.setBounds(24, 112, 62, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		
		textField_2.setBounds(24, 163, 62, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		
		textField_3.setBounds(121, 61, 62, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		
		textField_4.setBounds(122, 112, 62, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
	
		textField_5.setBounds(122, 163, 61, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(255, 250, 205));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(69, 198, 71, 23);
		panel.add(btnNewButton);
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
			Statement stm =conn.createStatement();
			ResultSet rst =stm.executeQuery("SELECT `Toan`, `Van`, `Anh`, `Hoa`, `Li`, `Sinh` FROM `student` where MaHS = '"+mhs+"'");
			
			rst.next();
			textField.setText(rst.getString(1));
			textField.setEditable(false);
			textField_1.setText(rst.getString(2));
			textField_1.setEditable(false);		
			textField_2.setText(rst.getString(3));
			textField_2.setEditable(false);
			textField_3.setText(rst.getString(4));
			textField_3.setEditable(false);
			textField_4.setText(rst.getString(5));
			textField_4.setEditable(false);		
			textField_5.setText(rst.getString(6));
			textField_5.setEditable(false);
		}
		catch (Exception e2) {
			System.out.println(e2.getMessage());
			
		}
	}
}
