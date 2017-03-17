import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main_Server {

	public static void main(String[] args) throws IOException {
	
		System.out.println("server main started...");
		
		// try to start the server
		ServerSocket serverSocket = new ServerSocket(8000);
		System.out.println("server started successfully.");
		
		int clientNumber = -1; 
		
		while(true){	
			System.out.println("waiting for client...");
			Socket clientSocket = serverSocket.accept();
			clientNumber++;
			new ServerListener(clientSocket,clientNumber).start();
			System.out.println("new client connected.");			
		}
		
		
	}



}
