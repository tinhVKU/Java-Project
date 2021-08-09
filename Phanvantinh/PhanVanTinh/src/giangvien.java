import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.crypto.ExemptionMechanism;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class giangvien extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static void xem() {
		Vector vData =null,vTitle=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
			Statement stm =conn.createStatement();
			ResultSet rst =stm.executeQuery("select * from student");
			ResultSetMetaData rstmeta =rst.getMetaData();
			int num_column=rstmeta.getColumnCount();
			 vTitle = new Vector(num_column);
			for(int i=1; i<=num_column;i++) {
				vTitle.add(rstmeta.getColumnLabel(i));
				
			}
			vData =new Vector();
			while (rst.next()) {
				Vector row =new Vector();
				for(int i=1;i<=num_column;i++) {
					row.add(rst.getString(i));	
				}
				vData.add(row);
			}
			rst.close();
			stm.close();
			conn.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		JScrollPane tableResult = new JScrollPane(new JTable(vData,vTitle));
		JFrame f =new JFrame();
		JButton b1,b2,b3,b4;
		b1 =new JButton("Tìm");
		b2=new JButton("Chỉnh sửa");
		b3=new JButton("Xóa");
		b4=new JButton();
		b4.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\01.png"));
		
		f.setSize(800, 440);
		f.setContentPane(tableResult);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.show();
	}
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public giangvien(String magv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocation(200,200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u00D4NG TIN GI\u00C1O VI\u00CAN");
		lblNewLabel.setBackground(new Color(240, 230, 140));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(54, 11, 344, 43);
		contentPane.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new asdf();
			}
		});
		btnNewButton.setBounds(0, 0, 25, 28);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\01.png"));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 87, 85, 86);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\gv.png"));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(124, 75, 74, 22);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(223, 75, 201, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("L\u1EDBp ch\u1EE7 nhi\u1EC7m");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(124, 128, 96, 22);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 129, 201, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("M\u00E3 Gi\u00E1o Vi\u00EAn");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(124, 178, 96, 22);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 179, 201, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("L\u1ECBch D\u1EA1y");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setBounds(10, 227, 116, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Danh S\u00E1ch L\u1EDBp");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new danhsach();
//				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(148, 227, 135, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cập Nhật Điểm");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new point();
				
			}
		});
		btnNewButton_3.setBounds(306, 227, 118, 23);
		contentPane.add(btnNewButton_3);
		try {
			String mk ="";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
			Statement stm =conn.createStatement();
			ResultSet rst =stm.executeQuery("select hovaten,lop from teacher where magv = '"+magv+"'");
			
			rst.next();
			textField.setText(rst.getString(1));
			textField.setEditable(false);
			textField_1.setText(rst.getString(2));
			textField_1.setEditable(false);
			mk= rst.getString(2);
			textField_2.setText(magv);
			textField_2.setEditable(false);
			
			}
		catch (Exception e2) {
			System.out.println(e2.getMessage());
			
		}
		setVisible(true);
	}
}
