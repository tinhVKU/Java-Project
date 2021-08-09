import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextPane;

public class ChatMessageSocket {
	private Socket socket;
	private JTextPane txpMessageBoard;
	private PrintWriter out ;
	private BufferedReader reader;
	public ChatMessageSocket(Socket socket, JTextPane txpMessageBoard) throws IOException {
		 this.socket = socket;
		 this.txpMessageBoard = txpMessageBoard;
		 
		 out = new PrintWriter(socket.getOutputStream());
		 reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		 receive();
	 }
	
	private void receive() {
		Thread th = new Thread() {
			public void run() {
				while(true) {
					String line;
					try {
						line = reader.readLine();
						if(line!= null) {
							txpMessageBoard.setText(txpMessageBoard.getText() + "\n" + line);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		th.start();
	}
	
	public void Send(String mag) {
		String current =txpMessageBoard.getText();
		txpMessageBoard.setText(current + "\nSent: "+ mag);
		out.println(mag);
		out.flush();
		
	}
	public void close() {
		try {
			out.close();
			reader.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
