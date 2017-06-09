package practicum_1_4;

import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4711);
        MyServlet ms = new MyServlet(ss.accept());
        ms.start();
        ss.close();
	}

}
