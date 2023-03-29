package chat.gui;

import javax.swing.*;
import java.awt.*;

public class SendMessagePanel extends JPanel {

    private  static final Font SEND_MESSAGE_FONT = new Font(Font.SERIF, Font.PLAIN, 15);

    private JTextArea messageArea;

    private JButton sendMessageButton;

    private void configBorders(){
        this.setBorder(BorderFactory.createLoweredBevelBorder());
    }

    private void configComponents(){
        messageArea = new JTextArea();
        messageArea.setFont(SEND_MESSAGE_FONT);
        messageArea.setColumns(20);
        this.add(messageArea);

        sendMessageButton = new JButton("Send");
        this.add(sendMessageButton);
    }


    public SendMessagePanel(){
        configBorders();
        configComponents();
    }
}
