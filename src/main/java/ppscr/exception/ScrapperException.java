package ppscr.exception;

public class ScrapperException extends RuntimeException {

    public ScrapperException() {
    }

    public ScrapperException(String message) {
        super(message);
    }

    public ScrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScrapperException(Throwable cause) {
        super(cause);
    }
}
