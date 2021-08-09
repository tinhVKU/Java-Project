import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.MysqlDataTruncation;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class danhsach extends JFrame {
//	 Vector tinh =new Vector();
	private int slrow;
	private JTable tb;
	private JScrollPane tableResult;
	DefaultTableModel model;
	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	int selectedrow=0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	Vector vData;
	Vector vTitle;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					danhsach frame = new danhsach();
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
	public danhsach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800, 470);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		 panel.setBackground(Color.WHITE);
		panel.setBounds(1, 1, 783, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new HintTextField("      Nhập vào tên muốn tìm rồi nhấn ENTER");
		
		
		textField.setBounds(254, 7, 263, 31);
		panel.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) {
					
					tim();
				}
				
			}
		});

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\tim1.jpg"));
		lblNewLabel.setBounds(208, 7, 45, 31);
		panel.add(lblNewLabel);
		
		 panel_1 = new JPanel();
		 panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(1, 50, 783, 316);
		contentPane.add(panel_1);
		
		
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(1, 377, 783, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		reload();
		tb = new JTable(vData,vTitle);
		
		tableResult = new JScrollPane(tb);
		tableResult.setBounds(1, 1, 783, 351);
		panel_1.setLayout(new BorderLayout());
		panel_1.add(tableResult,"Center");
		btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tam();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(178, 11, 97, 28);
		panel_2.add(btnNewButton_1);
		
//sua
		btnNewButton_2 = new JButton("Ch\u1EC9nh s\u1EEDa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int removeindex = tb.getSelectedRow();
					if(removeindex==-1) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng để chỉnh sửa");
					}
					else {
						
						 Vector tinh =  (Vector) vData.elementAt(removeindex);
						 new update(tinh.get(1).toString(),tinh.get(0).toString(),tinh.get(3).toString(),tinh.get(2).toString(),tinh.get(4).toString(),tinh.get(5).toString(),danhsach.this);
					}
					
				
				}
			});
			
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(340, 11, 105, 28);
		panel_2.add(btnNewButton_2);
		
//xoa
		btnNewButton_3 = new JButton("X\u00F3a");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int removeindex = tb.getSelectedRow();
				if(removeindex==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng để xóa");
				}
				else {
					String list[] ={"Có","Không"};
					int n= JOptionPane.showOptionDialog(null, "Bạn có chắc chắn xóa không ?","Lưu Ý",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,list,0);
					if(n==0) {
						Vector tinh =  (Vector) vData.elementAt(removeindex);
						 System.out.println(tinh);
						 try {
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
								Statement stm =conn.createStatement();
							
								stm.executeUpdate("DELETE FROM `student` WHERE MaHS='"+tinh.elementAt(0)+"'");
								
								}
								
							catch(Exception e1){
								e1.printStackTrace();
								System.out.println(e1.getMessage());
							}
						 tam();
					}
					
				}
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(515, 11, 97, 28);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String magv = null;
				dispose();
//				new giangvien(magv);
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hình ảnh\\01.png"));
		btnNewButton_4.setBounds(1, 5, 29, 27);
		panel.add(btnNewButton_4);
	}
	
	
//toa bang
	public void reload() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien?zeroDateTimeBehavior=convertToNull","root","");
			Statement stm =conn.createStatement();
			ResultSet rst =stm.executeQuery("select  MaHS as 'Mã học sinh',Hovaten as 'Họ và tên', Lop as 'Lớp',  Gioitinh as 'Giới tính', Ngaysinh as 'Ngày sinh', Noio as 'Nơi ở' from student "
					+ " order by MaHS");
			ResultSetMetaData rstmeta =rst.getMetaData();
			int num_column=rstmeta.getColumnCount();
			 vTitle = new Vector(num_column);
			for(int i=1; i<=num_column;i++) {
				vTitle.add(rstmeta.getColumnLabel(i));
				
			}
			vData =new Vector();
			while (rst.next()) {
				Vector row =new Vector(num_column);
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
		
	}
	
	
	
	
	
//tim
	public void tim() {
		Vector vData =null,vTitle=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien?zeroDateTimeBehavior=convertToNull","root","");
			Statement stm =conn.createStatement();
			ResultSet rst =stm.executeQuery("select  MaHS as 'Mã học sinh',Hovaten as 'Họ và tên', Lop as 'Lớp',  Gioitinh as 'Giới tính', Ngaysinh as 'Ngày sinh', Noio as 'Nơi ở' from student  WHERE `Hovaten` LIKE '%"+textField.getText()+"%'");
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
			if(vData.size()==0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin của người này !");
			}
		}
		catch(Exception e1){
			System.out.println(e1.getMessage());
		}
		tableResult.setViewportView(new JTable(vData,vTitle));
	}
	public void tam(){
		new danhsach();
		dispose();
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
