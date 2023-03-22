package chat.client;

import chat.UserInterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ServerListener implements Runnable{

    private ClientSocket clientSocket;
    private InputStream listener;
    private UserInterface userInterface;

    public ServerListener(ClientSocket clientSocket, InputStream listener, UserInterface userInterface){
        this.clientSocket = clientSocket;
        this.listener = listener;
        this.userInterface = userInterface;
    }

    @Override
    public void run() {
        Scanner s = new Scanner(this.listener);
        while (true){
            if(s.hasNextLine()){
                userInterface.showClientMessage(clientSocket.getNickname(), s.nextLine());
            }
        }
    }
}
