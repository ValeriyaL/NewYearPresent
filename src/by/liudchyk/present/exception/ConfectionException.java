package by.liudchyk.present.exception;

/**
 * Created by Admin on 08.10.2016.
 */
public class ConfectionException extends Exception {
    public ConfectionException() {
    }

    public ConfectionException(String message) {
        super(message);
    }

    public ConfectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfectionException(Throwable cause) {
        super(cause);
    }
}
