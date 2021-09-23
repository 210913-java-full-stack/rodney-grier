package exceptions;

public class BadUserException  extends Exception {

    public BadUserException(String message) {
        super(message);
    }
    public BadUserException() {
        super("Bad user input");
    }

}
