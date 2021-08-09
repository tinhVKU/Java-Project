import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ChatFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtHjk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame();
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
	public ChatFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 395, 231);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 246, 395, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setBounds(296, 26, 89, 23);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 18, 276, 36);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JTextPane txtpnDsfdsa = new JTextPane();
		txtpnDsfdsa.setText("dsfdsa");
		txtpnDsfdsa.setBounds(190, 308, 191, 46);
		contentPane.add(txtpnDsfdsa);
		
		txtHjk = new JTextField();
		txtHjk.setText("hjk");
		txtHjk.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHjk.setBounds(10, 322, 170, 32);
		contentPane.add(txtHjk);
		txtHjk.setColumns(10);
	}
}
