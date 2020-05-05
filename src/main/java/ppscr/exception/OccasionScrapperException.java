package ppscr.exception;

public class OccasionScrapperException extends RuntimeException {

    public OccasionScrapperException() {
    }

    public OccasionScrapperException(String message) {
        super(message);
    }

    public OccasionScrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public OccasionScrapperException(Throwable cause) {
        super(cause);
    }
}
