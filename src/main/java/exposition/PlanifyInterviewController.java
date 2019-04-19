package exposition;

import common.request.PlanifyInterviewRequest;
import common.response.PlanifyInterviewResponse;
import use_case.PlanifyInterview;

import java.util.Date;

public class PlanifyInterviewController {

    public PlanifyInterviewResponse execute(int idCandidat, Date interviewDate){
        PlanifyInterview planifyInterview = new PlanifyInterview();
        return planifyInterview.execute(new PlanifyInterviewRequest(interviewDate, idCandidat));
    }

}
