package Exceptions;

public class InvalidCustomerException extends Exception{

    private String message;

    public InvalidCustomerException() {
    }

    public InvalidCustomerException(String message) {
        this.message = message;
    }
}
