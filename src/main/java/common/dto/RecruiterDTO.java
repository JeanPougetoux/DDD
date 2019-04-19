package common.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class RecruiterDTO extends ProfilDTO{
    private String name;
    private ArrayList<InterviewDTO> interviews;

    RecruiterDTO(Integer id, String name, HashMap<SkillDTO, Integer> yearOfExperience) {
        super(id, yearOfExperience);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
