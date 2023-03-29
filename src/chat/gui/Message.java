package chat.gui;

import javax.swing.*;
import java.awt.*;

public class Message extends JPanel {

    private static final Font NICKNAME_FONT = new Font(Font.SERIF, Font.BOLD, 15);
    private static final Font MESSAGE_FONT = new Font(Font.SERIF, Font.PLAIN, 12);

    private JLabel nicknameLabel;
    private JLabel messageLabel;

    public void configBorders(){this.setBorder(BorderFactory.createLineBorder(Color.green));}


    public Message(String nickname, String message){
        configBorders();

        //this.setAlignmentX(Component.LEFT_ALIGNMENT);

        nicknameLabel = new JLabel(nickname);
        nicknameLabel.setFont(NICKNAME_FONT);
        nicknameLabel.setForeground(Color.red);

        messageLabel = new JLabel(message);
        messageLabel.setFont(MESSAGE_FONT);


        this.add(nicknameLabel);
        this.add(messageLabel);

        this.setVisible(true);
    }
}
