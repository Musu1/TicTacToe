package exception;

public class InvalidNumberOfPlayersException extends Exception {
    public InvalidNumberOfPlayersException() {
        super();
    }

    public InvalidNumberOfPlayersException(String message) {
        super(message);
    }
}
