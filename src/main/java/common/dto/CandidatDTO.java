package common.dto;

import java.util.HashMap;

public class CandidatDTO extends ProfilDTO{
    private String name;

    public CandidatDTO(int id, String name, HashMap<SkillDTO, Integer> yearOfExperience) {
        super(id, yearOfExperience);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
