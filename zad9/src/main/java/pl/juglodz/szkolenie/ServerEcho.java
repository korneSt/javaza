package pl.juglodz.szkolenie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerEcho implements Runnable {

	private Socket clientSocket;

	public ServerEcho(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		// open up IO streams
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                    true); 

			// waits for data and reads it in until connection dies
			// readLine() blocks until the server receives a new line from
			// client
			out.println("Welcome to server echo!");
			String s;
			while ((s = in.readLine()) != null) {
				System.out.println("Client said: " + s);
				out.println(s);
				
			}

			// close IO streams, then socket
			System.out.println("Closing connection with client");
			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
