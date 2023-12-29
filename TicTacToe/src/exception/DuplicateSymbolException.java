package exception;

public class DuplicateSymbolException extends Exception {
    public DuplicateSymbolException() {
        super();
    }

    public DuplicateSymbolException(String message) {
        super(message);
    }
}
