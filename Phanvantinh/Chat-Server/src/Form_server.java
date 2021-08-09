import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Form_server extends JFrame {

	private JPanel contentPane;
	private JTextField txtPort;
	private JTextField txtMessage;
	private ChatMassegeSocket mSocket;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_server frame = new Form_server();
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
	public Form_server() {
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 65, 395, 205);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane txpMessageBoard =           new JTextPane();
		scrollPane.setViewportView(txpMessageBoard);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 281, 395, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMessage.getText().equals("")) {
					return;
				}
				mSocket.Send(txtMessage.getText());
				txtMessage.setText("");
			}
		});
		btnSend.setBackground(new Color(245, 222, 179));
		btnSend.setBounds(296, 31, 89, 23);
		panel_1.add(btnSend);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 23, 273, 31);
		panel_1.add(scrollPane_1);
		
		txtMessage = new JTextField();
		scrollPane_1.setViewportView(txtMessage);
		txtMessage.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SERVER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 10, 106, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lbPort = new JLabel(" Port :");
		lbPort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPort.setBounds(30, 33, 46, 21);
		contentPane.add(lbPort);
		
		txtPort = new JTextField();
		txtPort.setText("2511");
		txtPort.setBounds(75, 33, 89, 20);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JButton btnListen = new JButton("Listen");
		btnListen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int port = Integer.parseInt(txtPort.getText());
					ServerSocket serverSocket = new ServerSocket(port);
					Thread th = new Thread() {
						public void run() {
							try {
								txpMessageBoard.setText(txpMessageBoard.getText() + "Listening...");
								Socket socket = serverSocket.accept();
								mSocket = new ChatMassegeSocket(socket,txpMessageBoard);
								
							} catch (Exception e2) {
								txpMessageBoard.setText("<br> Erorr: "+ e2.getStackTrace());
								e2.printStackTrace();
							}
						}
					};
					th.start();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Erorr");
					e1.printStackTrace();
				}
				
			}
		});
		btnListen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnListen.setBounds(296, 32, 89, 23);
		contentPane.add(btnListen);
	}
}
