import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class managefruit extends JFrame {
	private JTextField textField;
	private JTextField txtFvxcZxc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managefruit frame = new managefruit();
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
	public managefruit() {
		getContentPane().setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		textField.setBounds(80, 11, 269, 20);
		textField = new HintTextField("Nhập tên trái cây cần tìm rồi nhấn ENTER");
	
		
		getContentPane().add(textField);
		
		txtFvxcZxc = new JTextField();
		txtFvxcZxc.setHorizontalAlignment(SwingConstants.CENTER);
		txtFvxcZxc.setText("fvxc zxc");
		txtFvxcZxc.setBounds(117, 119, 86, 20);
		getContentPane().add(txtFvxcZxc);
		txtFvxcZxc.setColumns(10);
		textField.setColumns(10);
	}
	class HintTextField extends JTextField {
	    public HintTextField(String hint) {
	        _hint = hint;
	    }
	    @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        if (getText().length() == 0) {
	            int h = getHeight();
	            ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	            Insets ins = getInsets();
	            FontMetrics fm = g.getFontMetrics();
	            int c0 = getBackground().getRGB();
	            int c1 = getForeground().getRGB();
	            int m = 0xfefefefe;
	            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
	            g.setColor(new Color(c2, true));
	            g.drawString(_hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
	        }
	    }
	    private final String _hint;
	}
}
