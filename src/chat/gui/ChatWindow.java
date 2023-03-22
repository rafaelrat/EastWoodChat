package chat.gui;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame{

    private static void createAndConfigPanels(ChatWindow chatWindow){
        //Config connection panel
        chatWindow.connectionPanel = new JPanel();
        chatWindow.connectionPanel.add(new JMenu());



        //Config chat panel
        chatWindow.chatPanel = new JPanel();
        chatWindow.chatPanel.setBackground(Color.red);

        //Add Panels
        chatWindow.add(chatWindow.connectionPanel, BorderLayout.PAGE_START);
        chatWindow.add(chatWindow.chatPanel, BorderLayout.CENTER);
    }

    public final static int SCREEN_WIDTH = 800;
    public final static int SCREEN_HEIGHT = 800;
    public final static String title = "Eastwood Chat";


    private JPanel connectionPanel;
    private JPanel chatPanel;


    public ChatWindow(){
        //Set the window settings
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setTitle(title);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        //this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Create and config panels
       createAndConfigPanels(this);


        this.setVisible(true);
        //this.pack();
    }
}