package chat;

public class CommandLineTest implements UserInterface {

    @Override
    public void showClientMessage(String nickname, String message) {
        System.out.println(nickname + ": " + message);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showNewConnetion() {

    }

    @Override
    public void showErrorMessage(String message) {

    }



}
