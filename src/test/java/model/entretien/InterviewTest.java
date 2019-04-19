package model.entretien;

import common.exception.InterviewException;
import model.entretien.Candidate;
import model.entretien.Interview;
import model.entretien.Recruiter;
import org.junit.Test;
import common.exception.ExceptionMessages;
import common.status.InterviewStatus;
import model.entretien.Creneau;
import model.entretien.InterviewID;

import java.time.LocalTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InterviewTest {

    private Candidate candidate;
    private Recruiter recruiter;
    private Creneau creneau;

    public InterviewTest() {
        this.candidate = new Candidate();
        this.recruiter = new Recruiter();
        this.creneau = new Creneau(new Date(), LocalTime.parse("11:03"), LocalTime.parse("13:37"));
    }


    @Test
    public void interview_should_be_reported() {
        Interview interview = new Interview(new InterviewID((int)(Math.random()*100)), creneau, recruiter, candidate);
        Creneau newCreneau = new Creneau(new Date(), LocalTime.parse("15:00"), LocalTime.parse("16:00"));

        interview.report(newCreneau);
        assertThat(interview.getCreneau()).isEqualTo(newCreneau);
        assertThat(interview.getStatus()).isEqualTo(InterviewStatus.PLANIFIED);
    }

    @Test
    public void report_should_not_occur_when_is_cancelled() {
        Interview interview = new Interview(new InterviewID((int)(Math.random()*100)), creneau, recruiter, candidate);
        interview.cancel("canceled");

        assertThatThrownBy(()-> interview.report(creneau))
                .hasMessage(ExceptionMessages.REPORT_WHEN_CANCELED.getMessage())
                .isInstanceOf(InterviewException.class);
    }

    @Test
    public void interview_should_be_confirmed() {
        Interview interview = new Interview(new InterviewID((int)(Math.random()*100)), creneau, recruiter, candidate);
        interview.confirm();

        assertThat(interview.getStatus()).isEqualTo(InterviewStatus.CONFIRMED);
    }

    @Test
    public void confirmation_should_not_occur_when_is_cancelled() {
        Interview interview = new Interview(new InterviewID((int)(Math.random()*100)), creneau, recruiter, candidate);
        interview.cancel("canceled");

        assertThatThrownBy(interview::confirm)
                .hasMessage(ExceptionMessages.CONFIRM_WHEN_CANCELLED.getMessage())
                .isInstanceOf(InterviewException.class);
    }

    @Test
    public void confirmation_should_not_occur_when_is_already_confirmed() {
        Interview interview = new Interview(new InterviewID((int)(Math.random()*100)), creneau, recruiter, candidate);
        interview.confirm();

        assertThatThrownBy(interview::confirm)
                .hasMessage(ExceptionMessages.CONFIRM_WHEN_CONFIRM.getMessage())
                .isInstanceOf(InterviewException.class);
    }

    @Test
    public void interview_should_cancel_when_is_planified() {
        Interview interview = new Interview(new InterviewID((int)(Math.random()*100)), creneau, recruiter, candidate);
        interview.cancel("");

        assertThat(interview.getStatus()).isEqualTo(InterviewStatus.CANCELLED);
    }

    @Test
    public void interview_should_cancel_when_is_confirmed() {
        Interview interview = new Interview(new InterviewID((int)(Math.random()*100)), creneau, recruiter, candidate);
        interview.confirm();
        interview.cancel("");

        assertThat(interview.getStatus()).isEqualTo(InterviewStatus.CANCELLED);
    }

    @Test
    public void interview_should_not_cancel_when_is_cancelled() {
        Interview interview = new Interview(new InterviewID((int)(Math.random()*100)), creneau, recruiter, candidate);
        interview.cancel("");
        assertThatThrownBy(() -> interview.cancel(""))
                .hasMessage(ExceptionMessages.CANCEL_WHEN_CANCELLED.getMessage())
                .isInstanceOf(InterviewException.class);
    }
}