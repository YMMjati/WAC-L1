package practicum_1_2;

import java.net.Socket;
import java.io.PrintWriter;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 4711);
		PrintWriter pw = new PrintWriter(s.getOutputStream()); // autoFlush = false
		
        pw.write("Hello to you!");
        
        pw.flush();

		s.close();
	}

}