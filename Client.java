import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
    	
    	// using try catch block to handle exceptions.
        try {
        	// create a connection to server socket.
            Socket sock = new Socket("127.0.0.1", 9001);
            
            // loop begins.
            while(true) {
                PrintWriter print = new PrintWriter(sock.getOutputStream(), true);
                BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));       
                Scanner reader = new Scanner(System.in);                
                // program asks for user's name.
        		System.out.println("Please set your name: ");
        		String client = reader.next();
    			System.out.println("Success! Your name is set to: "+client+".");
                
    			// program asks for the user's message, which would be sent to the server.
    			System.out.print("\n["+client+"]: ");
                String clientMessage = bin.readLine();
                print.println(clientMessage);
                
                InputStream input = sock.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(input));
                String serverResponse = read.readLine();
                System.out.println(serverResponse); 
                
                // program asks for user input to either continue or end the loop.
                System.out.print("\nWould you like to enter another message to [Server]? Please type 'Yes' to proceed."); 
                System.out.println("\n["+client+"]: ");
                String ans = bin.readLine();
                
                if(ans.equals("Yes")) {
                	// loop continues.
                }
                else {
                	// loop ends.
                    bin.close();
                    break;
                }
            }
            
        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}