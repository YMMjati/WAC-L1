package practicum_1_3;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(4711);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		Scanner sc = new Scanner(is);
		
        while(sc.hasNextLine()){
            System.out.print(sc.nextLine() + "\n");
        }
		
        sc.close();
		s.close();
		ss.close();
	}

}
