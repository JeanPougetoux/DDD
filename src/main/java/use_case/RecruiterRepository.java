package use_case;

import common.dto.RecruiterDTO;

import java.util.ArrayList;

public interface RecruiterRepository {
    ArrayList<RecruiterDTO> getRecruiters();
}
