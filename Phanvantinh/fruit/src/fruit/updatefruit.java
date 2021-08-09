package fruit;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class updatefruit extends JFrame {

	private JPanel contentPane;
	String filename = null;
	byte[] person_image = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatefruit frame = new updatefruit();
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
	public updatefruit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 11, 193, 192);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Chooose");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				filename = f.getAbsolutePath();
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
				lblNewLabel.setIcon(imageIcon);
				try {
					File image = new File(filename);
					FileInputStream fis = new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					for(int readNum; (readNum= fis.read(buf))!=1;) {
						bos.write(buf, 0, readNum);
						
					}
					person_image = bos.toByteArray();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setBounds(71, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
