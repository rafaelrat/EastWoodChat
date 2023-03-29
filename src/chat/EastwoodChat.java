package chat;

import chat.client.*;
import chat.gui.*;
import server.*;

import java.io.IOException;
import java.util.Scanner;

public class EastwoodChat {
    public static void main(String[] args) {

        UserInterface userInterface = new ChatWindow();

        try {
            ClientSocket clientSocket = new ClientSocket("priqito", "127.0.0.1", Server.SERVER_PORT, userInterface);
            userInterface.addSystemMessage("You are connected!");

            clientSocket.execute();

            Scanner s = new Scanner(System.in);
            while (true) {
                if (s.hasNextLine()) {
                    String msg = s.nextLine();
                    if (msg != "\n") {
                        clientSocket.sendMessage(msg);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}