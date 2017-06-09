package practicum_1_5;

import java.net.ServerSocket;

import practicum_1_5.MyServlet;

public class Server {

	public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4711); // De server blijft voor altijd draaien en moet handmatig worden afgesloten.

        while (true) {
	        MyServlet ms = new MyServlet(ss.accept());
	        ms.start();
        }

	}

}
