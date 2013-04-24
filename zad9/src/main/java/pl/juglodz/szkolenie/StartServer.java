package pl.juglodz.szkolenie;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Echo klient i echo serwer wielowatkowy (dla ulatwienia zacznij od
 * jednowatkowego)
 */
public class StartServer {
	public static void main(String[] args) throws IOException {
		//wielowatkowy
		
		// create socket
        int port = 4444;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Started server on port " + port);

        // repeatedly wait for connections, and process
        while (true) {

            // a "blocking" call which waits until a connection is requested
            Socket clientSocket = serverSocket.accept();
            System.out.println("Klient connected and i start echo server thread");
            Thread serverThread = new Thread(new ServerEcho(clientSocket));
            serverThread.start();
        }
	}
}
