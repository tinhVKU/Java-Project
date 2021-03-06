import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class asdf extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox ;
	String tkString;
	int tam=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {   
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asdf frame = new asdf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public asdf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocation(500, 230);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÍ TRƯỜNG HỌC");
		lblNewLabel.setBounds(10, 5, 424, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã HS/GV");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(29, 46, 126, 30);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(188, 53, 178, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt Kh\u1EA9u");
		
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(29, 87, 111, 32);
		contentPane.add(lblNewLabel_2);
		
		//textField_1 = new JTextField();
		JPasswordField textField_1  = new JPasswordField();     
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tkString = textField.getText();
			}
		});
		textField_1.setBounds(188, 95, 178, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		 comboBox = new JComboBox();
			comboBox.addItem("Học Sinh");
			comboBox.addItem("Giáo Viên");
			comboBox.setBounds(188, 136, 178, 22);
			contentPane.add(comboBox);
		btnNewButton = new JButton("\u0110\u0102NG NH\u1EACP");
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mk="";
				if(comboBox.getSelectedItem().equals("Học Sinh")) {
					try {
						System.out.println("vo");
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
						Statement stm =conn.createStatement();
						ResultSet rst =stm.executeQuery("select Matkhau from dangnhap where MaHS = '"+tkString+"'");
						
						rst.next();
						
						mk= rst.getString(1);
						System.out.println(mk);
						if(textField_1.getText().equals(mk)) {
							dispose();
							new dangnhap(tkString);		  
						} else {
							JOptionPane.showMessageDialog(null, "Sai mật khẩu");
							textField_1.setText("");
						}
						}
					
					catch(SQLException e1){
						JOptionPane.showMessageDialog(null, "Không tồn tại mã này");
						textField_1.setText("");
					}
					
					catch (Exception e2) {
						System.out.println(e2.getMessage());
						
					}
					
					
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
						Statement stm =conn.createStatement();
						ResultSet rst =stm.executeQuery("select pass from passteacher where magv = '"+tkString+"'");
						
						rst.next();
						
						mk= rst.getString(1);
						if(textField_1.getText().equals(mk)) {
							dispose();
							new giangvien(tkString);		  
						} else {
							JOptionPane.showMessageDialog(null, "Sai mật khẩu");
							textField_1.setText("");
						}
						}
					
					catch(SQLException e1){
						JOptionPane.showMessageDialog(null, "Không tồn tại mã này");
						textField_1.setText("");
					}
					
					catch (Exception e2) {
						System.out.println(e2.getMessage());
						
					}
					
//				new giangvien();
//				dispose();
			}
			}
		 });
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(139, 181, 152, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Ch\u01B0a c\u00F3 t\u00E0i kho\u1EA3n ==>");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(114, 222, 137, 27);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setIcon(new ImageIcon("anhdong.gif"));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new nguoidk();
				dispose();
				
		
			}
		});
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBackground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(238, 223, 79, 25);
		contentPane.add(lblNewLabel_4);
		lblNewLabel.setIcon(new ImageIcon("ql1.png"));
		lblNewLabel_1.setIcon(new ImageIcon("cmnd.png"));
		lblNewLabel_2.setIcon(new ImageIcon("mkk1.jpg"));
		
		
		JLabel lblNewLabel_5 = new JLabel("Ng\u01B0\u1EDDi D\u00F9ng");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(29, 130, 152, 30);
		lblNewLabel_5.setIcon(new ImageIcon("pq1.jpg"));
		contentPane.add(lblNewLabel_5);
		
		
		setVisible(true);
	}
}
