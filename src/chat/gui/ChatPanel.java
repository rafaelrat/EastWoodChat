package chat.gui;


import chat.EastwoodChat;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ChatPanel extends JTextPane {

    private static final Font MESSAGE_FONT = new Font(Font.SERIF, Font.BOLD, 15);
    private static final Color SYSTEM_MESSAGE_COLOR = Color.orange;
    private static final Color ERROR_MESSAGE_COLOR = Color.red;

    private static final Color EXTERNAL_NICKNAME_COLOR = Color.pink;
    private static final Color EXTERNAL_MESSAGE_COLOR = Color.black;
    private static final Color INTERNAL_NICKNAME_COLOR = Color.blue;
    private static final Color INTERNAL_MESSAGE_COLOR = Color.black;

    private Image backgroundImage;

    private void configBorders() {
        this.setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public void addSystemMessage(String message) {
        StyledDocument doc = this.getStyledDocument();

        Style style = this.addStyle("Color Style", null);
        StyleConstants.setForeground(style, SYSTEM_MESSAGE_COLOR);
        try {
            doc.insertString(doc.getLength(), message + "\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void addErrorMessage(String message) {
        StyledDocument doc = this.getStyledDocument();

        Style style = this.addStyle("Color Style", null);
        StyleConstants.setForeground(style, ERROR_MESSAGE_COLOR);
        try {
            doc.insertString(doc.getLength(), message + "\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void clearChat() {
        this.setText("");
    }


    public void addMessage(String nickname, String message) {
        StyledDocument doc = this.getStyledDocument();

        //Nickname
        Style style = this.addStyle("Color Style", null);

        if (nickname.equals(EastwoodChat.clientSocket.getNickname())) {
            StyleConstants.setForeground(style, INTERNAL_NICKNAME_COLOR);
        } else {
            StyleConstants.setForeground(style, EXTERNAL_NICKNAME_COLOR);
        }

        try {
            doc.insertString(doc.getLength(), nickname + ": ", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        //Message
        style = this.addStyle("Color Style", null);
        if (nickname.equals(EastwoodChat.clientSocket.getNickname())) {
            StyleConstants.setForeground(style, INTERNAL_MESSAGE_COLOR);
        } else {
            StyleConstants.setForeground(style, EXTERNAL_MESSAGE_COLOR);
        }

        try {
            doc.insertString(doc.getLength(), message + "\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void configBackgroundImage(){
        //Config icon
        try{
            URL image = this.getClass().getResource("/chat/assets/image.gif");
            if(image != null){
                backgroundImage = new ImageIcon(image).getImage();
            }
        }catch (Exception e){
            System.out.printf("nao funfou");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        //draw background image
        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - backgroundImage.getWidth(null)) / 2;
        int y = (this.getHeight() - backgroundImage.getHeight(null)) / 2;
        g2d.drawImage(backgroundImage, x, y, null);



        super.paintComponent(g);

    }

    public ChatPanel() {

        this.setOpaque(false);
        configBorders();
        configBackgroundImage();


        this.setEditable(false);
        this.setFont(MESSAGE_FONT);


    }
}
