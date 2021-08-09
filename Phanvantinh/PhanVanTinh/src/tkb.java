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
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tkb extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tkb frame = new tkb();
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
	public tkb() {
		setBackground(new Color(245, 222, 179));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 328);setUndecorated(true);
		setLocation(750, 230);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u1EDDi Kh\u00F3a Bi\u1EC3u");
		lblNewLabel.setBackground(new Color(255, 255, 102));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\tkb.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(46, 4, 347, 53);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\01.png"));
		btnNewButton.setBounds(2, 2, 32, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("tkb1.jpg"));
		lblNewLabel_1.setBounds(10, 66, 483, 212);
		contentPane.add(lblNewLabel_1);
		setVisible(true);
	}
}
