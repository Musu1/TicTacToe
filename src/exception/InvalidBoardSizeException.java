package exception;

public class InvalidBoardSizeException extends Exception {
    public InvalidBoardSizeException() {
        super();
    }

    public InvalidBoardSizeException(String message) {
        super(message);
    }
}
