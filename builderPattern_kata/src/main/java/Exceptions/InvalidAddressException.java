package Exceptions;

public class InvalidAddressException extends Exception{
    public InvalidAddressException() {
    }

    public InvalidAddressException(String message) {
        super(message);
    }
}
