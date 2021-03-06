package socket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.lang.ProcessBuilder.Redirect;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class messenger extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	int i;
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					messenger frame = new messenger();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		//Tạo socket cho client kết nối đến server 
//		Socket clientSocket = new Socket("localhost", 9528);
//		
//		// Tạo file O.stream kết nối với socket
//		DataOutputStream outToServer =
//	            new DataOutputStream(clientSocket.getOutputStream());
//		
//		// Tạo file I.stream kết nối đến socket
//		BufferedReader inFromServer =
//	            new BufferedReader(new
//	            InputStreamReader(clientSocket.getInputStream()));
		
//		//Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket (ở trên)
//        outToServer.writeBytes();
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public messenger() throws UnknownHostException, IOException {
		//Tạo socket cho client kết nối đến server 
				Socket clientSocket = new Socket("localhost", 8888);
				
				// Tạo file O.stream kết nối với socket
				DataOutputStream outToServer =
			            new DataOutputStream(clientSocket.getOutputStream());
				
				// Tạo file I.stream kết nối đến socket
				BufferedReader inFromServer =
			            new BufferedReader(new
			            InputStreamReader(clientSocket.getInputStream()));
		setTitle("Messenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblNewLabel_1.setBounds(10, 11, 291, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblNewLabel_2.setBounds(10, 42, 291, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 73, 291, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(10, 104, 291, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(10, 135, 291, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 166, 291, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(10, 197, 291, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(10, 228, 291, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(10, 259, 291, 20);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setBounds(10, 290, 291, 20);
		contentPane.add(lblNewLabel_10);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(i==0&& !textField.getText().toString().equals("")) {
					lblNewLabel_1.setText(textField.getText());
					textField.setText("");
					lblNewLabel_3.setText("");
					lblNewLabel_5.setText("");
					lblNewLabel_7.setText("");
					lblNewLabel_9.setText("");
					i++;
				}
				if(i==1&& !textField.getText().toString().equals("")) {
					lblNewLabel_3.setText(textField.getText());
					textField.setText("");
					i++;
				}
				if(i==2&& !textField.getText().toString().equals("")) {
					lblNewLabel_5.setText(textField.getText());
					textField.setText("");
					i++;
				}
				if(i==3&& !textField.getText().toString().equals("")) {
					lblNewLabel_7.setText(textField.getText());
					textField.setText("");
					i++;
				}
				if(i==4&& !textField.getText().toString().equals("")) {
					lblNewLabel_9.setText(textField.getText());
					textField.setText("");
					i=0;			
				}
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Truon\\OneDrive\\Hi\u0300nh a\u0309nh\\sendmess1.png"));
		lblNewLabel.setBounds(272, 328, 24, 20);
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				

					if(i==0&&e.getKeyCode()==10&& !textField.getText().toString().equals("")) {
						lblNewLabel_1.setText(textField.getText());
						//Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket (ở trên)
				        try {
							outToServer.writeBytes(lblNewLabel_1.getText().toString());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textField.setText("");
						lblNewLabel_3.setText("");
						lblNewLabel_5.setText("");
						lblNewLabel_7.setText("");
						lblNewLabel_9.setText("");
						i++;
					}
					if(i==1&&e.getKeyCode()==10&& !textField.getText().toString().equals("")) {
						lblNewLabel_3.setText(textField.getText());
						textField.setText("");
						 try {
								outToServer.writeBytes(lblNewLabel_3.getText().toString());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						i++;
					}
					if(i==2&&e.getKeyCode()==10&& !textField.getText().toString().equals("")) {
						lblNewLabel_5.setText(textField.getText());
						textField.setText("");
						 try {
								outToServer.writeBytes(lblNewLabel_5.getText().toString());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						i++;
					}
					if(i==3&&e.getKeyCode()==10&& !textField.getText().toString().equals("")) {
						lblNewLabel_7.setText(textField.getText());
						textField.setText("");
						 try {
								outToServer.writeBytes(lblNewLabel_7.getText().toString());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						i++;
					}
					if(i==4&&e.getKeyCode()==10&& !textField.getText().toString().equals("")) {
						lblNewLabel_9.setText(textField.getText());
						textField.setText("");
						 try {
								outToServer.writeBytes(lblNewLabel_9.getText().toString());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						i=0;
					}
					
			}
		});
		textField.setBounds(68, 328, 194, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
//		try {
//			lblNewLabel_2.setText(inFromServer.readLine());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

//        //Đọc tin từ Server thông qua InputSteam đã nối với socket
//        String sentence_from_server = inFromServer.readLine();
//    
//        //print kết qua ra màn hình
//        System.out.println("FROM SERVER: " + sentence_from_server);
	}
}
