package by.epamtc.zhenekns.dev.exception;

public class WrongPropertiesException extends Exception {

    public WrongPropertiesException() {
    }

    public WrongPropertiesException(String message) {
        super(message);
    }

    public WrongPropertiesException(String message, Throwable exception){
        super(message, exception);
    }

    public WrongPropertiesException(Throwable cause){
        super(cause);
    }
}
