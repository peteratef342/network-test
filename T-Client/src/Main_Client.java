import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main_Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		System.out.println("clinet main started..");
		Socket socket = new Socket("localHost", 8000);
		System.out.println("connected to server successfully.");

		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

		for (int i = 0; i < 5; i++) {
			
		
			String msg = "Hi my name peter.";
			int msgLength = msg.getBytes().length;				 // calculate the msg length in bytes
			
			dataOutputStream.writeInt(msgLength);			 // set the msg first to the length of the msg
	
			dataOutputStream.write(msg.getBytes()); 				 // write the msg in Bytes
	
			dataOutputStream.flush(); 						 // send the msg
	
			System.out.println("message 1 is sent.");
	
	
			
			msg = "make sure you get it";
			msgLength =msg.getBytes().length;				 // calculate the msg length in bytes
		
			dataOutputStream.writeInt(msgLength);			 // set the msg first to the length of the msg
	
			dataOutputStream.write(msg.getBytes()); 				 // write the msg in Bytes
	
			dataOutputStream.flush(); 						 // send the msg
	
			System.out.println("message 2 is sent.");
		
		}
		
		Long start = System.currentTimeMillis();
		
		while ( System.currentTimeMillis() - start < 3000) {
		}
		
	}

}
