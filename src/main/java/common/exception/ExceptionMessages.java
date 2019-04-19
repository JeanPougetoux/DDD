package common.exception;

public enum ExceptionMessages {
    DURATION_LIMIT("The creneau should last more than 30 minutes"),
    ORDER("Start time should be before end time"),
    NULL("One of the parameter is null"),
    REPORT_WHEN_CANCELED("Can't report the interview when is already cancelled"),
    CONFIRM_WHEN_CONFIRM("Can't confirm the interview if it's already confirmed"),
    CONFIRM_WHEN_CANCELLED("Can't confirm the interview if it's already cancelled"),
    CANCEL_WHEN_CANCELLED("Cant't cancel the interview if it's already cancelled"),
    SKILLS_LIST_EMPTY("There is no skills in the list of skills"),
    NO_RECRUITER_AT_ALL("There is no recruiter at all in the list");

    private String message;

    ExceptionMessages(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
