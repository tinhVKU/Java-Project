package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	public void connect() {
		try {
			Socket socket = new Socket("localhost", 1912);
			
			PrintStream pStream = new PrintStream(socket.getOutputStream());//sending
			pStream.println("Tau la client xin chao the gioi");										//sending
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = reader.readLine();
			if(response!=null) {
				System.out.println("sever tra loi: "+response);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		client c= new client();
		c.connect();
	}

}
