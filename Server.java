import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args){
    	// using try catch block to handle exceptions.
        try {
            ServerSocket sock = new ServerSocket(9001);
            Socket client = sock.accept();
            // loop begins.
            while(true){
                if(client.isConnected()){
                	String e = "[Server]: Client successfully connected!";
                    PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                    System.out.println(e);
                    InputStream is = client.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String clientMessage = br.readLine();
                    pw.println("[Server]: "+clientMessage);
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}

