package practicum_1_5;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class MyServlet extends Thread {
	private Socket socket;
	
    public MyServlet(Socket sock) {
        socket = sock;
    }

    public void run() {
    	try {
    		Thread.sleep(1000);
    		Scanner sc = new Scanner(socket.getInputStream());
    	
	    	while (sc.hasNextLine()) {
	    		// De server stuurt geen response terug naar ServerTest
		        System.out.println("ServerTest:"+ sc.nextLine());
	    	}
	    	sc.close();
    	}
    	catch (IOException ioe) {
            System.out.println(ioe);
        }
    	catch (InterruptedException e) {
    		System.out.println(e);
		}
    }

}
