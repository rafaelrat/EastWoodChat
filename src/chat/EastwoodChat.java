package chat;

import chat.client.*;
import chat.gui.*;

import java.awt.*;
import java.io.IOException;
import java.util.EnumSet;

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

    public static void disconnectServer(){
        ClientSocket.closeSocket(EastwoodChat.clientSocket);

        EastwoodChat.chatWindow.clearChat();
        EastwoodChat.clientSocket = null;

        EastwoodChat.chatWindow.addSystemMessage("Disconnected.");

        var connectButton = EastwoodChat.chatWindow.getConnectionPanel().getConnectButton();
        connectButton.setText("Connect");
        connectButton.setConnected(false);
        connectButton.setBackground(Color.green);

        //Habilita a edição dos campos
        EastwoodChat.chatWindow.getConnectionPanel().getNicknameTextField().setEditable(true);
        EastwoodChat.chatWindow.getConnectionPanel().getHostTextField().setEditable(true);
        EastwoodChat.chatWindow.getConnectionPanel().getPortTextField().setEditable(true);

        //Seta o foco no host
        EastwoodChat.chatWindow.getConnectionPanel().getHostTextField().grabFocus();
        connectButton.grabFocus();

        //Seta o botão connect como padrão
        EastwoodChat.chatWindow.getConnectionPanel().getRootPane().setDefaultButton(connectButton);
    }

    public static void connectServer(){
        var nicknameTextField = EastwoodChat.chatWindow.getConnectionPanel().getNicknameTextField();
        var hostTextField = EastwoodChat.chatWindow.getConnectionPanel().getHostTextField();
        var portTextField = EastwoodChat.chatWindow.getConnectionPanel().getPortTextField();

        var connectButton = EastwoodChat.chatWindow.getConnectionPanel().getConnectButton();

        var nickname = nicknameTextField.getText();
        var host = hostTextField.getText();
        var port = portTextField.getText();

        boolean connected;
        try {
            connected = EastwoodChat.tryToCreateSocket(nickname, host, Integer.parseInt(port), EastwoodChat.chatWindow);
        } catch (NumberFormatException exception) {
            connected = false;
        }


        if (connected) {

            EastwoodChat.chatWindow.clearChat();

            nicknameTextField.setEditable(false);
            hostTextField.setEditable(false);
            portTextField.setEditable(false);

            EastwoodChat.chatWindow.addSystemMessage("Connected successfully!");
            EastwoodChat.chatWindow.addSystemMessage("Host: " + EastwoodChat.clientSocket.getHost() + ":" + EastwoodChat.clientSocket.getPort());

            connectButton.setText("Disconnect");
            connectButton.setConnected(true);
            connectButton.setBackground(Color.red);

            //Seta o foco no text field da mensagem
            EastwoodChat.chatWindow.getSendMessagePanel().getMessageField().grabFocus();

            //Seta o botão send como padrão
            EastwoodChat.chatWindow.getConnectionPanel().getRootPane().setDefaultButton(EastwoodChat.chatWindow.getSendMessagePanel().getSendMessageButton());
        } else {

            EastwoodChat.chatWindow.addErrorMessage("Error to connect.");
            EastwoodChat.chatWindow.addSystemMessage("Check the host and port!");
            connectButton.setConnected(false);
            //Seta o botão connect como padrão
            EastwoodChat.chatWindow.getConnectionPanel().getRootPane().setDefaultButton(connectButton);
        }
    }

    public static ClientSocket clientSocket;
    public final static ChatWindow chatWindow = new ChatWindow();



    public static void main(String[] args) {



    }
}