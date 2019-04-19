package common.exception;

public class CreneauException extends RuntimeException{
    public CreneauException(ExceptionMessages exceptionMessages) {
        super(exceptionMessages.getMessage());
    }
}
