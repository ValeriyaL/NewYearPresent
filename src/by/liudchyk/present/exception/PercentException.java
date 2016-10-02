package by.liudchyk.present.exception;


public class PercentException extends Exception {
    public PercentException(String s){
        super(s);
    }

    public PercentException(){
        super();
    }

    public PercentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PercentException(Throwable cause) {
        super(cause);
    }
}
