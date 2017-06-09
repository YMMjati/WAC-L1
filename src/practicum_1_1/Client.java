package practicum_1_1;

import java.net.Socket;
import java.io.OutputStream;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 4711);
		OutputStream os = s.getOutputStream();
		os.write("Hello!\n".getBytes());
		s.close();
	}

}
