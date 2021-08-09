package fruit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class manageFruit extends JFrame {
	private JTable tb;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	ArrayList pngArrayList;
	Vector vData;
	Vector vTitle;
	private JScrollPane tableResult;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageFruit frame = new manageFruit();
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
	public manageFruit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 479);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBorder(new MatteBorder(2, 2, 1, 1, (Color) Color.RED));
		panel_1.setBounds(10, 51, 504, 378);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u00D4NG TIN S\u1EA2N PH\u1EA8M");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 21, 488, 43);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn SP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 91, 46, 35);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField("Táo");
		textField.setBounds(66, 92, 167, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Gi\u00E1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 169, 46, 35);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField("15000VND");
		textField_1.setBounds(66, 170, 167, 35);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("HSD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 250, 46, 35);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField("25-11-2021");
		textField_2.setBounds(66, 251, 167, 35);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Xu\u1EA5t x\u1EE9");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 332, 46, 35);
		panel_1.add(lblNewLabel_4);
		
		textField_3 = new JTextField("Việt Nam");
		textField_3.setBounds(66, 333, 167, 35);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(238, 91, 256, 276);
		lblNewLabel_5.setIcon(new ImageIcon("apple.jpg"));
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(new Color(240, 230, 140));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_6.setBounds(332, 75, 55, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(new Color(240, 230, 140));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_7.setBounds(402, 75, 46, 14);
		panel_1.add(lblNewLabel_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 69, 0), new Color(255, 255, 0)));
		panel_2.setBounds(514, 51, 491, 378);
		contentPane.add(panel_2);
		reload();
		tb = new JTable(vData,vTitle);
		tb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int click = tb.getSelectedRow();
				
				Vector tinh = (Vector) vData.elementAt(click);
				
				if(click !=-1) {
					lblNewLabel_7.setText(tinh.get(0).toString());
					textField.setText(tinh.get(1).toString());
					textField.setEditable(false);
					textField_1.setText(tinh.get(2).toString());
					textField_1.setEditable(false);
					textField_2.setText(tinh.get(3).toString());
					textField_2.setEditable(false);
					textField_3.setText(tinh.get(4).toString());
					textField_3.setEditable(false);
					String anh = "" + tinh.get(5).toString();
					lblNewLabel_5.setIcon(new ImageIcon(anh));
					lblNewLabel_6.setText(anh);
				}
				
			}
		});
		tb.setBackground(Color.WHITE);
		
		tableResult = new JScrollPane(tb);
		tableResult.setBounds(1, 1, 783, 351);
		panel_2.setLayout(new BorderLayout());
		panel_2.add(tableResult,"Center");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel_2.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tam();
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new insertFruit("","","","","","",true,manageFruit.this);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Chỉnh sửa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new insertFruit(lblNewLabel_7.getText().toString(),textField.getText().toString(), textField_1.getText().toString(), textField_2.getText().toString(), textField_3.getText().toString(), lblNewLabel_6.getText().toString(), false,manageFruit.this);
			
				
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
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
								Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/maganefruit","root","");
								Statement stm =conn.createStatement();
							
								stm.executeUpdate("DELETE FROM `fruitfruit` WHERE ma='"+tinh.elementAt(0)+"'");
								
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
		
		
		panel.add(btnNewButton_2);
		textField_4 = new HintTextField("                Nhập loại trái cây cần tìm rồi nhấn ENTER");
		textField_4.setBounds(343, 11, 341, 29);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) {
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/maganefruit?zeroDateTimeBehavior=convertToNull","root","");
						Statement stm =conn.createStatement();
						ResultSet rst =stm.executeQuery("SELECT  ma as 'ID' ,name as 'Tên SP',cots as 'Giá', hsd as 'HSD', original as `Xuất xứ`,picture as 'Ảnh'  from fruitfruit  WHERE `name` LIKE '%"+textField_4.getText()+"%'");
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
							JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin !");
						}
					}
					catch(Exception e1){
						System.out.println(e1.getMessage());
					}
					tb  = new JTable(vData,vTitle);
					tableResult.setViewportView(tb);
					tb.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int click = tb.getSelectedRow();
							
							Vector tin = (Vector) vData.elementAt(click);
							
							if(click !=-1) {
								
								textField.setText(tin.get(1).toString());
								textField.setEditable(false);
								textField_1.setText(tin.get(2).toString());
								textField_1.setEditable(false);
								textField_2.setText(tin.get(3).toString());
								textField_2.setEditable(false);
								textField_3.setText(tin.get(4).toString());
								textField_3.setEditable(false);
								String anh = "" + tin.get(5).toString();
								lblNewLabel_5.setIcon(new ImageIcon(anh));
							}
							
						}
					});
				}
				
			}
		});
		
	}
	public void tam(){
		dispose();
		new manageFruit();
		
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
	
	public void reload() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/maganefruit?zeroDateTimeBehavior=convertToNull","root","");
			Statement stm =conn.createStatement();
			ResultSet rst =stm.executeQuery("SELECT  ma as 'ID' ,name as 'Tên SP',cots as 'Giá', hsd as 'HSD', original as `Xuất xứ`,picture as 'Ảnh' FROM fruitfruit");
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
}
