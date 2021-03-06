package model.entretien;

import common.dto.CandidatDTO;
import common.dto.RecruiterDTO;
import common.exception.ExceptionMessages;
import common.exception.InterviewException;
import common.status.InterviewStatus;

import java.util.ArrayList;

public class Interview {
    private InterviewID id;
    private InterviewStatus status;
    private Creneau creneau;
    private Recruiter recruiter;
    private Candidate candidate;

    Interview(InterviewID id, Creneau creneau, Recruiter recruiter, Candidate candidate) {

        this.id = id;
        this.creneau = creneau;
        this.recruiter = recruiter;
        this.candidate = candidate;
        this.status = InterviewStatus.PLANIFIED;
    }


    Interview(CandidatDTO candidatDTO, ArrayList<RecruiterDTO> recruiterDTO) {
        this.candidate = new Candidate(candidatDTO);

        RecruiterManager recruiterManager = new RecruiterManager(recruiterDTO);

        Recruiter recruiter = recruiterManager.getBestRecruiterFor(this.candidate);


    }

    public InterviewID getId() {
        return id;
    }

    public InterviewStatus getStatus() {
        return status;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void report(Creneau creneau){
        if(this.status == InterviewStatus.CANCELLED)
            throw new InterviewException(ExceptionMessages.REPORT_WHEN_CANCELED);

        this.creneau = creneau;
        this.status = InterviewStatus.PLANIFIED;
    }

    public void confirm(){
        if(this.status == InterviewStatus.CONFIRMED)
            throw new InterviewException(ExceptionMessages.CONFIRM_WHEN_CONFIRM);
        if(this.status == InterviewStatus.CANCELLED)
            throw new InterviewException(ExceptionMessages.CONFIRM_WHEN_CANCELLED);

        this.status = InterviewStatus.CONFIRMED;
    }

    public void cancel(String reason){
        if(this.status == InterviewStatus.CANCELLED)
            throw new InterviewException(ExceptionMessages.CANCEL_WHEN_CANCELLED);

        this.status = InterviewStatus.CANCELLED;
    }
}
