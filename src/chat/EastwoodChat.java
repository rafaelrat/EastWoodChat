package chat;

import chat.client.*;
import chat.gui.*;

import java.io.IOException;

public class EastwoodChat {

    public static boolean tryToCreateSocket(String nickname, String host, int port, UserInterface userInterface){
        try{
            EastwoodChat.clientSocket = new ClientSocket(nickname, host, port, userInterface);
            clientSocket.execute();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static ClientSocket clientSocket;
    public final static ChatWindow chatWindow = new ChatWindow();



    public static void main(String[] args) {



    }
}