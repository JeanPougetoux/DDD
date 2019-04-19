package common.response;

import common.request.PlanifyInterviewRequest;
import model.entretien.Interview;

public class PlanifyInterviewResponse {
    private Interview interview;

    public PlanifyInterviewResponse(Interview interview) {
        this.interview = interview;
    }

    public Interview getInterview() {
        return interview;
    }
}
