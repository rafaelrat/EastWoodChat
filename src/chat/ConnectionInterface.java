package chat;

public interface ConnectionInterface {
    static boolean connectToServer(String nickname, String host, int port) {
        return false;
    }

    void sendMessage(String message);
}
