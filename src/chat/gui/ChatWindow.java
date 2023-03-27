package chat.gui;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame{



    public final static int SCREEN_WIDTH = 800;
    public final static int SCREEN_HEIGHT = 800;
    public final static String title = "Eastwood Chat";


    private ConnectionPanel connectionPanel;
    private ChatPanel chatPanel;

    private void configPanelsAndLayout(){
        connectionPanel = new ConnectionPanel();
        this.add(connectionPanel,  BorderLayout.PAGE_START);

        chatPanel = new ChatPanel();
        this.add(chatPanel, BorderLayout.CENTER);

        JScrollPane sp = new JScrollPane(chatPanel);
        this.getContentPane().add(sp);

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
       // this.pack();
    }
}