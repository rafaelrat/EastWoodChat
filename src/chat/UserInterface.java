package chat;

public interface UserInterface {
    void showClientMessage(String nickname, String message);

    void showMessage(String message);
    void showNewConnetion();
    void showErrorMessage(String message);

}
