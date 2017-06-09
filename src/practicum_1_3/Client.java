package practicum_1_3;

import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 4711);
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(s.getOutputStream()); // autoFlush = false
		
        while (true) {
            System.out.print("Voer hier iets in: ");
            String line = sc.nextLine();

            pw.write(line + "\n");
            pw.flush();

            if(line.equals("stop")){
                break;
            }
        }

        sc.close();
		s.close();
	}

}