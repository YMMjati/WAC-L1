package practicum_1_5;

import java.net.Socket;
import java.io.PrintWriter;
import java.text.DecimalFormat; // Wordt gebruikt voor het weergeven van de seconden.
// De duur is niet 100% accuraat, maar geeft wel in brede lijnen weer hoe lang het ongeveer duurt.

public class ServerTest {

	public static void main(String[] args) {
		long starttime = System.nanoTime();
		int noThreads = 120;
		
        for (int x = 1; x < noThreads; x++) {
            new MyThread("Thread #"+ x).start();
        }
        
        double elapsedtime = (System.nanoTime() - starttime) / 1000000000.0;
        System.out.println("Duration: "+  new DecimalFormat("#.####").format(elapsedtime) +" seconds");
	}
	
	static class MyThread extends Thread {

        public MyThread(String naam) {
            super(naam);
        }
        
        public void run() {
            String naam = Thread.currentThread().getName();
            try {
                Socket s = new Socket("localhost", 4711);
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                pw.write(naam +" -- SUCCESS");
                pw.flush();
                System.out.println(naam +" -- SUCCESS");
                s.close();
            } catch (Exception e) {
                System.out.println(naam +" -- FAILURE");
            }
        }
    }

}
