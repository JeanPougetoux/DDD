package model.entretien;

import common.dto.RecruiterDTO;
import common.dto.SkillDTO;
import common.exception.ExceptionMessages;
import common.exception.RecruiterException;
import common.exception.SkillsException;

import java.util.ArrayList;
import java.util.HashMap;

class RecruiterManager {

    private ArrayList<Recruiter> recruiters;

    public RecruiterManager(ArrayList<RecruiterDTO> recruitersDTO) {
        for (RecruiterDTO recruiterDTO : recruitersDTO) {
            HashMap<SkillDTO, Integer> skillList = recruiterDTO.getYearOfExperience();
            recruiters.add(new Recruiter(new RecruiterID(recruiterDTO.getId()), recruiterDTO.getName(),skillList ));
        }
    }

    public Recruiter getBestRecruiterFor(Candidate candidate) throws SkillsException, RecruiterException {

        if(recruiters.size() == 0) {
            throw new RecruiterException(ExceptionMessages.NO_RECRUITER_AT_ALL);
        }

        Skills skill = candidate.getBestSkill();

        Recruiter recruiter = getMaxSkilled(recruiters, skill);

        if(recruiter == null) {

        }
        else {

        }
    }

    private Recruiter getMaxSkilled(ArrayList<Recruiter> recruiters, Skills skill) {
        Integer maxExperienceInSkill = -1;
        Recruiter maxSkilledRecruiter = null;

        for (Recruiter recruiter : recruiters) {
            HashMap<Skills, Integer> skills = recruiter.getSkills();
            if(skills.containsKey(skill)) {
                if(skills.get(skill) > maxExperienceInSkill) {
                    maxExperienceInSkill = skills.get(skill);
                    maxSkilledRecruiter = recruiter;
                }
            }
        }

        return maxSkilledRecruiter;
    }


}
