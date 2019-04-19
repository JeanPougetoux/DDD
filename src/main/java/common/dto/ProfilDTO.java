package common.dto;

import java.util.HashMap;

public class ProfilDTO {
    private int id;
    private HashMap<SkillDTO, Integer> yearOfExperience;

    ProfilDTO(Integer id, HashMap<SkillDTO, Integer> yearOfExperience){
        this.id = id;
        this.yearOfExperience = yearOfExperience;
    }
    public HashMap<SkillDTO, Integer> getYearOfExperience() {
        return yearOfExperience;
    }

    public int getId() {
        return id;
    }
}
