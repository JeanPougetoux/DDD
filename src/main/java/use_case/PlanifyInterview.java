package use_case;

import common.dto.CandidatDTO;
import common.dto.RecruiterDTO;
import common.request.PlanifyInterviewRequest;
import common.response.PlanifyInterviewResponse;
import infra.RepoFakeCandidat;
import model.entretien.Interview;

import java.util.ArrayList;

public class PlanifyInterview {
    public PlanifyInterviewResponse execute(PlanifyInterviewRequest request,
                                            CandidatRepository candidatRepository,
                                            RecruiterRepository recruiterRepository) {

        CandidatDTO candidatDTO = candidatRepository.getCandidatById(request.getCandidateID());
        ArrayList<RecruiterDTO> recruiterDTO = recruiterRepository.getRecruiters();


        // biz
        Interview interview = new Interview(candidatDTO, recruiterDTO);

        return new PlanifyInterviewResponse(null);
    }
}
