import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class ChatPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ChatPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Message", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		panel.add(scrollPane);
		
		JTextArea textMessage = new JTextArea();
		scrollPane.setViewportView(textMessage);
		
		JButton btnSend = new JButton("G\u1EEDi");
		panel.add(btnSend);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		add(scrollPane_1, BorderLayout.CENTER);
		
		JTextArea contenMessage = new JTextArea();
		scrollPane_1.setViewportView(contenMessage);

	}

}
