package vo;

class CreneauException extends RuntimeException{
    CreneauException(ExceptionMessages exceptionMessages) {
        super(exceptionMessages.getMessage());
    }
}
