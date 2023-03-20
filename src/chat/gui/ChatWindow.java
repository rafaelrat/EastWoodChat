package chat.gui;

import javax.swing.*;

public class ChatWindow extends JFrame{

    public final static int SCREEN_WIDTH = 800;
    public final static int SCREEN_HEIGHT = 800;
    public final static String title = "Eastwood Chat";


    public ChatWindow(){
        //Set the window settings
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setTitle(title);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        //this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}