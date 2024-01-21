import java.io.*;
import java.net.*;


public class ExtractServer {
	
	protected Socket socket;
	public static boolean listening = true;
	
	public static void main(String[] args) throws IOException {
		 
	        ServerSocket serverSocket = null;
	        try {
	            serverSocket = new ServerSocket(4444);
	        } catch (IOException e) {
	            System.err.println("Could not listen on port: 4444.");
	            System.exit(1);
	        }
	        while (listening)
	            new ETMultiServerThread(serverSocket.accept()).start();
	     
	        serverSocket.close();
	    }
}

