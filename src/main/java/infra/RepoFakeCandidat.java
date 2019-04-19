package infra;

import common.dto.CandidatDTO;
import use_case.CandidatRepository;

public class RepoFakeCandidat implements CandidatRepository {

    @Override
    public CandidatDTO getCandidatById(int id) {
        return null;
    }
}
