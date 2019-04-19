package use_case;

import common.dto.CandidatDTO;
import common.request.PlanifyInterviewRequest;
import common.response.PlanifyInterviewResponse;
import infra.RepoFakeCandidat;

public class PlanifyInterview {
    public PlanifyInterviewResponse execute(PlanifyInterviewRequest request, CandidatRepository candidatRepository) {
        CandidatDTO dto = candidatRepository.getCandidatById(request.getCandidateID());

        // biz

        return new PlanifyInterviewResponse(null);
    }
}
