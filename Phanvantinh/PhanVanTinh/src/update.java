import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class update extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public update(String ten,String mahs,String gioitinh,String lop,String ngaysinh,String noio,danhsach abc ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ch\u1EC9nh s\u1EEDa th\u00F4ng tin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 11, 323, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel_1.setBounds(9, 59, 54, 22);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(69, 59, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 HS");
		lblNewLabel_2.setBounds(227, 57, 41, 23);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(269, 59, 152, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		JLabel lblNewLabel_3 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_3.setBounds(10, 112, 53, 23);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setToolTipText("");
		comboBox.setBounds(69, 111, 139, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		
		JLabel lblNewLabel_4 = new JLabel("L\u1EDBp");
		lblNewLabel_4.setBounds(225, 112, 30, 22);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(269, 112, 150, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_5.setBounds(8, 164, 64, 22);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(70, 165, 138, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nơi ở");
		lblNewLabel_6.setBounds(225, 165, 42, 21);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(269, 165, 149, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Hủy bỏ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton.setBounds(87, 217, 89, 23);
		contentPane.add(btnNewButton);
		textField.setText(ten);
		textField_1.setText(mahs);
		
		textField_2.setText(lop);
		textField_3.setText(ngaysinh);
		textField_4.setText(noio);
		if(gioitinh.equals("Nam")) {
			comboBox.setSelectedItem("Nam");
			
		}
		else {
			comboBox.setSelectedItem("Nữ");
		}
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					 try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
							Statement stm =conn.createStatement();
						
							stm.executeUpdate("update student set MaHS = '"+textField_1.getText()+"',Hovaten = '"+textField.getText()+"', Lop = '"+textField_2.getText()+"',  Gioitinh = '"+comboBox.getSelectedItem().toString()+"', Ngaysinh = '"+textField_3.getText()+"', Noio = '"+textField_4.getText()+"' where MaHS = '"+textField_1.getText()+"'");
							
							}
							
						catch(Exception e1){
							System.out.println(e1.getMessage());
						}
					
					
					 
					
					 dispose();
					abc.tam();
				}
		
		});
		btnNewButton_1.setBounds(254, 216, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
