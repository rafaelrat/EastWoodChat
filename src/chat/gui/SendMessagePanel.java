package chat.gui;

import chat.EastwoodChat;

import javax.swing.*;
import java.awt.*;

public class SendMessagePanel extends JPanel {

    private static final Font SEND_MESSAGE_FONT = new Font(Font.SERIF, Font.PLAIN, 15);


    private JLabel sendMessageLabel;
    private JTextField messageField;

    private JButton sendMessageButton;


    private void configBorders() {
        this.setBorder(BorderFactory.createLoweredBevelBorder());
    }

    private void configComponents() {
        sendMessageLabel = new JLabel("Message: ");
        sendMessageLabel.setFont(SEND_MESSAGE_FONT);
        this.add(sendMessageLabel);

        messageField = new JTextField(19);

        messageField.setFont(SEND_MESSAGE_FONT);
        messageField.setAutoscrolls(true);
        this.add(messageField);

        sendMessageButton = new JButton("Send");
        this.add(sendMessageButton);

        sendMessageButton.addActionListener(e -> {
            String message = messageField.getText();

            if (!message.isBlank()) {
                if (EastwoodChat.chatWindow.getConnectionPanel().getConnectButton().isConnected()) {
                    EastwoodChat.clientSocket.sendMessage(message);
                    messageField.setText("");

                } else {
                    EastwoodChat.chatWindow.addSystemMessage("You're not connected to a server.");
                }
            }else{
                EastwoodChat.chatWindow.addSystemMessage("Blank messages are not accepted.");
            }


        });

    }


    public SendMessagePanel() {
        configBorders();
        configComponents();
    }
}
