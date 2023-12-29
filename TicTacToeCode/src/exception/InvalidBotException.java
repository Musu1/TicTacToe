package exception;

public class InvalidBotException extends Exception{
    public InvalidBotException() {
        super();
    }

    public InvalidBotException(String message) {
        super(message);
    }
}
