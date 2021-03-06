import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.MysqlDataTruncation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class giaovien extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	int tam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaovien frame = new giaovien();
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
	public giaovien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(370,430);
		setLocation(570, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel.setBounds(10, 11, 74, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(129, 12, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("L\u1EDBp gi\u1EA3ng d\u1EA1y");
		lblNewLabel_1.setBounds(10, 45, 81, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 43, 64, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		CheckboxGroup sbgr = new CheckboxGroup();
		Checkbox checkbox = new Checkbox("Nam",true,sbgr);
		checkbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tam=0;
			}
		});
		checkbox.setBounds(253, 43, 42, 22);
		contentPane.add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("Nu",false,sbgr);
		checkbox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tam=1;
			}
		});
		checkbox_1.setBounds(301, 43, 39, 22);
		contentPane.add(checkbox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_2.setBounds(186, 42, 59, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_3.setBounds(10, 75, 64, 22);
		contentPane.add(lblNewLabel_3);
		
		JTextField textField_2 = new HintTextField("N??m / Th??ng / Ng??y ");
		textField_2.setBounds(131, 76, 212, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Tr?????ng");
		lblNewLabel_4.setBounds(10, 108, 63, 23);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 110, 215, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("T???nh (Th??nh ph???)");
		lblNewLabel_5.setBounds(10, 139, 97, 22);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(129, 142, 215, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("S??T");
		lblNewLabel_6.setBounds(10, 172, 74, 23);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(129, 173, 215, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setBounds(10, 206, 97, 23);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("M?? gi??o vi??n");
		lblNewLabel_8.setBounds(10, 240, 97, 23);
		contentPane.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(129, 207, 215, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(129, 241, 215, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Nh???p m???t kh???u");
		lblNewLabel_9.setBounds(10, 274, 97, 23);
		contentPane.add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		JPasswordField textField_8 =new JPasswordField();
		textField_8.setBounds(129, 275, 215, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Nh???p l???i m???t kh???u");
		lblNewLabel_10.setBounds(10, 308, 109, 23);
		contentPane.add(lblNewLabel_10);
		
		textField_9 = new JTextField();
		JPasswordField textField_9 =new JPasswordField();
		textField_9.setBounds(129, 309, 215, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton = new JButton("Quay l???i");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new nguoidk();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(46, 350, 109, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("????NG K??");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
					Statement stm =conn.createStatement();
					String sqlString = "INSERT INTO `passteacher` VALUES ('"+textField_7.getText()+"', '"+textField_8.getText()+"')";
					stm.executeUpdate(sqlString);
					
				}
				catch(Exception e7){
					System.out.println(e7.getMessage());
					}
				if(textField_9.getText().length()!=0&&textField_7.getText().length()!=0&&textField.getText().length()!=0
						&&textField_1.getText().length()!=0
						&&textField_2.getText().length()!=0&&textField_3.getText().length()!=0&&textField_4.getText().length()!=0
						&&textField_5.getText().length()!=0&&textField_6.getText().length()!=0&&textField_8.getText().length()!=0){
						if(textField_8.getText().length()>=8) {
							if(!textField_9.getText().equals(textField_8.getText())) {
								JOptionPane.showInternalMessageDialog(null,"M???t kh???u kh??ng th???ng nh???t");
							}
							else {
								if(tam==0) {
									try {
										Class.forName("com.mysql.jdbc.Driver");
										Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
										Statement stm =conn.createStatement();
										String sqlString = "INSERT INTO `teacher` VALUES ('"+textField_7.getText()+"', '"+textField.getText()+"', '"+textField_1.getText()+"', 'Nam', '"+textField_2.getText()+"', '"+textField_4.getText()+"', '"+textField_5.getText()+"', '"+textField_6.getText()+"')";
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
										String sqlString = "INSERT INTO `teacher` VALUES ('"+textField_7.getText()+"', '"+textField.getText()+"', '"+textField_1.getText()+"', 'N???', '"+textField_2.getText()+"', '"+textField_4.getText()+"', '"+textField_5.getText()+"', '"+textField_6.getText()+"')";
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
//								JOptionPane.showInternalMessageDialog(null,"????ng k?? th??nh c??ng");
//								
//								dispose();
//								new asdf();
							}
					}
						else {
							JOptionPane.showInternalMessageDialog(null,"M???t kh???u ch??a ????? 8 k?? t???");
						}
					
				}
					else {
						JOptionPane.showInternalMessageDialog(null,"Vui l??ng nh???p ?????y ????? th??ng tin");
					}
				}
			});
		btnNewButton_1.setBounds(201, 350, 109, 30);
		contentPane.add(btnNewButton_1);
		textField_2.setColumns(10);
		setVisible(true);
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
