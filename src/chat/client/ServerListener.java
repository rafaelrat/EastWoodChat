package chat.client;

import chat.UserInterface;

import java.io.InputStream;
import java.util.Scanner;

public class ServerListener implements Runnable{

    private final InputStream listener;
    private final UserInterface userInterface;

    public ServerListener(InputStream listener, UserInterface userInterface){
        this.listener = listener;
        this.userInterface = userInterface;
    }

    @Override
    public void run() {
        Scanner s = new Scanner(this.listener);
        while (true){
            if(s.hasNextLine()){
                try{
                    //Separa o nickname da mensagem
                    String[] line = s.nextLine().split("//");
                    userInterface.addMessage(line[0], line[1]);
                }catch (IndexOutOfBoundsException e){
                    System.out.println("mensagem de mais de uma linha - resolva esse bug");
                }

            }
        }
    }
}
