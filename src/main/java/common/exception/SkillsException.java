package common.exception;

public class SkillsException extends Exception {
    public SkillsException(ExceptionMessages exceptionMessages) {
        super(exceptionMessages.getMessage());
    }
}
