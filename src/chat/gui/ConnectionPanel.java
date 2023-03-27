package chat.gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ConnectionPanel extends JPanel{

    private static Font FIELDS_FONT = new Font(Font.SERIF, Font.PLAIN, 15);
    private  static Font LABELS_FONT = new Font(Font.SERIF, Font.PLAIN, 15);

    //Text Fields
    private JTextField nicknameTextField;
    private JTextField ipTextField;
    private JTextField portTextField;


    //Labels
    private JLabel nicknameLabel;
    private JLabel ipLabel;
    private JLabel portLabel;

    //Button
    private JButton connectButton;


    private void configBorders(){
        this.setBorder(BorderFactory.createLoweredBevelBorder());
    }

    private void configInputFieldsandLabels(){

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
        ipLabel = new JLabel("Host");
        ipLabel.setFont(LABELS_FONT);
        this.add(ipLabel);

        //IP text field
        ipTextField = new JTextField(10);
        //ipTextField.setBackground(Color.green);
        ipTextField.setFont(FIELDS_FONT);
        ipTextField.setHorizontalAlignment(JTextField.CENTER);
        this.add(ipTextField);

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

    private void configButtons(){
        connectButton = new JButton("Connect");
        this.add(connectButton);
    }
    public ConnectionPanel(){
        configBorders();
        configInputFieldsandLabels();
        configButtons();
    }

}
