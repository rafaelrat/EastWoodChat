package chat.gui;


import javax.swing.*;

public class ChatPanel extends JPanel{

    public ChatPanel(){
        //Bordas
        this.setBorder(BorderFactory.createLoweredBevelBorder());

        this.add(new JButton("chatPanel"));
    }
}
