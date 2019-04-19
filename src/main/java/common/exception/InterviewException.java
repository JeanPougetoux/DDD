package common.exception;

public class InterviewException extends RuntimeException {
    public InterviewException(ExceptionMessages exceptionMessages) {
        super(exceptionMessages.getMessage());
    }

}
