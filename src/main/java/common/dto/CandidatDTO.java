package common.dto;

import common.etc.Skills;

import java.util.HashMap;

public class CandidatDTO extends ProfilDTO{
    private String name;

    public CandidatDTO(int id, String name, HashMap<Skills, Integer> yearOfExperience) {
        super(id, yearOfExperience);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
