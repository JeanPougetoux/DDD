package common.dto;

import java.util.Objects;

public class SkillDTO {
    public String getName() {
        return name;
    }

    private String name;
    public SkillDTO(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillDTO skillDTO = (SkillDTO) o;
        return Objects.equals(name, skillDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
