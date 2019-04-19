package common.dto;

import common.etc.Skills;

import java.util.HashMap;

public class ProfilDTO {
    private int id;
    private HashMap<Skills, Integer> yearOfExperience;

    ProfilDTO(Integer id, HashMap<Skills, Integer> yearOfExperience){
        this.id = id;
        this.yearOfExperience = yearOfExperience;
    }
    public HashMap<Skills, Integer> getYearOfExperience() {
        return yearOfExperience;
    }

    public int getId() {
        return id;
    }
}
