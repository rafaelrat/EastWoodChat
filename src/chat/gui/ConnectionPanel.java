package chat.gui;

import chat.EastwoodChat;
import chat.client.ClientSocket;

import javax.swing.*;
import java.awt.*;

public class ConnectionPanel extends JPanel {

    private static final Font FIELDS_FONT = new Font(Font.SERIF, Font.PLAIN, 15);
    private static final Font LABELS_FONT = new Font(Font.SERIF, Font.PLAIN, 15);

    //Text Fields
    private JTextField nicknameTextField;
    private JTextField hostTextField;
    private JTextField portTextField;


    //Labels
    private JLabel nicknameLabel;
    private JLabel hostLabel;
    private JLabel portLabel;

    //Button
    private ConnectButton connectButton;


    private void configBorders() {
        this.setBorder(BorderFactory.createLoweredBevelBorder());
    }

    private void configInputFieldsandLabels() {

        //Nickname label
        nicknameLabel = new JLabel("Nickname");
        nicknameLabel.setFont(LABELS_FONT);
        this.add(nicknameLabel);

        //Nickname text field
        nicknameTextField = new JTextField(10);
        //ipTextField.setBackground(Color.green);
        nicknameTextField.setFont(FIELDS_FONT);
        nicknameTextField.setHorizontalAlignment(JTextField.CENTER);
        this.add(nicknameTextField);

        //IP label
        hostLabel = new JLabel("Host");
        hostLabel.setFont(LABELS_FONT);
        this.add(hostLabel);

        //IP text field
        hostTextField = new JTextField(10);
        //ipTextField.setBackground(Color.green);
        hostTextField.setFont(FIELDS_FONT);
        hostTextField.setHorizontalAlignment(JTextField.CENTER);
        this.add(hostTextField);

        //Port label
        portLabel = new JLabel("Port");
        portLabel.setFont(LABELS_FONT);
        this.add(portLabel);

        //IP text field
        portTextField = new JTextField(5);
        //portTextField.setBackground(Color.red);
        portTextField.setFont(FIELDS_FONT);
        portTextField.setHorizontalAlignment(JTextField.CENTER);
        this.add(portTextField);
    }

    private void configButtons() {
        connectButton = new ConnectButton("Connect");
        connectButton.setBackground(Color.green);

        connectButton.addActionListener(e -> {
            //Close the socket, clear the chat and change button text
            if (connectButton.isConnected()) {
                EastwoodChat.disconnectServer();
            } else {
                EastwoodChat.connectServer();
            }

        });

        this.add(connectButton);
    }

    public ConnectionPanel() {
        configBorders();
        configInputFieldsandLabels();
        configButtons();
    }

    public ConnectButton getConnectButton() {
        return connectButton;
    }

    public JTextField getNicknameTextField() {
        return nicknameTextField;
    }

    public JTextField getHostTextField() {
        return hostTextField;
    }

    public JTextField getPortTextField() {
        return portTextField;
    }
}
