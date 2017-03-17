import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerListener extends Thread{
	   private Socket socket;
       private int clientNumber;
       private DataInputStream dataInputStream;
       private int length;
       private byte[] dataBytes;
       private String msg;
       
	public ServerListener(Socket socket , int clientNumber) {
		this.socket = socket;
		this.clientNumber = clientNumber;	
	}
	
	@Override
	public void run() {
		
		try {
			while(true){
				System.out.println("wait for the msg.");
				dataInputStream = new DataInputStream(socket.getInputStream());
				
				length = dataInputStream.readInt();		// i send the length at first
				
			    dataBytes = new byte[length];		// create array as a buffer
				
				dataInputStream.read(dataBytes);			// read the data into the buffer array	
				
				msg = new String(dataBytes);			// convert to string
				
				System.out.println("clinet " + clientNumber +" :" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
