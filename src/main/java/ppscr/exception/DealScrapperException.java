package ppscr.exception;

public class DealScrapperException extends RuntimeException {

    public DealScrapperException() {
    }

    public DealScrapperException(String message) {
        super(message);
    }

    public DealScrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public DealScrapperException(Throwable cause) {
        super(cause);
    }
}
