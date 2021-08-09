import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class dangnhap extends JFrame {

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
	public dangnhap(String mahs) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocation(300,230);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u00D4NG TIN H\u1ECCC SINH");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setBackground(new Color(240, 230, 140));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(62, 1, 276, 38);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(13, 80, 85, 85);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\hs1.png"));
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(122, 71, 76, 25);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("L\u1EDBp");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(122, 118, 76, 21);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 119, 208, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("M\u00E3 H\u1ECDc Sinh");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(122, 164, 76, 25);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 166, 208, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Th\u1EDDi Kh\u00F3a Bi\u1EC3u");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new tkb();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnNewButton.setBounds(12, 211, 126, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tra C\u1EE9u \u0110i\u1EC3m");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new tcdiem(textField.getText(),textField_2.getText());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(156, 211, 124, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("L\u1ECBch Thi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new lichthi();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnNewButton_2.setBounds(298, 210, 127, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new asdf();
			}
		});
		btnNewButton_3.setBounds(4, 3, 25, 25);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\01.png"));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new doimk(textField_2.getText());
			}
		});
		lblNewLabel_5.setForeground(new Color(255, 255, 0));
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(339, 11, 85, 14);
		textField = new JTextField();
		textField.setBounds(216, 74, 208, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.add(lblNewLabel_5);
		try {
			String mk ="";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
			Statement stm =conn.createStatement();
			ResultSet rst =stm.executeQuery("select Hovaten,Lop from student where MaHS = '"+mahs+"'");
			
			rst.next();
			textField.setText(rst.getString(1));
			textField.setEditable(false);
			textField_1.setText(rst.getString(2));
			textField_1.setEditable(false);
			mk= rst.getString(2);
			textField_2.setText(mahs);
			textField_2.setEditable(false);
			
			}
		catch (Exception e2) {
			System.out.println(e2.getMessage());
			
		}
		
		setVisible(true);
	}
}
