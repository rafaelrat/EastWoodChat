package chat;

import chat.client.ClientSocket;
import server.Server;

import java.io.IOException;
import java.util.Scanner;

public class EastwoodChatClient {
    public static void main(String[] args){
        //new ChatWindow();

        UserInterface userInterface = new CommandLineTest();

        try{
            ClientSocket clientSocket = new ClientSocket("rafael", Server.SERVER_HOST, Server.SERVER_PORT, userInterface);
            userInterface.showMessage("You are connected!");

            Scanner s = new Scanner(System.in);
            while(true){
                if(s.hasNextLine()){
                    String msg = s.nextLine();
                    if(msg != "\n"){
                        clientSocket.sendMessage(msg);
                    }
                }
            }

        } catch (IOException e) {
            userInterface.showErrorMessage("Error to connect. Check the host and port");
        }




    }
}
