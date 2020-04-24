package practical2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {


		String clientSentence;
		String capitalizedSentece;
		
		System.out.println("Waiting for clients");
		
		ServerSocket welcomeSocket = new ServerSocket(9806);
		
		while(true) {
				
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("Connection is established");
				
			System.out.println("Getting client data");
				
			//to read string client sent
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			clientSentence = inFromClient.readLine();
			
			capitalizedSentece = clientSentence.toUpperCase() + '\n';
			
			outToClient.writeBytes(capitalizedSentece);
			
		}

	}

}
