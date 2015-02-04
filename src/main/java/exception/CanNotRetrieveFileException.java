package exception;

public class CanNotRetrieveFileException extends Exception {
    public CanNotRetrieveFileException() {
        super();
    }

    public CanNotRetrieveFileException(String message) {
        super(message);
    }

    public CanNotRetrieveFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CanNotRetrieveFileException(Throwable cause) {
        super(cause);
    }

    protected CanNotRetrieveFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
