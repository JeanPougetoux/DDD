package vo;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class Creneau {
    private Date date;
    private LocalTime start;
    private LocalTime end;

    public Creneau(Date date, LocalTime start, LocalTime end) {
        this.date = date;
        this.start = start;
        this.end = end;
    }

    public Date getDate() {
        return date;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creneau creneau = (Creneau) o;
        return Objects.equals(date, creneau.date) &&
                Objects.equals(start, creneau.start) &&
                Objects.equals(end, creneau.end);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, start, end);
    }
}
