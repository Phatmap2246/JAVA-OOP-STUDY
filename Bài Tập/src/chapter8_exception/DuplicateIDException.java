package chapter8_exception;

public class DuplicateIDException extends Exception {
    public DuplicateIDException(String message){
        super(message);
    }
}
