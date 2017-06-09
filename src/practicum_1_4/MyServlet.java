package practicum_1_4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyServlet extends Thread {
	private Socket socket;
	
    public MyServlet(Socket sock) {
        socket = sock;
    }

    public void run() {
    	try {
	    	Scanner sc = new Scanner(socket.getInputStream());
	    	
	    	while (sc.hasNextLine()) {
	    		String line = sc.nextLine();
	    		
	    		if (line.equals("")) {
	                System.out.println("SUCCES");
	                PrintWriter pw = new PrintWriter(socket.getOutputStream());
	                pw.print("HTTP REQUEST IS GELUKT!");
	                pw.flush();
	    		}
		        else {
		            System.out.println(line);
		        }
	    	}
	    	
	    	sc.close();
    	}
    	catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}
