package model.entretien;

import common.dto.InterviewDTO;
import common.dto.RecruiterDTO;
import common.dto.SkillDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Recruiter {
    private RecruiterID recruiterID;
    private String name;
    private HashMap<Skills, Integer> skills;
    private ArrayList<Interview> interviews;

    public RecruiterID getRecruiterID() {
        return recruiterID;
    }

    public ArrayList<Interview> getInterviews() {
        return interviews;
    }

    public String getName() {
        return name;
    }

    public HashMap<Skills, Integer> getSkills() {
        return skills;
    }

    public Recruiter(RecruiterID recruiterID, String name, HashMap<SkillDTO, Integer> skillsDTO, RecruiterDTO recruiterDTO) {
        this.recruiterID = recruiterID;
        this.name = name;
        for (Map.Entry<SkillDTO, Integer> entry : skillsDTO.entrySet()) {
            skills.put(new Skills(entry.getKey()), entry.getValue());
        }

        for (InterviewDTO interviewDTO: recruiterDTO.getInterviews()) {
            Creneau creneau = new Creneau(interviewDTO.getDate(), interviewDTO.getStart(), interviewDTO.getEnd());
            interviews.add(new Interview(new InterviewID(interviewDTO.getId()), creneau, this, null));
        }
    }

    public boolean isAvailableFor(Creneau creneau){

        for (Interview interview : interviews) {
            if(creneau.getDate().compareTo(interview.getCreneau().getDate()) == 0){
                //same days

                if(!((creneau.getStart().isBefore(interview.getCreneau().getStart()) && creneau.getEnd().isBefore(interview.getCreneau().getStart()))
                        || (creneau.getStart().isAfter(interview.getCreneau().getEnd()) && creneau.getEnd().isBefore(interview.getCreneau().getEnd())))){
                    return false;
                }
            }
        }

        return true;

    }
}
