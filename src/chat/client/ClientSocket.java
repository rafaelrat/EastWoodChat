package chat.client;

import chat.UserInterface;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

    private String host;
    private int port;
    private String nickname;
    private UserInterface userInterface;

    private PrintStream output;
    private Socket client;

    public String getNickname() {
        return nickname;
    }

    public ClientSocket(String nickname, String host, int port, UserInterface userInterface) throws IOException {
        this.nickname = nickname;
        this.host = host;
        this.port = port;
        this.userInterface = userInterface;


        this.client = new Socket(host, port);

        this.output = new PrintStream(client.getOutputStream());
    }
    public void execute() throws IOException {
        //treat the sever messages
        ServerListener serverListener = new ServerListener(this, this.client.getInputStream(), userInterface);
        new Thread(serverListener).start();
    }


    public void sendMessage(String message){
        this.output.println(message);
    }




}
