package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {

	public static void main(String[] args) {
		String sentence_from_client;
        String sentence_to_client; 
        String to_client; 
        String toi_client; 
        String tu_client; 
        String from_client;
        String gui;
        String nhan;
        String den;
        String di;
        //Tạo socket server, chờ tại cổng '6543'
        try {
        	ServerSocket welcomeSocket = new ServerSocket(8888);
            System.out.println("Dang cho client...");
            while(true) {
                //chờ yêu cầu từ client
                Socket connectionSocket = welcomeSocket.accept();
                //Tạo input stream, nối tới Socket
                BufferedReader inFromClient =
                    new BufferedReader(new
                        InputStreamReader(connectionSocket.getInputStream())); 
                //Tạo outputStream, nối tới socket
                DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());
                //Đọc thông tin từ socket
                sentence_from_client = inFromClient.readLine();
                System.out.println("Received from client: " + sentence_from_client);
                sentence_to_client = sentence_from_client +" (Server accepted!)" + '\n';
                //ghi dữ liệu ra socket
                outToClient.writeBytes(sentence_to_client); 
    			
                from_client = inFromClient.readLine();
                System.out.println("Received from client: " + from_client);
                to_client = from_client +" (Server accepted!)" + '\n';
                outToClient.writeBytes(to_client);
                
                tu_client = inFromClient.readLine();
                System.out.println("Received from client: " + tu_client);
                toi_client = tu_client +" (Server accepted!)" + '\n';
                outToClient.writeBytes(toi_client);
                
                nhan = inFromClient.readLine();
                System.out.println("Received from client: " + nhan);
                gui = nhan +" (Server accepted!)" + '\n';
                outToClient.writeBytes(gui);
                
                den = inFromClient.readLine();
                System.out.println("Received from client: " + den);
                di = den +" (Server accepted!)" + '\n';
                outToClient.writeBytes(di);
                
                return;
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
