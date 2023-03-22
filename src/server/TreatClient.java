package server;

import javax.print.attribute.standard.Severity;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TreatClient implements Runnable{

    private InputStream clientInputStream;
    private Socket client;
    private Server server;

    public TreatClient(Socket client, InputStream clientInputStream , Server server){
        this.client = client;
        this.clientInputStream = clientInputStream;
        this.server = server;
    }

    @Override
    public void run() {
        //when receive a message, sent for all clients
        Scanner s = new Scanner(clientInputStream);
        while(client.isConnected()){
            if(s.hasNextLine()){
                String message = s.nextLine();
                if(message != "\n"){
                    server.sendMessage(message);
                }
            }
        }
    }
}
