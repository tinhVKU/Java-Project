import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Scrollable;

public class bang extends JFrame {
	private JScrollPane tableResult;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bang frame = new bang();
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
	public bang() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 26);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(47, 0, 255, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("T\u00ECm");
		btnNewButton.setBounds(321, 0, 51, 26);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 25, 434, 236);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(27, 11, 297, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton1 = new JButton("T\u00ECm");
		btnNewButton1.setBounds(334, 11, 71, 26);
		contentPane.add(btnNewButton);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(2, 43, 430, 217);
		contentPane.add(panel);
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
//		tableResult = new JScrollPane(new JTable(vData,vTitle));
//		contentPane
//		add(tableResult,"Center");
//		add(textField ,"North");
//		add(btnNewButton ,"North");
	}
	}


