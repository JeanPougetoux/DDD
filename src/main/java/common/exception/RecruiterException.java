package common.exception;

public class RecruiterException extends Exception {
    public RecruiterException(ExceptionMessages exceptionMessages) {
        super(exceptionMessages.getMessage());
    }
}
