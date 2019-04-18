package vo;

public enum ExceptionMessages {
    DURATION_LIMIT("The creneau should last more than 30 minutes"),
    ORDER("Start time should be before end time");

    private String message;

    ExceptionMessages(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
