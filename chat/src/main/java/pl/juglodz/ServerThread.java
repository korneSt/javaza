package pl.juglodz;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{

    private Scanner sc;
    private PrintWriter pw;

    public ServerThread(Socket sSocket) {
        try {
            sc = new Scanner(sSocket.getInputStream());
            pw = new PrintWriter(sSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Ten klient ma pecha");
        }
       
    }
    
    @Override
    public void run() {
        while (sc.hasNextLine()) {
            String string =  sc.nextLine();
            pw.println("Server " + string);
            pw.flush();
        }
    }

}
