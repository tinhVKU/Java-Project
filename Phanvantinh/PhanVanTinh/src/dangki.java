import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.EventQueue;

import javax.sql.RowSetListener;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.MysqlDataTruncation;

import java.awt.Checkbox;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.BreakIterator;
import java.util.Vector;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dangki extends JFrame {
	int tam;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private CheckboxGroup checkboxGroup;
	private JTextField textField_2 ;
	private JTextField txtN;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	public static int t;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangki frame = new dangki();
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
	public dangki() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(370,400);
		setLocation(570, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel.setBounds(8, 7, 65, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("L\u1EDBp");
		lblNewLabel_1.setBounds(8, 41, 28, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_2.setBounds(7, 70, 79, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tr\u01B0\u1EDDng");
		lblNewLabel_3.setBounds(5, 101, 81, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("T\u1EC9nh (Th\u00E0nh ph\u1ED1)");
		lblNewLabel_4.setBounds(5, 136, 106, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("S\u0110T");
		lblNewLabel_5.setBounds(6, 170, 63, 22);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(5, 205, 60, 22);
		contentPane.add(lblNewLabel_6);
		
		
		textField = new JTextField();
		textField.setBounds(118, 9, 220, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(50, 40, 69, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Gi\u1EDBi T\u00EDnh");
		lblNewLabel_7.setBounds(152, 38, 58, 20);
		contentPane.add(lblNewLabel_7);
		
		textField_2 = new HintTextField("N??m - Th??ng - Ng??y ");
		textField_2.setBounds(117, 69, 220, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		txtN = new JTextField();
		txtN.setBounds(117, 103, 220, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);
		CheckboxGroup sbgr = new CheckboxGroup();
		Checkbox checkbox = new Checkbox("Nam",true,sbgr);
		checkbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tam=0;
			}
		});
		checkbox.setBounds(222, 36, 42, 22);
		contentPane.add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("N???",false,sbgr);
		checkbox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tam=1;
			}
		});
		checkbox_1.setBounds(271, 36, 49, 22);
		contentPane.add(checkbox_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(117, 135, 220, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 169, 220, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(117, 201, 220, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("M?? h???c sinh");
		lblNewLabel_8.setBounds(4, 239, 103, 23);
		contentPane.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(117, 237, 220, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("M???t kh???u");
		lblNewLabel_9.setBounds(7, 277, 92, 23);
		contentPane.add(lblNewLabel_9);
		
		textField_7 = new JTextField("123");
		textField_7.setEditable(false);
		textField_7.setBounds(119, 274, 220, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		JButton btnNewButton = new JButton("\u0110\u0102NG K\u00CD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
					Statement stm =conn.createStatement();
					String sqlString = "INSERT INTO `dangnhap` VALUES ('"+textField_6.getText()+"', '"+textField_7.getText()+"')";
					stm.executeUpdate(sqlString);
					
				}
				catch(Exception e7){
					System.out.println(e7.getMessage());
					}
				if(textField_2.getText().length()!=0&&textField_7.getText().length()!=0&&textField.getText().length()!=0
						&&textField_1.getText().length()!=0
					&&txtN.getText().length()!=0&&textField_3.getText().length()!=0&&textField_4.getText().length()!=0
					&&textField_5.getText().length()!=0&&textField_6.getText().length()!=0){
					
						
						
							if(tam==0) {
								try {
									Class.forName("com.mysql.jdbc.Driver");
									Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
									Statement stm =conn.createStatement();
									String sqlString = "INSERT INTO `student` (`MaHS`, `Hovaten`, `Lop`, `Gioitinh`, `Ngaysinh`, `Noio`) VALUES ('"+textField_6.getText()+"', '"+textField.getText()+"', '"+textField_1.getText()+"', 'Nam', '"+textField_2.getText()+"', '"+textField_4.getText()+"')";
									stm.executeUpdate(sqlString);
									//stm.executeUpdate("insert into student values('"+textField_6.getText()+"','"+textField.getText()+"','"+textField_1.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_4.getText()+"')");	
								}
								catch(MysqlDataTruncation e2) {
									JOptionPane.showMessageDialog(null,"L???i ! Sai ?????nh d???ng ng??y");
									 
								}
								catch(Exception e5){
									e5.printStackTrace();
									System.out.println(e5.getMessage());
									JOptionPane.showInternalMessageDialog(null,"????ng k?? th??nh c??ng");
									
									dispose();
									new asdf();
								} 
								
							}
							if(tam==1) {
								try {
									Class.forName("com.mysql.jdbc.Driver");
									Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
									Statement stm =conn.createStatement();
									String sqlString = "INSERT INTO `student` (`MaHS`, `Hovaten`, `Lop`, `Gioitinh`, `Ngaysinh`, `Noio`) VALUES ('"+textField_6.getText()+"', '"+textField.getText()+"', '"+textField_1.getText()+"', 'N???', '"+textField_2.getText()+"', '"+textField_4.getText()+"')";
									stm.executeUpdate(sqlString);
									//stm.executeUpdate("insert into student values('"+textField_6.getText()+"','"+textField.getText()+"','"+textField_1.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_4.getText()+"')");	
								}
								catch(MysqlDataTruncation e7) {
									
									JOptionPane.showMessageDialog(null,"L???i ! Sai ?????nh d???ng ng??y");
								}
								catch(Exception e3){
									System.out.println(e3.getMessage());
									e3.printStackTrace();
									JOptionPane.showInternalMessageDialog(null,"????ng k?? th??nh c??ng");
									
									dispose();
									new asdf();
								}
								
							}
						
				
				
			}
				else {
					JOptionPane.showInternalMessageDialog(null,"Vui l??ng nh???p ?????y ????? th??ng tin");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(193, 315, 122, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quay l\u1EA1i");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 new nguoidk();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(30, 315, 122, 29);
		contentPane.add(btnNewButton_1);
		
		

		setVisible(true);
		//System.out.println(t);
	}
	class HintTextField extends JTextField {
	    public HintTextField(String hint) {
	        _hint = hint;
	    }
	    @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        if (getText().length() == 0) {
	            int h = getHeight();
	            ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	            Insets ins = getInsets();
	            FontMetrics fm = g.getFontMetrics();
	            int c0 = getBackground().getRGB();
	            int c1 = getForeground().getRGB();
	            int m = 0xfefefefe;
	            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
	            g.setColor(new Color(c2, true));
	            g.drawString(_hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
	        }
	    }
	    private final String _hint;
	}

	
}
