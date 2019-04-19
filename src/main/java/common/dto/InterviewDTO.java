package common.dto;

import java.time.LocalTime;
import java.util.Date;

public class InterviewDTO {

    private int id;
    private Date date;
    private LocalTime start;
    private LocalTime end;

    public InterviewDTO(int id, Date date, LocalTime start, LocalTime end) {
        this.id = id;
        this.date = date;
        this.start = start;
        this.end = end;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
}
