package chat.gui;

import javax.swing.*;

public class ConnectButton extends JButton {
    private boolean connected = false;

    public ConnectButton(String text){
        super(text);
    }
    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
