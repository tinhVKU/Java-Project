package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public void server() {
		try {
			ServerSocket serverSocket = new ServerSocket(1912);
			System.out.println("server dang doi....");
			Socket socket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String resulf = reader.readLine();
			if(resulf!=null) {
				System.out.println("sever nhan tn tu client: "+resulf);
				
				PrintStream pStream = new PrintStream(socket.getOutputStream());//sending
				pStream.println("tau nhan duoc roi");										//sending
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		server s = new server();
		s.server();
	}

}
