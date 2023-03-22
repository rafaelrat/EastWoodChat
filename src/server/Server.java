package server;

import chat.client.ServerListener;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final String SERVER_HOST = "10.0.0.48";
    public static final int SERVER_PORT = 21;

    public List<PrintStream> clients;

    public Server(){
        this.clients = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        new Server().execute();
    }

    public void execute() throws IOException {

        System.out.println("Starting server.");
        System.out.println("Opening port: " + SERVER_PORT);

        ServerSocket server = new ServerSocket(SERVER_PORT);

        System.out.println("Port opened: " + SERVER_PORT);

        while(true){
            //accept the client
            Socket client = server.accept();
            System.out.println("new client connection: " + client.getInetAddress());

            //add client output to list
            PrintStream ps = new PrintStream(client.getOutputStream());
            this.clients.add(ps);

            //treat the client
            TreatClient tc = new TreatClient(client, client.getInputStream(), this);
            new Thread(tc).start();
        }

    }

    public void sendMessage(String msg){
        for(PrintStream client : this.clients){
            client.println(msg);
        }
    }

}
