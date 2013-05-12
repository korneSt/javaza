package pl.juglodz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        while (true) {
            Socket sSocket = serverSocket.accept();
            new ServerThread(sSocket).start();
        }
    }

}
