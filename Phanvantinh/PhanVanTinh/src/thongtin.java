import java.awt.BorderLayout;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class thongtin {
public static void main(String[] args) {
	JTextField tf=new JTextField();
	Vector vData =null,vTitle=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","");
		Statement stm =conn.createStatement();
	
		stm.executeUpdate("DELETE FROM `student` WHERE `student`.`Masv` = \'20IT850\'");
//		int num_column=rstmeta.getColumnCount();
//		 vTitle = new Vector(num_column);
//		for(int i=1; i<=num_column;i++) {
//			vTitle.add(rstmeta.getColumnLabel(i));
//			
//		}
//		vData =new Vector();
//		while (rst.next()) {
//			Vector row =new Vector();
//			for(int i=1;i<=num_column;i++) {
//				row.add(rst.getString(i));	
////				System.out.println(rst.getString(i));
////				ResultSet r =stm.executeQuery("SELECT * FROM `student` ");
////				ResultSetMetaData ra =r.getMetaData();
//			}
//			vData.add(row);
//		}
//		rst.close();
//		stm.close();
//		conn.close();
	}
	catch(Exception e1){
		System.out.println(e1.getMessage());
	}
	JScrollPane tableResult = new JScrollPane(new JTable(vData,vTitle));
	JFrame f =new JFrame();
	f.setSize(800, 440);
	f.setContentPane(tableResult);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.show();
//	f.setLayout(n.add(tableResult,"Center");
//	f.add(tf,"North");
//	ew BorderLayout());
	
}
}
