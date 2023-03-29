package chat.client;

import chat.ConnectionInterface;
import chat.UserInterface;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket implements ConnectionInterface {

    public static void closeSocket(ClientSocket socket){
        try{
            socket.output.close();
            socket.client.close();
        }catch (IOException e) {
            System.out.println("haha exception\n");
        }

    }

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
        ServerListener serverListener = new ServerListener(this.client.getInputStream(), userInterface);
        new Thread(serverListener).start();
    }


    @Override
    public void sendMessage(String message){
        this.output.println(this.nickname + "//" + message);
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
