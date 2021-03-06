
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

public class Messager extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaikhoan;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	String tkString;
	int tam=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {   
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messager frame = new Messager();
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
	public Messager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocation(500, 230);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHAT V\u1EDAI B\u1EA0N B\u00C8");
		lblNewLabel.setBounds(10, 11, 424, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00E0i Kho\u1EA3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(32, 59, 126, 30);
		contentPane.add(lblNewLabel_1);
		
		txtTaikhoan = new JTextField();
		txtTaikhoan.setBounds(188, 59, 178, 30);
		contentPane.add(txtTaikhoan);
		txtTaikhoan.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt Kh\u1EA9u");
		
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(32, 112, 111, 32);
		contentPane.add(lblNewLabel_2);
		
		//textField_1 = new JTextField();
		JPasswordField txtmatkhau  = new JPasswordField();     
		txtmatkhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tkString = txtTaikhoan.getText();
			}
		});
		txtmatkhau.setBounds(188, 116, 178, 28);
		contentPane.add(txtmatkhau);
		txtmatkhau.setColumns(10);
		btnNewButton = new JButton("\u0110\u0102NG NH\u1EACP");
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mk="";
				
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mesage","root","");
						Statement stm =conn.createStatement();
						ResultSet rst =stm.executeQuery("select pass from chat where ma = '"+tkString+"'");
						
						rst.next();
						
						mk= rst.getString(1);
						System.out.println(mk);
						if(txtmatkhau.getText().equals(mk)) {
							
							new Form_Client();
						
							System.out.println("ok roi");
						} else {
							JOptionPane.showMessageDialog(null, "Sai m???t kh???u");
							txtmatkhau.setText("");
						}
						}
					
					catch(SQLException e1){
						
						JOptionPane.showMessageDialog(null, "Kh??ng t???n t???i m?? n??y");
						txtmatkhau.setText("");
					}
					
					catch (Exception e2) {
						System.out.println(e2.getMessage());
						
					}
			}
		 });
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(137, 177, 152, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Ch\u01B0a c\u00F3 t\u00E0i kho\u1EA3n ==>");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(114, 222, 137, 27);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("????ng k??");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				dispose();
				
		
			}
		});
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBackground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(251, 223, 72, 25);
		contentPane.add(lblNewLabel_4);
		lblNewLabel.setIcon(new ImageIcon("ql1.png"));
		lblNewLabel_1.setIcon(new ImageIcon("cmnd.png"));
		lblNewLabel_2.setIcon(new ImageIcon("mkk1.jpg"));
		
		
		setVisible(true);
	}
}
