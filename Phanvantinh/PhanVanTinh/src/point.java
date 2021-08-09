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
import javax.swing.BoxLayout;

public class point extends JFrame {
//	 Vector tinh =new Vector();
	private int slrow;
	private JTable tb;
	private JScrollPane tableResult;
	DefaultTableModel model;
	private JPanel contentPane;
	
	int selectedrow=0;
	private JPanel panel_1;
	
	Vector vData;
	Vector vTitle;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					point frame = new point();
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
	public point() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1026, 470);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(new BorderLayout());
		
		JButton b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
		});
		b1.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hình ảnh\\01.png"));
		b1.setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(b1);
		
		contentPane.add(panel,BorderLayout.NORTH);
		
		 panel_1 = new JPanel();
		 panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1,BorderLayout.CENTER);
		
		
		
		reload();
		tb = new JTable(vData,vTitle);
		tb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int removeindex = tb.getSelectedRow();
				if(removeindex!=-1) {
					Vector tinh = (Vector) vData.elementAt(removeindex);
					new cndiem(tinh.get(1).toString(),tinh.get(0).toString(),tinh.get(2).toString(),tinh.get(3).toString(),tinh.get(4).toString(),tinh.get(5).toString(),tinh.get(6).toString(),tinh.get(7).toString(),point.this);
				}
			}
		});
		tableResult = new JScrollPane(tb);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_1.add(tableResult,BorderLayout.CENTER);
		
		
	}
	public void reload() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
			Statement stm =conn.createStatement();
			ResultSet rst =stm.executeQuery("select  MaHS as 'Mã học sinh',Hovaten as 'Họ và tên',Toan as 'Toán' ,Van as 'Văn', Anh as 'Anh Văn' , Hoa as 'Hóa', Li as 'Lí', Sinh as 'Sinh'  from student "
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
	
	
}
