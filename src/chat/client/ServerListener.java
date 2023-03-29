package chat.client;

import chat.UserInterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ServerListener implements Runnable{

    private InputStream listener;
    private UserInterface userInterface;

    public ServerListener(InputStream listener, UserInterface userInterface){
        this.listener = listener;
        this.userInterface = userInterface;
    }

    @Override
    public void run() {
        Scanner s = new Scanner(this.listener);
        while (true){
            if(s.hasNextLine()){
                //Separa o nickname da mensagem
                String[] line = s.nextLine().split("//");
                userInterface.addMessage(line[0], line[1]);
            }
        }
    }
}
