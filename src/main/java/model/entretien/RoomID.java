package model.entretien;

import java.util.Objects;

public class RoomID {
    private int id;

    RoomID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomID roomID = (RoomID) o;
        return id == roomID.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
