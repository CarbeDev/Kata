package Exceptions;

public class InvalidOrderException extends Exception{

    public InvalidOrderException() {

    }

    public InvalidOrderException(String message){
        super(message);
    }
}
