package common.dto;

import common.etc.Skills;
import model.entretien.Interview;

import java.util.ArrayList;
import java.util.HashMap;

public class RecruiterDTO extends ProfilDTO{
    private String name;
    private ArrayList<InterviewDTO> interviews;

    RecruiterDTO(Integer id, String name, HashMap<Skills, Integer> yearOfExperience) {
        super(id, yearOfExperience);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
