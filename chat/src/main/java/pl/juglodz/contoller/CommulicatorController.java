
package pl.juglodz.contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import pl.juglodz.model.Model;

public class CommulicatorController {

    private Socket kkSocket;
    private PrintWriter out;
    private Scanner in;
    private final Model model;


    public CommulicatorController(Model m) {
        this.model = m;
        try {
            kkSocket = new Socket("localhost", 4444);
            
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new Scanner(kkSocket.getInputStream());
            Thread t = new Thread(){
                @Override
                public void run() {
                    while (in.hasNextLine()) {
                        model.addMessge(in.nextLine());
                    }
                    
                }
            };
            System.out.println("isConnected " + kkSocket.isConnected());
            System.out.println("isBound " + kkSocket.isBound());
            System.out.println("isInputShutdown " + kkSocket.isInputShutdown());
            
            t.start();
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        model.addMessge(message);
        out.println(message);
        out.flush();
    }

}
