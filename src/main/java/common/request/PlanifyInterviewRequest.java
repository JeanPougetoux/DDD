package common.request;

import model.entretien.CandidateID;
import model.entretien.RoomID;

import java.time.LocalTime;
import java.util.Date;

public class PlanifyInterviewRequest {

    private Date interviewDate;
    private int candidateID;

    public PlanifyInterviewRequest(Date interviewDate, int candidateID) {
        this.interviewDate = interviewDate;
        this.candidateID = candidateID;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }
}
