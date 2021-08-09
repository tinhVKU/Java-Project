import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class xoa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public xoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 117);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("B\u1EA1n ch\u1EAFc ch\u1EAFn mu\u1ED1n x\u00F3a th\u00F4ng tin c\u1EE7a ng\u01B0\u1EDDi n\u00E0y ?");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\tyh.jpg"));
		lblNewLabel.setBounds(1, 12, 334, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("H\u1EE7y ");
		btnNewButton.setBounds(63, 48, 62, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X\u00F3a");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(203, 47, 63, 19);
		contentPane.add(btnNewButton_1);
		setVisible(true);
	}

}
