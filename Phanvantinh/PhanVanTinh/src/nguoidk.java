import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class nguoidk extends JFrame {

	private JPanel contentPane;
	int select;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nguoidk frame = new nguoidk();
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
	public nguoidk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(300, 350);
		setLocation(400, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField textField = new JTextField();
		textField.setBounds(74, 127, 140, 23);
		contentPane.add(textField);
		JLabel lblNewLabel = new JLabel("Chọn đối tượng mà bạn muốn đăng kí");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 161, 224, 20);
		contentPane.add(lblNewLabel);
		JButton btnNewButton_1 = new JButton("Tiếp theo");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("NCC123")) {
					if(select==0) {
					new dangki();
					dispose();
					}
					else if (select==1){
						
						new giaovien();
						dispose();
					}
				}
				if(!textField.getText().equals("NCC123")){
					JOptionPane.showInternalMessageDialog(null,"Lỗi !  Mã không chính xác");
				}
			}
		});
		CheckboxGroup sbgr = new CheckboxGroup();
		Checkbox checkbox = new Checkbox("Hoc Sinh",true,sbgr);
		checkbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select=0;
				//System.out.println(textField.getText());
			}
		});
		checkbox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkbox.setBounds(100, 182, 99, 20);
		contentPane.add(checkbox);
		Checkbox checkbox_1 = new Checkbox("Giáo Viên",false,sbgr);
		checkbox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select=1;
				//System.out.println(textField.getText());
			}
		});
		checkbox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkbox_1.setBounds(100, 202, 92, 20);
		contentPane.add(checkbox_1);
		
		JButton btnNewButton = new JButton("Quay lại");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new asdf();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(25, 266, 94, 23);
		contentPane.add(btnNewButton);
		
		
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(163, 266, 94, 23);
		btnNewButton_1.setOpaque(true);
		btnNewButton.setOpaque(true);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nhấn vào tiếp theo để đăng kí");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(55, 241, 185, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Chỉ giáo viên mới có quyền đăng kí ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hình ảnh\\tyh.jpg"));
		lblNewLabel_2.setBounds(10, 11, 264, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mỗi giáo viên được cấp 1 Mã GV\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(25, 50, 214, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("mã này dùng để đăng kí tài khoản cho học sinh ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 66, 264, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vui lòng nhập mã của bạn vào bên dưới !");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 96, 261, 23);
		contentPane.add(lblNewLabel_5);
		
		
		textField.setColumns(10);
		setVisible(true);
	}
	
}
