package model.entretien;

import common.dto.CandidatDTO;
import common.etc.Skills;

import java.util.HashMap;

class Candidate {
    private CandidateID id;
    private String name;
    HashMap<Skills, Integer> yearOfExperience;

    Candidate(CandidatDTO candidatDTO) {

        this.id = new CandidateID(candidatDTO.getId());
        this.name = candidatDTO.getName();
        this.yearOfExperience = candidatDTO.getYearOfExperience();
    }

    public Skills getBestSkill(){
        
    }
}
