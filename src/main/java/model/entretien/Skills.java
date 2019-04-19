package model.entretien;

import common.dto.SkillDTO;

import java.util.Objects;

public class Skills {
    private String name;
    public Skills(SkillDTO skill) {
        this.name = skill.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skills skills = (Skills) o;
        return Objects.equals(name, skills.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
