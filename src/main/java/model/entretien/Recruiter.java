package model.entretien;

import common.dto.SkillDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Recruiter {
    private RecruiterID recruiterID;
    private String name;
    private HashMap<Skills, Integer> skills;

    public RecruiterID getRecruiterID() {
        return recruiterID;
    }

    public String getName() {
        return name;
    }

    public HashMap<Skills, Integer> getSkills() {
        return skills;
    }

    public Recruiter(RecruiterID recruiterID, String name, HashMap<SkillDTO, Integer> skillsDTO) {
        this.recruiterID = recruiterID;
        this.name = name;
        for (Map.Entry<SkillDTO, Integer> entry : skillsDTO.entrySet()) {
            skills.put(new Skills(entry.getKey()), entry.getValue());
        }
    }
}
