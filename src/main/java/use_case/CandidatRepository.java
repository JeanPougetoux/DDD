package use_case;

import common.dto.CandidatDTO;

public interface CandidatRepository {
    public CandidatDTO getCandidatById(int id);
}
