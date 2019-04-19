package model.entretien;

import common.dto.CandidatDTO;
import common.dto.SkillDTO;
import common.exception.ExceptionMessages;
import common.exception.SkillsException;

import java.util.HashMap;
import java.util.Map;

class Candidate {
    private CandidateID id;
    private String name;
    HashMap<Skills, Integer> yearOfExperience;

    Candidate(CandidatDTO candidatDTO) {

        this.id = new CandidateID(candidatDTO.getId());
        this.name = candidatDTO.getName();
        for (Map.Entry<SkillDTO, Integer> entry : candidatDTO.getYearOfExperience().entrySet()) {
            yearOfExperience.put(new Skills(entry.getKey().getName()), entry.getValue());
        }
    }

    public Skills getBestSkill() throws SkillsException {
        Integer maxYearExperience = -1;
        Skills maxSkillExperience = null;

        if(yearOfExperience.size() == 0) {
            throw new SkillsException(ExceptionMessages.SKILLS_LIST_EMPTY);
        }

        for (Map.Entry<Skills, Integer> entry : yearOfExperience.entrySet()) {
            if (entry.getValue() > maxYearExperience) {
                maxYearExperience = entry.getValue();
                maxSkillExperience = entry.getKey();
            }
        }

        return maxSkillExperience;
    }
}
