package chat.gui;

import chat.EastwoodChat;
import chat.UserInterface;
import chat.client.ClientSocket;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame implements UserInterface {



    public static void connectServer(){

    }


    public final static int SCREEN_WIDTH = 800;
    public final static int SCREEN_HEIGHT = 800;
    public final static String title = "Eastwood Chat";

    private ConnectionPanel connectionPanel;
    private ChatPanel chatPanel;
    private SendMessagePanel sendMessagePanel;

    private void configPanelsAndLayout(){
        //Connection Panel
        connectionPanel = new ConnectionPanel();
        this.add(connectionPanel,  BorderLayout.PAGE_START);

        //Chat Panel
        chatPanel = new ChatPanel();
        this.add(chatPanel, BorderLayout.CENTER);

        //Add scroll for chat
        JScrollPane sp = new JScrollPane(chatPanel);
        this.getContentPane().add(sp);

        //Send Message Panel
        sendMessagePanel= new SendMessagePanel();
        this.add(sendMessagePanel, BorderLayout.PAGE_END);
    }



    public ChatWindow(){
        //Set the window settings
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setTitle(title);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        //this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Create and config panels
        configPanelsAndLayout();


        this.setVisible(true);
        //this.pack();

        //Seta o botão connect como padrão
        this.getRootPane().setDefaultButton(connectionPanel.getConnectButton());
    }

    @Override
    public void addMessage(String nickname, String message) {
        this.chatPanel.addMessage(nickname, message);
    }

    @Override
    public void addSystemMessage(String message) {
        this.chatPanel.addSystemMessage(message);
    }

    @Override
    public void addErrorMessage(String message) {
        this.chatPanel.addErrorMessage(message);
    }

    @Override
    public void clearChat() {
        this.chatPanel.clearChat();
    }


    public ConnectionPanel getConnectionPanel() {
        return connectionPanel;
    }

    public ChatPanel getChatPanel() {
        return chatPanel;
    }

    public SendMessagePanel getSendMessagePanel() {
        return sendMessagePanel;
    }


}