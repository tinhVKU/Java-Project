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
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Form_Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtHost;
	private JTextField txtPort;
	private JTextField txtMessage;
	private ChatMessageSocket msocket;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Client frame = new Form_Client();
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
	public Form_Client() {
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
		
		JTextPane txpMessageBoard = new JTextPane();
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
				msocket.Send(txtMessage.getText());
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
		
		JLabel lblNewLabel = new JLabel("CLIENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 10, 106, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lbhost = new JLabel("Sever Host :");
		lbhost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbhost.setBounds(10, 33, 75, 21);
		contentPane.add(lbhost);
		
		txtHost = new JTextField();
		txtHost.setText("127.0.0.1");
		txtHost.setBounds(89, 33, 86, 20);
		contentPane.add(txtHost);
		txtHost.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int port = Integer.parseInt(txtPort.getText());
					Socket socket = new Socket(txtHost.getText(),port);
					msocket = new ChatMessageSocket(socket,txpMessageBoard);
					txpMessageBoard.setText(txpMessageBoard.getText() + "Connected !");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erorr !");
				}
				
				
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConnect.setBounds(311, 32, 86, 23);
		contentPane.add(btnConnect);
		
		JLabel lblNewLabel_1 = new JLabel("Port :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(186, 33, 37, 18);
		contentPane.add(lblNewLabel_1);
		
		txtPort = new JTextField();
		txtPort.setText("2511");
		txtPort.setBounds(220, 33, 75, 21);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		setVisible(true);
	}
}
