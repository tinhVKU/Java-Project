package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class ClientUI extends JFrame implements ActionListener {	

	// Socket Related
	private static Socket clientSocket;
	private static int PORT;
	private PrintWriter out;

	// JFrame related
	private JPanel contentPane;
	private JTextArea txtAreaLogs;
	private JButton btnStart;
	private JPanel panelNorth;
	private JLabel lblChatClient;
	private JPanel panelNorthSouth;
	private JLabel lblPort;
	private JLabel lblName;
	private JPanel panelSouth;
	private JButton btnSend;
	private JTextField txtMessage;
	private JTextField txtNickname;
	private JTextField txtPort;
	private String clientName;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientUI frame = new ClientUI();
//					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//					SwingUtilities.updateComponentTreeUI(frame);
//					//Logs
//					System.setOut(new PrintStream(new TextAreaOutputStream(frame.getTxtAreaLogs())));
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * Create the frame.
	 */
	public ClientUI(String tam) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelNorth = new JPanel();
		panelNorth.setBackground(new Color(218, 165, 32));
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));

//		lblChatClient = new JLabel("CHAT CLIENT");
		lblChatClient = new JLabel("");
		lblChatClient.setText(tam);
		lblChatClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblChatClient.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panelNorth.add(lblChatClient, BorderLayout.NORTH);

		panelNorthSouth = new JPanel();
		panelNorthSouth.setBackground(new Color(218, 165, 32));
		panelNorth.add(panelNorthSouth, BorderLayout.SOUTH);
		panelNorthSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		lblName = new JLabel("Nickname");
		lblName.setBackground(new Color(218, 165, 32));
		lblName.setForeground(new Color(218, 165, 32));
		panelNorthSouth.add(lblName);

		txtNickname = new JTextField();
		txtNickname.setText(tam);
		txtNickname.setEditable(false);
		txtNickname.setColumns(10);
		txtNickname.setBackground(new Color(218, 165, 32));
		txtNickname.setForeground(new Color(218, 165, 32));
		panelNorthSouth.add(txtNickname);

		lblPort = new JLabel("Port");
		panelNorthSouth.add(lblPort);

		txtPort = new JTextField();
		panelNorthSouth.add(txtPort);
		txtPort.setColumns(10);

		btnStart = new JButton("START");
		panelNorthSouth.add(btnStart);
		btnStart.addActionListener(this);
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		setTxtAreaLogs(new JTextArea());
		getTxtAreaLogs().setBackground(Color.white);
		getTxtAreaLogs().setForeground(Color.red);
		getTxtAreaLogs().setLineWrap(true);
		scrollPane.setViewportView(getTxtAreaLogs());

		panelSouth = new JPanel();
		FlowLayout fl_panelSouth = (FlowLayout) panelSouth.getLayout();
		fl_panelSouth.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(new Color(135, 206, 250));
		panelSouth.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	

		txtMessage = new JTextField();
		panelSouth.add(txtMessage);
		txtMessage.setColumns(50);

		btnSend = new JButton("SEND");
		btnSend.setBackground(new Color(245, 222, 179));
		btnSend.addActionListener(this);
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelSouth.add(btnSend);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStart) {
			if(btnStart.getText().equals("START")) {
				btnStart.setText("EXIT");
				start();
			}else {
				btnStart.setText("START");
				stop();
				dispose();
			}
		}else if(e.getSource() == btnSend) {
			String message = txtMessage.getText().trim();
			if(!message.isEmpty()) {
				out.println(message);
				txtMessage.setText("");
			}
		}
		//Refresh UI
		refreshUIComponents();
	}

	public void refreshUIComponents() {

	}

	public void start() {
		try {
			PORT = Integer.parseInt(txtPort.getText().trim());
			clientName = txtNickname.getText().trim();
			clientSocket = new Socket("localhost", PORT);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			new Thread(new Listener()).start();
			//send name
			out.println(clientName);
		} catch (Exception err) {
			addToLogs("[ERROR] "+err.getLocalizedMessage());
		}
	}

	public void stop(){
		if(!clientSocket.isClosed()) {
			try {
				clientSocket.close();
			} catch (IOException e1) {}
		}
	}

	public static void addToLogs(String message) {
		System.out.printf("%s %s\n", ServerUI.formatter.format(new Date()), message);
	}

	public JTextArea getTxtAreaLogs() {
		return txtAreaLogs;
	}


	public void setTxtAreaLogs(JTextArea txtAreaLogs) {
		this.txtAreaLogs = txtAreaLogs;
	}

	private static class Listener implements Runnable {
		private BufferedReader in;
		@Override
		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String read;
				for(;;) {
					read = in.readLine();
					if (read != null && !(read.isEmpty())) addToLogs(read);
				}
			} catch (IOException e) {
				return;
			}
		}

	}

}
